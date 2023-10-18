package India.Cultural.Tour.DataMapList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import India.Cultural.Tour.R

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val Nom : TextView = itemView.findViewById<TextView>(R.id.CategoryNom)
    val Pic : ImageView = itemView.findViewById<ImageView>(R.id.CategoryPic)
}