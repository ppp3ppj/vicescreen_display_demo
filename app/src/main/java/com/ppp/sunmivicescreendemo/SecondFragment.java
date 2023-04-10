package com.ppp.sunmivicescreendemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.ppp.sunmivicescreendemo.databinding.FragmentSecondBinding;
import com.ppp.sunmivicescreendemo.present.TextDisplay;
import com.ppp.sunmivicescreendemo.present.TextDisplayP;
import com.ppp.sunmivicescreendemo.utilsnservice.ScreenManager;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    Context mContext;
    public ScreenManager screenManager = null;
    public Display[] displays;
    //public TextDisplay textDisplay = null;
    public TextDisplayP textDisplay = null;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        mContext = container.getContext();
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initData();

        if(textDisplay != null) {
            textDisplay.show();
        }

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        if(textDisplay != null) {
            textDisplay.hide();
        }
    }

    private void initData() {
        screenManager = ScreenManager.getInstance();
        screenManager.init(mContext);
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
            //textDisplay = new TextDisplay(mContext, display);
            textDisplay = new TextDisplayP(mContext, display);
            //videoDisplay = new VideoDisplay(thisContext, display, Environment.getExternalStorageDirectory().getPath() + "/video_02.mp4");
        }
        //textDisplay.show();
        //videoDisplay.show();
        //}

        //textDisplay = new TextDisplay(this, di)
    }

}