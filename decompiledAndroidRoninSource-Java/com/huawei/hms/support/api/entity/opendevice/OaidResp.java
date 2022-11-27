package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class OaidResp
  extends AbstractMessageEntity
{
  @a
  private String id;
  @a
  private boolean isTrackLimited;
  @a
  private PendingIntent settingIntent;
  
  public String getId()
  {
    return this.id;
  }
  
  public PendingIntent getSettingIntent()
  {
    return this.settingIntent;
  }
  
  public boolean isTrackLimited()
  {
    return this.isTrackLimited;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setSettingIntent(PendingIntent paramPendingIntent)
  {
    this.settingIntent = paramPendingIntent;
  }
  
  public void setTrackLimited(boolean paramBoolean)
  {
    this.isTrackLimited = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\opendevice\OaidResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */