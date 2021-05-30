package com.example.tri_eco;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.io.File;

@ParseClassName("Profile")
public class Profile extends ParseObject {
    private static final String KEY_PROFILE_PICTURE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_EMAIL = "email";

//    public Profile() {
//
//   }

    public ParseFile getProfilePicture() {
        return getParseFile(KEY_PROFILE_PICTURE);
    }

    public ParseUser getUser(){ return getParseUser(KEY_USER); }

    public void setProfilePicture(ParseFile profilePicture){
        put(KEY_PROFILE_PICTURE, profilePicture);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }

    public void setEmail(String email){
        put(KEY_EMAIL, email);
    }
}
