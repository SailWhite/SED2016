package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/29.
 */

public class OrGate extends Component {
    public OrGate() {
        super();
        iconId=R.drawable.or_gate;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.orgate_a).getOutput(inputPort.get(R.string.orgate_a));
        int b=inputComonent.get(R.string.orgate_b).getOutput(inputPort.get(R.string.orgate_b));
        output.put(R.string.orgate_out, a|b);
    }
}
