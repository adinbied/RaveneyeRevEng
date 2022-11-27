package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext.Builder;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerSchedulerBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getData().getQueryParameter("backendName");
    String str1 = paramIntent.getData().getQueryParameter("extras");
    int i = Integer.valueOf(paramIntent.getData().getQueryParameter("priority")).intValue();
    int j = paramIntent.getExtras().getInt("attemptNumber");
    TransportRuntime.initialize(paramContext);
    paramContext = TransportContext.builder().setBackendName(str2).setPriority(PriorityMapping.valueOf(i));
    if (str1 != null) {
      paramContext.setExtras(Base64.decode(str1, 0));
    }
    TransportRuntime.getInstance().getUploader().upload(paramContext.build(), j, AlarmManagerSchedulerBroadcastReceiver..Lambda.1.lambdaFactory$());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\AlarmManagerSchedulerBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */