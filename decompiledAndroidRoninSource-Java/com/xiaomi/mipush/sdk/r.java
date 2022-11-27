package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.iz;

public class r
{
  public static <T extends iz<T, ?>> void a(Context paramContext, Config paramConfig)
  {
    if (paramConfig == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("action_cr_config");
    localIntent.putExtra("action_cr_event_switch", paramConfig.isEventUploadSwitchOpen());
    localIntent.putExtra("action_cr_event_frequency", paramConfig.getEventUploadFrequency());
    localIntent.putExtra("action_cr_perf_switch", paramConfig.isPerfUploadSwitchOpen());
    localIntent.putExtra("action_cr_perf_frequency", paramConfig.getPerfUploadFrequency());
    localIntent.putExtra("action_cr_event_en", paramConfig.isEventEncrypted());
    localIntent.putExtra("action_cr_max_file_size", paramConfig.getMaxFileLength());
    aw.a(paramContext).a(localIntent);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */