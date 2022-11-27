package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.transport.DatagramTransport;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class c<R extends Result, T extends IMessageEntity>
  extends InnerPendingResult<R>
{
  private CountDownLatch a;
  private R b = null;
  private WeakReference<ApiClient> c;
  private String d = null;
  private long e = 0L;
  protected DatagramTransport transport = null;
  
  public c(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    this.d = paramString;
    a(paramApiClient, paramString, paramIMessageEntity, getResponseType());
  }
  
  public c(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass)
  {
    a(paramApiClient, paramString, paramIMessageEntity, paramClass);
  }
  
  /* Error */
  private void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(int arg1, IMessageEntity arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(ApiClient arg1, String arg2, IMessageEntity arg3, Class<T> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public final R await()
  {
    return null;
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public final R awaitOnAnyThread()
  {
    return null;
  }
  
  public final R awaitOnAnyThread(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  protected boolean checkApiClient(ApiClient paramApiClient)
  {
    return (paramApiClient != null) && (((InnerApiClient)paramApiClient).innerIsConnected());
  }
  
  protected Class<T> getResponseType()
  {
    return null;
  }
  
  public abstract R onComplete(T paramT);
  
  protected R onError(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public final void setResultCallback(Looper arg1, ResultCallback<R> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void setResultCallback(ResultCallback<R> paramResultCallback)
  {
    setResultCallback(Looper.getMainLooper(), paramResultCallback);
  }
  
  protected static class a<R extends Result>
    extends Handler
  {
    public a()
    {
      this(Looper.getMainLooper());
    }
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void a(ResultCallback<? super R> arg1, R arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected void b(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      paramResultCallback.onResult(paramR);
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */