package com.example.nycschools.usecases

import com.example.nycschools.repository.network.data.SchoolInformationDTO
import com.example.nycschools.repository.NycSchoolsRepo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NYCGetAllSchoolsUseCase @Inject constructor(private val nycSchoolsRepo: NycSchoolsRepo) {
    suspend operator fun invoke(): List<SchoolInformationDTO> {
        return nycSchoolsRepo.getSchools()
    }
}
