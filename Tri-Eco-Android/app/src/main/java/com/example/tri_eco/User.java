package com.example.tri_eco;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

@ParseClassName("User")
public class User extends ParseUser {
    private static final String KEY_PROFILE_PICTURE = "profile_picture";
    private static final String COLLEGE_NAME = "college_name";
    ParseUser user;

    public String getCollegeName() {
        ParseUser currentUser = ParseUser.getCurrentUser();

        return currentUser.getString(COLLEGE_NAME); }

    public ParseFile getProfilePicture() {
        return getParseFile(KEY_PROFILE_PICTURE);
    }

    public void setCollegeName(String collegeName) {
        put(COLLEGE_NAME, collegeName);
    }

    public static void setCurrentUserProfilePicture(ParseFile profilePicture, SaveCallback callback){
        ParseUser currentUser = ParseUser.getCurrentUser();
        currentUser.put(KEY_PROFILE_PICTURE, profilePicture);
        currentUser.saveInBackground(callback);
    }
}
