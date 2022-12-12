package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Fees (

    @SerializedName("world"  ) var world  : World?  = World(),
    @SerializedName("russia" ) var russia : Russia? = Russia(),
    @SerializedName("usa"    ) var usa    : Usa?    = Usa(),
    @SerializedName("_id"    ) var Id     : String? = null

)