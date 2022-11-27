package dji.midware.util;

import android.content.Context;
import com.dji.frame.interfaces.V_CallBack_ReceiveData;
import com.dji.frame.util.V_AppUtils;
import dji.thirdparty.afinal.FinalHttp;
import dji.thirdparty.afinal.http.AjaxCallBack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class DJIGeocoderResult
{
  public ArrayList<FirstLevel> results;
  public String status;
  
  public static void get(Context paramContext, double paramDouble1, double paramDouble2, V_CallBack_ReceiveData paramV_CallBack_ReceiveData)
  {
    paramContext = V_AppUtils.getFinalHttp(paramContext);
    String str = Locale.getDefault().getLanguage();
    str.contains("zh");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://ditu.google.cn/maps/api/geocode/json?latlng=");
    localStringBuilder.append(paramDouble1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramDouble2);
    localStringBuilder.append("&sensor=false&language=");
    localStringBuilder.append(str);
    paramContext.get(localStringBuilder.toString(), new AjaxCallBack()
    {
      public void onFailure(Throwable paramAnonymousThrowable, int paramAnonymousInt, String paramAnonymousString)
      {
        this.val$callBack.exec(null);
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static FirstLevel getStreetAdress(DJIGeocoderResult paramDJIGeocoderResult)
  {
    paramDJIGeocoderResult = paramDJIGeocoderResult.results.iterator();
    while (paramDJIGeocoderResult.hasNext())
    {
      FirstLevel localFirstLevel = (FirstLevel)paramDJIGeocoderResult.next();
      if ((localFirstLevel.types.contains("street_address")) || (localFirstLevel.types.contains("route"))) {
        return localFirstLevel;
      }
    }
    return null;
  }
  
  public static void get_en(Context paramContext, double paramDouble1, double paramDouble2, V_CallBack_ReceiveData paramV_CallBack_ReceiveData)
  {
    paramContext = V_AppUtils.getFinalHttp(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://ditu.google.cn/maps/api/geocode/json?latlng=");
    localStringBuilder.append(paramDouble1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramDouble2);
    localStringBuilder.append("&sensor=false&language=en");
    paramContext.get(localStringBuilder.toString(), new AjaxCallBack()
    {
      public void onFailure(Throwable paramAnonymousThrowable, int paramAnonymousInt, String paramAnonymousString)
      {
        this.val$callBack.exec(null);
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static class FirstLevel
  {
    public ArrayList<DJIGeocoderResult.SecondLevel> address_components;
    public String formatted_address;
    public ArrayList<String> types;
  }
  
  public static class SecondLevel
  {
    public String long_name;
    public String short_name;
    public ArrayList<String> types;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DJIGeocoderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */