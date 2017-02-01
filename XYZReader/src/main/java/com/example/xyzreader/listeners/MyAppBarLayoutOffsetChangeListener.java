package com.example.xyzreader.listeners;

import android.support.design.widget.AppBarLayout;

/**
 * Created by scott on 1/25/2017.
 */

public abstract class MyAppBarLayoutOffsetChangeListener implements AppBarLayout.OnOffsetChangedListener{

    public static final String EXPANDED = "expanded";
    public static final String  COLLAPSED= "collapsed";
    public static final String IDLE = "idle";

    private String mCurrentState = IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (!mCurrentState.equalsIgnoreCase(EXPANDED)) {
                onStateChanged(appBarLayout, EXPANDED);
            }
            mCurrentState = EXPANDED;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()-100) {
            if (!mCurrentState.equalsIgnoreCase(COLLAPSED)) {
                onStateChanged(appBarLayout, COLLAPSED);
            }
            mCurrentState = COLLAPSED;
        } else {
            if (!mCurrentState.equalsIgnoreCase(IDLE)) {
                onStateChanged(appBarLayout, IDLE);
            }
            mCurrentState = IDLE;
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, String state);
}
