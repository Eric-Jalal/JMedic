package net.teslaa.jmedic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.teslaa.data.ApiClient;
import net.teslaa.data.JMedicServices;
import net.teslaa.domain.dataModel.SearchDoctorTemplateResponse;
import net.teslaa.domain.dataModel.TokensTemplateResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        

    }
}
