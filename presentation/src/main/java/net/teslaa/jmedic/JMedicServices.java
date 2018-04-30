package net.teslaa.jmedic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ahHosseini on 4/28/18.
 */

public interface JMedicServices {

  @Headers({
      "Content-Type: application/x-www-form-urlencoded",
      "Accept: application/json",
      "Authorization: Basic aXBob25lOmlwaG9uZXdpbGxub3RiZXRoZXJlYW55bW9yZQ=="
  })
  @POST("/oauth/token?grant_type=password&username=rowanto@uvita.eu&password=88888888")
  Call<TokensTemplateResponse> accessToken();


  @Headers({
          "Accept: application/json",
  })
  @GET("/api/users/{user}/doctors")
  Call<SearchDoctorTemplateResponse> searchDoctor(

          @Header("Authorization")
          String access_token,
          @Path("user")
          String userId,
          @Query("location_name")
          String location_name,
          @Query("lat")
          double lat,
          @Query("lng")
          double lng);


}
