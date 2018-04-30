package net.teslaa.jmedic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.teslaa.data.ApiCalls;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiCalls apiCalls = new ApiCalls();

        apiCalls.getAccess_token();
        apiCalls.getRetrievDoctorsList();

    }
}
