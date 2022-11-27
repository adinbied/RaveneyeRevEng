package com.huawei.hms.support.api.entity.game;

import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GameIsShowBuoyResp
  implements IMessageEntity
{
  private static final int SHOW_BUOY = 1;
  @a
  private int clientVersionCode;
  @a
  private Intent intent;
  @a
  private int isShowBuoy;
  @a
  private int statusCode;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public int getClientVersionCode()
  {
    return 0;
  }
  
  public Intent getIntent()
  {
    return null;
  }
  
  public int getIsShowBuoy()
  {
    return 0;
  }
  
  public int getStatusCode()
  {
    return 0;
  }
  
  public boolean isShow()
  {
    return this.isShowBuoy == 1;
  }
  
  public void setClientVersionCode(int paramInt)
  {
    this.clientVersionCode = paramInt;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.intent = paramIntent;
  }
  
  public void setIsShowBuoy(int paramInt)
  {
    this.isShowBuoy = paramInt;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GameIsShowBuoyResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */