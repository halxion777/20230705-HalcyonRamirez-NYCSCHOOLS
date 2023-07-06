package com.example.nycschools.pages.medium

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.nycschools.R
import com.example.nycschools.ui.components.SchoolInformation.SchoolInformation
import com.example.nycschools.ui.components.SchoolList.SchoolList
import com.example.nycschools.ui.components.common.CircularProgressBar
import com.example.nycschools.ui.events.NycSchooInfoScreenUIEvents
import com.example.nycschools.vm.SharedVM

@Composable
fun NycSchoolMedium(vm: SharedVM) {
    val state by vm.state.collectAsState()
    if (state.schoolMap.size > 1) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            SchoolList(schoolMap = state.schoolMap.toList(), onClick = {
                vm.uiEvent(NycSchooInfoScreenUIEvents.GetSchoolInfoForDBN(it))
            }, modifier = Modifier.weight(0.3f))

            SchoolInformation(
                currentSchool = state.currentSchool!!,
                modifier = Modifier.weight(0.7f)
            )
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center), horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressBar()

        }
    }

    if (state.schoolMap.isEmpty()) {
        LaunchedEffect(vm) {
            vm.uiEvent(NycSchooInfoScreenUIEvents.LoadInitialData)
        }
    }
}