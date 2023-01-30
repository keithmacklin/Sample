package com.kmacklin.sample.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.io.InputStream
import javax.inject.Inject

class ReadFileViewModel() : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    @Inject
    lateinit var applicationContext: Context

    // var state by mutableStateOf(FirstAppState())
    var filename by mutableStateOf("")
    var output by mutableStateOf("")

    fun updateFileName(_filename: String) {
        filename = _filename
    }

    fun readFile() {
        var string: String? = ""
        try {
            val inputStream: InputStream = applicationContext.assets.open("t1.txt")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            string = String(buffer)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        output = string ?: ""
    }
}