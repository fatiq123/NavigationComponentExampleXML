package com.example.navigationcomponentexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationcomponentexample.R

class SpecifyFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view = view)

        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.send_btn -> {
                navController.navigate(R.id.action_specifyFragment_to_confirmationFragment)
            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }

}