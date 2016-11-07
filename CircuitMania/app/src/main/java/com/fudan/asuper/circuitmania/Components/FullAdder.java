package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/11/8.
 */

public class FullAdder extends Component {
    public FullAdder() {
        super();
        iconId= R.drawable.full_adder;
        inputPort.put(R.string.fulladder_a,0);
        inputPort.put(R.string.fulladder_b,0);
        inputPort.put(R.string.fulladder_cin,0);
        output.put(R.string.fulladder_cout,0);
        output.put(R.string.fulladder_s,0);
        priorityId=R.integer.priority_fulladder;
        descriptionID=R.string.fulladder_desc;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.fulladder_a).getOutput(inputPort.get(R.string.fulladder_a));
        int b=inputComonent.get(R.string.fulladder_b).getOutput(inputPort.get(R.string.fulladder_b));
        int cin=inputComonent.get(R.string.fulladder_cin).getOutput(inputPort.get(R.string.fulladder_cin));
        output.put(R.string.fulladder_s, (a+b)&1);
        output.put(R.string.fulladder_cout, (a+b)&2);
    }
}
