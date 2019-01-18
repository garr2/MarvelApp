package com.example.user.test.presentation.inject

import com.example.data.executor.UIThread
import com.example.data.net.MarvelRestService
import com.example.data.repository.MarvelRepositoryImpl
import com.example.domain.entity.RequestData
import com.example.domain.repository.MarvelRepository
import com.example.domain.useCase.CharacterListUseCase
import com.example.user.test.BuildConfig
import com.example.user.test.presentation.utils.MD5KeyGenerator
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UseCaseModule {

    private val timeStamp = System.currentTimeMillis().toString()

    @Provides
    fun provideCharacterListUseCase(
        uiThread: UIThread,
        repository: MarvelRepository
    ): CharacterListUseCase =
        CharacterListUseCase(uiThread, repository)

    @Provides
    fun provideUiThread(): UIThread = UIThread()

    @Provides
    fun provideMarvelRepository(restService: MarvelRestService): MarvelRepository =
        MarvelRepositoryImpl(restService)

    @Provides
    fun provideMarvelRestService(@Named(API_BASE_URL) baseUrl: String): MarvelRestService =
        MarvelRestService(baseUrl)

    @Provides
    @Named(API_BASE_URL)
    fun provideBaseUrl(): String = BuildConfig.MARVEL_API_BASE_URL

    @Provides
    fun provideRequestData(
        @Named(API_PUBLIC_KEY) apiKey: String
        , @Named(GENERATED_HASH) hash: String
        , @Named(TIME_STAMP) timeStamp: String
    ): RequestData = RequestData(apiKey, hash, timeStamp)

    @Provides
    @Named(GENERATED_HASH)
    fun provideHash(keyGenerator: MD5KeyGenerator, @Named(BASE_STRING) baseString: String): String {
        return keyGenerator.generate(baseString)
    }

    @Provides
    fun provideKeyGenerator(): MD5KeyGenerator = MD5KeyGenerator()

    @Provides
    @Named(BASE_STRING)
    fun provideBaseString(
        @Named(TIME_STAMP) timeStamp: String
        , @Named(API_PRIVATE_KEY) apiPrivateKey: String
        , @Named(API_PUBLIC_KEY) apiPublicKey: String
    ): String = timeStamp + apiPrivateKey + apiPublicKey

    @Provides
    @Named(TIME_STAMP)
    fun provideTimeStamp(): String = timeStamp

    @Provides
    @Named(API_PRIVATE_KEY)
    fun provideApiPrivateKey(): String = BuildConfig.MARVEL_API_PRIVATE_KEY

    @Provides
    @Named(API_PUBLIC_KEY)
    fun provideApiPublicKey(): String = BuildConfig.MARVEL_API_PUBLIC_KEY
}