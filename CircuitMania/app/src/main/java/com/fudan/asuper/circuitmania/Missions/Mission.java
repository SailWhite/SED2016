package com.fudan.asuper.circuitmania.Missions;

import com.fudan.asuper.circuitmania.Components.Component;

/**
 * Created by SailW on 2016/9/29.
 */

public abstract class Mission {
    String missionText;
    Component standardComponent;
    Mission nextMission;

    public Mission(String missionText, Component standardComponent, Mission nextMission) {
        this.missionText=missionText;
        this.standardComponent=standardComponent;
        this.nextMission=nextMission;
    }
}
