package com.fudan.asuper.circuitmania.Components;

/**
 * Created by narco on 2016/9/27.
 */
import com.fudan.asuper.circuitmania.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public abstract class Component {

    public static ArrayList<Component> components;
    static {
        components=new ArrayList<>();
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new AndGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new NotGate());
        components.add(new OrGate());
        components.add(new AndGate());
        components.add(new XorGate());
    }

    public Map<Integer, Component> inputComonent;
    public Map<Integer, Integer> inputPort;
    public Map<Integer, Integer> output;
    public boolean isOnTime;
    public int iconId;
    public int priorityId= R.integer.priority_none;
    public int descriptionID;

    public Component() {
        inputComonent=new HashMap<>();
        inputPort=new HashMap<>();
        output=new HashMap<>();
        isOnTime=false;
    }

    public void update() {
        for (Component component : inputComonent.values()) {
            component.update();
        }
        isOnTime=true;
    }

    public void setPort(int targetPort, Component sourceComponent, int soucecePort) {
        inputComonent.put(targetPort,sourceComponent);
        inputPort.put(targetPort,soucecePort);
    }

    public int getOutput(int x){
        if(!isOnTime)update();
        if (output.get(x) == null)
            return -1;
        else
            return output.get(x);
    }

    public void reset() {
        isOnTime=false;
    }
}
