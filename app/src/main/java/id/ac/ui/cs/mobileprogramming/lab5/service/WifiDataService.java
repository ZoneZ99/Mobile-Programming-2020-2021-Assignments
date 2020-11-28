package id.ac.ui.cs.mobileprogramming.lab5.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface WifiDataService {

    @POST(".")
    Call<ServiceResponse> sendWifiData(@Body List<WifiData> wifiData);
}
