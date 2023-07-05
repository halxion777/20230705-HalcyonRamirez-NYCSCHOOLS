package com.example.nycschools.repository.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nycschools.repository.network.data.SchoolInformationDTO


@Entity(tableName = "SchoolInformation")
data class SchoolInformationEntity(
    @PrimaryKey val dbn: String = "",
    var schoolName: String = "",
    var boro: String = "",
    var overviewParagraph: String = "",
    var ellPrograms: String = "",
    var neighborhood: String = "",
    var location: String = "",
    var phoneNumber: String = "",
    var faxNumber: String = "",
    var schoolEmail: String = "",
    var website: String = "",
    var totalStudents: String = "",
    var extracurricularActivities: String =  "",
    var schoolSports: String = "",
    var primaryAddressLine1: String = "",
    var city: String = "",
    var zip: String =  "",
    var stateCode: String =  "",
    var latitude: String =  "",
    var longitude: String = "",
    var communityBoard: String = "",
    var councilDistrict: String = "",
    var borough: String = "",
    var mathScore: String? = null,
    var readingScore: String? = null,
    var writingScore: String? = null
)


fun List<SchoolInformationEntity>.toDTOs(): List<SchoolInformationDTO> {
    return this.map {
        it.toDTO()
    }
}


fun SchoolInformationEntity.toDTO(): SchoolInformationDTO {
    return SchoolInformationDTO(
        dbn = dbn,
        schoolName = schoolName,
        boro = boro,
        overviewParagraph = overviewParagraph,
        ellPrograms = ellPrograms,
        neighborhood = neighborhood,
        location = location,
        phoneNumber = phoneNumber,
        faxNumber = faxNumber,
        schoolEmail = schoolEmail,
        website = website,
        totalStudents = totalStudents,
        extracurricularActivities = extracurricularActivities,
        schoolSports = schoolSports,
        primaryAddressLine1 = primaryAddressLine1,
        city = city,
        zip = zip,
        stateCode = stateCode,
        latitude = latitude,
        longitude = longitude,
        communityBoard = communityBoard,
        councilDistrict = councilDistrict,
        borough = borough,
        mathScore = mathScore,
        writingScore = writingScore,
        readingScore = readingScore
    )
}
