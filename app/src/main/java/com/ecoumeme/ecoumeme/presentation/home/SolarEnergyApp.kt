package com.ecoumeme.ecoumeme.presentation.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SolarEnergyApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "form") {
        composable("form") {
            EnergyForm(navController = navController)
        }
        composable("recommendation/{location}/{bill1}/{bill2}/{bill3}/{fridge}/{washer}/{ac}/{cooker}/{inspectionDate}") { backStackEntry ->
            RecommendationScreen(
                location = backStackEntry.arguments?.getString("location") ?: "",
                billMonth1 = backStackEntry.arguments?.getString("bill1")?.toInt() ?: 0,
                billMonth2 = backStackEntry.arguments?.getString("bill2")?.toInt() ?: 0,
                billMonth3 = backStackEntry.arguments?.getString("bill3")?.toInt() ?: 0,
                hasFridge = backStackEntry.arguments?.getString("fridge") == "true",
                hasWasher = backStackEntry.arguments?.getString("washer") == "true",
                hasAC = backStackEntry.arguments?.getString("ac") == "true",
                hasCooker = backStackEntry.arguments?.getString("cooker") == "true",
                inspectionDate = backStackEntry.arguments?.getString("inspectionDate") ?: "N/A"
            )
        }
    }
}