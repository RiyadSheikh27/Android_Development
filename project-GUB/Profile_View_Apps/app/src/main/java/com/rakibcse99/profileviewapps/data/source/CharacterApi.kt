package com.rakibcse99.profileviewapps.data.source

import com.rakibcse99.profileviewapps.repository.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {
    @GET("api/characters")
    suspend fun getCharactersList(): Response<MutableList<CharacterModel>>




}