package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/11/8.
 */

public class Dec2_4 extends Component {
    public Dec2_4() {
        super();
        iconId= R.drawable.dec2_4;
        inputPort.put(R.string.dec_a0,0);
        inputPort.put(R.string.dec_a1,0);
        output.put(R.string.dec_d0,0);
        output.put(R.string.dec_d1,0);
        output.put(R.string.dec_d2,0);
        output.put(R.string.dec_d3,0);
        priorityId=R.integer.priority_dec2_4;
        descriptionID=R.string.xorgate_desc;
    }

    @Override
    public void update() {
        super.update();
        int a0=inputComonent.get(R.string.dec_a0).getOutput(inputPort.get(R.string.dec_a0));
        int a1=inputComonent.get(R.string.dec_a1).getOutput(inputPort.get(R.string.dec_a1));
        int t=1<<(a0+2*a1);
        output.put(R.string.dec_d0, t&1);
        output.put(R.string.dec_d1, (t>>1)&1);
        output.put(R.string.dec_d2, (t>>2)&1);
        output.put(R.string.dec_d3, (t>>3)&1);
    }
}
