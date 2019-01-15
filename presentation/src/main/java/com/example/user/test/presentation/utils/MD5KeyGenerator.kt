package com.example.user.test.presentation.utils

import java.security.NoSuchAlgorithmException

class MD5KeyGenerator {

    @Throws(NoSuchAlgorithmException::class)
    fun generate(baseString: String): String {
        val digest = java.security.MessageDigest
                .getInstance("MD5")
        digest.update(baseString.toByteArray())
        val messageDigest = digest.digest()
        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2)
                h = "0$h"
            hexString.append(h)
        }
        return hexString.toString()
    }
}