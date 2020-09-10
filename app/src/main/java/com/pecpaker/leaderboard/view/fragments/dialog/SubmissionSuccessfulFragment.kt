package com.pecpaker.leaderboard.view.fragments.dialog

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.view.fragments.SubmitFragment


/**
 * A simple [Fragment] subclass.
 * Use the [SubmissionSuccessfulFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubmissionSuccessfulFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_submission_successfull, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Window.FEATURE_NO_TITLE

//        requireDialog().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        setStyle(STYLE_NO_FRAME, android.R.style.Theme)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            findNavController().navigate(R.id.mainFragment)

        }, DIALOG_TIME_OUT)
    }

    override fun onStart() {
        super.onStart()
        SubmitFragment.hideSubmitView(requireActivity())
    }

    companion object {
        // This is the loading time of the splash screen
        const val DIALOG_TIME_OUT: Long = 3000 // 1 sec
    }


}