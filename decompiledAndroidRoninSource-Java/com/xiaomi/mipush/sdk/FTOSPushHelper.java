package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

public class FTOSPushHelper
{
  private static long jdField_a_of_type_Long;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  private static void a(Context paramContext)
  {
    paramContext = e.a(paramContext).a(d.d);
    if (paramContext != null)
    {
      b.a("ASSEMBLE_PUSH :  register fun touch os when network change!");
      paramContext.register();
    }
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
        a(paramContext);
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
  
  public static void notifyFTOSNotificationClicked(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (!paramMap.containsKey("pushMsg")) {
        return;
      }
      Object localObject = (String)paramMap.get("pushMsg");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramMap = h.a(paramContext);
        if (paramMap != null)
        {
          localObject = h.a((String)localObject);
          if (((MiPushMessage)localObject).getExtra().containsKey("notify_effect")) {
            return;
          }
          paramMap.onNotificationMessageClicked(paramContext, (MiPushMessage)localObject);
        }
      }
    }
  }
  
  public static void setNeedRegister(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void uploadToken(Context paramContext, String paramString)
  {
    h.a(paramContext, d.d, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\FTOSPushHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */