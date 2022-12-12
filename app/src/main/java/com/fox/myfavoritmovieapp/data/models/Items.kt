package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Items (

    @SerializedName("logo" ) var logo : Logo?   = Logo(),
    @SerializedName("_id"  ) var Id   : String? = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null

)