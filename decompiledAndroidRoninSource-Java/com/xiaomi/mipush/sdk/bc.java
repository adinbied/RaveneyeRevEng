package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.push.ad;
import com.xiaomi.push.ai;
import com.xiaomi.push.bf;
import com.xiaomi.push.ht;
import com.xiaomi.push.in;
import com.xiaomi.push.service.ah;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class bc
{
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("mipush_extra", 0);
    long l1 = localSharedPreferences.getLong("last_sync_info", -1L);
    long l2 = System.currentTimeMillis() / 1000L;
    long l3 = ah.a(paramContext).a(ht.B.a(), 1209600);
    if (l1 == -1L) {}
    for (;;)
    {
      localSharedPreferences.edit().putLong("last_sync_info", l2).commit();
      return;
      if (Math.abs(l2 - l1) <= l3) {
        break;
      }
      a(paramContext, true);
    }
  }
  
  public static void a(Context paramContext, in paramin)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("need to update local info with: ");
    ((StringBuilder)localObject).append(paramin.a());
    com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)localObject).toString());
    localObject = (String)paramin.a().get("accept_time");
    int j = 0;
    if (localObject != null)
    {
      MiPushClient.removeAcceptTime(paramContext);
      localObject = ((String)localObject).split("-");
      if (localObject.length == 2)
      {
        MiPushClient.addAcceptTime(paramContext, localObject[0], localObject[1]);
        if (("00:00".equals(localObject[0])) && ("00:00".equals(localObject[1]))) {
          b.a(paramContext).a(true);
        } else {
          b.a(paramContext).a(false);
        }
      }
    }
    localObject = (String)paramin.a().get("aliases");
    int k;
    int i;
    if (localObject != null)
    {
      MiPushClient.removeAllAliases(paramContext);
      if (!"".equals(localObject))
      {
        localObject = ((String)localObject).split(",");
        k = localObject.length;
        i = 0;
        while (i < k)
        {
          MiPushClient.addAlias(paramContext, localObject[i]);
          i += 1;
        }
      }
    }
    localObject = (String)paramin.a().get("topics");
    if (localObject != null)
    {
      MiPushClient.removeAllTopics(paramContext);
      if (!"".equals(localObject))
      {
        localObject = ((String)localObject).split(",");
        k = localObject.length;
        i = 0;
        while (i < k)
        {
          MiPushClient.addTopic(paramContext, localObject[i]);
          i += 1;
        }
      }
    }
    paramin = (String)paramin.a().get("user_accounts");
    if (paramin != null)
    {
      MiPushClient.removeAllAccounts(paramContext);
      if (!"".equals(paramin))
      {
        paramin = paramin.split(",");
        k = paramin.length;
        i = j;
        while (i < k)
        {
          MiPushClient.addAccount(paramContext, paramin[i]);
          i += 1;
        }
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    ai.a(paramContext).a(new bd(paramContext, paramBoolean));
  }
  
  private static String c(List<String> paramList)
  {
    paramList = bf.a(d(paramList));
    if ((!TextUtils.isEmpty(paramList)) && (paramList.length() > 4)) {
      return paramList.substring(0, 4).toLowerCase();
    }
    return "";
  }
  
  private static String d(List<String> paramList)
  {
    boolean bool = ad.a(paramList);
    Object localObject = "";
    if (bool) {
      return "";
    }
    paramList = new ArrayList(paramList);
    Collections.sort(paramList, Collator.getInstance(Locale.CHINA));
    Iterator localIterator = paramList.iterator();
    for (paramList = (List<String>)localObject; localIterator.hasNext(); paramList = paramList.toString())
    {
      String str = (String)localIterator.next();
      localObject = paramList;
      if (!TextUtils.isEmpty(paramList))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append(",");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramList = new StringBuilder();
      paramList.append((String)localObject);
      paramList.append(str);
    }
    return paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */