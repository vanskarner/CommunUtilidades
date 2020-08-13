package vanskarner.android.communutilidades.utilities.lib.admob.interstitial;


import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class AdInterstitial implements IAdInterstitial {

    private InterstitialAd interstitialAd;
    private String AD_UNIT_ID;
    private boolean isActivated;

    public AdInterstitial(String AD_UNIT_ID, boolean isActivated) {
        this.AD_UNIT_ID = AD_UNIT_ID;
        this.isActivated = isActivated;
    }

    private void createRequestAd() {
        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }
    }

    @Override
    public void showInterstitial() {
        if (interstitialAd != null && isActivated) {
            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
            } else {
                createRequestAd();
            }
        }
    }

    @Override
    public void onCreate(Context context) {
        if (isActivated) {
            interstitialAd = new InterstitialAd(context);
            interstitialAd.setAdUnitId(AD_UNIT_ID);
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    createRequestAd();
                }
            });
            createRequestAd();
        }
    }

}
