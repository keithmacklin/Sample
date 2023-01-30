package com.kmacklin.sample

data class ReadFileState (
    val isLoading: Boolean,
    val isOnError: Boolean,
    val fileMessage: String?
)