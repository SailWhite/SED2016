package com.fudan.asuper.circuitmania;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SailW on 2016/9/25.
 */

public final class MessageManager {
    final MainActivity parent;
    Resources res;
    View.OnClickListener back;

    public MessageManager(final MainActivity parent){
        this.parent=parent;
        AssetManager mgr=parent.getAssets();//得到AssetManager
        Typeface tf=Typeface.createFromAsset(mgr, "fonts/xjlFont.fon");//根据路径得到Typeface
        ((TextView)parent.findViewById(R.id.msg_text)).setTypeface(tf);//设置字体
        ((TextView)parent.findViewById(R.id.msg_username)).setTypeface(tf);//设置字体
        res = parent.getResources();
        preferences = parent.getSharedPreferences("login", parent.MODE_PRIVATE);
        editor = preferences.edit();

        back=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.findViewById(R.id.msg_text).setVisibility(View.INVISIBLE);
                parent.findViewById(R.id.message).setVisibility(View.INVISIBLE);
            }
        };
        save=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("username",((EditText)parent.findViewById(R.id.msg_input_name)).getText().toString());
                editor.commit();
                parent.findViewById(R.id.msg_opt).setVisibility(View.INVISIBLE);
                parent.findViewById(R.id.message).setVisibility(View.INVISIBLE);
                parent.hide();
            }
        };
        optionOnClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_option_msg();
            }
        };
    }

    public void show_help_msg(int msg_id) {
        parent.findViewById(R.id.msg_back0).setOnClickListener(back);
        parent.findViewById(R.id.msg_back1).setOnClickListener(back);
        ((TextView)parent.findViewById(R.id.msg_text)).setText(res.getString(msg_id));
        parent.findViewById(R.id.msg_text).setVisibility(View.VISIBLE);
        parent.findViewById(R.id.message).setVisibility(View.VISIBLE);
    }

    View.OnClickListener getHelpOnClickListener(final int msg_id) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_help_msg(msg_id);
            }
        };
    }

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    View.OnClickListener save;

    public void show_option_msg() {
        parent.findViewById(R.id.msg_back0).setOnClickListener(save);
        parent.findViewById(R.id.msg_back1).setOnClickListener(save);
        ((EditText)parent.findViewById(R.id.msg_input_name)).setText(preferences.getString("username",""));
        parent.findViewById(R.id.msg_opt).setVisibility(View.VISIBLE);
        parent.findViewById(R.id.message).setVisibility(View.VISIBLE);
    }

    public View.OnClickListener optionOnClickListener;
}
