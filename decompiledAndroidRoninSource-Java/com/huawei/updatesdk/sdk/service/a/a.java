package com.huawei.updatesdk.sdk.service.a;

import android.content.Context;
import android.net.ConnectivityManager;

public class a
{
  private static a b;
  private static final Object d = new Object();
  private Context a;
  private ConnectivityManager c = null;
  
  public a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public static a a()
  {
    synchronized (d)
    {
      a locala = b;
      return locala;
    }
  }
  
  public static void a(Context paramContext)
  {
    synchronized (d)
    {
      if (b == null) {
        b = new a(paramContext);
      }
      return;
    }
  }
  
  public Context b()
  {
    return this.a;
  }
  
  public ConnectivityManager c()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */