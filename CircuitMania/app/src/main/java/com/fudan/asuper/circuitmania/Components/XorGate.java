package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/29.
 */

public class XorGate extends Component {
    public XorGate() {
        super();
        iconId=R.drawable.xor_gate;
        inputPort.put(R.string.xorgate_a,0);
        inputPort.put(R.string.xorgate_b,0);
        output.put(R.string.xorgate_out,0);
        priorityId=R.integer.priority_xor;
        descriptionID=R.string.xorgate_desc;
        best=80;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.xorgate_a).getOutput(inputPort.get(R.string.xorgate_a));
        int b=inputComonent.get(R.string.xorgate_b).getOutput(inputPort.get(R.string.xorgate_b));
        output.put(R.string.xorgate_out, a^b);
    }
}
