package com.example.agrithonadmin

import java.io.Serializable

data class AdminResponse(
    val index: String,
    val pred: PredictData
):Serializable
