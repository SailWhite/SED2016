package com.fudan.asuper.circuitmania;

import com.fudan.asuper.circuitmania.Components.Component;
import com.fudan.asuper.circuitmania.Components.InPort;
import com.fudan.asuper.circuitmania.Components.OutPort;

import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by SailW on 2016/10/18.
 */

public class Judger {
    public class Result {
        public final boolean correctness;
        public final int cost;
        public final int star;
        public final String message;

        public Result(boolean correctness, int cost, int star, String message) {
            this.correctness=correctness;
            this.cost=cost;
            this.star=star;
            this.message=message;
        }
    }

    public final MainActivity mainActivity;
    public Judger(final MainActivity mainActivity,int layoutid) {
        this.mainActivity=mainActivity;
    }



    /**
     * For combinational circuit only
     * @param inport input component of the design
     * @param components
     * @param outport output component of the design
     * @return
     */
    public Result judg1e(Component standard, InPort inport, Set<Component> components, OutPort outport) {
        Random random=new Random();
        for(int i=0;i<10;i++) {
            for(Integer id:inport.output.keySet()) {
                inport.output.put(id, random.nextBoolean() ? 1 : 0);
                standard.setPort(id, inport, id);
            }
            standard.update();
            inport.isOnTime=true;
            outport.update();
        }
        for (Integer id:outport.inputComonent.keySet()) {
            if (outport.inputComonent.get(id).output.get(outport.inputPort.get(id)) != standard.output.get(id)) {
                return new Result(false,0,0,"Wrong Answer!");
            }
        }
        return new Result(true,0,3,"Accepted!");
    }
}
