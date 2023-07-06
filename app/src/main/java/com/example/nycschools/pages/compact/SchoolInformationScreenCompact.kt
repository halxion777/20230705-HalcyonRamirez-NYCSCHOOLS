package com.example.nycschools.pages.compact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.nycschools.R
import com.example.nycschools.ui.components.SchoolInformation.SchoolInformation
import com.example.nycschools.vm.SharedVM


@Composable
fun SchoolInformationScreenCompact(
    navController: NavController,
    vm: SharedVM
) {
    val state = vm.state.value

    if (state.currentSchool?.dbn != null) {
        SchoolInformation(currentSchool = state.currentSchool!!)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(text = stringResource(R.string.fetching_schoolinformation))
        }
    }
}

