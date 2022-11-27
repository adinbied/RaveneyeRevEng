package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;

public class COSPushHelper
{
  private static long jdField_a_of_type_Long;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static void convertMessage(Intent paramIntent)
  {
    h.a(paramIntent);
  }
  
  public static void doInNetworkChange(Context paramContext)
  {
    long l1 = SystemClock.elapsedRealtime();
    if (getNeedRegister())
    {
      long l2 = jdField_a_of_type_Long;
      if ((l2 <= 0L) || (l2 + 300000L <= l1))
      {
        jdField_a_of_type_Long = l1;
        registerCOSAssemblePush(paramContext);
      }
    }
  }
  
  public static boolean getNeedRegister()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean hasNetwork(Context paramContext)
  {
    return h.a(paramContext);
  }
  
  public static void onNotificationMessageCome(Context paramContext, String paramString) {}
  
  public static void onPassThoughMessageCome(Context paramContext, String paramString) {}
  
  public static void registerCOSAssemblePush(Context paramContext)
  {
    paramContext = e.a(paramContext).a(d.c);
    if (paramContext != null)
    {
      b.a("ASSEMBLE_PUSH :  register cos when network change!");
      paramContext.register();
    }
  }
  
  public static void setNeedRegister(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void uploadToken(Context paramContext, String paramString)
  {
    h.a(paramContext, d.c, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\COSPushHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */