package com.rakibcse99.profileviewapps.data.source

import com.rakibcse99.profileviewapps.repository.model.DataResponse
import com.rakibcse99.profileviewapps.repository.model.StudentDto
import com.rakibcse99.profileviewapps.repository.model.StudentModelItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/users/result")
    suspend fun getStudentList(): Response<MutableList<StudentModelItem>>


    @POST("api/users/result")
    suspend fun addStudent(@Body  studentModelItem: StudentDto): Response<DataResponse>

    @PUT("api/users/result")
    suspend fun updateStudent(@Body  studentModelItem: StudentModelItem): Response<DataResponse>

    @DELETE("api/users/result")
    suspend fun delete(@Query("id") id: String): Response<DataResponse>

}