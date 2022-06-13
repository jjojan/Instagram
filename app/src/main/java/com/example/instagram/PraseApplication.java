package com.example.instagram;

import android.app.Application;

import com.parse.Parse;

public class PraseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Inal0ODHrPqFV4IxrU7qDxbHtuJyGl5fAP9paJ8q")
                .clientKey("2DRdTXr6JOpK3kcd59gebkBqBWv6xpKd4Tsu3FPo")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

    }

