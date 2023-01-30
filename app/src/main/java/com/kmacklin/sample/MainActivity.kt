package com.kmacklin.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kmacklin.sample.ui.theme.SampleTheme
import com.kmacklin.sample.view.StartScreen
import com.kmacklin.sample.viewmodel.CoinChangeViewModel
import com.kmacklin.sample.viewmodel.PoolViewModel
import com.kmacklin.sample.viewmodel.ReadFileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        StartScreen(navController)
                    }
                    composable(
                        route = "problems/pool",
                    ) {
                        poolOfWordsScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = "problems/coinChange",
                    ) {
                        coinChangeScreen(
                            navController = navController,
                        )
                    }
                    composable(
                        route = "problems/readFile",
                    ) {
                        readFile(
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun poolOfWordsScreen(navController: NavController) {
    val viewModel = PoolViewModel()

    PoolScreen(viewModel = viewModel)
}

@Composable
fun coinChangeScreen(navController: NavController) {
    val viewModel = CoinChangeViewModel()

    coinChangeScreen(viewModel = viewModel)
}

@Composable
fun readFile(navController: NavController) {
    val viewModel = ReadFileViewModel()

    readFileScreen(viewModel = viewModel)
}
