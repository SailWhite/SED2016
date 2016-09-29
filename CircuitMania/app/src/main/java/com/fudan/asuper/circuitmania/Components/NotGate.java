package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by narco on 2016/9/27.
 */

public class NotGate extends Component {
    public NotGate() {
        super();
        iconId=R.drawable.not_gate;
    }

    @Override
    public void update() {
        super.update();
        int in=inputComonent.get(R.string.notgate_in).getOutput(inputPort.get(R.string.notgate_in));
        output.put(R.string.notgate_out, in==0?1:0);
    }
}
