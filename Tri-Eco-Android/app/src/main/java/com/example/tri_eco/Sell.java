package com.example.tri_eco;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Sell")
public class Sell extends ParseObject {
    //TODO: match field names with variables here
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_PRICE = "price";
    public static final String KEY_CONDITION = "condition";
    public static final String KEY_EMAIL = "email";

    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_AT = "createdAt";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public String getPrice(){
        return getString(KEY_PRICE);
    }

    public String getCondition(){
        return getString(KEY_CONDITION);
    }

    public String getEmail(){
        return getString(KEY_EMAIL);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }
}

