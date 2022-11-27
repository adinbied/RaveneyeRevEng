package com.huawei.hianalytics.log.g;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hianalytics.log.e.e;
import java.io.File;

public final class a
{
  private static Context a;
  private static int b;
  private static volatile a c;
  private static String d;
  private static a e;
  
  public static a a()
  {
    try
    {
      if (e == null) {
        e = new a();
      }
      a locala = e;
      return locala;
    }
    finally {}
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (a == null) {}
    for (paramString1 = "No init of logServer";; paramString1 = "tag or msg Parameter error!")
    {
      com.huawei.hianalytics.g.b.d("AppLogApiImpl", paramString1);
      return;
      if (!b(paramString2, paramString3)) {
        break;
      }
    }
    if (a(paramInt))
    {
      com.huawei.hianalytics.i.b.c().a(new f(new com.huawei.hianalytics.log.c.a(paramString1, paramString2, paramString3), null, d));
      return;
    }
    com.huawei.hianalytics.g.b.c("AppLogApiImpl", "levelInt < Specified level for write log");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    String str = com.huawei.hianalytics.util.f.a("logClintID", paramString1, "[a-zA-Z0-9_]{1,4096}", "");
    paramString1 = paramString2;
    if (!com.huawei.hianalytics.util.f.a("logClintKey", paramString2, 4096)) {
      paramString1 = "";
    }
    com.huawei.hianalytics.a.d.a(str);
    com.huawei.hianalytics.a.d.b(paramString1);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (a == null)
    {
      com.huawei.hianalytics.g.b.c("AppLogApiImpl", "No init of SDK logServer");
      return;
    }
    if (!com.huawei.hianalytics.util.f.a("errorCode", paramString3, 256))
    {
      com.huawei.hianalytics.g.b.c("AppLogApiImpl", "This method is stopped from execution due to a parameter error");
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null)
    {
      com.huawei.hianalytics.g.b.c("AppLogApiImpl", "bundle is null");
      localBundle = new Bundle();
    }
    if (b(paramString1, paramString2))
    {
      com.huawei.hianalytics.g.b.c("AppLogApiImpl", "This method is stopped from execution due to a parameter error");
      return;
    }
    if (com.huawei.hianalytics.util.f.a("metaData", localBundle.getString("MetaData"), 20480)) {
      paramBundle = localBundle.getString("MetaData");
    } else {
      paramBundle = "";
    }
    localBundle.putString("MetaData", paramBundle);
    a(6, "E", paramString1, paramString2);
    localBundle.putString("Eventid", paramString3);
    paramString2 = new StringBuilder();
    paramString2.append(d);
    paramString2.append(com.huawei.hianalytics.log.b.a.a.b);
    paramString3 = new d(localBundle, "eventinfo.log", paramString2.toString());
    paramString2 = com.huawei.hianalytics.i.b.c();
    paramString2.a(paramString3);
    paramString1 = e.a(a, false, paramString1.equals("CrashHandler"));
    if (c != null) {
      paramString2.a(new b(paramString1, c, d));
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= b;
  }
  
  private static boolean a(File[] paramArrayOfFile)
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfFile[i].getName().equals("eventinfo.log")) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void b()
  {
    a = null;
  }
  
  private static void b(Context paramContext)
  {
    d = paramContext.getFilesDir().getPath();
    a = paramContext.getApplicationContext();
    if (TextUtils.isEmpty(com.huawei.hianalytics.a.b.d())) {
      com.huawei.hianalytics.a.b.d(paramContext.getPackageName());
    }
    if (c == null)
    {
      paramContext = new HandlerThread(a.class.getCanonicalName(), 10);
      paramContext.start();
      Looper localLooper = paramContext.getLooper();
      if (localLooper == null)
      {
        com.huawei.hianalytics.g.b.d("AppLogApiImpl", "handler thread looper is null,send data over!");
        paramContext.quitSafely();
        return;
      }
      c = new a(localLooper);
    }
    b = com.huawei.hianalytics.a.d.e();
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int j = 0;
    int i = j;
    if (!bool) {
      if (TextUtils.isEmpty(paramString2))
      {
        i = j;
      }
      else
      {
        i = j;
        if (paramString1.length() <= 256) {
          if (paramString2.length() > 20480) {
            i = j;
          } else {
            i = 1;
          }
        }
      }
    }
    return i ^ 0x1;
  }
  
  public static void c()
  {
    if ((com.huawei.hianalytics.log.e.f.b(a)) && (com.huawei.hianalytics.log.e.f.a(a)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(d);
      ((StringBuilder)localObject1).append(com.huawei.hianalytics.log.b.a.a.c);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(d);
      ((StringBuilder)localObject2).append(com.huawei.hianalytics.log.b.a.a.b);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (!((File)localObject2).exists())
      {
        com.huawei.hianalytics.g.b.c("AppLogApiImpl", "checkUploadLog() No logs file");
        return;
      }
      File[] arrayOfFile = ((File)localObject2).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0) && (arrayOfFile.length <= 5))
      {
        if (a(arrayOfFile))
        {
          localObject2 = new b(e.a(a, false, false), c, d);
          localObject1 = com.huawei.hianalytics.i.b.c();
        }
        else
        {
          com.huawei.hianalytics.g.b.b("HiAnalytics/logServer", "No error log.");
        }
      }
      else
      {
        com.huawei.hianalytics.log.e.a.a((File)localObject2);
        localObject1 = new File((String)localObject1).listFiles();
        if ((localObject1 == null) || (localObject1.length == 0)) {
          break label264;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(d);
        ((StringBuilder)localObject1).append(com.huawei.hianalytics.log.b.a.a.d);
        com.huawei.hianalytics.log.e.a.a(new File(((StringBuilder)localObject1).toString()));
        localObject1 = e.a(a, true, false);
        localObject2 = new g(a, (String)localObject1, d);
        localObject1 = com.huawei.hianalytics.i.b.d();
      }
      ((com.huawei.hianalytics.i.b)localObject1).a((com.huawei.hianalytics.i.a)localObject2);
      return;
      label264:
      com.huawei.hianalytics.g.b.b("HiAnalytics/logServer", "No error log.");
    }
  }
  
  public void a(Context paramContext)
  {
    try
    {
      b(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
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
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */