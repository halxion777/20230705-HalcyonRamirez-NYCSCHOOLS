package com.example.nycschools.repository.network.data

import com.example.nycschools.repository.db.models.SchoolInformationEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class SchoolInformationDTO(
    @Json(name = "dbn") var dbn: String? = null,
    @Json(name = "school_name") var schoolName: String? = null,
    @Json(name = "boro") var boro: String? = null,
    @Json(name = "overview_paragraph") var overviewParagraph: String? = null,
    @Json(name = "ell_programs") var ellPrograms: String? = null,
    @Json(name = "neighborhood") var neighborhood: String? = null,
    @Json(name = "location") var location: String? = null,
    @Json(name = "phone_number") var phoneNumber: String? = null,
    @Json(name = "fax_number") var faxNumber: String? = null,
    @Json(name = "school_email") var schoolEmail: String? = null,
    @Json(name = "website") var website: String? = null,
    @Json(name = "total_students") var totalStudents: String? = null,
    @Json(name = "extracurricular_activities") var extracurricularActivities: String? = null,
    @Json(name = "school_sports") var schoolSports: String? = null,
    @Json(name = "primary_address_line_1") var primaryAddressLine1: String? = null,
    @Json(name = "city") var city: String? = null,
    @Json(name = "zip") var zip: String? = null,
    @Json(name = "state_code") var stateCode: String? = null,
    @Json(name = "latitude") var latitude: String? = null,
    @Json(name = "longitude") var longitude: String? = null,
    @Json(name = "community_board") var communityBoard: String? = null,
    @Json(name = "council_district") var councilDistrict: String? = null,
    @Json(name = "borough") var borough: String? = null,
    var mathScore: String? = null,
    var readingScore: String? = null,
    var writingScore: String? = null
)

fun List<SchoolInformationDTO>.toEntities(): List<SchoolInformationEntity> {
    return this.map {
        SchoolInformationEntity(
            dbn = it.dbn ?: "",
            schoolName = it.schoolName ?: "",
            boro = it.boro ?: "",
            overviewParagraph = it.overviewParagraph?: "",
            ellPrograms = it.ellPrograms ?: "",
            neighborhood = it.neighborhood ?: "",
            location = it.location ?: "",
            phoneNumber = it.phoneNumber ?: "",
            faxNumber = it.faxNumber ?: "",
            schoolEmail = it.schoolEmail ?: "",
            website = it.website ?: "",
            totalStudents = it.totalStudents ?: "",
            extracurricularActivities = it.extracurricularActivities ?: "",
            schoolSports = it.schoolSports ?: "",
            primaryAddressLine1 = it.primaryAddressLine1 ?: "",
            city = it.city ?: "",
            zip = it.zip ?: "",
            stateCode = it.stateCode ?: "",
            latitude = it.latitude ?: "",
            longitude = it.longitude ?: "",
            communityBoard = it.communityBoard ?: "",
            councilDistrict = it.councilDistrict ?: "",
            borough = it.borough ?: "",
        )
    }
}