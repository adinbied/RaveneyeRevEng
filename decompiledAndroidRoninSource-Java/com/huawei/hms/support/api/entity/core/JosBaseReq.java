package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class JosBaseReq
  implements IMessageEntity
{
  @a
  private String channelId;
  @a
  private String cpId;
  @a
  private String hmsSdkVersionName;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public String getChannelId()
  {
    return null;
  }
  
  public String getCpID()
  {
    return null;
  }
  
  public String getHmsSdkVersionName()
  {
    return null;
  }
  
  public void setChannelId(String paramString)
  {
    this.channelId = paramString;
  }
  
  public void setCpID(String paramString)
  {
    this.cpId = paramString;
  }
  
  public void setHmsSdkVersionName(String paramString)
  {
    this.hmsSdkVersionName = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\core\JosBaseReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */