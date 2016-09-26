package com.fudan.asuper.circuitmania.ViewManagers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/25.
 */

public final class MissionSelectingViewManager extends ViewManager {
    public MissionSelectingViewManager(final MainActivity mainActivity){
        super(mainActivity,R.layout.mission_selecting);
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.ms_back).setOnClickListener(view ->mainActivity.back());
    }
}
