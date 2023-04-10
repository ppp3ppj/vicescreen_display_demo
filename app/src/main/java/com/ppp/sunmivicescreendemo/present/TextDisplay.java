package com.ppp.sunmivicescreendemo.present;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ppp.sunmivicescreendemo.BasePresentation;
import com.ppp.sunmivicescreendemo.R;
//import com.sunmi.sunmit2demo.BasePresentation;
//import com.sunmi.sunmit2demo.R;
//import com.sunmi.sunmit2demo.dialog.PayDialog;
import com.ppp.sunmivicescreendemo.utilsnservice.ScreenManager;
//import com.sunmi.sunmit2demo.utils.ScreenManager;
import com.ppp.sunmivicescreendemo.utilsnservice.SharePreferenceUtil;
//import com.sunmi.sunmit2demo.utils.SharePreferenceUtil;

/**
 * Created by highsixty on 2018/3/23.
 * mail  gaolulin@sunmi.com
 */

public class TextDisplay extends BasePresentation {

    private LinearLayout root;

    public int state;

    Context mContext;
    public TextDisplay(Context outerContext, Display display) {
        super(outerContext, display);
        mContext = outerContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ScreenManager.getInstance().isMinScreen()) {
            setContentView(R.layout.vice_text_min_layout);
        }else {
            setContentView(R.layout.vice_text_layout);
        }

        root = (LinearLayout) findViewById(R.id.root);






        root.setClipToOutline(true);
        root.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 15);
            }
        });

    }


    public void update(String tip) {
        update(tip, 0);
    }


    public void update(String tip, final int state) {
        this.state = state;


    }


    private SpannableString zoomString(String strings){
        SpannableString ss = new SpannableString(strings);
        ss.setSpan(new RelativeSizeSpan(0.65f), 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE); // set size
        return  ss;
    }

    void playAnim(){
        //AnimationDrawable animationDrawable = (AnimationDrawable) ivTitle.getDrawable();
        //animationDrawable.start();
    }


    public void setSelect(int index) {
    }

    @Override
    public void show() {
        super.show();
    }
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public void onSelect(boolean isShow) {

    }
}

