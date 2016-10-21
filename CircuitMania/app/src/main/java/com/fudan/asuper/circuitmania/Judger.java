package com.fudan.asuper.circuitmania;

import com.fudan.asuper.circuitmania.Components.Component;

import java.util.Map;
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
     *
     * @param inputs map of input potr id, input component of the design
     * @param components
     * @param outputs map of output potr id, output component of the design
     * @return
     */
    public Result judge(Map<Integer, Component> inputs, Set<Component> components, Map<Integer, Component> outputs) {
        return new Result(true,0,2,"Test Accepted!");
    }
}
