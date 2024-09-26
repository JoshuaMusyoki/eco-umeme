package com.ecoumeme.ecoumeme.presentation.FinalResponse

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorScreen(navController: NavController) {
    Scaffold(
    topBar = { TopAppBar(title = { Text("Form Submission Error") }) },
    content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("There was an error submitting your form.")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Please try again.")
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedButton(onClick = {
                navController.navigate("energy_survey_form") {
                    popUpTo("form") { inclusive = true }
                }
            }) {
                Text("Try Again")
            }
        }
    }
    )
}