package com.ecoumeme.ecoumeme.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecommendationScreen(
    location: String,
    billMonth1: Int,
    billMonth2: Int,
    billMonth3: Int,
    hasFridge: Boolean,
    hasWasher: Boolean,
    hasAC: Boolean,
    hasCooker: Boolean,
    inspectionDate: String
){
    val averageBill = (billMonth1 + billMonth2 + billMonth3) / 3

    // Calculation logic for recommendation
    val requiredPanels = calculateSolarPanels(averageBill)
    val recommendedInverter = calculateInverter(hasFridge, hasWasher, hasAC, hasCooker)
    val batteryStorage = calculateBatteryStorage(hasFridge, hasWasher, hasAC, hasCooker)

    Scaffold(
        topBar = { TopAppBar(title = { Text("Solar Energy Recommendation") }) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text("Based on your inputs, here is the recommendation for your solar energy setup:")

                Text("Location: $location")
                Text("Average Electricity Bill: $averageBill")

                Text("Recommended Solar Panels: $requiredPanels panels")
                Text("Recommended Inverter Size: $recommendedInverter kW")
                Text("Recommended Battery Storage: $batteryStorage kWh")

                if (inspectionDate.isNotEmpty()) {
                    Text("Inspection Date: $inspectionDate")
                }

                Button(onClick = { /* You can add a way to go back */ }) {
                    Text("Go Back")
                }
            }
        }
    )
}

// Dummy Calculation Functions (Replace with real logic)
fun calculateSolarPanels(averageBill: Int): Int {
    // Basic logic: Assume 1 panel can generate 300 watts and cover ~100kWh monthly consumption
    return (averageBill / 100) * 3 // Rough estimate for number of panels
}

fun calculateInverter(hasFridge: Boolean, hasWasher: Boolean, hasAC: Boolean, hasCooker: Boolean): Double {
    // Based on appliances, let's assume 3kW basic inverter, add 1kW per appliance
    var inverterSize = 3.0
    if (hasFridge) inverterSize += 1.0
    if (hasWasher) inverterSize += 1.0
    if (hasAC) inverterSize += 2.0 // AC consumes more power
    if (hasCooker) inverterSize += 1.5

    return inverterSize
}

fun calculateBatteryStorage(hasFridge: Boolean, hasWasher: Boolean, hasAC: Boolean, hasCooker: Boolean): Double {
    // Basic storage: 10kWh + additional capacity based on appliances
    var batteryStorage = 10.0
    if (hasFridge) batteryStorage += 1.0
    if (hasWasher) batteryStorage += 1.0
    if (hasAC) batteryStorage += 2.0
    if (hasCooker) batteryStorage += 1.5

    return batteryStorage
}