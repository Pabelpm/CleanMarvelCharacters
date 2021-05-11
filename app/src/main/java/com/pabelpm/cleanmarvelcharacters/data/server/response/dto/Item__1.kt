package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item__1(
    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("type")
    @Expose
    var type: String,

    )