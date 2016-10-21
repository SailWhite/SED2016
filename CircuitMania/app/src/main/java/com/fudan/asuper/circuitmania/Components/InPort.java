package com.fudan.asuper.circuitmania.Components;

import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/10/18.
 */

public class InPort extends Component {
    Component component;
    public InPort(Component component) {
        super();
        this.component=component;
        iconId= R.drawable.in_port;
        for(Integer port:component.inputPort.keySet()) {
            output.put(port,0);
        }

        priorityId=R.integer.priority_none;
        descriptionID=R.string.in_desc;
    }
}
