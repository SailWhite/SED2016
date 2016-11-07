package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/11/8.
 */

public class NorGate extends Component {
    public NorGate() {
        super();
        iconId= R.drawable.nor_gate;
        inputPort.put(R.string.norgate_a,0);
        inputPort.put(R.string.norgate_b,0);
        output.put(R.string.norgate_out,0);
        priorityId=R.integer.priority_nor;
        descriptionID=R.string.norgate_desc;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.norgate_a).getOutput(inputPort.get(R.string.norgate_a));
        int b=inputComonent.get(R.string.norgate_b).getOutput(inputPort.get(R.string.norgate_b));
        output.put(R.string.norgate_out, ((a|b)==0)?1:0);
    }
}
