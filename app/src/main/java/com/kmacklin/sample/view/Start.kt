package com.kmacklin.sample.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StartScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Start Screen")
        Button(onClick = {
            navController.navigate("problems/pool")
        }) {
            Text("Go to Pool of Words Problem")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("problems/coinChange")
        }) {
            Text("Go to Coin Change Problem")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate("problems/readFile")
        }) {
            Text("Read a File")
        }
    }

}