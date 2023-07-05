package com.example.nycschools

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nycschools.pages.compact.NYCSchoolCompact
import com.example.nycschools.pages.medium.NycSchoolMedium

@Composable
fun NycSchoolApp(windowSizeClass: WindowSizeClass) {
    if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
        NYCSchoolCompact()
    } else {
        NycSchoolMedium(vm = viewModel())
    }
}