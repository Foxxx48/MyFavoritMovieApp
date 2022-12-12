package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class SpokenLanguages (

  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("nameEn" ) var nameEn : String? = null

)