package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/29.
 */

public class AndGate extends Component {
    public AndGate() {
        super();
        iconId=R.drawable.and_gate;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.andgate_a).getOutput(inputPort.get(R.string.andgate_a));
        int b=inputComonent.get(R.string.andgate_b).getOutput(inputPort.get(R.string.andgate_b));
        output.put(R.string.andgate_out, a&b);
    }
}
