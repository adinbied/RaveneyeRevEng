package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class o
{
  private static ArrayList<Pair<String, byte[]>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static final Map<String, byte[]> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(paramContext, str, (byte[])jdField_a_of_type_JavaUtilMap.get(str), paramInt, paramString);
      }
      jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.ERROR");
    localIntent.setPackage(paramString1);
    localIntent.putExtra("mipush_payload", paramArrayOfByte);
    localIntent.putExtra("mipush_error_code", paramInt);
    localIntent.putExtra("mipush_error_msg", paramString2);
    paramContext.sendBroadcast(localIntent, w.a(paramString1));
  }
  
  public static void a(XMPushService paramXMPushService)
  {
    try
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          w.a(paramXMPushService, str, (byte[])jdField_a_of_type_JavaUtilMap.get(str));
        }
        jdField_a_of_type_JavaUtilMap.clear();
        return;
      }
      return;
    }
    catch (gf localgf)
    {
      b.a(localgf);
      paramXMPushService.a(10, localgf);
    }
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      jdField_a_of_type_JavaUtilMap.put(paramString, paramArrayOfByte);
      return;
    }
  }
  
  public static void b(XMPushService paramXMPushService)
  {
    try
    {
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject2 = jdField_a_of_type_JavaUtilArrayList;
        jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (Pair)((Iterator)???).next();
          w.a(paramXMPushService, (String)((Pair)localObject2).first, (byte[])((Pair)localObject2).second);
        }
      }
      return;
    }
    catch (gf localgf)
    {
      b.a(localgf);
      paramXMPushService.a(10, localgf);
    }
  }
  
  public static void b(String paramString, byte[] paramArrayOfByte)
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramString, paramArrayOfByte));
      if (jdField_a_of_type_JavaUtilArrayList.size() > 50) {
        jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */