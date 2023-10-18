package India.Cultural.Tour.Views.CustomDialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.preference.PreferenceManager
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.google.android.material.internal.ContextUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import India.Cultural.Tour.Models.PostsPlaces
import India.Cultural.Tour.Network.PostUserApi
import India.Cultural.Tour.Network.retrofit
import India.Cultural.Tour.R
import India.Cultural.Tour.Utils.CustomToast
import India.Cultural.Tour.Utils.ReadyFunction
import India.Cultural.Tour.Views.Admin.AdminPosts

class DialogAdminPostReported {
    val ReadyFunction = ReadyFunction()

    @SuppressLint("RestrictedApi")
    fun ShowOptionReported(context: Context?, view: View) {
        val dialog = Dialog(context!!)
        dialog.setContentView(view)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //Make it TRANSPARENT
        dialog.window!!.getAttributes().windowAnimations = R.style.DialogAnimation; //Set Animation
        dialog.getWindow()?.getAttributes()?.gravity = Gravity.BOTTOM;
        dialog.show()
        /////
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
        val Postid = sharedPreference.getString("IdPostDetail", null)
        /////
        val btnYesDelete = view.findViewById<TextView>(R.id.admindeletereport) as? TextView
        val btnNoDelete = view.findViewById<TextView>(R.id.admincancelreport) as? TextView
        btnNoDelete?.setOnClickListener{
            CancelPost(Postid!!,context,dialog)
        }
        btnYesDelete?.setOnClickListener{
            DeletePost(Postid!!,context,dialog)
        }
    }


    @SuppressLint("RestrictedApi")
    fun DeletePost(Postid:String,context: Context, dialog:Dialog)
    {
        val retrofi: Retrofit = retrofit.getInstance()
        val service: PostUserApi = retrofi.create(PostUserApi::class.java)
        val Posts = PostsPlaces()
        Posts.setId(Postid)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.DeletePost(Posts)
                withContext(Dispatchers.Main) {
                    if (response!!.isSuccessful) {
                        CustomToast(context, "Deleted Successfully!","GREEN").show()
                        dialog.dismiss()
                            ReadyFunction.changeFragmentnull(AdminPosts(), context)
                    } else {
                        Log.e("RETROFIT_ERROR", response.code().toString())
                        println("Message :" + response.errorBody()?.string())
                        CustomToast(context, "Something Went Wrong!", "RED").show()
                    }
                }
            } catch (e: Exception) {
                println("Error")
                println(e.printStackTrace())
                ContextUtils.getActivity(context)?.runOnUiThread(java.lang.Runnable {
                    dialog.dismiss()
                    // CustomToast(context, "Sorry, Our Server Is Down!", "RED").show()
                    //ReadyFunction.changeFragmentnull(FragmentExplore(), context)
                })
            }
        }
    }


    @SuppressLint("RestrictedApi")
    fun CancelPost(Postid:String,context: Context, dialog:Dialog)
    {
        val retrofi: Retrofit = retrofit.getInstance()
        val service: PostUserApi = retrofi.create(PostUserApi::class.java)
        val Posts = PostsPlaces()
        Posts.setId(Postid)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.CancelReport(Posts)
                withContext(Dispatchers.Main) {
                    if (response!!.isSuccessful) {
                        CustomToast(context, "Canceled Successfully!","GREEN").show()
                        dialog.dismiss()
                        ReadyFunction.changeFragmentnull(AdminPosts(), context)
                    } else {
                        Log.e("RETROFIT_ERROR", response.code().toString())
                        println("Message :" + response.errorBody()?.string())
                        CustomToast(context, "Something Went Wrong!", "RED").show()
                    }
                }
            } catch (e: Exception) {
                println("Error")
                println(e.printStackTrace())
                ContextUtils.getActivity(context)?.runOnUiThread(java.lang.Runnable {
                    dialog.dismiss()
                    // CustomToast(context, "Sorry, Our Server Is Down!", "RED").show()
                    //ReadyFunction.changeFragmentnull(FragmentExplore(), context)
                })
            }
        }
    }
}