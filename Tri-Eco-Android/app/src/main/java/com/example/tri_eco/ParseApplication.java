package com.example.tri_eco;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("KgscKcV6mTsZRC6x0rnwEBgcHEpNVDOz7r2shrvA")
                .clientKey("BuxPUiFd3b9o0gxACLHnlAhgakwNDovYqFhOn2qc")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

