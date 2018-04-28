package net.teslaa.jmedic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JMedic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JMedicService jMedicService = ApiClient.getClient().create(JMedicService.class);

        Call<TokensTemplateResponse> tokensTemplateResponseCall = jMedicService.accessToken();
        tokensTemplateResponseCall.enqueue(new Callback<TokensTemplateResponse>() {
            @Override public void onResponse(Call<TokensTemplateResponse> call,
                Response<TokensTemplateResponse> response) {
                Log.i(TAG, "got it" + response.toString());
            }

            @Override public void onFailure(Call<TokensTemplateResponse> call, Throwable t) {
                Log.e(TAG, "couldn't get");
            }
        });
    }
}
