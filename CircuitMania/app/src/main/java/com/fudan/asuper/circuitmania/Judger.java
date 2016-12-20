package com.fudan.asuper.circuitmania;

import com.fudan.asuper.circuitmania.Components.Component;
import com.fudan.asuper.circuitmania.Components.InPort;
import com.fudan.asuper.circuitmania.Components.OutPort;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.max;


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

        @Override
        public String toString() {
            return message;
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
    public Result judge(Component standard, InPort inport, Set<Component> components, OutPort outport) {
        //return new Result(true,0,3,"Accepted!");
        Random random=new Random();
        int cost=0;
        for(Component c:components) {
            Integer x=mainActivity.state.cost.get(c.descriptionID);
            if(x!=null)cost+=x;
        }
        System.out.println("cost="+cost);
        try {
            for (int i = 0; i < 100; i++) {
                for (Integer id : inport.output.keySet()) {
                    inport.output.put(id, random.nextBoolean() ? 1 : 0);
                    standard.setPort(id, inport, id);
                }
                standard.update();
                inport.isOnTime = true;
                outport.update();
                for (Integer id : outport.inputPort.keySet()) {
                    if (outport.inputComonent.get(id).output.get(outport.inputPort.get(id)) != standard.output.get(id)) {
                        //System.out.println(outport.inputComonent.get(id).output.get(outport.inputPort.get(id))+" "+standard.output.get(id));
                        return new Result(false, cost, 0, "Wrong Answer!");
                    }
                }
            }
        } catch (Exception e){
            return new Result(false, cost, 0, "Wrong Answer!");
        }
        mainActivity.state.level=max(mainActivity.state.level, mainActivity.res.getInteger(standard.priorityId)+100);
        mainActivity.state.cost.put(standard.descriptionID, cost);
        mainActivity.state.save();
        mainActivity.submissionViewManager.setColor();
        return new Result(true,cost, cost>standard.best?2:3,"Accepted!");
    }
}
