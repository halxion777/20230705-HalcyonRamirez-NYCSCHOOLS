package com.example.nycschools.ui.components.SchoolInformation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nycschools.repository.network.data.SchoolInformationDTO


@Composable
fun SchoolInformation(currentSchool: SchoolInformationDTO, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Text(
            text = currentSchool.schoolName ?: "",
            fontSize = 50.sp,
            lineHeight = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = currentSchool.overviewParagraph ?: "")
        currentSchool.extracurricularActivities?.let {
            val items = it.split(",")
            Extracurriculars(extracurriculars = items)
        }
        if (currentSchool.mathScore != null) {
            Spacer(modifier = Modifier.height(20.dp))
            SatScores(
                mathScore = currentSchool.mathScore ?: "",
                readingScore = currentSchool.readingScore ?: "",
                writingScore = currentSchool.writingScore ?: ""
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        ContactInformation(
            schoolEmail = currentSchool.schoolEmail ?: "",
            phoneNumber = currentSchool.phoneNumber ?: "",
            website = currentSchool.website ?: "",
            faxNumber = currentSchool.faxNumber ?: ""
        )
    }
}