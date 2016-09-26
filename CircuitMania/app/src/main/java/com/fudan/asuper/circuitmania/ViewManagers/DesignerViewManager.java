package com.fudan.asuper.circuitmania.ViewManagers;

import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/26.
 */

public class DesignerViewManager extends ViewManager {
    String missionName="ms_1_1";
    public DesignerViewManager(MainActivity mainActivity) {
        super(mainActivity, R.layout.designer);
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.dn_back).setOnClickListener(view ->mainActivity.back());
        view.findViewById(R.id.dn_help).setOnClickListener(view -> mainActivity.messageManager.show_text_msg(R.string.msg_help));
    }
}
