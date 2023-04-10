package com.ppp.sunmivicescreendemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.ppp.sunmivicescreendemo.databinding.FragmentFirstBinding;
import com.ppp.sunmivicescreendemo.present.TextDisplay;
import com.ppp.sunmivicescreendemo.present.VideoDisplay;
import com.ppp.sunmivicescreendemo.present.pppPresentation;
import com.ppp.sunmivicescreendemo.utilsnservice.ScreenManager;
import com.sunmi.scalelibrary.ScaleManager;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    Context thisContext;

    private DrawerLayout drawerLayout;
    private FrameLayout ivBack;
    public ScaleManager mScaleManager;
    public ScreenManager screenManager = null;
    public Display[] displays;

    public TextDisplay textDisplay = null;
    private VideoDisplay videoDisplay = null;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.d("mine", "onCreatedView");

        thisContext = container.getContext();
        Log.w("ppp", "this log");
        Log.w("ppp", thisContext.toString());
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();

        Log.d("mine", "onViewCreated");
        if(videoDisplay != null) {
            videoDisplay.show();
        }
        if(textDisplay != null) {
            textDisplay.show();
        }

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        if(videoDisplay != null) {
            videoDisplay.hide();
        }
        if(textDisplay != null) {
            textDisplay.hide();
        }
    }

    private void initData() {
        screenManager = ScreenManager.getInstance();
        screenManager.init(thisContext);
        displays = screenManager.getDisplays();
        for(int i = 0; i < displays.length; i++) {
            Log.e("debugppp", "D : " + displays[i]);
        }
        Display display = screenManager.getPresentationDisplays();
        //Log.d("debugppp", display.toString());
        Log.e("debugppp", Environment.getExternalStorageDirectory().getPath());
        //if(display != null) {
        //textDisplay = new TextDisplay(this, display);
        if(display != null) {
            textDisplay = new TextDisplay(thisContext, display);
            //videoDisplay = new VideoDisplay(thisContext, display, Environment.getExternalStorageDirectory().getPath() + "/video_02.mp4");
        }
        //textDisplay.show();
        //videoDisplay.show();
        //}

        //textDisplay = new TextDisplay(this, di)
    }

}