package com.fudan.asuper.circuitmania;


import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.fudan.asuper.circuitmania.ViewManagers.MainViewManager;
import com.fudan.asuper.circuitmania.ViewManagers.MessageViewManager;
import com.fudan.asuper.circuitmania.ViewManagers.MissionSelectingViewManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {
    public LayoutInflater inflater;
    public MainViewManager mainViewManager;
    public MissionSelectingViewManager missionSelectingManager;
    public MessageViewManager messageManager;
    public View mControlsView;
    public FrameLayout mContentView;
    public State state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = (FrameLayout) findViewById(R.id.fullscreen_content);
        inflater = getLayoutInflater();
        state=new State(this);
        mainViewManager=new MainViewManager(this);
        missionSelectingManager=new MissionSelectingViewManager(this);
        messageManager=new MessageViewManager(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hide();
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delayedHide(100);
        if(state.pages.empty()) {
            changeView(mainViewManager.view);
        } else {
            View view=state.pages.peek();
            mContentView.addView(view);
        }
    }

    public void changeView(View view) {
        mContentView.removeAllViews();
        mContentView.addView(view);
        state.pages.push(view);
        state.save();
    }

    public void back() {
        state.pages.pop();
        View view=state.pages.peek();
        mContentView.removeAllViews();
        mContentView.addView(view);
    }

    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();


    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };

    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };

    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    public void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    public void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
