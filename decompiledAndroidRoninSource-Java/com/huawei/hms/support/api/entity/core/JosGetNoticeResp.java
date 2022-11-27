package com.huawei.hms.support.api.entity.core;

import android.content.Intent;
import com.huawei.hms.core.aidl.a.a;

public class JosGetNoticeResp
  extends JosBaseResp
{
  @a
  private Intent noticeIntent;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public Intent getNoticeIntent()
  {
    return null;
  }
  
  public void setNoticeIntent(Intent paramIntent)
  {
    this.noticeIntent = paramIntent;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\core\JosGetNoticeResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */