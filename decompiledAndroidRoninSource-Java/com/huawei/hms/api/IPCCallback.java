package com.huawei.hms.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.d.a;
import com.huawei.hms.support.api.transport.DatagramTransport.a;

public class IPCCallback
  extends d.a
{
  private final Class<? extends IMessageEntity> a;
  private final DatagramTransport.a b;
  
  public IPCCallback(Class<? extends IMessageEntity> paramClass, DatagramTransport.a parama)
  {
    this.a = paramClass;
    this.b = parama;
  }
  
  /* Error */
  public void call(com.huawei.hms.core.aidl.b arg1)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected IMessageEntity newResponseInstance()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\IPCCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */