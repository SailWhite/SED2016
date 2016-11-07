package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/11/8.
 */

public class XnorGate extends Component {
    public XnorGate() {
        super();
        iconId= R.drawable.xnor_gate;
        inputPort.put(R.string.xnorgate_a,0);
        inputPort.put(R.string.xnorgate_b,0);
        output.put(R.string.xnorgate_out,0);
        priorityId=R.integer.priority_xnor;
        descriptionID=R.string.xnorgate_desc;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.xnorgate_a).getOutput(inputPort.get(R.string.xnorgate_a));
        int b=inputComonent.get(R.string.xnorgate_b).getOutput(inputPort.get(R.string.xnorgate_b));
        output.put(R.string.xnorgate_out, (a^b)==0?1:0);
    }
}
