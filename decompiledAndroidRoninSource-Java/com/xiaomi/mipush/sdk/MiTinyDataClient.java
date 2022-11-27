package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hs;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MiTinyDataClient
{
  public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
  public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
  public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";
  
  public static void init(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      com.xiaomi.channel.commonutils.logger.b.a("context is null, MiTinyDataClient.init(Context, String) failed.");
      return;
    }
    a.a().a(paramContext);
    if (TextUtils.isEmpty(paramString))
    {
      com.xiaomi.channel.commonutils.logger.b.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
      return;
    }
    a.a().a(paramString);
  }
  
  public static boolean upload(Context paramContext, hs paramhs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiTinyDataClient.upload ");
    localStringBuilder.append(paramhs.d());
    com.xiaomi.channel.commonutils.logger.b.c(localStringBuilder.toString());
    if (!a.a().a()) {
      a.a().a(paramContext);
    }
    return a.a().a(paramhs);
  }
  
  public static boolean upload(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    hs localhs = new hs();
    localhs.d(paramString1);
    localhs.c(paramString2);
    localhs.a(paramLong);
    localhs.b(paramString3);
    localhs.a(true);
    localhs.a("push_sdk_channel");
    return upload(paramContext, localhs);
  }
  
  public static boolean upload(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    hs localhs = new hs();
    localhs.d(paramString1);
    localhs.c(paramString2);
    localhs.a(paramLong);
    localhs.b(paramString3);
    return a.a().a(localhs);
  }
  
  public static class a
  {
    private static a jdField_a_of_type_ComXiaomiMipushSdkMiTinyDataClient$a;
    private Context jdField_a_of_type_AndroidContentContext;
    private a jdField_a_of_type_ComXiaomiMipushSdkMiTinyDataClient$a$a = new a();
    private Boolean jdField_a_of_type_JavaLangBoolean;
    private String jdField_a_of_type_JavaLangString;
    private final ArrayList<hs> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    
    public static a a()
    {
      if (jdField_a_of_type_ComXiaomiMipushSdkMiTinyDataClient$a == null) {
        try
        {
          if (jdField_a_of_type_ComXiaomiMipushSdkMiTinyDataClient$a == null) {
            jdField_a_of_type_ComXiaomiMipushSdkMiTinyDataClient$a = new a();
          }
        }
        finally {}
      }
      return jdField_a_of_type_ComXiaomiMipushSdkMiTinyDataClient$a;
    }
    
    /* Error */
    private void a(hs arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    private boolean a(Context paramContext)
    {
      return false;
    }
    
    private boolean b(Context paramContext)
    {
      return (b.a(paramContext).a() == null) && (!a(this.jdField_a_of_type_AndroidContentContext));
    }
    
    private boolean b(hs paramhs)
    {
      return false;
    }
    
    public void a(Context paramContext)
    {
      if (paramContext == null)
      {
        com.xiaomi.channel.commonutils.logger.b.a("context is null, MiTinyDataClientImp.init() failed.");
        return;
      }
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(a(paramContext));
      b("com.xiaomi.xmpushsdk.tinydataPending.init");
    }
    
    /* Error */
    public void a(String arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean a()
    {
      return this.jdField_a_of_type_AndroidContentContext != null;
    }
    
    public boolean a(hs paramhs)
    {
      return false;
    }
    
    /* Error */
    public void b(String arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public class a
    {
      private final Runnable jdField_a_of_type_JavaLangRunnable = new ak(this);
      public final ArrayList<hs> a;
      private ScheduledFuture<?> jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
      private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
      
      public a()
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
      private void b()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void a(hs arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\MiTinyDataClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */