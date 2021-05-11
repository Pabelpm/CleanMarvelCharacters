package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MarvelCharacterResponseDto(
    @SerializedName("code")
    @Expose
    var code: String,

    @SerializedName("status")
    @Expose
    var status: String,

    @SerializedName("copyright")
    @Expose
    var copyright: String,

    @SerializedName("attributionText")
    @Expose
    var attributionText: String,

    @SerializedName("attributionHTML")
    @Expose
    var attributionHTML: String,

    @SerializedName("data")
    @Expose
    var data: Data,

    @SerializedName("etag")
    @Expose
    var etag: String,

    )