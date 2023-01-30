package com.kmacklin.sample

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmacklin.sample.ui.theme.SampleTheme
import com.kmacklin.sample.viewmodel.CoinChangeViewModel

@Composable
fun coinChangeScreen(
    viewModel: CoinChangeViewModel
) {
    SampleTheme {
        // A surface container using the 'background' color from the theme
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row {
                    val dollarAmount = viewModel.amount
                    TextField(
                        value = dollarAmount,
                        onValueChange = viewModel::updateDollarAmount,
                        enabled = true,
                        label = { Text(text = "Enter amount") },
                    )
                }
                Button(
                    onClick = { viewModel.updateAmount() }
                ) {
                    Text("Get Change")
                }
                Text(viewModel.output, fontSize = 30.sp)
            }
        }
    }
}