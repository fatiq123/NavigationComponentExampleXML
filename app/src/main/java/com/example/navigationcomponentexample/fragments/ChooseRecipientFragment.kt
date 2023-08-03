package com.example.navigationcomponentexample.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentexample.R

class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var recipient: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view = view)

        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)

        recipient = view.findViewById(R.id.input_recipient)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.next_btn -> {
                if (!TextUtils.isEmpty(recipient.text.toString())) {
                    val bundle = bundleOf(
                        "recipient" to recipient.text.toString()
                    )
                    navController.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyFragment,
                        bundle
                    )
                }

            }

            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }

}