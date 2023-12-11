package com.rakibcse99.profileviewapps.repository.model

import com.rakibcse99.profileviewapps.base.ErrorResponse
import com.rakibcse99.profileviewapps.base.Resource
import com.rakibcse99.profileviewapps.data.source.CharacterApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val apiService: CharacterApi):CharacterRepository {

    override suspend fun getStudent(): Resource<MutableList<StudentModelItem>, ErrorResponse> {
        val response = apiService.getStudentList()
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

    override suspend fun addtStudent(studentModelItem: StudentModelItem): Resource<StudentModelItem, ErrorResponse> {
        val response = apiService.addStudent(studentModelItem)
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