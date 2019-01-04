package com.example.data.net

import android.util.Log
import com.rubylichtenstein.rxtest.assertions.shouldEmit
import com.rubylichtenstein.rxtest.extentions.test
import io.reactivex.functions.Predicate
import org.junit.After
import org.junit.Before
import org.junit.Test


class MarvelRestServiceTest {

    companion object {
        const val API_PUBLIC_KEY = "4da5fb7588e305bad17943c6cb84f0ae"
        const val API_PRIVATE_KEY = "d0b688c49968cdbf07df63db58c15aeff68fb19b"
        const val BASE_URL = "https://gateway.marvel.com"
    }

    private lateinit var marvelRestService: MarvelRestService
    private lateinit var hash: String
    private val timeStamp = System.currentTimeMillis().toString()
    private val md5 = timeStamp + API_PRIVATE_KEY + API_PUBLIC_KEY

    @Before
    fun initService(){
        marvelRestService = MarvelRestService(BASE_URL)

        try {
            val digest = java.security.MessageDigest
                .getInstance("MD5")
            digest.update(md5.toByteArray())
            val messageDigest = digest.digest()


            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2)
                    h = "0$h"
                hexString.append(h)
            }
            hash = hexString.toString()

        } catch (e: Exception) {
            e.printStackTrace()
            hash = ""
        }


    }
    @Test
    fun getCharectersListTest(){

            marvelRestService.getCharectersList(timeStamp,API_PUBLIC_KEY,hash)
                .test{

                    it shouldEmit Predicate{
                        it.data.results.isNotEmpty()}
                }
    }
}