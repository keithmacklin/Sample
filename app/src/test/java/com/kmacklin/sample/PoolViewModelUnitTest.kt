package com.kmacklin.sample

import com.kmacklin.sample.viewmodel.PoolViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PoolViewModelUnitTest {

    @Test
    fun shouldReturnFalseWhenPoolDoesNotHaveLetters() {
        val target = PoolViewModel()
        target.pool = "helllll"
        target.word = "hello"

        assertEquals(target.setFromASet(), false)
    }

    @Test
    fun shouldReturnTrueWhenPoolDoesHaveLetters() {
        val target = PoolViewModel()
        target.pool = "helllllo"
        target.word = "hello"

        assertEquals(target.setFromASet(), true)
    }
}