package com.fudan.asuper.circuitmania.ViewManagers;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/25.
 */

public final class MessageViewManager extends ViewManager {
    Resources res;
    FrameLayout msg_content;
    TextView msg_text;
    View msg_opt;
    public MessageViewManager(final MainActivity mainActivity){
        super(mainActivity,R.layout.message);
        res = mainActivity.getResources();
        msg_content=(FrameLayout)view.findViewById(R.id.msg_content);
        msg_opt=mainActivity.inflater.inflate(R.layout.msg_opt,null);
        msg_text=(TextView)mainActivity.inflater.inflate(R.layout.msg_text,null);
        initFont();
    }

    void initFont() {
        AssetManager mgr=mainActivity.getAssets();
        Typeface tf=Typeface.createFromAsset(mgr, "fonts/xjlFont.fon");
        ((TextView)msg_opt.findViewById(R.id.msg_username)).setTypeface(tf);
        msg_text.setTypeface(tf);
    }

    public void show_help_msg(int msg_id) {
        msg_text.setText(res.getString(msg_id));
        msg_content.removeAllViews();
        msg_content.addView(msg_text);
        mainActivity.mContentView.addView(view);
    }

    public void show_option_msg() {
        ((EditText)msg_opt.findViewById(R.id.msg_input_name)).setText(mainActivity.state.username);
        msg_content.removeAllViews();
        msg_content.addView(msg_opt);
        mainActivity.mContentView.addView(view);
    }

    @Override
    public void initFunc() {
        View.OnClickListener msg_back= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.state.username=((EditText)msg_opt.findViewById(R.id.msg_input_name)).getText().toString();
                ((FrameLayout)mainActivity.mContentView).removeView(view);
                mainActivity.state.save();
                mainActivity.hide();
            }
        };
        view.findViewById(R.id.msg_back0).setOnClickListener(msg_back);
        view.findViewById(R.id.msg_back1).setOnClickListener(msg_back);
    }
}
