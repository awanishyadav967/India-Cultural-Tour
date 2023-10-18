package India.Cultural.Tour.Views.Admin
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapterAdmin (fa: FragmentActivity) : FragmentStateAdapter(fa){

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AdminPosts()
            }
            else -> {
                return AdminPosts()
            }
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

}