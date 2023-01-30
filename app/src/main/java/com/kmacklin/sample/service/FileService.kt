package com.kmacklin.sample.service

import android.content.Context
import androidx.compose.runtime.MutableState
import com.kmacklin.sample.ReadFileState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class FileService @Inject constructor() {

    fun readFile(
        scope: CoroutineScope,
        filename: String,
        context: Context,
        uiState: MutableState<ReadFileState>
    ) {
        scope.launch(Dispatchers.IO) {
            try {
                val inputStream: InputStream = context.assets.open(filename)
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                val string = String(buffer)
                launch(Dispatchers.Main) {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        isOnError = false,
                        fileMessage = string
                    )
                }
            } catch (e: IOException) {
                e.printStackTrace()
                launch(Dispatchers.Main) {
                    uiState.value = uiState.value.copy(
                        isLoading = false,
                        isOnError = true,
                        fileMessage = null
                    )
                }
            }
        }
    }
}