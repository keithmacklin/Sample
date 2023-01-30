package com.kmacklin.sample

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmacklin.sample.ui.theme.SampleTheme
import com.kmacklin.sample.viewmodel.ReadFileViewModel

@Composable
fun readFileScreen(
    viewModel: ReadFileViewModel
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
                    val filename = viewModel.filename
                    TextField(
                        value = filename,
                        onValueChange = viewModel::updateFileName,
                        enabled = true,
                        label = { Text(text = "Enter file name") },
                    )
                }
                Button(
                    onClick = { viewModel.readFile() }
                ) {
                    Text("Read File")
                }
                Text(viewModel.output, fontSize = 30.sp)
                Spacer(modifier = Modifier.height(8.dp))
                val uiState = viewModel.uiState.value
                when {
                    uiState.isLoading -> CircularProgressIndicator()
                    uiState.isOnError -> Text(text = "Error when try load data from txt file")
                    uiState.fileMessage != null -> {
                        Text(
                            text = "${uiState.fileMessage}",
                            modifier = Modifier
                                .border(BorderStroke(2.dp, Color.Blue))
                                .background(Color.White)
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState())
                                .padding(5.dp)
                        )
                    }
                }
            }
        }
    }
}