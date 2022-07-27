package a06367.apicture.ui.main.adapter

import a06367.apicture.R
import a06367.apicture.ui.main.StarredData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StarredAdapter(val context: Context, val userList: List<StarredData>) :
    RecyclerView.Adapter<StarredAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img1: ImageView = itemView.findViewById<ImageView>(R.id.img_1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //  holder..text=userList[position].userId.toString()
        // holder.author.text=userList[position].author
        val url = userList[position].download_url
        Glide.with(context)
            .load(url)
            .override(550, 500)
            .centerCrop()
            .into(holder.img1)
    }
}