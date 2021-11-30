package com.example.marketplace.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.marketplace.R
import com.example.marketplace.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setData()
        mainButton()
        return root
    }

    fun setData(){

        homeViewModel.text.observe(viewLifecycleOwner, {
            binding.tvTitel.text = it
        })

    }

    fun mainButton(){
        binding.btnTest.setOnClickListener {
            homeViewModel.ubahData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}