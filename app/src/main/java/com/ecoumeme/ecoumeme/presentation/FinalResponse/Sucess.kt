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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SuccessScreen(navController: NavController){
    Scaffold(
        topBar = { TopAppBar(title = { Text("Form Submission Success") }) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Your form has been submitted successfully!")
                Spacer(modifier = Modifier.height(8.dp))
                Text("You will receive a message shortly.")
                Spacer(modifier = Modifier.height(24.dp))

                OutlinedButton(onClick = {
                    navController.navigate("form") {
                        popUpTo("form") { inclusive = true }
                    }
                }) {
                    Text("Go Back to Home")
                }
            }
        }
    )

}