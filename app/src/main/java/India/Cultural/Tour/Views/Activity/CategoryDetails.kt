package India.Cultural.Tour.Views.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import India.Cultural.Tour.Models.PostsAdmin
import India.Cultural.Tour.Navigation
import India.Cultural.Tour.Network.AdminApi
import India.Cultural.Tour.Network.retrofit
import India.Cultural.Tour.R
import India.Cultural.oneblood.DataMapList.CategoryTypeAdapter




class CategoryDetails : AppCompatActivity() {
    private lateinit var RecyclerDetailsCategory: RecyclerView
    lateinit var AdapterRecommended: CategoryTypeAdapter
    private lateinit var backCategory: ImageView
    lateinit var TitleCategoryDetail: TextView
    var PostsModels: ArrayList<PostsAdmin> = ArrayList()
    //
    lateinit var mShimmerViewContainer: ShimmerFrameLayout
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_details)
        RecyclerDetailsCategory = findViewById(R.id.RecyclerDetailsCategory)
        backCategory = findViewById(R.id.backCategory)
        TitleCategoryDetail= findViewById(R.id.TitleCategoryDetail)
        ////

        //RecyclerDetailsCategory.setLayoutManager(StaggeredGridLayoutManager(2, 1))
        RecyclerDetailsCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        AdapterRecommended = CategoryTypeAdapter(this)
        RecyclerDetailsCategory.adapter = AdapterRecommended

        // ShowPostsRecommended()

        println("Avant"+PostsModels.size)
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        val TypeCategory = sharedPreference.getString("CategorySelected", null)
        //
        TitleCategoryDetail.text = TypeCategory
        //
        ShowPosts(TypeCategory!!)
        println("Apres"+PostsModels.size)
        backCategory.setOnClickListener {
            val intent = Intent(this, Navigation::class.java).apply {}
            startActivity(intent)
            finish()
        }
        //
        mShimmerViewContainer = findViewById(R.id.shimmer_categorytype)

    }

    fun ShowPosts(TypeCategory: String) {
        val map: HashMap<String, String> = HashMap()
        map["categorie"] = TypeCategory
        val retrofi: Retrofit = retrofit.getInstance()
        val service: AdminApi = retrofi.create(AdminApi::class.java)
        val call: Call<List<PostsAdmin>> = service.FindByCategory(map)
        call.enqueue(object : Callback<List<PostsAdmin>> {
            override fun onResponse(call: Call<List<PostsAdmin>>, response: Response<List<PostsAdmin>>) {
                PostsModels = ArrayList(response.body())
                //println("Boddddyyyyyyyyyy "+response.body())
                //println("Size in fun "+PostsModels.size)
                AdapterRecommended.setDataList(PostsModels)
                AdapterRecommended.notifyDataSetChanged()
                //
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
            }
            @SuppressLint("RestrictedApi")
            override fun onFailure(call: Call<List<PostsAdmin>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("***", "Opppsss" + t.message)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        mShimmerViewContainer.startShimmerAnimation()
    }

    override fun onPause() {
        mShimmerViewContainer.stopShimmerAnimation()
        super.onPause()
    }

}