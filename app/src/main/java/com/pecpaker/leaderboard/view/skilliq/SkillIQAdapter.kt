package com.pecpaker.leaderboard.view.skilliq

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.dataSource.remote.RestClient.inflate
import com.pecpaker.leaderboard.dataSource.response.SkillIQResponse
import kotlinx.android.synthetic.main.list_item_skilliq.view.*

class SkillIQAdapter  () : RecyclerView.Adapter<SkillIQAdapter.SkillIQViewHolder>() {

    private var items = ArrayList<SkillIQResponse>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SkillIQAdapter.SkillIQViewHolder = SkillIQViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SkillIQAdapter.SkillIQViewHolder, position: Int) =
        holder.bind(items[position])

    fun addItems( list: List<SkillIQResponse>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    inner class SkillIQViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(
            R.layout.list_item_skilliq
        )
    ) {

        fun bind(items: SkillIQResponse) {

            itemView.tvIqName.text = items.name
            itemView.tvIqScores.text = items.score.toString()
            itemView.tvIqCountry.text = items.country
            Glide
                .with(itemView.imgIq)
                .load(items.badgeUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_skill_iq)
                .into(itemView.imgIq)

        }

    }
}