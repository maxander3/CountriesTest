package jumpingball.sport.countriestest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import jumpingball.sport.countriestest.data.CountriesRepositoryImpl
import jumpingball.sport.countriestest.domain.CountriesRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {
    @Binds
    abstract fun bindRepository(countriesRepositoryImpl: CountriesRepositoryImpl):CountriesRepository
}