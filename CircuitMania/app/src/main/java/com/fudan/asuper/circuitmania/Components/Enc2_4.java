package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/11/8.
 */

public class Enc2_4 extends Component {
    public Enc2_4() {
        super();
        iconId= R.drawable.enc2_4;
        inputPort.put(R.string.enc_d0,0);
        inputPort.put(R.string.enc_d1,0);
        inputPort.put(R.string.enc_d2,0);
        inputPort.put(R.string.enc_d3,0);
        output.put(R.string.enc_a0,0);
        output.put(R.string.enc_a1,0);
        priorityId=R.integer.priority_end2_4;
        descriptionID=R.string.enc_desc;
    }

    @Override
    public void update() {
        super.update();
        int d0=inputComonent.get(R.string.enc_d0).getOutput(inputPort.get(R.string.enc_d0));
        int d1=inputComonent.get(R.string.enc_d1).getOutput(inputPort.get(R.string.enc_d1));
        int d2=inputComonent.get(R.string.enc_d2).getOutput(inputPort.get(R.string.enc_d2));
        int d3=inputComonent.get(R.string.enc_d3).getOutput(inputPort.get(R.string.enc_d3));
        output.put(R.string.enc_a0, );
    }
}
