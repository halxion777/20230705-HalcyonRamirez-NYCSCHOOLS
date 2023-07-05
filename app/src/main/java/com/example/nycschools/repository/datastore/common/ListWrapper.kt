package com.example.nycschools.repository.datastore.common

import com.example.nycschools.repository.network.data.SchoolInformationDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListWrapper(@Json(name="list") val list: List<SchoolInformationDTO>)