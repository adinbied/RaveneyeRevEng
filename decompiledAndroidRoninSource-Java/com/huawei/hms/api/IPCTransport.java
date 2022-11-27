package com.huawei.hms.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.api.transport.DatagramTransport.a;

public class IPCTransport
  implements DatagramTransport
{
  private final String a;
  private final IMessageEntity b;
  private final Class<? extends IMessageEntity> c;
  
  public IPCTransport(String paramString, IMessageEntity paramIMessageEntity, Class<? extends IMessageEntity> paramClass)
  {
    this.a = paramString;
    this.b = paramIMessageEntity;
    this.c = paramClass;
  }
  
  private int a(ApiClient paramApiClient, d paramd)
  {
    return 0;
  }
  
  public final void post(ApiClient paramApiClient, DatagramTransport.a parama)
  {
    send(paramApiClient, parama);
  }
  
  /* Error */
  public final void send(ApiClient arg1, DatagramTransport.a arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\IPCTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */