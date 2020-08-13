package vanskarner.android.communutilidades.utilities.lib.retrofit;

import android.os.Build;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro implements IRetro{

    private int CONNECT_TIMEOUT_SECONDS;
    private int READ_TIMEOUT_SECONDS;
    private boolean ENABLE_LOG;
    private String BASE_URL;

    public Retro(int CONNECT_TIMEOUT_SECONDS, int READ_TIMEOUT_SECONDS, boolean ENABLE_LOG, String BASE_URL) {
        this.CONNECT_TIMEOUT_SECONDS = CONNECT_TIMEOUT_SECONDS;
        this.READ_TIMEOUT_SECONDS = READ_TIMEOUT_SECONDS;
        this.ENABLE_LOG = ENABLE_LOG;
        this.BASE_URL = BASE_URL;
    }

    private void compatibilityAndroid4_1_To_4_4(OkHttpClient.Builder httpClient) {
        /* Compatibility with versions 4.1 to 4.4 due to error [SSLProtocolException: SSL handshake aborted]  */
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                List<CipherSuite> cipherSuites = ConnectionSpec.MODERN_TLS.cipherSuites();
                if (cipherSuites != null && !cipherSuites.contains(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA)) {
                    cipherSuites = new ArrayList(cipherSuites);
                    cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
                    ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                            .cipherSuites(cipherSuites.toArray(new CipherSuite[0]))
                            .build();
                    httpClient.connectionSpecs(Collections.singletonList(spec));
                }
            }
        } catch (Exception ignored) {

        }
    }

    private OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS).readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        compatibilityAndroid4_1_To_4_4(httpClient);
        if (ENABLE_LOG) {
            httpClient.addInterceptor(logging);
        }
        return httpClient.build();
    }

    @Override
    public <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
        return retrofit.create(serviceClass);
    }


}
