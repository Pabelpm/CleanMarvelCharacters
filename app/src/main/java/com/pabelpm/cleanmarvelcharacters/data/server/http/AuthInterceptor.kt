package com.pabelpm.cleanmarvelcharacters.data.server.http

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val publicKey: String,
    private val privateKey: String
) : Interceptor {

    /*   override fun intercept(chain: Interceptor.Chain): Response {
           val timestamp = System.currentTimeMillis().toString()
           val originalRequest = chain.request()
           val originalUrl = originalRequest.url()
           val url = originalUrl.newBuilder()
               .addQueryParameter("ts", timestamp)
               .addQueryParameter("apikey", publicKey)
               .addQueryParameter("hash", Auth().getHash(timestamp,privateKey,publicKey))
               .build()
   
           val requestBuilder = originalRequest.newBuilder().url(url)
           val request = requestBuilder.build()
           return chain.proceed(request)
       }*/

    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = System.currentTimeMillis().toString()
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder()
            .addQueryParameter("ts", "1")
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", "c12f8513d6e05549223ddd6e0bf5806e")
            .addQueryParameter("limit","100")
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }


}