package com.alex44.glukhovfitnesskittest.model.repo

import com.alex44.glukhovfitnesskittest.common.interfaces.INetworkStatus
import com.alex44.glukhovfitnesskittest.model.api.IDataSource
import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.reactivex.schedulers.Schedulers

class DataRepo(private var source: IDataSource, private val networkStatus: INetworkStatus) : IDataRepo {

    override fun getData(): Maybe<List<LessonDTO>> {
        if (networkStatus.isOnline()) {
            return source.getData()
                .subscribeOn(Schedulers.io())
                .map { list ->
                    return@map list.filter { lessonDTO ->
                        return@filter lessonDTO != null && !lessonDTO.name.isNullOrBlank()
                    }
                }
        }
        else {
            return Maybe.create { emitter: MaybeEmitter<List<LessonDTO>> ->
                emitter.onError(RuntimeException("No internet"))
            }
                .subscribeOn(Schedulers.io())
        }
    }

}