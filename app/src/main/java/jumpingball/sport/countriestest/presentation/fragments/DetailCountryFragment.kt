package jumpingball.sport.countriestest.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import jumpingball.sport.countriestest.R
import jumpingball.sport.countriestest.databinding.FragmentCountriesListBinding
import jumpingball.sport.countriestest.databinding.FragmentDetailCountryBinding

class DetailCountryFragment : Fragment() {

    private val viewModel: DetailCountryViewModel by viewModels()

    private var _binding: FragmentDetailCountryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailCountryBinding.inflate(inflater,container,false)
        return binding.root
    }

}