package com.kakaboc.roomdemo.activities.main.dagger

import com.kakaboc.roomdemo.activities.main.MainView
import dagger.Module
import dagger.Provides

@Module
class MainViewModule(
        private val view: MainView
) {

    @Provides
    fun providesView(): MainView {
        return view
    }
}