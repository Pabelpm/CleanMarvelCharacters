package com.pabelpm.cleanmarvelcharacters.data.server.response


import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import java.net.SocketTimeoutException

open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> Resource.error(getErrorMessage(e.code()), null)
            is SocketTimeoutException -> Resource.error(getErrorMessage(408), null)
            is JsonSyntaxException -> Resource.error(e.message.toString(),null)
            else -> Resource.error(getErrorMessage(Int.MAX_VALUE), null)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            408 -> "Timeout. Check if you have an internet connection"
            404 -> "Can not retrieve info, Not Found"
            else -> "Something went wrong"
        }
    }
}