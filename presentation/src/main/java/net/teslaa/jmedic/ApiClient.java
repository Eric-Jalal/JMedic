package net.teslaa.jmedic;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahHosseini on 4/28/18.
 */


public class ApiClient {


  private static Retrofit retrofit = null;

  public static Retrofit getClient() {


    if (retrofit==null) {

      OkHttpClient client = new OkHttpClient.Builder()
          .readTimeout(20, TimeUnit.SECONDS)
          .connectTimeout(20, TimeUnit.SECONDS)
          .build();

      retrofit = new Retrofit.Builder()
          .baseUrl("https://api.uvita.eu")
          .client(client)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }

    return retrofit;
  }

}
