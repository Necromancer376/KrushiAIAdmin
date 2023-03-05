package com.example.agrithonadmin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PredictData(
    val description: String = "",
    val image: String = "",
    val location: String = "",
    val prediction: String = "",
    val source: String = "",
    val time: String = "",
    val symptoms: String = ""
):Parcelable
