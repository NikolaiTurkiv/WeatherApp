package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Coord {

    @SerializedName("lon")
    @Expose
    private var lon = 0.0

    @SerializedName("lat")
    @Expose
    private var lat = 0.0


}