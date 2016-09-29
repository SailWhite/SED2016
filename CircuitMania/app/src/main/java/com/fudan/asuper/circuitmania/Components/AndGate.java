package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/29.
 */

public class AndGate extends Component {
    public AndGate() {
        super();
        iconId=R.drawable.and_gate;
        inputPort.put(R.string.andgate_a,0);
        inputPort.put(R.string.andgate_b,0);
        output.put(R.string.andgate_out,0);
        priorityId=R.integer.priority_and;
        descriptionID=R.string.andgate_desc;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.andgate_a).getOutput(inputPort.get(R.string.andgate_a));
        int b=inputComonent.get(R.string.andgate_b).getOutput(inputPort.get(R.string.andgate_b));
        output.put(R.string.andgate_out, a&b);
    }
}
