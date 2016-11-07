package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/11/8.
 */

public class NandGate extends Component {
    public NandGate() {
        super();
        iconId= R.drawable.nand_gate;
        inputPort.put(R.string.nandgate_a,0);
        inputPort.put(R.string.nandgate_b,0);
        output.put(R.string.nandgate_out,0);
        priorityId=R.integer.priority_nand;
        descriptionID=R.string.nandgate_desc;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.nandgate_a).getOutput(inputPort.get(R.string.nandgate_a));
        int b=inputComonent.get(R.string.nandgate_b).getOutput(inputPort.get(R.string.nandgate_b));
        output.put(R.string.nandgate_out, ((a&b)==0)?1:0);
    }
}
