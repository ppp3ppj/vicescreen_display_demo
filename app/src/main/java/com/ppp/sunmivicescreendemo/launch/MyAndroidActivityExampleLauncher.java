package com.ppp.sunmivicescreendemo.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ppp.sunmivicescreendemo.present.Example;

public class MyAndroidActivityExampleLauncher {
    public static void launch(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, Example.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
