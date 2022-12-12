package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Watchability (

  @SerializedName("_id"   ) var Id    : String?          = null,
  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf()

)