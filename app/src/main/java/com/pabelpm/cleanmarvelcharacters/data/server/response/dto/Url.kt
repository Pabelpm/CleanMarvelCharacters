package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Url(
    @SerializedName("type")
    @Expose
    var type: String,

    @SerializedName("url")
    @Expose
    var url: String,

    )