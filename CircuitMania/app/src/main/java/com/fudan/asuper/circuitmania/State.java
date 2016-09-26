package com.fudan.asuper.circuitmania;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

import java.util.Stack;

/**
 * Created by SailW on 2016/9/26.
 */

public class State {
    final MainActivity mainActivity;
    public int mission,submission;
    public String username;
    public Stack<View> pages;
    public Stack<Circuit> circuits;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public State(final MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        preferences = mainActivity.getSharedPreferences("state", mainActivity.MODE_PRIVATE);
        editor = preferences.edit();
        load();
    }

    public void load() {
        username=preferences.getString("username","");
        if(username==null)username="";
        pages=new Stack<>();
        circuits=new Stack<>();
    }

    public void save() {
        editor.putString("username",username);
        editor.commit();
    }
}
