package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by narco on 2016/9/27.
 */

public class NotGate extends Component {
    @Override
    public void update() {
        output.put(R.integer.notgate_out, (R.integer.notgate_in==0)?1:0);
    }
}
