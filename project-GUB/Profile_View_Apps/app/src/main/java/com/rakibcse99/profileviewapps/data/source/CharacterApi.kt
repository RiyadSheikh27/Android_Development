package com.rakibcse99.profileviewapps.data.source

import com.rakibcse99.profileviewapps.repository.model.StudentModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface CharacterApi {

    @GET("api/users/result")
    suspend fun getStudentList(): Response<MutableList<StudentModelItem>>


    @POST("api/users/result")
    suspend fun addStudent(studentModelItem: StudentModelItem): Response<StudentModelItem>

}