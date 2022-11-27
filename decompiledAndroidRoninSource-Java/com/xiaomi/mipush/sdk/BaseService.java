package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import java.lang.ref.WeakReference;

public abstract class BaseService
  extends Service
{
  private a a;
  
  protected abstract boolean a();
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (this.a == null) {
      this.a = new a(new WeakReference(this));
    }
    this.a.a();
  }
  
  public static class a
    extends Handler
  {
    private WeakReference<BaseService> a;
    
    public a(WeakReference<BaseService> paramWeakReference)
    {
      this.a = paramWeakReference;
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\BaseService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */