package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item(
    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String,

    @SerializedName("name")
    @Expose
    var name: String,

    )