package com.example.nycschools.repository.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NycSchoolsDataStore @Inject constructor(private val store: DataStore<Preferences>) {
    suspend fun saveTimeStamp(data: String) {
        store.edit { settings ->
            settings[TIMESTAMP] = data
        }
    }

    suspend fun getTimeStamp(): String {
        val timestamp = store.data.map { pref -> pref[TIMESTAMP] ?: "" }.first()
        return timestamp
    }

    suspend fun saveDbn(dbn: String) {
        store.edit { settings ->
            settings[DBN] = dbn
        }
    }
    suspend fun getDbn(): String {
        return store.data.map { pref -> pref[DBN] ?: "" }.first()
    }

    suspend fun isCacheExpired(): Boolean {
        val timestamp = getTimeStamp()
        return if (timestamp.isEmpty()) {
            true
        } else {
            val prevTimestamp = timestamp.toLong()
            val currentTimeStamp = System.currentTimeMillis()
            val diff = (currentTimeStamp - prevTimestamp) / (1000 * 60 * 60)
            diff >= 6
        }

    }

    companion object {
        val Context.store by preferencesDataStore("prefs")
        val TIMESTAMP = stringPreferencesKey("timestamp")
        val DBN = stringPreferencesKey("dbn")
    }

}

