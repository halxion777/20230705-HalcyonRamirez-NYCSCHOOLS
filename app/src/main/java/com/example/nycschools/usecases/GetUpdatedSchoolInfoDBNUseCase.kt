package com.example.nycschools.usecases

import com.example.nycschools.repository.NycSchoolsRepo
import com.example.nycschools.repository.db.models.SchoolInformationEntity
import com.example.nycschools.repository.db.models.toDTO
import com.example.nycschools.repository.network.data.SchoolInformationDTO
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GetUpdatedSchoolInfoDBNUseCase @Inject constructor(private val repo: NycSchoolsRepo) {
    suspend operator fun invoke(dbn: String): SchoolInformationDTO {
        val schoolInfo = repo.getSchoolInfo(dbn)
        if (schoolInfo != null && schoolInfo.mathScore == null) {
            val satData = repo.getSatScoreForSchool(dbn)
            if (satData.size == 1) {
                repo.updateSchoolSatScore(dbn, satData[0])
                return schoolInfo.copy(
                    mathScore = satData[0].satMathAvgScore,
                    readingScore = satData[0].satCriticalReadingAvgScore,
                    writingScore = satData[0].satWritingAvgScore
                ).toDTO()
            }
        }
        return schoolInfo!!.toDTO()

    }
}