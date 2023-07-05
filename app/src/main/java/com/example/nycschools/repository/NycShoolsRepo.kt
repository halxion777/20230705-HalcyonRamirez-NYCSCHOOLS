package com.example.nycschools.repository

import com.example.nycschools.repository.db.models.SchoolInformationEntity
import com.example.nycschools.repository.network.data.SchoolInformationDTO
import com.example.nycschools.repository.network.data.SchoolSatDTO

interface NycSchoolsRepo {
    suspend fun getSchools(): List<SchoolInformationDTO>
    suspend fun getSatScoreForSchool(dbn: String): List<SchoolSatDTO>
    suspend fun getSchoolInfo(dbn: String): SchoolInformationEntity?
    suspend fun saveTimeStamp(timestamp: String)
    suspend fun getTimeStamp():String
    suspend fun updateSchoolSatScore(dbn: String, satDTO: SchoolSatDTO)
}