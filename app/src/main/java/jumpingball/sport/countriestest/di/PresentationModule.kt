package jumpingball.sport.countriestest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jumpingball.sport.countriestest.presentation.fragments.CountriesListAdapter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class PresentationModuleModule {
    @Provides
    @Singleton
    fun provideAdapter(): CountriesListAdapter =
        CountriesListAdapter()

    @Provides
    @Singleton
    fun provideDispatchers(): CoroutineContext = Dispatchers.IO
}