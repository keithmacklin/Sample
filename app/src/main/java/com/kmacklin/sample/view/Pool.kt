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
import com.kmacklin.sample.viewmodel.PoolViewModel

@Composable
fun PoolScreen(
    viewModel: PoolViewModel
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
                    val pool = viewModel.pool
                    TextField(
                        value = pool,
                        onValueChange = viewModel::updatePool,
                        enabled = true,
                        label = { Text(text = "Pool") },
                    )
                }
                Row {
                    val word = viewModel.word
                    TextField(
                        value = word,
                        onValueChange = viewModel::updateWord,
                        enabled = true,
                        label = { Text(text = "Word") },
                    )
                }
                Button(
                    onClick = { viewModel.updateText() }
                ) {
                    Text("Click Me")
                }
                Text(viewModel.output, fontSize = 30.sp)
            }
        }
    }
}