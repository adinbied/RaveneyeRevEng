package com.huawei.hms.support.api.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.support.api.client.Result;

public class OaidResult
  extends Result
{
  private String a;
  private boolean b;
  private PendingIntent c;
  
  public String getId()
  {
    return this.a;
  }
  
  public PendingIntent getSettingIntent()
  {
    return this.c;
  }
  
  public boolean isTrackLimited()
  {
    return this.b;
  }
  
  public void setId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setSettingIntent(PendingIntent paramPendingIntent)
  {
    this.c = paramPendingIntent;
  }
  
  public void setTrackLimited(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\opendevice\OaidResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */