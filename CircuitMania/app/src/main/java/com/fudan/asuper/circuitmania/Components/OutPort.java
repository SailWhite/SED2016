package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/10/22.
 */

public class OutPort extends Component {
    Component component;
    public OutPort(Component component) {
        super();
        this.component=component;
        iconId= R.drawable.out_port;
        for(Integer port:component.output.keySet()) {
            output.put(port,0);
        }

        priorityId=R.integer.priority_none;
        descriptionID=R.string.out_desc;
    }
}
