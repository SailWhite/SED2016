package com.fudan.asuper.circuitmania.ViewManagers;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.fudan.asuper.circuitmania.Components.Component;
import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.Missions.Mission;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/26.
 */

public class DesignerViewManager extends ViewManager {
    String missionName="ms_1_1";
    Mission mission;
    Component currentComponent;
    int stt;

    public DesignerViewManager(MainActivity mainActivity, Mission mission) {
        super(mainActivity, R.layout.designer);
        this.mission=mission;
        initCompBox();
        initPainter();
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.dn_back).setOnClickListener(view ->mainActivity.back());
        view.findViewById(R.id.dn_help).setOnClickListener(view -> mainActivity.messageManager.show_text_msg(mission.standardComponent.descriptionID));
    }

    private void initPainter() {

    }

    private void initCompBox() {
        int s=0;
        LinearLayout compBox= (LinearLayout) view.findViewById(R.id.dn_compbox);
        LinearLayout line=null;

        for(Component component:Component.components) {
            if (mainActivity.res.getInteger(component.priorityId)<mainActivity.res.getInteger(mission.standardComponent.priorityId)) {
                if(s==0) {
                    line=new LinearLayout(mainActivity);
                    line.setOrientation(LinearLayout.HORIZONTAL);
                    line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    line.setWeightSum(3);
                    compBox.addView(line);
                }
                ImageView iv=new ImageView(mainActivity);
                iv.setImageResource(component.iconId);
                iv.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,1));
                iv.setOnClickListener(view ->{
                    mainActivity.messageManager.show_text_msg(mainActivity.res.getString(component.descriptionID)+" selected");
                    currentComponent=component;
                    stt=R.integer.dn_stt_compsltd;
                });
                line.addView(iv);
                s=(s+1)%3;
            }
        }
    }
}
