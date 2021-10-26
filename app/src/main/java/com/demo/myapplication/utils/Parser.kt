package com.demo.myapplication.utils

import retrofit2.HttpException

object Parser {

    fun onErrorFromServer(throwable: Throwable, networkResponseCallback: NetworkResponseCallback<*>) {
        if (throwable is HttpException) {
            try {
                val response = throwable.response()
                when {

                    response!!.code() == 400 -> {
                        networkResponseCallback.onErrorResponse(ErrorUtils.getHtttpCodeError(400))
                    }
                    response!!.code() == 401 -> {
                        networkResponseCallback.onErrorResponse(ErrorUtils.getHtttpCodeError(401))
                    }
                    else -> {
                        networkResponseCallback.onErrorResponse(
                            ErrorUtils.getHtttpCodeError(100)
                        )
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }else if(throwable is Exception)  {

        } else {

        }
    }
}
