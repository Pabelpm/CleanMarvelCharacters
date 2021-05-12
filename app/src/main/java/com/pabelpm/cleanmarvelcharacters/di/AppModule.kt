package com.pabelpm.cleanmarvelcharacters.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pabelpm.cleanmarvelcharacters.BuildConfig
import com.pabelpm.cleanmarvelcharacters.data.local.MarvelCharacterDao
import com.pabelpm.cleanmarvelcharacters.data.local.MarvelCharacterDataBase
import com.pabelpm.cleanmarvelcharacters.data.local.RoomDataSourceImp
import com.pabelpm.cleanmarvelcharacters.data.server.RemoteDataSourceImp
import com.pabelpm.cleanmarvelcharacters.data.server.WebService
import com.pabelpm.cleanmarvelcharacters.data.server.http.AuthInterceptor
import com.pabelpm.data.source.LocalDataSource
import com.pabelpm.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(provideAuthInterceptor())
            .addInterceptor(logger)
            .cache(null)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).build()
    }


    @Provides
    fun providePublicKey() = BuildConfig.PUBLIC_KEY

    @Provides
    fun providePrivateKey() = BuildConfig.PRIVATE_KEY

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideAuthInterceptor() = AuthInterceptor(providePublicKey(), providePrivateKey())

    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()


    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(provideBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .client(okHttpClient)
            .build()


    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit): WebService = retrofit.create(WebService::class.java)

    @Provides
    fun remoteDataSourceProvider(webService: WebService): RemoteDataSource =
        RemoteDataSourceImp(webService)

    @Provides
    fun localDataSourceProvider(marvelCharacterDao: MarvelCharacterDao): LocalDataSource = RoomDataSourceImp(marvelCharacterDao)

    @Provides
    fun marvelCharacterDaoProvides(marvelCharacterDataBase: MarvelCharacterDataBase): MarvelCharacterDao = marvelCharacterDataBase.marvelCharacterDao()

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context): MarvelCharacterDataBase {
        return Room.databaseBuilder(
            context,
            MarvelCharacterDataBase::class.java,
            "marvelCharacters"
        )
            //.addMigrations(MIGRATION_1_2)
            .build()
    }

    /*val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE LocalMarvelCharacter " + " ADD COLUMN url TEXT")
        }
    }*/
}