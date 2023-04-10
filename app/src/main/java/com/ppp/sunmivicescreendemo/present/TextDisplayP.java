package com.ppp.sunmivicescreendemo.present;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ppp.sunmivicescreendemo.R;
import com.ppp.sunmivicescreendemo.utilsnservice.ScreenManager;

public class TextDisplayP extends pppPresentation{

    Context mContext;

    public TextDisplayP(Context outerContext, Display display) {
        super(outerContext, display);
        mContext = outerContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(mContext);
        textView.setText("Hello, world!");
        textView.setTextSize(24);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(16, 16, 16, 16);

        Button button = new Button(mContext);
        button.setText("Click me!");

        layout.addView(textView);
        layout.addView(button);

        //setContentView(layout);

        if (ScreenManager.getInstance().isMinScreen()) {
            //setContentView(R.layout.vice_text_min_layout);
            setContentView(layout);
        }else {
            //setContentView(R.layout.vice_text_layout);
            setContentView(layout);
        }
    }

    @Override
    public void show() {
        super.show();
    }
}
