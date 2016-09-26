package com.fudan.asuper.circuitmania.ViewManagers;

import android.util.Log;
import android.view.*;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.fudan.asuper.circuitmania.*;

/**
 * Created by SailW on 2016/9/26.
 */

public class MainViewManager extends ViewManager {
    public MainViewManager(final MainActivity mainActivity) {
        super(mainActivity,R.layout.main);
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.close).setOnClickListener(view -> {System.exit(0);Log.d("","asdewq");});
        view.findViewById(R.id.start).setOnClickListener(view -> mainActivity.changeView(mainActivity.missionSelectingManager.view));
        view.findViewById(R.id.help).setOnClickListener(view -> mainActivity.messageManager.show_text_msg(R.string.msg_help));
        view.findViewById(R.id.about).setOnClickListener(view -> mainActivity.messageManager.show_text_msg(R.string.msg_about));
        view.findViewById(R.id.option).setOnClickListener(view -> mainActivity.messageManager.show_option_msg());
    }
}
