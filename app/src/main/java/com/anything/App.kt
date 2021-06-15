package com.anything

import android.app.Application
import com.orhanobut.logger.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber


class App : Application() {
    // I CREATED THE lateinit VARIABLE
    lateinit var customLogStrategyForTimber: LogStrategy

    override fun onCreate() {
        super.onCreate()
        Timber.plant(object : Timber.DebugTree() {
            override fun log(
                priorityTimber: Int, tagTimber: String?, message: String, t: Throwable?
            ) {

                // USED THE lateinit HERE
                customLogStrategyForTimber = object : LogcatLogStrategy() {
                    override fun log(priority: Int, tag: String?, message: String) {
                        super.log(priorityTimber, tagTimber, message)
                    }
                }

                println("customLogStrategyForTimber: ${::customLogStrategyForTimber.isInitialized}") // PRINTS TRUE
            }
        })

        println("customLogStrategyForTimber OUTSIDE: ${::customLogStrategyForTimber.isInitialized}") // PRINTS FALSE - WHY??


        var formatStrategy1 = PrettyFormatStrategy.newBuilder()

            // TRYING TO CALL THE lateinit VARIABLE HERE
            // NOW, HERE THE lateinit IS NOT INITIALIZED.
            .logStrategy(customLogStrategyForTimber)
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy1))
    }
}