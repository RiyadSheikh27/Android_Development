package com.rakibcse99.profileviewapps.repository.model

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


@Keep
data class StudentModelItem(
    @SerializedName("final")
    val `final`: Int, // 9
    @SerializedName("id")
    val id: Int, // 6
    @SerializedName("ksa1")
    val ksa1: Int, // 1
    @SerializedName("ksa2")
    val ksa2: Int, // 3
    @SerializedName("mid")
    val mid: Int, // 5
    @SerializedName("name")
    val name: String, // Noman 3.0
    @SerializedName("quiz_mark")
    val quizMark: Int, // 50
    @SerializedName("total")
    val total: Int // 0
)