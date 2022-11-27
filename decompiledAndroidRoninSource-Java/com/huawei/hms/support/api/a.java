package com.huawei.hms.support.api;

import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

public abstract class a<R extends Result>
  extends PendingResult<R>
{
  private R a = null;
  private int b;
  
  public a(int paramInt)
  {
    this.b = paramInt;
  }
  
  private R a(int paramInt)
  {
    return null;
  }
  
  public final R await()
  {
    return await(0L, null);
  }
  
  public R await(long paramLong, TimeUnit paramTimeUnit)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return a(this.b);
    }
    throw new IllegalStateException("await must not be called on the UI thread");
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */