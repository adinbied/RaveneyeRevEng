package dji.internal.network;

import dji.internal.logics.countrycode.CountryCodeResponse;
import dji.thirdparty.okhttp3.MultipartBody.Part;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.retrofit2.Call;
import dji.thirdparty.retrofit2.http.Body;
import dji.thirdparty.retrofit2.http.GET;
import dji.thirdparty.retrofit2.http.Multipart;
import dji.thirdparty.retrofit2.http.POST;
import dji.thirdparty.retrofit2.http.Part;
import dji.thirdparty.retrofit2.http.Query;
import java.util.List;

public abstract interface RemoteClient
{
  public static final String COUNTRY_CODE_SUB_URI = "geoip";
  public static final String EVENT_SUB_URI = "events";
  public static final String FLAG_SUB_URI = "flags";
  public static final String LOG_SUB_URI = "upload";
  
  @GET("geoip")
  public abstract Call<CountryCodeResponse> getCountryCodeByGPSCoordinate(@Query("lat") double paramDouble1, @Query("lng") double paramDouble2);
  
  @GET("geoip")
  public abstract Call<CountryCodeResponse> getCountryCodeByIP(@Query("ip") String paramString);
  
  @GET("flags")
  public abstract Call<DJIFeatureFlags> getFeatureFlags(@Query("appKey") String paramString1, @Query("installId") String paramString2, @Query("displayName") String paramString3, @Query("platform") String paramString4, @Query("sdkVersion") String paramString5, @Query("locale") String paramString6);
  
  @POST("events")
  public abstract Call<ResponseBody> postAnalyticsEvents(@Body List<DJIAnalyticsEvent> paramList);
  
  @Multipart
  @POST("upload")
  public abstract Call<ResponseBody> uploadLogZipFile(@Part MultipartBody.Part paramPart, @Query("type") String paramString1, @Query("installId") String paramString2, @Query("hash") String paramString3);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\RemoteClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */