package com.huawei.updatesdk.support.pm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.updatesdk.support.d.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class g
{
  protected static final d a = new d();
  private static final ExecutorService b = Executors.newFixedThreadPool(1);
  
  private static b a(String paramString, d.a parama)
  {
    paramString = a.a(paramString, parama);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  protected static void a(int paramInt1, int paramInt2)
  {
    Object localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("INSTALL_STATE", paramInt1);
    localBundle.putInt("INSTALL_TYPE", paramInt2);
    ((Intent)localObject).putExtras(localBundle);
    localObject = com.huawei.updatesdk.sdk.service.secure.a.a((Intent)localObject);
    c.a().c((com.huawei.updatesdk.sdk.service.secure.a)localObject);
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    b(paramString1, paramString2, paramObject);
  }
  
  private static b b(String paramString)
  {
    return a(paramString, d.a.a);
  }
  
  private static void b(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("process:processType=install,path=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",packageName:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",isNow=");
      localStringBuilder.append(false);
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("PackageService", localStringBuilder.toString());
      if (TextUtils.isEmpty(paramString1))
      {
        com.huawei.updatesdk.sdk.a.c.a.a.a.d("PackageService", "install failed!!!path is empty!!!!");
        return;
      }
      paramString1 = new b(paramString2, paramString1, paramObject);
      paramString1.a(c.a.b);
      paramString1.a(false);
      if (paramString1.d() == null) {
        com.huawei.updatesdk.sdk.a.c.a.a.a.a("PackageService", "task.param is null!!");
      }
      a.a(paramString2, paramString1);
      paramString1.a(c.b.a);
      paramString2 = new StringBuilder();
      paramString2.append("install|pkg:");
      paramString2.append(paramString1.e());
      paramString2.append("|path:");
      paramString2.append(paramString1.f());
      paramString2 = paramString2.toString();
      paramString1 = new Thread(new e(com.huawei.updatesdk.sdk.service.a.a.a().b(), paramString1));
      paramString1.setName(paramString2);
      paramString1.start();
      return;
    }
    finally {}
  }
  
  public static final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final String a;
    private final int b;
    private boolean c = false;
    private b d;
    
    private a(String paramString, int paramInt, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramInt;
      this.c = paramBoolean;
    }
    
    /* Error */
    private void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public static void a(String paramString, int paramInt)
    {
      new a(paramString, paramInt, false).execute(new Void[0]);
    }
    
    public static void a(String paramString, int paramInt, boolean paramBoolean)
    {
      new a(paramString, paramInt, paramBoolean).execute(new Void[0]);
    }
    
    /* Error */
    private void a(String arg1, java.io.File arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private boolean a(String paramString)
    {
      return false;
    }
    
    private boolean b()
    {
      return false;
    }
    
    protected Boolean a(Void... paramVarArgs)
    {
      return null;
    }
    
    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\support\pm\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */