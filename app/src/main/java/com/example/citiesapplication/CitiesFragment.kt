package com.example.citiesapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.navigation.fragment.findNavController
import com.example.citiesapplication.databinding.FragmentCitiesBinding
import com.example.navigationapp.City
import com.example.navigationapp.CityAdapter

class CitiesFragment : Fragment(), CityAdapter.CityClickListener {

    lateinit var binding: FragmentCitiesBinding
    var cities: MutableList<City> = mutableListOf()
    lateinit var cityAdapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCitiesBinding.inflate(inflater, container, false)

        // Initialize the list of cities
        cities = mutableListOf(
            City(resources.getString(R.string.newyork), R.drawable.city1),
            City(resources.getString(R.string.ontario), R.drawable.city2),
            City(resources.getString(R.string.cairo), R.drawable.city3),
            City(resources.getString(R.string.dubai), R.drawable.city4)
        )

        // Set up the adapter
        cityAdapter = CityAdapter(cities, this)

        // Set up the RecyclerView with a GridLayoutManager
        val gridLayoutManager = GridLayoutManager(context, 2) // 2 columns
        binding.rvCities.layoutManager = gridLayoutManager
        binding.rvCities.adapter = cityAdapter

        return binding.root
    }

    override fun onCityClicked(city: City) {
        val action = CitiesFragmentDirections.actionCitiesFragment2ToCityDetailsFragment(city)
        findNavController().navigate(action)
    }
}
