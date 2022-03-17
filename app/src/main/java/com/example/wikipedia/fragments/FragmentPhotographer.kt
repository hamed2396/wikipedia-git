package com.example.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.FragmentPhotographerBinding
import com.example.wikipedia.databinding.FragmentProfileBinding

class FragmentPhotographer:Fragment() {
    lateinit var binding: FragmentPhotographerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPhotographerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}