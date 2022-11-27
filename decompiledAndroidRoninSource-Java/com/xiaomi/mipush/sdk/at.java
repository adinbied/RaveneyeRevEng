package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.push.bf;
import com.xiaomi.push.ik;
import com.xiaomi.push.r;
import com.xiaomi.push.service.aq;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class at
{
  private static at jdField_a_of_type_ComXiaomiMipushSdkAt;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Queue<String> jdField_a_of_type_JavaUtilQueue;
  private Context jdField_a_of_type_AndroidContentContext;
  
  private at(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentContext = localContext;
    if (localContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
  }
  
  public static Intent a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (!paramMap.containsKey("notify_effect")) {
        return null;
      }
      String str1 = (String)paramMap.get("notify_effect");
      int j = -1;
      String str4 = (String)paramMap.get("intent_flag");
      int i = j;
      try
      {
        if (!TextUtils.isEmpty(str4)) {
          i = Integer.parseInt(str4);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cause by intent_flag: ");
        localStringBuilder.append(localNumberFormatException.getMessage());
        com.xiaomi.channel.commonutils.logger.b.d(localStringBuilder.toString());
        i = j;
      }
      if (aq.a.equals(str1))
      {
        try
        {
          paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
        }
        catch (Exception paramString)
        {
          paramMap = new StringBuilder();
          paramMap.append("Cause: ");
          paramMap.append(paramString.getMessage());
          com.xiaomi.channel.commonutils.logger.b.d(paramMap.toString());
          break label492;
        }
      }
      else
      {
        String str2;
        String str3;
        if (aq.b.equals(str1))
        {
          if (paramMap.containsKey("intent_uri"))
          {
            paramMap = (String)paramMap.get("intent_uri");
            if (paramMap == null) {
              break label492;
            }
            try
            {
              paramMap = Intent.parseUri(paramMap, 1);
              try
              {
                paramMap.setPackage(paramString);
                paramString = paramMap;
              }
              catch (URISyntaxException localURISyntaxException1)
              {
                paramString = paramMap;
              }
              paramMap = new StringBuilder();
            }
            catch (URISyntaxException localURISyntaxException2)
            {
              paramString = null;
            }
            paramMap.append("Cause: ");
            str2 = localURISyntaxException2.getMessage();
          }
          else
          {
            if (!paramMap.containsKey("class_name")) {
              break label492;
            }
            str2 = (String)paramMap.get("class_name");
            paramMap = new Intent();
            paramMap.setComponent(new ComponentName(paramString, str2));
            paramString = paramMap;
            break label494;
          }
        }
        else
        {
          if (!aq.c.equals(str2)) {
            break label492;
          }
          paramString = (String)paramMap.get("web_uri");
          if (paramString == null) {
            break label492;
          }
          paramMap = paramString.trim();
          paramString = paramMap;
          if (!paramMap.startsWith("http://"))
          {
            paramString = paramMap;
            if (!paramMap.startsWith("https://"))
            {
              paramString = new StringBuilder();
              paramString.append("http://");
              paramString.append(paramMap);
              paramString = paramString.toString();
            }
          }
          try
          {
            paramMap = new URL(paramString).getProtocol();
            if ((!"http".equals(paramMap)) && (!"https".equals(paramMap))) {
              break label492;
            }
            paramMap = new Intent("android.intent.action.VIEW");
            try
            {
              paramMap.setData(Uri.parse(paramString));
              paramString = paramMap;
            }
            catch (MalformedURLException localMalformedURLException1)
            {
              paramString = paramMap;
            }
            paramMap = new StringBuilder();
          }
          catch (MalformedURLException localMalformedURLException2)
          {
            paramString = null;
          }
          paramMap.append("Cause: ");
          str3 = localMalformedURLException2.getMessage();
        }
        paramMap.append(str3);
        com.xiaomi.channel.commonutils.logger.b.d(paramMap.toString());
        break label494;
      }
      label492:
      paramString = null;
      label494:
      if (paramString != null)
      {
        if (i >= 0) {
          paramString.setFlags(i);
        }
        paramString.addFlags(268435456);
        try
        {
          if (paramContext.getPackageManager().resolveActivity(paramString, 65536) != null) {
            return paramString;
          }
          paramContext = new StringBuilder();
          paramContext.append("not resolve activity:");
          paramContext.append(paramString);
          com.xiaomi.channel.commonutils.logger.b.a(paramContext.toString());
          return null;
        }
        catch (Exception paramContext)
        {
          paramString = new StringBuilder();
          paramString.append("Cause: ");
          paramString.append(paramContext.getMessage());
          com.xiaomi.channel.commonutils.logger.b.d(paramString.toString());
        }
      }
    }
    return null;
  }
  
  private PushMessageHandler.a a(ik paramik, boolean paramBoolean, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    return null;
  }
  
  private PushMessageHandler.a a(ik paramik, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public static at a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiMipushSdkAt == null) {
      jdField_a_of_type_ComXiaomiMipushSdkAt = new at(paramContext);
    }
    return jdField_a_of_type_ComXiaomiMipushSdkAt;
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
  private void a(Context arg1, android.content.pm.PackageInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static void a(Context paramContext, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilQueue.remove(paramString);
      b.a(paramContext);
      paramString = b.a(paramContext);
      paramContext = bf.a(jdField_a_of_type_JavaUtilQueue, ",");
      paramString = paramString.edit();
      paramString.putString("pref_msg_ids", paramContext);
      r.a(paramString);
      return;
    }
  }
  
  /* Error */
  private void a(Context arg1, String[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(com.xiaomi.push.if arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(ik arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(com.xiaomi.push.ir arg1, ik arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(String arg1, long arg2, d arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      b.a(paramContext);
      paramContext = b.a(paramContext);
      if (jdField_a_of_type_JavaUtilQueue == null)
      {
        String[] arrayOfString = paramContext.getString("pref_msg_ids", "").split(",");
        jdField_a_of_type_JavaUtilQueue = new LinkedList();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          jdField_a_of_type_JavaUtilQueue.add(str);
          i += 1;
        }
      }
      if (jdField_a_of_type_JavaUtilQueue.contains(paramString)) {
        return true;
      }
      jdField_a_of_type_JavaUtilQueue.add(paramString);
      if (jdField_a_of_type_JavaUtilQueue.size() > 25) {
        jdField_a_of_type_JavaUtilQueue.poll();
      }
      paramString = bf.a(jdField_a_of_type_JavaUtilQueue, ",");
      paramContext = paramContext.edit();
      paramContext.putString("pref_msg_ids", paramString);
      r.a(paramContext);
      return false;
    }
  }
  
  private boolean a(ik paramik)
  {
    return false;
  }
  
  /* Error */
  private void b(com.xiaomi.push.if arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void b(ik arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public PushMessageHandler.a a(Intent paramIntent)
  {
    return null;
  }
  
  public List<String> a(TimeZone paramTimeZone1, TimeZone paramTimeZone2, List<String> paramList)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */