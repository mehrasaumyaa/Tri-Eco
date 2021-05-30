package com.example.tri_eco;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseObject {
    private static final String KEY_PROFILE_PICTURE = "profile_picture";
    ParseUser user;

//    public User() {
//   }

    public ParseFile getProfilePicture() {
        return getParseFile(KEY_PROFILE_PICTURE);
    }

    public void setProfilePicture(ParseFile profilePicture){
        ParseUser.getCurrentUser().put(KEY_PROFILE_PICTURE, profilePicture);
    }
}
