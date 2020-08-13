package vanskarner.android.communutilidades.utilities.lib.googleclient;

import android.content.Intent;


public interface IGoogleCli {

    Intent getSignInIntent();

    void signIn(Intent intent, OnSessionListener listener);

    void signOff();

}
