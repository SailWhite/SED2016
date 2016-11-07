package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/11/8.
 */

public class Mux1_2 extends Component {
    public Mux1_2() {
        super();
        iconId= R.drawable.mux1_2;
        inputPort.put(R.string.mux_a,0);
        inputPort.put(R.string.mux_b,0);
        inputPort.put(R.string.mux_s,0);
        output.put(R.string.mux_out,0);
        priorityId=R.integer.priority_mux1_2;
        descriptionID=R.string.mux_desc;
    }

    @Override
    public void update() {
        super.update();
        int a=inputComonent.get(R.string.mux_a).getOutput(inputPort.get(R.string.mux_a));
        int b=inputComonent.get(R.string.mux_b).getOutput(inputPort.get(R.string.mux_b));
        int s=inputComonent.get(R.string.mux_s).getOutput(inputPort.get(R.string.mux_s));
        output.put(R.string.mux_out, s==0?a:b);
    }
}
