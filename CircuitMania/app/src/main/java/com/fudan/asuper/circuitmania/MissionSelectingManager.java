package com.fudan.asuper.circuitmania;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SailW on 2016/9/25.
 */

public final class MissionSelectingManager {
    final AppCompatActivity parent;

    public MissionSelectingManager(final AppCompatActivity parent){
        this.parent=parent;
        parent.findViewById(R.id.ms_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.findViewById(R.id.mission_selecting).setVisibility(View.INVISIBLE);
                parent.findViewById(R.id.main).setVisibility(View.VISIBLE);
            }
        });
    }
}
