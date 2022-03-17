package com.example.wikipedia.dataClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemPost(
   val url: String,
   val txtTitle: String,
   val subTitle: String,
   val txtDetail: String,
   val isTrend:Boolean,
   val insight:String
):Parcelable
