package com.example.nycschools


import com.example.nycschools.repository.NycSchoolsRepo
import com.example.nycschools.repository.db.models.SchoolInformationEntity
import com.example.nycschools.repository.network.data.SchoolSatDTO
import com.example.nycschools.usecases.GetUpdatedSchoolInfoDBNUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetUpdatedSchoolInfoDBNUseCaseTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    @RelaxedMockK
    lateinit var repo: NycSchoolsRepo

    private lateinit var target: GetUpdatedSchoolInfoDBNUseCase

    @Before
    fun init() {
        target = GetUpdatedSchoolInfoDBNUseCase(repo)
    }

    @Test
    fun test_getschoolInfoDBNUseCase() {
        runTest {
            val dbn = "3473"
            coEvery { repo.getSchoolInfo(dbn) } returns SchoolInformationEntity()
            coEvery { repo.getSatScoreForSchool(dbn) } returns listOf(SchoolSatDTO())
            val result = target.invoke(dbn)
            coVerify {
                repo.getSchoolInfo(dbn)
                repo.getSatScoreForSchool(dbn)
            }
        }
    }
}