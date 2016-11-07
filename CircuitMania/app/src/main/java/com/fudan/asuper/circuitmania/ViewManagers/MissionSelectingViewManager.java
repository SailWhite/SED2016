package com.fudan.asuper.circuitmania.ViewManagers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/25.
 */

public final class MissionSelectingViewManager extends ViewManager {
    public MissionSelectingViewManager(final MainActivity mainActivity){
        super(mainActivity,R.layout.mission_selecting);
        ((TextView)view.findViewById(R.id.ms_1)).setTypeface(mainActivity.messageManager.tf);
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.ms_back).setOnClickListener(view ->mainActivity.back());
        view.findViewById(R.id.ms_1).setOnClickListener(view ->mainActivity.changeView(mainActivity.submissionViewManager.view));
    }
}
