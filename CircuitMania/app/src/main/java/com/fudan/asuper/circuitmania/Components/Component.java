package com.fudan.asuper.circuitmania.Components;

/**
 * Created by narco on 2016/9/27.
 */
import java.util.Map;
public class Component {
    public Map<Integer, Component> inputComonent;
    public Map<Integer, Integer> inputPort;
    public Map<Integer, Integer> output;

    public void update() {
        for (Component component : inputComonent.values()) {
            component.update();
        }
    }

    public void setPort(int x, int y) {

    }

    public int getOutput(int x){
        update();
        if (output.get(x) == null)
            return -1;
        else
            return output.get(x);
    }


}
