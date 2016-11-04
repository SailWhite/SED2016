package com.fudan.asuper.circuitmania.ViewManagers;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fudan.asuper.circuitmania.Components.Component;
import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.R;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by SailW on 2016/9/25.
 */

public final class MessageViewManager extends ViewManager {
    FrameLayout msg_content;
    View msg_opt,msg_text,msg_port;
    Consumer<Object> onBack=null;
    Typeface tf;

    public MessageViewManager(final MainActivity mainActivity){
        super(mainActivity,R.layout.message);
        msg_content=(FrameLayout)view.findViewById(R.id.msg_content);
        msg_opt=mainActivity.inflater.inflate(R.layout.msg_opt,null);
        msg_text=mainActivity.inflater.inflate(R.layout.msg_text,null);
        msg_port=mainActivity.inflater.inflate(R.layout.msg_port,null);
        initFont();
    }

    void initFont() {
        AssetManager mgr=mainActivity.getAssets();
        tf=Typeface.createFromAsset(mgr, "fonts/xjlFont.fon");
        ((TextView)msg_opt.findViewById(R.id.msg_username)).setTypeface(tf);
        ((TextView)msg_text.findViewById(R.id.msg_text_content)).setTypeface(tf);
    }

    public void show_text_msg(int msg_id) {
        initFunc();
        show_text_msg(mainActivity.res.getString(msg_id));
    }

    public void show_text_msg(String msg) {
        initFunc();
        ((TextView)msg_text.findViewById(R.id.msg_text_content)).setText(msg);
        msg_content.removeAllViews();
        msg_content.addView(msg_text);
        mainActivity.mContentView.addView(view);
    }

    public void show_option_msg() {
        initFunc();
        ((EditText)msg_opt.findViewById(R.id.msg_input_name)).setText(mainActivity.state.username);
        msg_content.removeAllViews();
        msg_content.addView(msg_opt);
        mainActivity.mContentView.addView(view);
    }

    void show_port_msg(Component c1, Component c2) {
        Integer[] ret={null,null};
        LinearLayout ll0=((LinearLayout)msg_port.findViewById(R.id.msg_outp));
        LinearLayout ll1=((LinearLayout)msg_port.findViewById(R.id.msg_inp));
        ll0.removeAllViews();
        ll1.removeAllViews();
        Map<Integer,TextView> map=new HashMap<>();
        for(Integer pid:c1.output.keySet()) {
            TextView tv=new TextView(mainActivity);
            tv.setText(mainActivity.res.getString(pid));
            tv.setTypeface(tf);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PT,18);
            ll0.addView(tv);
            map.put(pid,tv);
            tv.setOnClickListener(view->{
                if(ret[0]!=null) {
                    map.get(ret[0]).setBackgroundColor(mainActivity.res.getColor(R.color.colorNone));
                }
                ret[0]=pid;
                tv.setBackgroundColor(mainActivity.res.getColor(R.color.colorSltd));
            });
            System.out.println(pid);
        }
        for(Integer pid:c2.inputPort.keySet()) {
            TextView tv=new TextView(mainActivity);
            tv.setText(mainActivity.res.getString(pid));
            tv.setTypeface(tf);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PT,18);
            ll1.addView(tv);
            map.put(pid,tv);
            tv.setOnClickListener(view->{
                if(ret[1]!=null) {
                    map.get(ret[1]).setBackgroundColor(mainActivity.res.getColor(R.color.colorNone));
                }
                ret[1]=pid;
                tv.setBackgroundColor(mainActivity.res.getColor(R.color.colorSltd));
            });
            System.out.println(pid);
        }
        msg_content.removeAllViews();
        msg_content.addView(msg_port);
        View.OnClickListener msg_back= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.state.username=((EditText)msg_opt.findViewById(R.id.msg_input_name)).getText().toString();
                if(ret[0]!=null && ret[1]!=null) {
                    c2.setPort(ret[1], c1, ret[0]);
                    mainActivity.designerViewManager.view.findViewById(R.id.dn_canvas).invalidate();
                }
                ((FrameLayout)mainActivity.mContentView).removeView(view);
                mainActivity.state.save();
                mainActivity.hide();
            }
        };
        view.findViewById(R.id.msg_back0).setOnClickListener(msg_back);
        view.findViewById(R.id.msg_back1).setOnClickListener(msg_back);
        mainActivity.mContentView.addView(view);
    }

    @Override
    public void initFunc() {
        View.OnClickListener msg_back= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.state.username=((EditText)msg_opt.findViewById(R.id.msg_input_name)).getText().toString();
                if(onBack!=null)onBack.accept(null);
                ((FrameLayout)mainActivity.mContentView).removeView(view);
                mainActivity.state.save();
                mainActivity.hide();
            }
        };
        view.findViewById(R.id.msg_back0).setOnClickListener(msg_back);
        view.findViewById(R.id.msg_back1).setOnClickListener(msg_back);
    }
}
