package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("offset")
    @Expose
    var offset: String,

    @SerializedName("limit")
    @Expose
    var limit: String,

    @SerializedName("total")
    @Expose
    var total: String,

    @SerializedName("count")
    @Expose
    var count: String,

    @SerializedName("results")
    @Expose
    var marvelCharacterDtos: List<MarvelCharacterDto>,

    )