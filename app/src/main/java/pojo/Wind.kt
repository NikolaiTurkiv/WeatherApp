package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Wind {
    @SerializedName("speed")
    @Expose
     val speed = 0.0

    @SerializedName("deg")
    @Expose
    private val deg = 0
}