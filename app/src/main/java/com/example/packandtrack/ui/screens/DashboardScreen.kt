package com.example.packandtrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(onAddFoodClick: () -> Unit, onWeightClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text("Astăzi", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.background(Color.Yellow).padding(16.dp))
        Spacer(Modifier.height(16.dp))
        Text("Calorii: 0 / 2000 kcal")
        Spacer(Modifier.height(24.dp))
        Button(onClick = onAddFoodClick) {
            Text("Adaugă aliment")
        }
        Button(onClick = onWeightClick) {
            Text("Greutate")
        }
    }
}