package com.privat.contacts.di.modules;

import com.privat.contacts.data.cloud.NetworkApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    public RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    public GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    public Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory,
                                    RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .baseUrl("https://random-data-api.com/api/v2/")
                .build();
    }

    @Provides
    public NetworkApiService provideNetworkApiService(Retrofit retrofit) {
        return retrofit.create(NetworkApiService.class);
    }

}
