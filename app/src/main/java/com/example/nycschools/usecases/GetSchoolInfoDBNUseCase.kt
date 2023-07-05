package com.example.nycschools.usecases

import com.example.nycschools.repository.NycSchoolsRepo
import com.example.nycschools.repository.db.models.SchoolInformationEntity
import javax.inject.Inject

class GetSchoolInfoDBNUseCase @Inject constructor(private val repo: NycSchoolsRepo) {
    suspend operator fun invoke(dbn:String): SchoolInformationEntity? {
        return repo.getSchoolInfo(dbn)
    }
}