package vanskarner.android.communutilidades.utilities.lib.admob.banner;

import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AdBanner implements IAdbanner {
    private AdView adView;
    private boolean isActivate;

    public AdBanner(AdView adView, boolean isActivate) {
        this.adView = adView;
        this.isActivate = isActivate;
    }

    private void loadAdBanner(){
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onCreate() {
        if (adView != null) {
            if (isActivate) {
                adView.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        loadAdBanner();
                    }
                });
                loadAdBanner();
            } else {
                adView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onResume() {
        if (adView != null && isActivate) {
            adView.resume();
        }
    }

    @Override
    public void onPause() {
        if (adView != null && isActivate) {
            adView.pause();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null && isActivate) {
            adView.destroy();
        }
    }

}
