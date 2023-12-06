package com.rakibcse99.profileviewapps.repository.model

import com.rakibcse99.profileviewapps.base.ErrorResponse
import com.rakibcse99.profileviewapps.base.Resource
import com.rakibcse99.profileviewapps.data.source.CharacterApi
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val apiService: CharacterApi):CharacterRepository {
    override suspend fun getCharacter(): Resource<MutableList<CharacterModel>, ErrorResponse> {
        val response = apiService.getCharactersList()
        return if (response.isSuccessful) {
            Resource.success(response.body())
        } else {
            Resource.error(
                null,
                error = ErrorResponse(
                    success = false,
                    message = response.message(),
                    code = response.code()
                )
            )
        }
    }


}