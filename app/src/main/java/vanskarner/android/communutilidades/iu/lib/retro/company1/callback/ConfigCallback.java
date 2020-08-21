package vanskarner.android.communutilidades.iu.lib.retro.company1.callback;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vanskarner.android.communutilidades.BuildConfig;
import vanskarner.android.communutilidades.iu.lib.retro.company1.codes.Codes;
import vanskarner.android.communutilidades.iu.lib.retro.company1.codes.ICodes;
import vanskarner.android.communutilidades.utilities.lib.retrofit.HeaderHttp;
import vanskarner.android.communutilidades.utilities.lib.retrofit.IRetro;
import vanskarner.android.communutilidades.utilities.lib.retrofit.Retro;

abstract class ConfigCallback<T, S> {
    private static ICodes code = new Codes();
    private static int CONNECT_TIMEOUT_SECONDS = 30;
    private static int READ_TIMEOUT_SECONDS = 30;
    private static boolean ENABLE_LOG = true; //true to see the request detail - false to hide
    private static String BASE_URL = BuildConfig.URL_BASE;
    private static IRetro retro = new Retro(CONNECT_TIMEOUT_SECONDS, READ_TIMEOUT_SECONDS, ENABLE_LOG, BASE_URL);


    protected abstract Class<S> interfaceToClass();

    protected S serviceWithHeader(List<HeaderHttp> headerHttpList){
        return retro.createServiceWithHeader(interfaceToClass(), headerHttpList);
    }

    protected S service(){
        return retro.createService(interfaceToClass());
    }

    protected Callback<T> createCallback(final OnCallbackListener<T> listener) {
        return new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    String message = code.getMessagesOfCodesHttp(response.code());
                    listener.onFail(message);
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                listener.onFail(t.getMessage());
                t.printStackTrace();
            }
        };
    }

}
