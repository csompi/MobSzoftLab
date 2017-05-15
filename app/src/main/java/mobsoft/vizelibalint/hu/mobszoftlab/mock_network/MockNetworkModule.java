package mobsoft.vizelibalint.hu.mobszoftlab.mock_network;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.vizelibalint.hu.mobszoftlab.network.API;
import mobsoft.vizelibalint.hu.mobszoftlab.network.NetworkConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(1, TimeUnit.SECONDS)
                .addInterceptor(new FakeInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public API provideAPI(Retrofit retrofit) {
        return retrofit.create(API.class);
    }
}