package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Thumbnail(
    @SerializedName("path")
    @Expose
    var path: String,

    @SerializedName("extension")
    @Expose
    var extension: String,

    )