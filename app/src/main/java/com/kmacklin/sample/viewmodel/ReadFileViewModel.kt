package com.kmacklin.sample.viewmodel

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmacklin.sample.ReadFileState
import com.kmacklin.sample.service.FileService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class ReadFileViewModel(_context: Context) : ViewModel() {

    @Inject lateinit var fileService: FileService

    // var state by mutableStateOf(FirstAppState())
    var filename by mutableStateOf("t1.txt")
    var output by mutableStateOf("")
    val uiState = mutableStateOf(
        ReadFileState(
            isLoading = false,
            isOnError = false,
            fileMessage = null
        )
    )
    val context = _context

    fun updateFileName(_filename: String) {
        filename = _filename
    }

    // fun readFile() = fileService.readFile(viewModelScope, filename, context, uiState)

    fun readFile() {
        viewModelScope.launch(Dispatchers.IO) {
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