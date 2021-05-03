package id.rrlab.diffutil.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.rrlab.diffutil.data.Rating
import id.rrlab.diffutil.databinding.ItemRatingBinding
import id.rrlab.diffutil.util.RatingDiffCallback

class RatingAdapter : RecyclerView.Adapter<RatingAdapter.ViewHolder>() {

    private val ratings = ArrayList<Rating>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRatingBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RatingAdapter.ViewHolder, position: Int) {
        holder.bind(ratings[position])
    }

    override fun getItemCount(): Int {
        return ratings.size
    }

    class ViewHolder(private val binding: ItemRatingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rating: Rating) {
            binding.tvTitle.text = rating.name
        }
    }

    fun setData(ratings: List<Rating>) {
        val diffCallback = RatingDiffCallback(this.ratings, ratings)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.ratings.clear()
        this.ratings.addAll(ratings)
        diffResult.dispatchUpdatesTo(this)
    }
}