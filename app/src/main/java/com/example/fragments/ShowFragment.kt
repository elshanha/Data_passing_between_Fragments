package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentShowBinding


class ShowFragment : Fragment() {

    lateinit var binding: FragmentShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShowBinding.inflate(inflater)

        val data = arguments?.getString("key") ?: ""
        println(data)

        val textView = binding.showFragmentText
        textView.text = data

        binding.showFragmentButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, AddFragment())
                .addToBackStack(null)
                .commit()

        }

        return binding.root
    }
}