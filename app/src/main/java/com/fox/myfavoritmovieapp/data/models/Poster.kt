package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Poster (

  @SerializedName("_id"        ) var Id         : String? = null,
  @SerializedName("url"        ) var url        : String? = null,
  @SerializedName("previewUrl" ) var previewUrl : String? = null

)