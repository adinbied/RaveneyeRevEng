package dji.midware.sdk;

import android.content.Context;
import android.os.Environment;
import com.dji.frame.util.V_ActivityUtil;
import com.dji.frame.util.V_AppUtils;
import dji.thirdparty.afinal.FinalHttp;
import dji.thirdparty.afinal.http.AjaxCallBack;
import dji.thirdparty.afinal.http.HttpHandler;
import java.io.File;

public class DataUpgradeServerAdapter
{
  private String fileAppend;
  private final FinalHttp finalHttp;
  private final String key = "YTS7yyTAkmHkMwut";
  private final String serverAdr = "https://flysafe-api.dji.com";
  
  public DataUpgradeServerAdapter(Context paramContext)
  {
    this.finalHttp = V_AppUtils.getFinalHttp(paramContext);
    this.fileAppend = paramContext.getFilesDir().getAbsolutePath();
    if (V_ActivityUtil.isApkDebugable(paramContext))
    {
      paramContext = new StringBuilder();
      paramContext.append(Environment.getExternalStorageDirectory());
      paramContext.append("/DJI/Flysafe/");
      this.fileAppend = paramContext.toString();
      paramContext = new File(this.fileAppend);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
    }
  }
  
  /* Error */
  private void getNewestDB(String arg1, String arg2, AjaxCallBack<String> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public HttpHandler<File> downloadDB(String paramString1, String paramString2, AjaxCallBack<File> paramAjaxCallBack)
  {
    return null;
  }
  
  public void getNewestAppDB(String paramString, AjaxCallBack<String> paramAjaxCallBack)
  {
    getNewestDB("https://flysafe-api.dji.com/api/v3/geofence/app_static_data", paramString, paramAjaxCallBack);
  }
  
  public void getNewestOnboardDB(String paramString, AjaxCallBack<String> paramAjaxCallBack)
  {
    getNewestDB("https://flysafe-api.dji.com/api/v3/geofence/onboard_static_data", paramString, paramAjaxCallBack);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sdk\DataUpgradeServerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */