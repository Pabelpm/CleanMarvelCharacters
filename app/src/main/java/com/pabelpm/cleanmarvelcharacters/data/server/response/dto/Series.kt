package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Series(
    @SerializedName("available")
    @Expose
    var available: String,

    @SerializedName("returned")
    @Expose
    var returned: String,

    @SerializedName("collectionURI")
    @Expose
    var collectionURI: String,

    @SerializedName("items")
    @Expose
    var items: List<Item__3>,

    )