package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Videos (

    @SerializedName("_id"      ) var Id       : String?             = null,
    @SerializedName("trailers" ) var trailers : ArrayList<Trailers> = arrayListOf(),
    @SerializedName("teasers"  ) var teasers  : ArrayList<String>   = arrayListOf()

)