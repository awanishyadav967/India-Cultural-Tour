package India.Cultural.Tour.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Posts  (
    @Expose
    @SerializedName("message") val message : String,
    ) :  Serializable

