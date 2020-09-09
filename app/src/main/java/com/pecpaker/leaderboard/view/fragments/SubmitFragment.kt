package com.pecpaker.leaderboard.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.dataSource.remote.RetrofitClient
import com.pecpaker.leaderboard.view.MainActivity
import com.pecpaker.leaderboard.view.fragments.dialog.AreYouSureDialogFragment
import com.pecpaker.leaderboard.view.fragments.dialog.YesDialogClick
import kotlinx.android.synthetic.main.fragment_submit2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [SubmitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubmitFragment : Fragment(), YesDialogClick {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submit2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AreYouSureDialogFragment.setYesDialogClick(this)

        btn_submit.setOnClickListener {
            val firstName = First_name.text.toString().trim()
            val lastName = last_name.text.toString().trim()
            val email = email_address.text.toString().trim()
            val link = project_git_link.text.toString().trim()
            when {
                firstName.isBlank() -> {
                    First_name.error = "Enter first name"
                    First_name.requestFocus()
                    return@setOnClickListener
                }
                lastName.isBlank() -> {
                    last_name.error = "Enter last name"
                    last_name.requestFocus()
                    return@setOnClickListener
                }
                link.isBlank() -> {
                    project_git_link.error = "Enter link to you Github"
                    project_git_link.requestFocus()
                    return@setOnClickListener
                }
                email.isBlank() -> {
                    email_address.error = "Enter Email"
                    email_address.requestFocus()
                    return@setOnClickListener
                }

            }

            findNavController().navigate(R.id.to_areYouSureDialogFragment)
        }
    }

    private fun handleSubmission() {
        val firstName = First_name.text.toString().trim()
        val lastName = last_name.text.toString().trim()
        val email = email_address.text.toString().trim()
        val link = project_git_link.text.toString().trim()
        RetrofitClient.submitInstance.submitForm(firstName, lastName, email, link)

            .enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                    println("Submission Failure: ${t.message}")
                    submitProgressBar.visibility = View.GONE
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    if (response.isSuccessful) {
                        submitProgressBar.visibility = View.GONE
                        findNavController().navigate(R.id.to_dialogSubmissionSuccessfulFragment)


                    } else {
                        submitProgressBar.visibility = View.GONE
                        findNavController().navigate(R.id.to_dialogSubmissionNotSuccessfulFragment)
                        Toast.makeText(
                            requireContext(),
                            "Submission Fail: ${response.errorBody()}",
                            Toast.LENGTH_LONG
                        ).show()
                        println("Submission Fail: ${response.body()}")
                    }

                }
            })
    }

    override fun onStart() {
        super.onStart()
        MainActivity.hideToolBarTitle(requireActivity())
        showSubmitView(requireActivity())
    }

    override fun onResume() {
        super.onResume()
        showSubmitView(requireActivity())
    }


    override fun getSelected() {
        handleSubmission()
        submitProgressBar.visibility = View.VISIBLE
    }

    fun hideSubmitView() {

    }

    companion object {
        //val view: View? = null
        fun hideSubmitView(activity: FragmentActivity) {
            activity.views.visibility = View.GONE
        }

        fun showSubmitView(activity: FragmentActivity) {
            activity.views.visibility = View.VISIBLE

        }
    }


}