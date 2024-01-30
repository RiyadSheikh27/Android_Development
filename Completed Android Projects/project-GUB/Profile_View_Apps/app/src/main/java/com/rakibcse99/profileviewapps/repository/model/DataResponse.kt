package com.rakibcse99.profileviewapps.repository.model


import com.google.gson.annotations.SerializedName
 import androidx.annotation.Keep

@Keep
data class DataResponse(
    @SerializedName("message")
    val message: String? // Successfully created
)