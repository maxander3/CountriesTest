package jumpingball.sport.countriestest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jumpingball.sport.countriestest.presentation.fragments.CountriesListAdapter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PresentationModuleModule {
    @Provides
    @Singleton
    fun provideAdapter(countriesListAdapter: CountriesListAdapter): CountriesListAdapter =
        CountriesListAdapter()
}