package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.g;

public class ClientReportClient
{
  public static void init(Context paramContext)
  {
    init(paramContext, Config.defaultConfig(paramContext), new com.xiaomi.clientreport.processor.a(paramContext), new com.xiaomi.clientreport.processor.b(paramContext));
  }
  
  public static void init(Context paramContext, Config paramConfig)
  {
    init(paramContext, paramConfig, new com.xiaomi.clientreport.processor.a(paramContext), new com.xiaomi.clientreport.processor.b(paramContext));
  }
  
  public static void init(Context paramContext, Config paramConfig, IEventProcessor paramIEventProcessor, IPerfProcessor paramIPerfProcessor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init in process ");
    localStringBuilder.append(g.a(paramContext));
    localStringBuilder.append(" pid :");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(" threadId: ");
    localStringBuilder.append(Thread.currentThread().getId());
    com.xiaomi.channel.commonutils.logger.b.c(localStringBuilder.toString());
    a.a(paramContext).a(paramConfig, paramIEventProcessor, paramIPerfProcessor);
    if (g.a(paramContext))
    {
      com.xiaomi.channel.commonutils.logger.b.c("init in process　start scheduleJob");
      a.a(paramContext).a();
    }
  }
  
  public static void reportEvent(Context paramContext, EventClientReport paramEventClientReport)
  {
    if (paramEventClientReport != null) {
      a.a(paramContext).a(paramEventClientReport);
    }
  }
  
  public static void reportPerf(Context paramContext, PerfClientReport paramPerfClientReport)
  {
    if (paramPerfClientReport != null) {
      a.a(paramContext).a(paramPerfClientReport);
    }
  }
  
  public static void updateConfig(Context paramContext, Config paramConfig)
  {
    if (paramConfig == null) {
      return;
    }
    a.a(paramContext).a(paramConfig.isEventUploadSwitchOpen(), paramConfig.isPerfUploadSwitchOpen(), paramConfig.getEventUploadFrequency(), paramConfig.getPerfUploadFrequency());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\manager\ClientReportClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */