package com.pecpaker.leaderboard.view.fragments.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.view.fragments.SubmitFragment


/**
 * A simple [Fragment] subclass.
 * Use the [DialogSubmissionNotSuccessfulFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogSubmissionNotSuccessfulFragment : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_dialog_submission_not_successfull,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Window.FEATURE_NO_TITLE
        requireDialog().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setStyle(STYLE_NO_FRAME, android.R.style.Theme)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        SubmitFragment.showSubmitView(requireActivity())
    }

    override fun onStart() {
        super.onStart()
        SubmitFragment.hideSubmitView(requireActivity())
    }


}