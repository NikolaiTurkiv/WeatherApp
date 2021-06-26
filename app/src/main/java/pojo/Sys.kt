package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Sys {
    @SerializedName("type")
    @Expose
     val type = 0

    @SerializedName("id")
    @Expose
     val id = 0

    @SerializedName("message")
    @Expose
     val message = 0.0

    @SerializedName("country")
    @Expose
      val country: String? = null

    @SerializedName("sunrise")
    @Expose
    val sunrise = 0

    @SerializedName("sunset")
    @Expose
      val sunset = 0
}