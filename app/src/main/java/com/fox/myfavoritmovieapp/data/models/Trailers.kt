package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Trailers (

  @SerializedName("url"  ) var url  : String? = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("site" ) var site : String? = null,
  @SerializedName("type" ) var type : String? = null,
  @SerializedName("_id"  ) var Id   : String? = null

)