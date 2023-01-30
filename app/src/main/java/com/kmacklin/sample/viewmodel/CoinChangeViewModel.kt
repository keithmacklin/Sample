package com.kmacklin.sample.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CoinChangeViewModel() : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    @Inject
    lateinit var applicationContext: Context

    // var state by mutableStateOf(FirstAppState())
    var amount by mutableStateOf("")
    var output by mutableStateOf("")

    fun updateAmount() {
        output = getChange()
    }

    fun getChange(): String {
        var remainingAmount = amount.toDouble()
        var coins = ""
        listOf(0.25,0.10,0.05,0.01).onEach { coin ->
            coins += "${coin}: ${((remainingAmount/coin).toInt())}\n"
            remainingAmount %= coin
        }
        return coins
    }

    fun updateDollarAmount(_amount: String) {
        amount = _amount
    }
}