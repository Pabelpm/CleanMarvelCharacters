package com.pabelpm.cleanmarvelcharacters.data.server.http

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.jvm.Throws

class Auth() {
    fun getHash(timestamp: String, privateKey: String, publicKey: String): String {
        val stringToMd5 = "$timestamp$privateKey$publicKey "
        return md5(stringToMd5)
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    @Throws(NoSuchAlgorithmException::class)
    private fun md5hash(text: String): String? {
        val hash = MessageDigest.getInstance("MD5").digest(text.toByteArray())
        return String.format("%032x", BigInteger(1, hash))
    }
}