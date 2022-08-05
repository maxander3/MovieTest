package droid.maxaria.maxander.movietest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import droid.maxaria.maxander.movietest.data.MovieRepositoryImpl
import droid.maxaria.maxander.movietest.data.network.ApiProvider
import droid.maxaria.maxander.movietest.domain.MovieRepository

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun getRepository(apiProvider: ApiProvider): MovieRepository {
        return MovieRepositoryImpl(apiProvider)
    }
}