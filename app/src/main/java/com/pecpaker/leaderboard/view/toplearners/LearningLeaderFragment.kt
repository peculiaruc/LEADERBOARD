package com.pecpaker.leaderboard.view.toplearners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.dataSource.remote.ApiService
import com.pecpaker.leaderboard.dataSource.remote.RestClient.getRetrofit
import com.pecpaker.leaderboard.dataSource.response.LearningLearderResponse
import com.pecpaker.leaderboard.model.Model
import kotlinx.android.synthetic.main.list_item_toplearner.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LearningLeaderFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private var topLearnersAdapter = LearnerLeaderAdapter()
    private var allTopLearners: List<Model>? = null
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_leader, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.Learner_Recycler_view)
        recyclerView.adapter = topLearnersAdapter
        layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = layoutManager

        val service = getRetrofit.create(ApiService::class.java)
        val call = service.getLearningLeaders()

        call.enqueue(object : Callback<List<LearningLearderResponse>> {
            override fun onResponse(call: Call<List<LearningLearderResponse>>, response: Response<List<LearningLearderResponse>>) {
                if (response.code() == 200) {
                    val skillIq = response.body()!!
                    topLearnersAdapter.addItems(response.body()!!)

                }

            }

            override fun onFailure(call: Call<List<LearningLearderResponse>>, t: Throwable) {
                text_learner_name!!.text = t.message
                text_learner_Country!!.text = t.message
                text_learner_hours!!.text = t.message
                //imgIq.setImageResource(R.drawable) = t.message
            }
        })
    }

}