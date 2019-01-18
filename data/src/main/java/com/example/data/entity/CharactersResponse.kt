package com.example.data.entity

import com.google.gson.annotations.SerializedName
import java.util.*

data class CharactersResponse(val data: Data) {

    data class Data(
        val offset: Int = 0,
        val limit: Int = 0,
        val total: Int = 0,
        val count: Int = 0,
        val results: List<Characters> = emptyList()
    )

    data class Characters(
        val id: Int = 0,
        val name: String = "",
        val description: String = "",
        val modified: Date? = null,
        val resourceURI: String = "",
        val thumbnail: Thumbnail? = null
    )

    data class Thumbnail(
        @SerializedName("path")
        val photoUrl: String = "",
        val extension: String = ""
    )
}