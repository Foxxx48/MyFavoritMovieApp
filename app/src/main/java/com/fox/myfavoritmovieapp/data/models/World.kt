package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class World (

  @SerializedName("_id"      ) var Id       : String? = null,
  @SerializedName("value"    ) var value    : Int?    = null,
  @SerializedName("currency" ) var currency : String? = null

)