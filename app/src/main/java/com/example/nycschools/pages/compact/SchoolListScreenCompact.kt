package com.example.nycschools.pages.compact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.nycschools.R
import com.example.nycschools.ui.components.SchoolList.SchoolList
import com.example.nycschools.ui.events.NycSchooInfoScreenUIEvents
import com.example.nycschools.vm.SharedVM


@Composable
fun SchoolListScreenCompact(
    navController: NavController,
    vm: SharedVM,
    modifier: Modifier = Modifier
) {
    val state by vm.state.collectAsState()
    val schools = state.schoolMap.toList()
    if (schools.size > 1) {
        SchoolList(schoolMap = schools, onClick = {
            vm.uiEvent(NycSchooInfoScreenUIEvents.GetSchoolInfoForDBN(it))
            vm.uiEvent(NycSchooInfoScreenUIEvents.SchoolClickNavigate {
                navController.navigate("schoolInfo")
            })
        }, modifier = modifier)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.fetching_data))
        }
    }

    if (state.schoolMap.isEmpty()) {
        LaunchedEffect(vm) {
            vm.uiEvent(NycSchooInfoScreenUIEvents.LoadInitialData)
        }
    }

}


