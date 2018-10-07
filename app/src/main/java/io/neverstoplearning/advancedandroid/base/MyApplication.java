package io.neverstoplearning.advancedandroid.base;

import android.app.Application;

import javax.inject.Inject;

import io.neverstoplearning.advancedandroid.di.ActivityInjector;

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
