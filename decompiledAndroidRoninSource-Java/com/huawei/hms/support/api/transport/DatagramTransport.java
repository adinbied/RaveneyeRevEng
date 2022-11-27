package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

public abstract interface DatagramTransport
{
  public abstract void post(ApiClient paramApiClient, a parama);
  
  public abstract void send(ApiClient paramApiClient, a parama);
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, IMessageEntity paramIMessageEntity);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\transport\DatagramTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */