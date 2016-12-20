package com.fudan.asuper.circuitmania;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

import com.fudan.asuper.circuitmania.Components.Component;
import com.fudan.asuper.circuitmania.Components.InPort;
import com.fudan.asuper.circuitmania.Components.NorGate;
import com.fudan.asuper.circuitmania.Components.NotGate;
import com.fudan.asuper.circuitmania.Components.OrGate;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by SailW on 2016/9/26.
 */

public class State {
    final MainActivity mainActivity;
    public int mission,submission;
    public String username;
    public Stack<View> pages;
    public Integer level;
    public Map<Integer, Stack<Circuit>> circuits;
    public Map<Integer, Integer> cost;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public State(final MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        preferences = mainActivity.getSharedPreferences("state", mainActivity.MODE_PRIVATE);
        editor = preferences.edit();
        cost=new HashMap<>();
        load();
    }

    public void load() {
        username=preferences.getString("username","");
        level=preferences.getInt("level",200);
        if(username==null)username="";
        if(level==null ||level<200)level=200;
        for(Component c:Component.components) {
            Integer x=preferences.getInt("comp"+Integer.toString(c.descriptionID),0);
            if(x==null)x=0;
            if(c instanceof NotGate || c instanceof OrGate)x=10;
            cost.put(c.descriptionID, x);
        }
        pages=new Stack<>();
        circuits=new HashMap<>();
    }

    public void save() {
        if(username.equals("reset")) {
            username="";
            level=200;
            mainActivity.submissionViewManager.setColor();
        }
        editor.putString("username",username);
        editor.putInt("level",level);
        for(Integer did:cost.keySet()) {
            editor.putInt("comp"+Integer.toString(did),cost.get(did));
        }
        editor.commit();
    }
}
