package com.pecpaker.leaderboard.view.skilliq

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
import com.pecpaker.leaderboard.dataSource.response.SkillIQResponse
import com.pecpaker.leaderboard.model.ModelIQ
import kotlinx.android.synthetic.main.list_item_skilliq.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SkillIQFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    private var skillIQLeadersAdapter = SkillIQAdapter()
    private var allSkillIq: List<ModelIQ>? = null
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_i_q, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.skill_recycler_view)
        recyclerView.adapter = skillIQLeadersAdapter
        layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = layoutManager

        val service = getRetrofit.create(ApiService::class.java)
        val call = service.getSkillIqLeaders()

        call.enqueue(object : Callback<List<SkillIQResponse>> {
            override fun onResponse(
                call: Call<List<SkillIQResponse>>,
                response: Response<List<SkillIQResponse>>
            ) {
                if (response.code() == 200) {
                    val skillIq = response.body()!!
                    skillIQLeadersAdapter.addItems(response.body()!!)

                }
            }

            override fun onFailure(call: Call<List<SkillIQResponse>>, t: Throwable) {
                text_skill_name!!.text = t.message
                text_skil_Country!!.text = t.message
                text_skil_score!!.text = t.message
            }
        })
    }
}