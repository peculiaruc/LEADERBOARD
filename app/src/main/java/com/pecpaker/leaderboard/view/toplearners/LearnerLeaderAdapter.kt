package com.pecpaker.leaderboard.view.toplearners

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.dataSource.remote.RestClient.inflate
import com.pecpaker.leaderboard.dataSource.response.LearningLearderResponse
import kotlinx.android.synthetic.main.list_item_toplearner.view.*

class LearnerLeaderAdapter () : RecyclerView.Adapter<LearnerLeaderAdapter.LearningViewHolder>() {

    private var items = ArrayList<LearningLearderResponse>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LearnerLeaderAdapter.LearningViewHolder = LearningViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LearnerLeaderAdapter.LearningViewHolder, position: Int) =
        holder.bind(items[position])

    fun addItems( list: List<LearningLearderResponse>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    inner class LearningViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(
            R.layout.list_item_toplearner
        )
    ) {

        fun bind(items: LearningLearderResponse) {

            itemView.tvName.text = items.name
            itemView.tvHours.text = items.hours.toString()
            itemView.tvCountry.text = items.country
            Glide
                .with(itemView.img_topl)
                .load(items.badgeUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_top_learner)
                .into(itemView.img_topl)

        }

    }
}