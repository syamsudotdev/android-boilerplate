package net.mnsam.applicationboilerplate.feature.premierleague

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.mnsam.applicationboilerplate.databinding.ListTeamItemBinding
import net.mnsam.data.domain.TeamDetail

class PremierTeamAdapter : RecyclerView.Adapter<PremierTeamAdapter.ViewHolder>() {

    private var teamDetails = listOf<TeamDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding = ListTeamItemBinding.inflate(inflater, parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(teamDetails[position])
    }

    override fun getItemCount() = teamDetails.size

    fun setList(teamDetails: List<TeamDetail>) {
        this.teamDetails = teamDetails
        notifyDataSetChanged()
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
}
