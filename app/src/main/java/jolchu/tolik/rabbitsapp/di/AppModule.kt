package jolchu.tolik.rabbitsapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jolchu.tolik.rabbitsapp.data.RabbitsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRabbitsApi(): RabbitsApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RabbitsApi.BASE_URL)
            .build()
            .create(RabbitsApi::class.java)
    }

}