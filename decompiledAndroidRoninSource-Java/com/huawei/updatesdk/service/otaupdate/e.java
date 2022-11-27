package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.updatesdk.service.a.b;
import com.huawei.updatesdk.support.c.a;

public class e
{
  private boolean a = false;
  private a b;
  private b c;
  
  public e(Context paramContext, b paramb)
  {
    if (!a.a(paramContext))
    {
      if (!TextUtils.isEmpty(b.a().e()))
      {
        b.a().c("");
        b.a().a("");
      }
      new Handler(Looper.getMainLooper()).post(new d(paramb, false));
      return;
    }
    this.c = paramb;
    new Handler(Looper.getMainLooper()).post(new d(paramb, true));
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(android.database.Cursor arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private class a
    extends Handler
  {
    private a() {}
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  private class c
    extends AsyncTask<Void, Void, Void>
  {
    private e.b b;
    
    public c(e.b paramb)
    {
      this.b = paramb;
    }
    
    protected Void a(Void... paramVarArgs)
    {
      return null;
    }
    
    /* Error */
    protected void a(Void arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private class d
    implements Runnable
  {
    private e.b b;
    private boolean c;
    
    public d(e.b paramb, boolean paramBoolean)
    {
      this.b = paramb;
      this.c = paramBoolean;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */