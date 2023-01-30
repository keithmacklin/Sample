package com.kmacklin.sample.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.io.InputStream
import javax.inject.Inject

class PoolViewModel() : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    @Inject
    lateinit var applicationContext: Context

    // var state by mutableStateOf(FirstAppState())
    var pool by mutableStateOf("")
    var word by mutableStateOf("")
    var output by mutableStateOf("")

    fun updateText() {
        output = setFromASet().toString()
    }

    fun setFromASet(): Boolean {
        val poolArray = pool.toCharArray()
        val poolMap = mutableMapOf<Char, Int>()
        poolArray.forEach {
            val count = poolMap.getOrElse(it, {0})
            poolMap.set(it, count + 1)
        }

        word.toCharArray().forEach {
            val count = poolMap.getOrElse(it, {0})
            if (count == 0) return false
            poolMap.set(it, count - 1)
        }
        return true
    }

    fun updatePool(_pool: String) {
        Log.d("Updating pool to: ", _pool)
        pool = _pool
    }

    fun updateWord(_word: String) {
        Log.d("Updating word to: ", _word)
        word = _word
    }
}