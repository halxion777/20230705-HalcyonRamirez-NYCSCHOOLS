package com.example.nycschools.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nycschools.repository.db.dao.SchoolInformationDao
import com.example.nycschools.repository.db.models.SchoolInformationEntity

@Database(entities = [SchoolInformationEntity::class], version = 1)
abstract class NycSchoolDatabase: RoomDatabase() {
    abstract fun schoolInfoDao(): SchoolInformationDao

    companion object {
        const val DB_NAME = "nyc-schools-db"
    }
}