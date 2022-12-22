package com.fox.myfavoritmovieapp.data.model.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(val id: Int, val country: String): Parcelable
