package com.example.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding

    var userInput = MutableLiveData<String?>()
//    lateinit var viewModel: AddFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater)

        val userInputEditText = binding.addFragmentEditText
        binding.addFragmentButton.setOnClickListener {

            val showFragment = ShowFragment()

            val addedText = userInputEditText.text.toString()
            userInput.value = addedText

            val bundle = Bundle().apply {
                putString("key", addedText)
            }

            showFragment.arguments = bundle

            println(bundle)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, showFragment)
                .addToBackStack(null)
                .commit()

//            val action = AddFragmentDirections.toShowFragment()
//            findNavController().navigate(action)

        }

        return binding.root
    }

}