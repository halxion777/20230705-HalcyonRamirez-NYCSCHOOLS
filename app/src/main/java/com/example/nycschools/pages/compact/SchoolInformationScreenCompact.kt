package com.example.nycschools.pages.compact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.nycschools.R
import com.example.nycschools.ui.components.SchoolInformation.SchoolInformation
import com.example.nycschools.vm.SchoolInformationUIEvent
import com.example.nycschools.vm.SchoolInformationVM
import com.example.nycschools.vm.SchoolListVM


@Composable
fun SchoolInformationScreenCompact(
    schoolId: String,
    navController: NavController,
    vm: SchoolInformationVM
) {
    val currentSchool = vm.state.value

    if (currentSchool.dbn != null) {
        SchoolInformation(currentSchool = currentSchool)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(text = stringResource(R.string.fetching_schoolinformation))
        }
    }
    LaunchedEffect(key1 = schoolId) {
        vm.uiEvent(SchoolInformationUIEvent.GetSchoolInformationDBN(schoolId))
    }
}
