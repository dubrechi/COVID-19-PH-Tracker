package com.dubrechi.ambag

import android.util.Log
import io.reactivex.disposables.Disposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {

    val TAG = this.javaClass.simpleName

    fun coronaApi(): ApiService {
        return create(ApiService::class.java)
    }

    private var disposable: Disposable? = null

    private var builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(Application.baseUrl)

    private fun <S> create(serviceClass: Class<S>): S {
        Log.e(TAG, "retrofit created")

        var retrofit = builder.build()

        return retrofit.create(serviceClass)
    }

}