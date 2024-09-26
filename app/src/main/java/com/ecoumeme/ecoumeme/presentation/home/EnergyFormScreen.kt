package com.ecoumeme.ecoumeme.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EnergyForm(navController: NavHostController) {
    val location = remember { mutableStateOf("") }
    val billMonth1 = remember { mutableStateOf("") }
    val billMonth2 = remember { mutableStateOf("") }
    val billMonth3 = remember { mutableStateOf("") }

    val hasFridge = remember { mutableStateOf(false) }
    val hasWasher = remember { mutableStateOf(false) }
    val hasAC = remember { mutableStateOf(false) }
    val hasCooker = remember { mutableStateOf(false) }

    val requestInspection = remember { mutableStateOf(false) }
    val inspectionDate = remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Energy Solution Form") }) },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                TextField(
                    value = location.value,
                    onValueChange = { location.value = it },
                    label = { Text("Location") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Electricity Bill Input
                TextField(
                    value = billMonth1.value,
                    onValueChange = { billMonth1.value = it },
                    label = { Text("Electricity Bill - Month 1") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = billMonth2.value,
                    onValueChange = { billMonth2.value = it },
                    label = { Text("Electricity Bill - Month 2") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = billMonth3.value,
                    onValueChange = { billMonth3.value = it },
                    label = { Text("Electricity Bill - Month 3") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Checkbox for appliances
                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(checked = hasFridge.value, onCheckedChange = { hasFridge.value = it })
                    Text(text = "Fridge")
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(checked = hasWasher.value, onCheckedChange = { hasWasher.value = it })
                    Text(text = "Washer")
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(checked = hasAC.value, onCheckedChange = { hasAC.value = it })
                    Text(text = "AC")
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(checked = hasCooker.value, onCheckedChange = { hasCooker.value = it })
                    Text(text = "Cooker")
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Submit Button with Navigation to Recommendation Screen
                Button(
                    onClick = {
                        navController.navigate(
                            "recommendation/${location.value}/${billMonth1.value}/${billMonth2.value}/${billMonth3.value}/" +
                                    "${hasFridge.value}/${hasWasher.value}/${hasAC.value}/${hasCooker.value}/${inspectionDate.value}"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Submit & Get Recommendation")
                }
            }
        }
    )
}

@Preview
@Composable
fun EnergyFormPreview() {
    EnergyForm(navController = rememberNavController())
}
