package com.fudan.asuper.circuitmania.ViewManagers;

import android.text.Layout;
import android.view.View;
import android.widget.FrameLayout;

import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/26.
 */

public abstract class ViewManager {
    public final MainActivity mainActivity;
    public abstract void initFunc();
    public View view;
    public ViewManager(final MainActivity mainActivity,int layoutid) {
        this.mainActivity=mainActivity;
        view=mainActivity.inflater.inflate(layoutid,null);
        initFunc();
    }
}
