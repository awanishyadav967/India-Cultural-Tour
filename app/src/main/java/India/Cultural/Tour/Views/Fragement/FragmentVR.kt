package India.Cultural.Tour.Views.Fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import India.Cultural.Tour.Navigation
import India.Cultural.Tour.R


class FragmentVR : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //
                fragmentManager?.beginTransaction()?.replace(R.id.container, TODO())
                    ?.addToBackStack("ExploreTodo")?.commit()
                (requireActivity() as Navigation).BottomNavigationView.visibility = View.VISIBLE
            }
        })
    }


}