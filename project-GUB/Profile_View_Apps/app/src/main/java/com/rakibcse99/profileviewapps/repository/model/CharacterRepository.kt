package com.rakibcse99.profileviewapps.repository.model

import com.rakibcse99.profileviewapps.base.ErrorResponse
import com.rakibcse99.profileviewapps.base.Resource

interface CharacterRepository {
    suspend fun getCharacter(): Resource<MutableList<CharacterModel>, ErrorResponse>
}