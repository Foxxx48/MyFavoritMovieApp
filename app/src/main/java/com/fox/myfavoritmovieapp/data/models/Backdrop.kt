package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Backdrop (

  @SerializedName("_id"        ) var Id         : String? = null,
  @SerializedName("url"        ) var url        : String? = null,
  @SerializedName("previewUrl" ) var previewUrl : String? = null

)