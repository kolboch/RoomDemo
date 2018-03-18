package com.kakaboc.roomdemo.activities.main.dagger

import android.app.Application
import com.kakaboc.roomdemo.activities.dagger.AppModule
import com.kakaboc.roomdemo.activities.main.MainActivity
import com.kakaboc.roomdemo.activities.main.MainView
import com.kakaboc.roomdemo.database.AppDatabase
import com.kakaboc.roomdemo.database.dagger.RoomModule
import com.kakaboc.roomdemo.database.model.DaoTraining
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RoomModule::class, MainViewModule::class], dependencies = [])
interface MainComponent {

    fun inject(activity: MainActivity)

    fun trainingDao(): DaoTraining

    fun appDatabase(): AppDatabase

    fun mainView(): MainView

    fun application(): Application

}