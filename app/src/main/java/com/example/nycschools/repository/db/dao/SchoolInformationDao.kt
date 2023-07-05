package com.example.nycschools.repository.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nycschools.repository.db.models.SchoolInformationEntity

@Dao
interface SchoolInformationDao {
    @Query("SELECT * FROM SchoolInformation")
    suspend fun getAllSchools(): List<SchoolInformationEntity>?

    @Query("""
            Update SchoolInformation SET 
            mathScore = :mathScore,
            readingScore = :readingScore,
            writingScore = :writingScore WHERE dbn = :dbn
            """
    )
    suspend fun update(dbn: String, mathScore: String, readingScore: String, writingScore: String)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<SchoolInformationEntity>)

    @Query("SELECT * FROM SchoolInformation WHERE dbn = :dbnData")
    suspend fun getSchoolInfoForDBN(dbnData: String): SchoolInformationEntity?
}