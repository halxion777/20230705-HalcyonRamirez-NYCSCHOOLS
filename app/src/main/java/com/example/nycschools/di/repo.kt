package com.example.nycschools.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.example.nycschools.repository.NycSchoolsRepo
import com.example.nycschools.repository.NycSchoolsRepoImpl
import com.example.nycschools.repository.datastore.NycSchoolsDataStore
import com.example.nycschools.repository.datastore.NycSchoolsDataStore.Companion.store
import com.example.nycschools.repository.db.NycSchoolDatabase
import com.example.nycschools.repository.network.NycSchoolsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideNycSchoolsService(): NycSchoolsService {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(NycSchoolsService::class.java)
    }


    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): NycSchoolDatabase {
        return Room.databaseBuilder(
            context,
            NycSchoolDatabase::class.java,
            NycSchoolDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.store
    }


    @Provides
    @Singleton
    fun provideRepository(
        nycSchoolsService: NycSchoolsService,
        nycSchoolDatabase: NycSchoolDatabase,
        nycSchoolsDataStore: NycSchoolsDataStore
    ): NycSchoolsRepo {
        return NycSchoolsRepoImpl(nycSchoolsService, nycSchoolDatabase, nycSchoolsDataStore)
    }
}