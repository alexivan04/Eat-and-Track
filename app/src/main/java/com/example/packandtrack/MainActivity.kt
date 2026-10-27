package com.example.packandtrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.example.packandtrack.ui.theme.PackAndTrackTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.packandtrack.ui.screens.DashboardScreen
import com.example.packandtrack.ui.screens.FoodSearchScreen
import com.example.packandtrack.ui.screens.WeightScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PackAndTrackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "dashboard",
        modifier = modifier
    ) {
        composable("dashboard") {
            DashboardScreen(
                onAddFoodClick = { navController.navigate("search") { launchSingleTop = true }},
                onWeightClick = { navController.navigate("weight") { launchSingleTop = true }}
            )
        }
        composable("search") {
            FoodSearchScreen(onBack = { navController.popBackStackSafely() })
        }

        composable("weight") {
            WeightScreen(onBack = { navController.popBackStackSafely() })
        }
    }
}

fun NavController.popBackStackSafely() {
    if (currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
        popBackStack()
    }
}
