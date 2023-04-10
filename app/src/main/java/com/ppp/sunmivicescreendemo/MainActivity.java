package com.ppp.sunmivicescreendemo;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ppp.sunmivicescreendemo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

//test

import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import sunmi.ds.DSKernel;
import sunmi.ds.SF;
import sunmi.ds.callback.ICheckFileCallback;
import sunmi.ds.callback.IConnectionCallback;
import sunmi.ds.callback.IReceiveCallback;
import sunmi.ds.callback.ISendCallback;
import sunmi.ds.callback.ISendFilesCallback;
import sunmi.ds.callback.QueryCallback;
import sunmi.ds.data.DSData;
import sunmi.ds.data.DSFile;
import sunmi.ds.data.DSFiles;
import sunmi.ds.data.DataPacket;

import com.ppp.sunmivicescreendemo.present.TextDisplay;
import com.ppp.sunmivicescreendemo.present.VideoDisplay;
import com.ppp.sunmivicescreendemo.utilsnservice.ScreenManager;
import com.sunmi.scalelibrary.ScaleManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;


    // test
    private final String TAG = MainActivity.class.getSimpleName();

    private DSKernel mDSKernel = null;

    private MyHandler myHandler;

   //Ex
   private DrawerLayout drawerLayout;
    private FrameLayout ivBack;
    public ScaleManager mScaleManager;
    public ScreenManager screenManager = null;
    public Display[] displays;

    public TextDisplay textDisplay = null;
    private VideoDisplay videoDisplay = null;

    private IConnectionCallback mIConnectionCallback = new IConnectionCallback() {
        @Override
        public void onDisConnect() {
            /*
            Message message = new Message();
            message.what = 1;
            message.obj = "与远程服务连接中断";
            myHandler.sendMessage(message);

             */
            Log.d("debugppp", "onDis");
        }

        @Override
        public void onConnected(ConnState state) {
            //Message message = new Message();
            //message.what = 1;
            switch (state) {
                case AIDL_CONN:
                    //message.obj = "与远程服务绑定成功";
                    Log.d("debugppp", "AIDL-con");
                    break;
                case VICE_SERVICE_CONN:
                    Log.d("debugppp", "Vice-service-con");
                    //message.obj = "与副屏服务通讯正常";
                    break;
                case VICE_APP_CONN:
                    Log.d("debugppp", "Vice-app-con");
                    //message.obj = "与副屏app通讯正常";
                    break;
                default:
                    break;
            }
            //myHandler.sendMessage(message);

        }
    };

    private IReceiveCallback mIReceiveCallback = new IReceiveCallback() {
        @Override
        public void onReceiveData(DSData data) {

        }

        @Override
        public void onReceiveFile(DSFile file) {

        }

        @Override
        public void onReceiveFiles(DSFiles files) {

        }

        @Override
        public void onReceiveCMD(DSData cmd) {

        }
    };
    private IReceiveCallback mIReceiveCallback2 = new IReceiveCallback() {
        @Override
        public void onReceiveData(DSData data) {

        }

        @Override
        public void onReceiveFile(DSFile file) {

        }

        @Override
        public void onReceiveFiles(DSFiles files) {

        }

        @Override
        public void onReceiveCMD(DSData cmd) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("debugppp", "OnCreate :" + TAG);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        myHandler = new MyHandler(this); //add new handler
        //initSdk();
        //Log.d("debugppp", myHandler.toString());
        //Log.d("debugppp", mDSKernel.toString());
        //initData();

        //Log.d("debugppp", displays.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View view) {
        Log.d("Hiii", "onClick");
    }

    // Method test
    private void initSdk() {
        //mDSKernel = DSKernel.newInstance();
        //mDSKernel.init(this, mIConnectionCallback);
        //mDSKernel.addReceiveCallback(mIReceiveCallback);
        //mDSKernel.addReceiveCallback(mIReceiveCallback2);
        //mDSKernel.removeReceiveCallback(mIReceiveCallback);
        //mDSKernel.removeReceiveCallback(mIReceiveCallback2);
    }

    private void initData() {
        screenManager = ScreenManager.getInstance();
        screenManager.init(this);
        displays = screenManager.getDisplays();
        for(int i = 0; i < displays.length; i++) {
            Log.e("debugppp", "D : " + displays[i]);
        }
        Display display = screenManager.getPresentationDisplays();
        //Log.d("debugppp", display.toString());
        Log.e("debugppp", Environment.getExternalStorageDirectory().getPath());
        //if(display != null) {
           //textDisplay = new TextDisplay(this, display);
           videoDisplay = new VideoDisplay(this, display, Environment.getExternalStorageDirectory().getPath() + "/video_01.mp4");
            //textDisplay.show();
           //videoDisplay.show();
        //}

        //textDisplay = new TextDisplay(this, di)
    }

    private static class MyHandler extends Handler {
        private WeakReference<Activity> mActivity;

        public MyHandler(Activity activity) {
            mActivity = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mActivity.get() != null && !mActivity.get().isFinishing()) {
                switch (msg.what) {
                    case 1://消息提示用途
                        Toast.makeText(mActivity.get(), msg.obj + "", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        }

    }
}