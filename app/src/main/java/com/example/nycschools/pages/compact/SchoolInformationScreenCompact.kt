package com.example.nycschools.pages.compact

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nycschools.R
import com.example.nycschools.ui.components.SchoolInformation.SchoolInformation
import com.example.nycschools.ui.components.common.CircularProgressBar
import com.example.nycschools.ui.events.NycSchooInfoScreenUIEvents
import com.example.nycschools.vm.SharedVM


@Composable
fun SchoolInformationScreenCompact(
    navController: NavController,
    vm: SharedVM
) {
    val state by  vm.state.collectAsState()

    if (state.currentSchool?.dbn != null) {
        SchoolInformation(currentSchool = state.currentSchool!!)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            CircularProgressBar()
        }
    }
    BackHandler {
        vm.uiEvent(NycSchooInfoScreenUIEvents.BackPressed)
        navController.popBackStack()
    }
}

