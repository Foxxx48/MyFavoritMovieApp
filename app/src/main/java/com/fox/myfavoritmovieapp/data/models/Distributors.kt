package com.fox.myfavoritmovieapp.data.models

import com.google.gson.annotations.SerializedName


data class Distributors (

  @SerializedName("distributor"        ) var distributor        : String? = null,
  @SerializedName("distributorRelease" ) var distributorRelease : String? = null

)