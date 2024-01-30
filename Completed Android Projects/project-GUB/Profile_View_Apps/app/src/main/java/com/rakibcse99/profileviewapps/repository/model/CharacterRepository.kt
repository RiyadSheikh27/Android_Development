package com.rakibcse99.profileviewapps.repository.model

import com.rakibcse99.profileviewapps.base.ErrorResponse
import com.rakibcse99.profileviewapps.base.Resource

interface CharacterRepository {

    suspend fun getStudent(): Resource<MutableList<StudentModelItem>, ErrorResponse>
    suspend fun addStudent(studentModelItem: StudentDto): Resource<DataResponse, ErrorResponse>
    suspend fun updateStudent(studentModelItem: StudentModelItem): Resource<DataResponse, ErrorResponse>
    suspend fun delete(id:String): Resource<DataResponse, ErrorResponse>
}