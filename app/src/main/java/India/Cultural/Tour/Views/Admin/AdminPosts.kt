package India.Cultural.Tour.Views.Admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import India.Cultural.Tour.Models.PostsPlaces
import India.Cultural.Tour.Network.AdminApi
import India.Cultural.Tour.Network.retrofit
import India.Cultural.Tour.R
import India.Cultural.Tour.Utils.ReadyFunction
import India.Cultural.oneblood.DataMapList.AdminReportAdapter

class AdminPosts : Fragment() {
    lateinit var RecyclerReport: RecyclerView
    lateinit var AdapterAdminReport: AdminReportAdapter
    var PostsModels: ArrayList<PostsPlaces> = ArrayList()
    val retrofi: Retrofit = retrofit.getInstance()
    val service: AdminApi = retrofi.create(AdminApi::class.java)
    val ReadyFunction = ReadyFunction()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.admin_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        RecyclerReport = view.findViewById(R.id.RecyclerReport)
        //
        RecyclerReport.setLayoutManager(StaggeredGridLayoutManager(1, 1))
        AdapterAdminReport = AdminReportAdapter(requireContext())
        RecyclerReport.adapter = AdapterAdminReport
        //
        ShowAllReported()
    }

    fun ShowAllReported() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        service.GetReportedPost().enqueue(object : Callback<List<PostsPlaces>> {
            override fun onResponse(
                call: Call<List<PostsPlaces>>,
                response: Response<List<PostsPlaces>>
            ) {
                var DataBody = response.body()?.toString()
                println("Boddddyyyy " + DataBody)
                println("Boddddyyyy " + response.body())

                PostsModels = ArrayList(response.body()!!)
                AdapterAdminReport.submitList(PostsModels)
            }
            override fun onFailure(call: Call<List<PostsPlaces>>, t: Throwable) {
                // Log.e("RETROFIT_ERROR", Response.code().toString())
                println("Message :" + t.stackTrace)
            }

        })
    }





































































































































































































































































































































































































































































}