package com.alex44.glukhovfitnesskittest.model.repo

import com.alex44.glukhovfitnesskittest.common.interfaces.INetworkStatus
import com.alex44.glukhovfitnesskittest.model.api.IDataSource
import com.alex44.glukhovfitnesskittest.model.cache.IDataCache
import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.reactivex.schedulers.Schedulers

class DataRepo(
    private var source: IDataSource,
    private val networkStatus: INetworkStatus,
    private val dataCache: IDataCache
) : IDataRepo {

    override fun getData(): Maybe<List<LessonDTO>> {
        if (networkStatus.isOnline()) {
            return source.getData()
                .subscribeOn(Schedulers.io())
                .map { list ->
                    return@map list.filter { lessonDTO ->
                        return@filter lessonDTO != null && !lessonDTO.appointmentId.isNullOrBlank()
                    }.apply {
                        dataCache.putData(this)
                    }
                }
        }
        else {
            return Maybe.create { emitter: MaybeEmitter<List<LessonDTO>> ->
                val list = dataCache.getData()
                if (list.isNullOrEmpty()) {
                    emitter.onError(java.lang.RuntimeException("No internet connection. No data in local storage"))
                }
                else {
                    emitter.onSuccess(list)
                }
            }
                .subscribeOn(Schedulers.io())
        }
    }

}