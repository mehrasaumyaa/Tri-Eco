package com.example.tri_eco;

import android.app.Application;
import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //TODO: replace applicationId and clientKey with your specific values
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ZejJfLpd30Zz8zBpJiTOyPZODgeNYEttEsNWA5m6")
                .clientKey("e52R23fM370EkXmMrW3Ej9MVHwkgQ0INmbxxdUZs")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
