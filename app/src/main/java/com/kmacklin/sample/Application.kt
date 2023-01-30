package com.kmacklin.sample

import androidx.multidex.MultiDexApplication

open class Application : MultiDexApplication() {
    companion object {
        var dependencies: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        initializeDagger()
    }

    private fun initializeDagger() {
        if (dependencies == null) {
            dependencies = DaggerAppComponent
                .builder()
                .appModule(AppModule(applicationContext))
                .build()
        }
        dependencies?.inject(this)
    }
}