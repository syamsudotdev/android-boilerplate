package net.mnsam.applicationboilerplate.feature.premierleague.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.mnsam.applicationboilerplate.databinding.ListTeamItemBinding
import net.mnsam.data.domain.TeamDetail

class PremierTeamAdapter : ListAdapter<TeamDetail, PremierTeamAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ListTeamItemBinding.inflate(inflater, parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val listTeamItemBinding: ListTeamItemBinding) :
        RecyclerView.ViewHolder(listTeamItemBinding.root) {

        fun bind(teamDetail: TeamDetail) {
            listTeamItemBinding.apply {
                tvName.text = teamDetail.name
                tvHome.text = teamDetail.home
                tvHomeLocation.text = teamDetail.location
                Glide.with(root.context)
                    .load(teamDetail.badgeUrl)
                    .into(ivTeamBadge)
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<TeamDetail>() {
        override fun areItemsTheSame(oldItem: TeamDetail, newItem: TeamDetail): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TeamDetail, newItem: TeamDetail): Boolean {
            return oldItem == newItem
        }

    }
}
