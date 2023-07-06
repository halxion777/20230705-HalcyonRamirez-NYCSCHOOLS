package com.example.nycschools.repository

import com.example.nycschools.repository.datastore.NycSchoolsDataStore
import com.example.nycschools.repository.db.NycSchoolDatabase
import com.example.nycschools.repository.db.models.SchoolInformationEntity
import com.example.nycschools.repository.db.models.toDTO
import com.example.nycschools.repository.db.models.toDTOs
import com.example.nycschools.repository.network.NycSchoolsService
import com.example.nycschools.repository.network.data.SchoolInformationDTO
import com.example.nycschools.repository.network.data.SchoolSatDTO
import com.example.nycschools.repository.network.data.toEntities
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NycSchoolsRepoImpl @Inject constructor(
    private val nycSchoolService: NycSchoolsService,
    private val nycSchoolDatabase: NycSchoolDatabase,
    private val nycSchoolsDataStore: NycSchoolsDataStore
) :
    NycSchoolsRepo {
    override suspend fun getSchools(): List<SchoolInformationDTO> {
        return if (!nycSchoolsDataStore.isCacheExpired()) {
            nycSchoolDatabase.schoolInfoDao().getAllSchools()?.toDTOs() ?: listOf()
        } else {
            val data = nycSchoolService.getAllSchools()
            nycSchoolDatabase.schoolInfoDao().insert(data.toEntities())
            nycSchoolsDataStore.saveTimeStamp(System.currentTimeMillis().toString())
            data
        }
    }

    override suspend fun updateSchoolSatScore(dbn: String, satDTO: SchoolSatDTO) {
        nycSchoolDatabase.schoolInfoDao().update(
            dbn,
            mathScore = satDTO.satMathAvgScore ?: "",
            readingScore = satDTO.satCriticalReadingAvgScore ?: "",
            writingScore = satDTO.satWritingAvgScore ?: ""
        )
    }

    override suspend fun saveDBN(dbn: String) {
        nycSchoolsDataStore.saveDbn(dbn)
    }

    override suspend fun getDBN(): String {
        return nycSchoolsDataStore.getDbn()
    }

    override suspend fun getSatScoreForSchool(dbn: String): List<SchoolSatDTO> {
        return nycSchoolService.getSchoolDBNSatScore(dbn)
    }


    override suspend fun getSchoolInfo(dbn: String): SchoolInformationEntity? {
        return nycSchoolDatabase.schoolInfoDao().getSchoolInfoForDBN(dbn)
    }

    override suspend fun saveTimeStamp(timestamp: String) {
        nycSchoolsDataStore.saveTimeStamp(timestamp)
    }

    override suspend fun getTimeStamp(): String {
        return nycSchoolsDataStore.getTimeStamp()
    }

}