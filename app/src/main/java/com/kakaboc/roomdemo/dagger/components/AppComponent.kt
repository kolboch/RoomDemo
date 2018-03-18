package com.kakaboc.roomdemo.dagger.components

import android.app.Application
import com.kakaboc.roomdemo.activities.main.MainPresenter
import com.kakaboc.roomdemo.dagger.modules.AppModule
import com.kakaboc.roomdemo.dagger.modules.RoomModule
import com.kakaboc.roomdemo.database.AppDatabase
import com.kakaboc.roomdemo.database.model.DaoTraining
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RoomModule::class], dependencies = [])
interface AppComponent {

    fun inject(presenter: MainPresenter)

    fun trainingDao(): DaoTraining

    fun appDatabase(): AppDatabase

    fun application(): Application

}