package net.teslaa.jmedic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JMedic";

    String access_token;
    String location_name;
    String userId;
    double lat;
    double lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Getting the access token --> Start
        JMedicServices JMedicServices = ApiClient.getClient().create(JMedicServices.class);
        Call<TokensTemplateResponse> tokensTemplateResponseCall = JMedicServices.accessToken();
        tokensTemplateResponseCall.enqueue(new Callback<TokensTemplateResponse>() {
            @Override public void onResponse(Call<TokensTemplateResponse> call,
                Response<TokensTemplateResponse> response) {
                if (response.body() != null) {
                    Log.i(TAG, "got it" + response.body().access_token);
                    access_token = "Bearer " + response.body().access_token;
                }
            }

            @Override public void onFailure(Call<TokensTemplateResponse> call, Throwable t) {
                Log.e(TAG, "couldn't get");
            }
        });
        // Getting the access token --> End up

        // Getting latitude and longitude --> Start
        lat = 52.534709;
        lng = 13.3976972;
        location_name= "Fritzhof";
        userId = "rowanto";
        // Getting latitude and longitude --> End up

        // Getting doctors search result --> Start
        Call<SearchDoctorTemplateResponse> searchDoctorTemplateResponseCall = JMedicServices.searchDoctor(access_token, userId, location_name, lat, lng);
        searchDoctorTemplateResponseCall.enqueue(new Callback<SearchDoctorTemplateResponse>() {
            @Override
            public void onResponse(Call<SearchDoctorTemplateResponse> call, @NonNull Response<SearchDoctorTemplateResponse> response) {
                Log.i(TAG, "Successful retrieved doctors list");

            }

            @Override
            public void onFailure(Call<SearchDoctorTemplateResponse> call, Throwable t) {
                Log.e(TAG, "Retrieving doctors list was unsuccessful");
            }
        });
        // Getting doctors search --> End up

        

    }
}
