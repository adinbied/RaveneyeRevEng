package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.a.a;

public class ResponseHeader
  implements IMessageEntity
{
  @a
  protected int statusCode;
  
  public ResponseHeader() {}
  
  public ResponseHeader(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\core\aidl\ResponseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */