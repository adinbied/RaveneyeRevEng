package com.huawei.hms.support.api.entity.hwid;

import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public abstract class IHwIDRespEntity
  implements IMessageEntity
{
  @a
  private Intent data;
  @a
  private int retCode;
  
  public Intent getData()
  {
    return this.data;
  }
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public void setData(Intent paramIntent)
  {
    this.data = paramIntent;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\hwid\IHwIDRespEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */