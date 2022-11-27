package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.Config.Builder;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.bf;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class fc
{
  private static a jdField_a_of_type_ComXiaomiPushFc$a;
  private static Map<String, hy> jdField_a_of_type_JavaUtilMap;
  
  public static int a(int paramInt)
  {
    if (paramInt > 0) {
      return paramInt + 1000;
    }
    return -1;
  }
  
  public static int a(Enum paramEnum)
  {
    if (paramEnum != null)
    {
      if ((paramEnum instanceof ho)) {
        return paramEnum.ordinal() + 1001;
      }
      if ((paramEnum instanceof hy)) {
        return paramEnum.ordinal() + 2001;
      }
      if ((paramEnum instanceof fi)) {
        return paramEnum.ordinal() + 3001;
      }
    }
    return -1;
  }
  
  public static Config a(Context paramContext)
  {
    boolean bool1 = ah.a(paramContext).a(ht.aA.a(), false);
    boolean bool2 = ah.a(paramContext).a(ht.az.a(), false);
    int i = ah.a(paramContext).a(ht.aC.a(), 86400);
    int j = ah.a(paramContext).a(ht.aB.a(), 86400);
    return Config.getBuilder().setEventUploadSwitchOpen(bool2).setEventUploadFrequency(j).setPerfUploadSwitchOpen(bool1).setPerfUploadFrequency(i).build(paramContext);
  }
  
  public static EventClientReport a(Context paramContext, String paramString1, String paramString2, int paramInt, long paramLong, String paramString3)
  {
    paramContext = a(paramString1);
    paramContext.eventId = paramString2;
    paramContext.eventType = paramInt;
    paramContext.eventTime = paramLong;
    paramContext.eventContent = paramString3;
    return paramContext;
  }
  
  public static EventClientReport a(String paramString)
  {
    EventClientReport localEventClientReport = new EventClientReport();
    localEventClientReport.production = 1000;
    localEventClientReport.reportType = 1001;
    localEventClientReport.clientInterfaceId = paramString;
    return localEventClientReport;
  }
  
  public static PerfClientReport a()
  {
    PerfClientReport localPerfClientReport = new PerfClientReport();
    localPerfClientReport.production = 1000;
    localPerfClientReport.reportType = 1000;
    localPerfClientReport.clientInterfaceId = "P100000";
    return localPerfClientReport;
  }
  
  public static PerfClientReport a(Context paramContext, int paramInt, long paramLong1, long paramLong2)
  {
    paramContext = a();
    paramContext.code = paramInt;
    paramContext.perfCounts = paramLong1;
    paramContext.perfLatencies = paramLong2;
    return paramContext;
  }
  
  public static hs a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    hs localhs = new hs();
    localhs.d("category_client_report_data");
    localhs.a("push_sdk_channel");
    localhs.a(1L);
    localhs.b(paramString);
    localhs.a(true);
    localhs.b(System.currentTimeMillis());
    localhs.g(paramContext.getPackageName());
    localhs.e("com.xiaomi.xmsf");
    localhs.f(bf.a());
    localhs.c("quality_support");
    return localhs;
  }
  
  public static hy a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap == null) {
      try
      {
        if (jdField_a_of_type_JavaUtilMap == null)
        {
          jdField_a_of_type_JavaUtilMap = new HashMap();
          hy[] arrayOfhy = hy.values();
          int j = arrayOfhy.length;
          int i = 0;
          while (i < j)
          {
            hy localhy = arrayOfhy[i];
            jdField_a_of_type_JavaUtilMap.put(localhy.jdField_a_of_type_JavaLangString.toLowerCase(), localhy);
            i += 1;
          }
        }
      }
      finally {}
    }
    paramString = (hy)jdField_a_of_type_JavaUtilMap.get(paramString.toLowerCase());
    if (paramString != null) {
      return paramString;
    }
    return hy.jdField_a_of_type_ComXiaomiPushHy;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1000) {
      return "E100000";
    }
    if (paramInt == 3000) {
      return "E100002";
    }
    if (paramInt == 2000) {
      return "E100001";
    }
    if (paramInt == 6000) {
      return "E100003";
    }
    return "";
  }
  
  public static void a(Context paramContext)
  {
    ClientReportClient.updateConfig(paramContext, a(paramContext));
  }
  
  public static void a(Context paramContext, Config paramConfig)
  {
    ClientReportClient.init(paramContext, paramConfig, new fa(paramContext), new fb(paramContext));
  }
  
  private static void a(Context paramContext, hs paramhs)
  {
    if (a(paramContext.getApplicationContext()))
    {
      bg.a(paramContext.getApplicationContext(), paramhs);
      return;
    }
    a locala = jdField_a_of_type_ComXiaomiPushFc$a;
    if (locala != null) {
      locala.a(paramContext, paramhs);
    }
  }
  
  public static void a(Context paramContext, List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        hs localhs = a(paramContext, (String)paramList.next());
        StringBuilder localStringBuilder;
        if (bf.a(localhs, false))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localhs.d());
          localStringBuilder.append("is not valid...");
          b.c(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("send event/perf data item id:");
          localStringBuilder.append(localhs.d());
          b.c(localStringBuilder.toString());
          a(paramContext, localhs);
        }
      }
      return;
    }
    finally
    {
      b.d(paramContext.getMessage());
    }
  }
  
  public static void a(a parama)
  {
    jdField_a_of_type_ComXiaomiPushFc$a = parama;
  }
  
  public static boolean a(Context paramContext)
  {
    return (paramContext != null) && (!TextUtils.isEmpty(paramContext.getPackageName())) && ("com.xiaomi.xmsf".equals(paramContext.getPackageName()));
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, hs paramhs);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */