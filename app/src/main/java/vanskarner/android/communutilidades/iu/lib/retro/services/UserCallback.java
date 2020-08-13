package vanskarner.android.communutilidades.iu.lib.retro.services;

import javax.annotation.Nonnull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vanskarner.android.communutilidades.iu.lib.retro.codeapi.CodeApi;
import vanskarner.android.communutilidades.iu.lib.retro.codeapi.OnCodeApiListener;
import vanskarner.android.communutilidades.iu.lib.retro.model.UserResponse;


class UserCallback {
    private static CodeApi codeApi = new CodeApi();

    static Callback<UserResponse> defaultCallBack(final OnCompleteListener<UserResponse> listener) {
        return new Callback<UserResponse>() {
            @Override
            public void onResponse(@Nonnull Call<UserResponse> call, @Nonnull final Response<UserResponse> response) {
                if (response.body() != null) {
                    codeApi.checkCodeApi(response.body().getCodeStatus(), new OnCodeApiListener() {
                        @Override
                        public void onSuccess() {
                            listener.onSuccess(response.body());
                        }

                        @Override
                        public void onFail(String message) {
                            listener.onFail(message);
                        }
                    });
                }
            }

            @Override
            public void onFailure(@Nonnull Call<UserResponse> call, @Nonnull Throwable t) {
                listener.onFail(t.getMessage());
            }
        };
    }
}
