package a06367.apicture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val pics: List<Picture>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pic, null)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(pics[position])
    }

    override fun getItemCount(): Int {
        return pics.size
    }

    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivPoster: ImageView = itemView.findViewById(R.id.view_pic__iv)
        val tvTitle: TextView = itemView.findViewById(R.id.view_pic__tv)

        fun bind(pic: Picture) {
            ivPoster.setImageResource(pic.img)
            tvTitle.text = pic.title
        }
    }

}