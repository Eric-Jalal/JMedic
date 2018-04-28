package net.teslaa.jmedic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ahHosseini on 4/28/18.
 */

public interface JMedicService {

  @Headers({
      "Content-Type: application/x-www-form-urlencoded",
      "Accept: application/json",
      "Authorization: Basic aXBob25lOmlwaG9uZXdpbGxub3RiZXRoZXJlYW55bW9yZQ=="
  })
  @POST("/oauth/token?grant_type=password&username=rowanto@uvita.eu&password=88888888")
  Call<TokensTemplateResponse> accessToken();

}
