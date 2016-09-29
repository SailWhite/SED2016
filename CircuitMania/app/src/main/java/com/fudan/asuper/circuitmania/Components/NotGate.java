package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by narco on 2016/9/27.
 */

public class NotGate extends Component {
    public NotGate() {
        super();
        iconId=R.drawable.not_gate;
        inputPort.put(R.string.notgate_in,0);
        output.put(R.string.notgate_out,0);
        priorityId=R.integer.priority_not;
        descriptionID=R.string.notgate_desc;
    }

    @Override
    public void update() {
        super.update();
        int in=inputComonent.get(R.string.notgate_in).getOutput(inputPort.get(R.string.notgate_in));
        output.put(R.string.notgate_out, in==0?1:0);
    }
}
