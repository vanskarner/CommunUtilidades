package vanskarner.android.communutilidades;

import android.app.Application;
import android.content.Context;
//import androidx.multidex.MultiDexApplication;

public class App extends Application {
    private static App instace;

    public static Context getAppContext(){
        return instace;
    }

    public static String idToString(int id){
        return instace.getString(id);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instace=this;
    }
}
