package com.ppp.sunmivicescreendemo.utilsnservice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

public class InstallApkUtils {
    public static String smilePkgName = "com.alipay.zoloz.smile";
    public static String SunmiPayPkgName = "com.sunmi.payment";// 商米收银服务

    public static boolean checkApkExist(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) return false;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * get App versionCode * @param context * @return
     */
    public static int getVersionCode(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo;
        int versionCode = 0;
        try {
            packageInfo = packageManager.getPackageInfo(packageName, 0);
            versionCode = packageInfo.versionCode;
            Log.e("@@@","versionCode=="+versionCode+" ");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


}
