package com.pecpaker.leaderboard.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
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

        btnSubmit.setOnClickListener {
            val firstName = etFname.text.toString().trim()
            val lastName = etLname.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val link = etProject.text.toString().trim()
            when {
                firstName.isBlank() -> {
                    etFname.error = "Enter first name"
                    etFname.requestFocus()
                    return@setOnClickListener
                }
                lastName.isBlank() -> {
                    etLname.error = "Enter last name"
                    etLname.requestFocus()
                    return@setOnClickListener
                }
                link.isBlank() -> {
                    etProject.error = "Enter link to you Github"
                    etProject.requestFocus()
                    return@setOnClickListener
                }
                email.isBlank() -> {
                    etEmail.error = "Enter Email"
                    etEmail.requestFocus()
                    return@setOnClickListener
                }

            }

            findNavController().navigate(R.id.to_areYouSureDialogFragment)
        }
    }

    private fun handleSubmission() {
        val firstName = etFname.text.toString().trim()
        val lastName = etLname.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val link = etProject.text.toString().trim()
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