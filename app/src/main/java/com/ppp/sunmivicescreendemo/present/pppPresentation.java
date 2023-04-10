package com.ppp.sunmivicescreendemo.present;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

public class pppPresentation extends Presentation {
    private static final String TAG = "TextDisplayPPP";

    public pppPresentation(Context outerContext, Display display) {
        super(outerContext, display);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    }

    @Override
    public void hide() {
        super.hide();
        Log.i(TAG, "hide");
    }

    @Override
    public void show() {
//        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        super.show();
        Log.i(TAG, "show");
    }

    @Override
    public void dismiss() {
        Log.i(TAG, "dismiss");
        super.dismiss();
    }
}
