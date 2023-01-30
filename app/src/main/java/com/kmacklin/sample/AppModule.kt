package com.kmacklin.sample

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val applicationContext: Context) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        Log.d("KEITH", "MARK 1")
        return applicationContext
    }
}