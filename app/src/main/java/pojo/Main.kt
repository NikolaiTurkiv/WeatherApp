package pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Main {
    @SerializedName("temp")
    @Expose
     var temp = 0.0

    @SerializedName("feels_like")
    @Expose
    private var feelsLike = 0.0

    @SerializedName("temp_min")
    @Expose
    private var tempMin = 0.0

    @SerializedName("temp_max")
    @Expose
     var tempMax = 0.0

    @SerializedName("pressure")
    @Expose
      var pressure = 0

    @SerializedName("humidity")
    @Expose
      var humidity = 0

}