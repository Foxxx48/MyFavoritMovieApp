package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Technology (

  @SerializedName("_id"     ) var Id      : String?  = null,
  @SerializedName("hasImax" ) var hasImax : Boolean? = null,
  @SerializedName("has3D"   ) var has3D   : Boolean? = null

)