package vanskarner.android.communutilidades.utilities.lib.retrofit;

import java.util.List;

public interface IRetro {

    <S> S createService(Class<S> serviceClass);

    <S> S createServiceWithHeader(Class<S> serviceClass, List<HeaderHttp> headerHttpList);

}
