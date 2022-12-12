package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class ImagesInfo (

  @SerializedName("_id"         ) var Id          : String? = null,
  @SerializedName("framesCount" ) var framesCount : Int?    = null

)