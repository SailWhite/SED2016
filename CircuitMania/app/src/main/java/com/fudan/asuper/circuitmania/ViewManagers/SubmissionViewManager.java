package com.fudan.asuper.circuitmania.ViewManagers;

import com.fudan.asuper.circuitmania.Components.AndGate;
import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.Missions.Mission;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/26.
 */

public class SubmissionViewManager extends ViewManager {
    public SubmissionViewManager(MainActivity mainActivity) {
        super(mainActivity, R.layout.submission_selecting);
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.sms_back).setOnClickListener(view ->mainActivity.back());
        view.findViewById(R.id.sms_1_1).setOnClickListener(view -> {
            Mission mission=new Mission(new AndGate(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.andgate_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
    }
}
