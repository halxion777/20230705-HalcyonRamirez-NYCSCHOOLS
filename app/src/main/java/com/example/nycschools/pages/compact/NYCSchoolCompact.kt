package com.example.nycschools.pages.compact

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nycschools.vm.SharedVM

@Composable
fun NYCSchoolCompact(viewModel: SharedVM) {
    val navController = rememberNavController()
    val startRoute = "schoolList"
    NavHost(navController, startDestination = startRoute) {
        composable(startRoute) {
            SchoolListScreenCompact(navController, vm = viewModel)
        }
        composable(
            "schoolInfo",
        ) {
            SchoolInformationScreenCompact(
                navController = navController,
                vm = viewModel,
            )
        }
    }
}