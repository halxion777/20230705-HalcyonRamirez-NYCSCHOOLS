package com.example.nycschools.repository.network

import com.example.nycschools.repository.network.data.SchoolInformationDTO
import com.example.nycschools.repository.network.data.SchoolSatDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface NycSchoolsService {
    @GET("/resource/s3k6-pzi2.json")
    suspend fun getAllSchools(): List<SchoolInformationDTO>

    @GET("/resource/f9bf-2cp4.json")
    suspend fun getSchoolDBNSatScore(@Query("dbn") dbn:String): List<SchoolSatDTO>
}