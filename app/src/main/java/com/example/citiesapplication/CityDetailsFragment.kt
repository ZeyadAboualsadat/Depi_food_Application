package com.example.citiesapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.citiesapplication.databinding.FragmentCityDetailsBinding

class CityDetailsFragment : Fragment() {


    lateinit var binding: FragmentCityDetailsBinding
    private val args: CityDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCityDetailsBinding.inflate(inflater,container,false)

        val city = args.user

        binding.ivCity.setImageResource(city.imageId)
        binding.tvName.text=city.title

        return binding.root
    }
}