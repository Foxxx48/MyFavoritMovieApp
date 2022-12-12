package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Persons (

  @SerializedName("id"           ) var id           : Int?    = null,
  @SerializedName("photo"        ) var photo        : String? = null,
  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("enName"       ) var enName       : String? = null,
  @SerializedName("enProfession" ) var enProfession : String? = null

)