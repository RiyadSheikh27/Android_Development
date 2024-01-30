package com.rakibcse99.profileviewapps.repository.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

 @Keep
data class StudentDto(
    @SerializedName("final")
    val `final`: String?, // 9
    @SerializedName("id")
    val id: String?, // 22
    @SerializedName("ksa1")
    val ksa1: String?, // 1
    @SerializedName("ksa2")
    val ksa2: String?, // 3
    @SerializedName("mark")
    val mark: String?, // 22
    @SerializedName("mid")
    val mid: String?, // 5
    @SerializedName("name")
    val name: String? // Rabbi
)