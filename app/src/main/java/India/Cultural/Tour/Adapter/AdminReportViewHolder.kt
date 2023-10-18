package India.Cultural.Tour.DataMapList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import India.Cultural.Tour.R

class AdminReportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val UserPostAvatar : ImageView = itemView.findViewById(R.id.PostUserReported)
    val UserPostName : TextView = itemView.findViewById(R.id.UserPostNamePostUserReported)
    val UserPostDate : TextView = itemView.findViewById(R.id.DatePostUserReported)
    val UserMediaPost : ImageView = itemView.findViewById(R.id.UserMediaPostUserReported)
    val PostuserMenu : ImageView = itemView.findViewById(R.id.PostuserMenuReported)
    val DescriptionPost : TextView = itemView.findViewById(R.id.DescriptionPostttPostUserReported)

}