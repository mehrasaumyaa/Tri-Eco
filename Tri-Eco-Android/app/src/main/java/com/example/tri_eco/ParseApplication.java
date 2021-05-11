package com.example.tri_eco;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Sell.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("KgscKcV6mTsZRC6x0rnwEBgcHEpNVDOz7r2shrvA")
                .clientKey("BuxPUiFd3b9o0gxACLHnlAhgakwNDovYqFhOn2qc")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

