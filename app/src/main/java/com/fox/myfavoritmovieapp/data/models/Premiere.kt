package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Premiere (

  @SerializedName("_id"     ) var Id      : String? = null,
  @SerializedName("country" ) var country : String? = null,
  @SerializedName("world"   ) var world   : String? = null,
  @SerializedName("russia"  ) var russia  : String? = null,
  @SerializedName("cinema"  ) var cinema  : String? = null,
  @SerializedName("dvd"     ) var dvd     : String? = null,
  @SerializedName("bluray"  ) var bluray  : String? = null

)