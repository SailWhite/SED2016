package com.fudan.asuper.circuitmania.Missions;

import com.fudan.asuper.circuitmania.Circuit;
import com.fudan.asuper.circuitmania.Components.Component;

import java.util.Stack;

/**
 * Created by SailW on 2016/9/29.
 */

public class Mission {

    public Component standardComponent;
    public Mission nextMission;
    public Stack<Circuit> circuit;

    public Mission(Component standardComponent, Mission nextMission) {
        this.standardComponent=standardComponent;
        this.nextMission=nextMission;
        circuit=new Stack<>();
    }
}
