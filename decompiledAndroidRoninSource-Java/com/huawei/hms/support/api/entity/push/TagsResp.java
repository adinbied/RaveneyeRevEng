package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class TagsResp
  implements IMessageEntity
{
  @a
  private String content = "";
  @a
  private int retCode = 0;
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getRetCode()
  {
    return this.retCode;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setRetCode(int paramInt)
  {
    this.retCode = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\TagsResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */