package net.teslaa.data;

import android.support.annotation.NonNull;
import android.util.Log;

import net.teslaa.domain.dataModel.SearchDoctorTemplateResponse;
import net.teslaa.domain.dataModel.TokensTemplateResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApiCalls {

    private static final String TAG = "JMedic";

    private String access_token;
    private String location_name;
    private String userId;
    private double lat;
    private double lng;
    private JMedicServices JMedicServices = ApiRepository.getClient().create(JMedicServices.class);

    public void getAccess_token(String grant_type, String username, String password) {
        // Getting the access token --> Start
        Call<TokensTemplateResponse> tokensTemplateResponseCall = JMedicServices.accessToken(grant_type, username, password);
        tokensTemplateResponseCall.enqueue(new Callback<TokensTemplateResponse>() {
            @Override
            public void onResponse(Call<TokensTemplateResponse> call,
                                   Response<TokensTemplateResponse> response) {
                Log.i(TAG, "got it" + response.body());
                access_token = "Bearer " + response.body().access_token;
            }

            @Override
            public void onFailure(Call<TokensTemplateResponse> call, Throwable t) {
                Log.e(TAG, "couldn't get");
            }
        });
    }
    // Getting the access token --> End up

    public void getRetrievDoctorsList() {
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
    }
    // Getting doctors search --> End up
}
