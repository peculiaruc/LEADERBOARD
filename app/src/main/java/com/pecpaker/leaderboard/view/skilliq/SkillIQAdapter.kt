package com.pecpaker.leaderboard.view.skilliq

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pecpaker.leaderboard.R
import com.pecpaker.leaderboard.dataSource.remote.RetrofitClient
import com.pecpaker.leaderboard.dataSource.response.SkillIQResponse
import com.pecpaker.leaderboard.inflate
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

            itemView.text_skill_name.text = items.name
            itemView.text_skil_score.text = items.score.toString()
            itemView.text_skil_Country.text = items.country
            Glide
                .with(itemView.img_skill)
                .load(items.badgeUrl)
                .fitCenter()
                .placeholder(R.drawable.ic_skill_iq)
                .into(itemView.img_skill)

        }

    }
}