package com.example.nycschools.pages.compact

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NYCSchoolCompact() {
    val navController = rememberNavController()
    val startRoute = "schoolList"
    NavHost(navController, startDestination = startRoute) {
        composable(startRoute) {
            SchoolListScreenCompact(navController, vm = hiltViewModel())
        }
        composable(
            "schoolInfo/{dbn}",
            arguments = listOf(navArgument("dbn") { type = NavType.StringType })
        ) {

            SchoolInformationScreenCompact(
                schoolId = it.arguments?.getString("dbn")!!,
                navController = navController,
                vm = hiltViewModel()
            )
        }
    }
}