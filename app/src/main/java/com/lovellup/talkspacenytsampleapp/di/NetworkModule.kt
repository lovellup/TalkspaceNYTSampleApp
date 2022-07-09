package com.lovellup.talkspacenytsampleapp.di


import com.lovellup.talkspacenytsampleapp.R
import com.lovellup.talkspacenytsampleapp.data.network.ArticleSearchService
import com.lovellup.talkspacenytsampleapp.data.network.ArticleSearchServiceManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideArticleSearchService(get()) }
    factory {
        ArticleSearchServiceManager(
            get(),
            androidContext().resources.getString(R.string.api_key)
        )
    }
}

private fun provideRetrofit(): Retrofit {
    val baseUrl = "https://api.nytimes.com/svc/search/v2/"
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            )
        )
        .build()
}

private fun provideArticleSearchService(retrofit: Retrofit): ArticleSearchService {
    return retrofit.create(ArticleSearchService::class.java)
}