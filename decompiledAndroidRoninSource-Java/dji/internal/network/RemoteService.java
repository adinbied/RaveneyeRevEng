package dji.internal.network;

import android.util.Base64;
import dji.internal.logics.countrycode.CountryCodeResponse;
import dji.midware.natives.SDKRelativeJNI;
import dji.thirdparty.okhttp3.Interceptor;
import dji.thirdparty.okhttp3.OkHttpClient;
import dji.thirdparty.okhttp3.OkHttpClient.Builder;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.retrofit2.Callback;
import dji.thirdparty.retrofit2.Retrofit;
import dji.thirdparty.retrofit2.Retrofit.Builder;
import dji.thirdparty.retrofit2.converter.gson.GsonConverterFactory;

public class RemoteService
  extends BaseRemoteService
{
  private static final String AUTH_HEADER_NAME = "Authorization";
  private static final String BASIC_AUTH;
  private static final String PASSWORD = "";
  private static final String SDK_LOG_FILE_TYPE = "warrantyLog";
  private static final String TAG = "RemoteService";
  private static String baseUrl = ;
  private static RemoteClient client;
  private static RemoteClient countryCodeClient;
  private static String countryCodeURL;
  private static RemoteService instance;
  private static String userName = SDKRelativeJNI.native_getRemoteServerProdUserName();
  
  static
  {
    countryCodeURL = "https://mydjiflight.dji.com/api/v2/geocoder_service/";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Basic ");
    localStringBuilder.append(Base64.encodeToString(String.format("%s:%s", new Object[] { userName, "" }).getBytes(), 2));
    BASIC_AUTH = localStringBuilder.toString();
  }
  
  private RemoteService()
  {
    Object localObject = new HttpInterceptor();
    ((HttpInterceptor)localObject).setLevel(HttpInterceptor.Level.NONE);
    ((HttpInterceptor)localObject).addHeader("Authorization", BASIC_AUTH);
    localObject = new OkHttpClient.Builder().addInterceptor((Interceptor)localObject).build();
    client = (RemoteClient)new Retrofit.Builder().client((OkHttpClient)localObject).baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build().create(RemoteClient.class);
  }
  
  public static String getBaseUrl()
  {
    return baseUrl;
  }
  
  public static RemoteService getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new RemoteService();
      }
      RemoteService localRemoteService = instance;
      return localRemoteService;
    }
    finally {}
  }
  
  public void destroy() {}
  
  /* Error */
  public void getCountryCodeByGPSCoordinate(double arg1, double arg3, BaseRemoteService.SDKRemoteServiceCallback arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: return
  }
  
  /* Error */
  public void getCountryCodeByIPAddress(String arg1, BaseRemoteService.SDKRemoteServiceCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void getFeatureFlags(String arg1, String arg2, String arg3, String arg4, String arg5, BaseRemoteService.SDKRemoteServiceCallback arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void postAnalyticsEvents(java.util.List<DJIAnalyticsEvent> arg1, BaseRemoteService.SDKRemoteServiceCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void uploadLogZipFile(String arg1, String arg2, String arg3, BaseRemoteService.SDKRemoteServiceCallback arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\RemoteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */