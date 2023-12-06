package com.rakibcse99.profileviewapps.repository.model
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
import com.rakibcse99.profileviewapps.utils.join


@Keep
data class CharacterModel(
    @SerializedName("id")
    val id: String? = null, // 9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8
    @SerializedName("name")
    val name: String? = null, // Harry Potter
    @SerializedName("alternate_names")
    val alternateNames: List<String?>? = null,
    @SerializedName("species")
    val species: String? = null, // human
    @SerializedName("gender")
    val gender: String? = null, // male
    @SerializedName("house")
    val house: String? = null, // Gryffindor
    @SerializedName("dateOfBirth")
    val dateOfBirth: String? = null, // 31-07-1980
    @SerializedName("yearOfBirth")
    val yearOfBirth: Int? = null, // 1980
    @SerializedName("wizard")
    val wizard: Boolean? = null, // true
    @SerializedName("ancestry")
    val ancestry: String? = null, // half-blood
    @SerializedName("eyeColour")
    val eyeColour: String? = null, // green
    @SerializedName("hairColour")
    val hairColour: String? = null,
    @SerializedName("patronus")
    val patronus: String? = null, // stag
    @SerializedName("hogwartsStudent")
    val hogwartsStudent: Boolean? = null, // true
    @SerializedName("hogwartsStaff")
    val hogwartsStaff: Boolean? = null, // false
    @SerializedName("actor")
    val actor: String? = null, // Daniel Radcliffe
    @SerializedName("alternate_actors")
    val alternateActors: List<Any?>? = null,
    @SerializedName("alive")
    val alive: Boolean? = null, // true
    @SerializedName("image")
    val image: String? = null // https://ik.imagekit.io/hpapi/harry.jpg
)

@Keep
data class Wand(
    @SerializedName("wood")
    val wood: String? = null, // holly
    @SerializedName("core")
    val core: String? = null, // phoenix feather
    @SerializedName("length")
    val length: Int? = null // 11
)