package com.ironmeddieapps.remote.repository

import com.ironmeddieapps.remote.utils.Constance
import com.ironmeddieapps.utils.DataResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface BaseRepository {
    fun <T> safeApiCall(apiCall: suspend () -> T): Flow<DataResource<T>> {
        return flow {
            val resp = withContext(Dispatchers.IO) {
                try {
                    DataResource.Success(apiCall.invoke())
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is HttpException -> {
                            DataResource.Failure(
                                throwable.code(),
                                throwable.message()
                            )
                        }
                        else -> {
                            if (throwable.message == Constance.NO_INTERNET) {
                                DataResource.Failure(
                                    Constance.NO_INTERNET_CODE,
                                    throwable.message ?: Constance.NO_INTERNET
                                )

                            } else {
                                DataResource.Failure(
                                    Constance.OTHER_ERROR_CODE,
                                    throwable.message ?: Constance.OTHER_ERROR
                                )
                            }
                        }
                    }
                }
            }
            emit(resp)
        }
    }
}