package com.example.tri_eco;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Sell")
public class Sell extends ParseObject {
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_PRICE = "price";
    public static final String KEY_CONDITION = "condition";
    public static final String KEY_EMAIL = "email";

    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_AT = "createdAt";

    //getters
    public String getTitle(){
        return getString(KEY_TITLE);
    }

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

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public ParseUser getUser(){ return getParseUser(KEY_USER); }

//    public String getKeyCreatedAt () { return getString(KEY_CREATED_AT); }

    //setters
    public void setTitle(String title){
        put(KEY_TITLE, title);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public void setPrice(String price){
        put(KEY_PRICE, price);
    }

    public void setCondition(String condition){
        put(KEY_CONDITION, condition);
    }

    public void setEmail(String email){
        put(KEY_EMAIL, email);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }
//
//    public String getFormattedTimeStamp () {
//        return TimeFormatter.getTimeDifference(getKeyCreatedAt());
//    }
}

