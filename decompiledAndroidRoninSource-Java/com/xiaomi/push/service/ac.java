package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.push.bf;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ac
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Map<String, Queue<String>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static boolean a(XMPushService paramXMPushService, String paramString1, String paramString2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      SharedPreferences localSharedPreferences = paramXMPushService.getSharedPreferences("push_message_ids", 0);
      Object localObject1 = (Queue)jdField_a_of_type_JavaUtilMap.get(paramString1);
      paramXMPushService = (XMPushService)localObject1;
      if (localObject1 == null)
      {
        localObject1 = localSharedPreferences.getString(paramString1, "").split(",");
        paramXMPushService = new LinkedList();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          paramXMPushService.add(localObject1[i]);
          i += 1;
        }
        jdField_a_of_type_JavaUtilMap.put(paramString1, paramXMPushService);
      }
      if (paramXMPushService.contains(paramString2)) {
        return true;
      }
      paramXMPushService.add(paramString2);
      if (paramXMPushService.size() > 25) {
        paramXMPushService.poll();
      }
      paramXMPushService = bf.a(paramXMPushService, ",");
      paramString2 = localSharedPreferences.edit();
      paramString2.putString(paramString1, paramXMPushService);
      paramString2.commit();
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */