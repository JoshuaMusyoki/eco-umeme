package com.ecoumeme.ecoumeme.presentation.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FeaturesScreen(){
    val context = LocalContext.current

    // States for form inputs
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
        topBar = {
            TopAppBar(title = { Text("EcoUmeme Energy Evaluation Form") })
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Location input
                TextField(
                    value = location.value,
                    onValueChange = { location.value = it },
                    label = { Text("Location") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Electricity bills for last 3 months
                TextField(
                    value = billMonth1.value,
                    onValueChange = { billMonth1.value = it },
                    label = { Text("Electricity Bill - Month 1") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                TextField(
                    value = billMonth2.value,
                    onValueChange = { billMonth2.value = it },
                    label = { Text("Electricity Bill - Month 2") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                TextField(
                    value = billMonth3.value,
                    onValueChange = { billMonth3.value = it },
                    label = { Text("Electricity Bill - Month 3") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                // Appliance Checkboxes
                Text("Do you have these appliances?")

                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = hasFridge.value,
                        onCheckedChange = { hasFridge.value = it }
                    )
                    Text("Fridge")
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = hasWasher.value,
                        onCheckedChange = { hasWasher.value = it }
                    )
                    Text("Washer")
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = hasAC.value,
                        onCheckedChange = { hasAC.value = it }
                    )
                    Text("AC")
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = hasCooker.value,
                        onCheckedChange = { hasCooker.value = it }
                    )
                    Text("Cooker")
                }

                // Request Inspection Toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Request Inspection?")
                    Switch(
                        checked = requestInspection.value,
                        onCheckedChange = { requestInspection.value = it }
                    )
                }

                // If requesting inspection, show DatePicker for inspection date
                if (requestInspection.value) {
                    TextField(
                        value = inspectionDate.value,
                        onValueChange = { inspectionDate.value = it },
                        label = { Text("Select Inspection Date (DD/MM/YYYY)") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                // Submit Button
                Button(
                    onClick = {
                        // Handle form submission logic (e.g., send to a server)
                        Toast.makeText(context, "Form Submitted", Toast.LENGTH_LONG).show()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Submit")
                }
            }
        }
    )
}

@Preview
@Composable
fun FeaturesScreenPreview(){
    FeaturesScreen()
}