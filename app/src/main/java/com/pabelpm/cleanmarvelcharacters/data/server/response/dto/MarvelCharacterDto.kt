package com.pabelpm.cleanmarvelcharacters.data.server.response.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MarvelCharacterDto(
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("modified")
    @Expose
    var modified: String,

    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String,

    @SerializedName("urls")
    @Expose
    var urls: List<Url>,

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: Thumbnail,

    @SerializedName("comics")
    @Expose
    var comics: Comics,

    @SerializedName("stories")
    @Expose
    var stories: Stories,

    @SerializedName("events")
    @Expose
    var events: Events,

    @SerializedName("series")
    @Expose
    var series: Series,

    )