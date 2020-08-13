package vanskarner.android.communutilidades.utilities.so.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

public class UtilityNetwork implements IUtilityNetwork{

    private NetworkCapabilities networkCapabilities;//Used for api>=23
    private NetworkInfo networkInfo; //Used for api<23


    public UtilityNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Network network = connectivityManager.getActiveNetwork();
                networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            }
        }
    }


    @Override
    public boolean isConnectedWifi() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
        }else{
            return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
        }
    }

    @Override
    public boolean isConnectedMobile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
        }else{
            return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
        }
    }

    @Override
    public boolean isConnectedBluetooth() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH);
        }else{
            return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_BLUETOOTH;
        }
    }


}
