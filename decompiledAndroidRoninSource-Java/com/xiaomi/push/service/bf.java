package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hr;
import com.xiaomi.push.hs;
import com.xiaomi.push.hy;
import com.xiaomi.push.in;
import com.xiaomi.push.iy;
import com.xiaomi.push.iz;
import com.xiaomi.push.t;
import com.xiaomi.push.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class bf
{
  private static String jdField_a_of_type_JavaLangString;
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  
  static
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    jdField_a_of_type_JavaTextSimpleDateFormat = localSimpleDateFormat;
    jdField_a_of_type_JavaLangString = localSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
  }
  
  public static String a()
  {
    try
    {
      String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
      if (!TextUtils.equals(jdField_a_of_type_JavaLangString, str))
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
        jdField_a_of_type_JavaLangString = str;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("-");
      localStringBuilder.append(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.incrementAndGet());
      str = localStringBuilder.toString();
      return str;
    }
    finally {}
  }
  
  public static ArrayList<in> a(List<hs> paramList, String paramString1, String paramString2, int paramInt)
  {
    if (paramList == null) {}
    for (paramList = "requests can not be null in TinyDataHelper.transToThriftObj().";; paramList = "requests.length is 0 in TinyDataHelper.transToThriftObj().")
    {
      b.d(paramList);
      return null;
      if (paramList.size() != 0) {
        break;
      }
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new hr();
    int j = 0;
    int i = 0;
    while (j < paramList.size())
    {
      hs localhs = (hs)paramList.get(j);
      if (localhs != null)
      {
        int m = iy.a(localhs).length;
        Object localObject2;
        if (m > paramInt)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("TinyData is too big, ignore upload request item:");
          ((StringBuilder)localObject2).append(localhs.d());
          b.d(((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = localObject1;
          int k = i;
          if (i + m > paramInt)
          {
            localObject2 = new in("-1", false);
            ((in)localObject2).d(paramString1);
            ((in)localObject2).b(paramString2);
            ((in)localObject2).c(hy.B.jdField_a_of_type_JavaLangString);
            ((in)localObject2).a(y.a(iy.a((iz)localObject1)));
            localArrayList.add(localObject2);
            localObject2 = new hr();
            k = 0;
          }
          ((hr)localObject2).a(localhs);
          i = k + m;
          localObject1 = localObject2;
        }
      }
      j += 1;
    }
    if (((hr)localObject1).a() != 0)
    {
      paramList = new in("-1", false);
      paramList.d(paramString1);
      paramList.b(paramString2);
      paramList.c(hy.B.jdField_a_of_type_JavaLangString);
      paramList.a(y.a(iy.a((iz)localObject1)));
      localArrayList.add(paramList);
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    hs localhs = new hs();
    localhs.d(paramString1);
    localhs.c(paramString2);
    localhs.a(paramLong);
    localhs.b(paramString3);
    localhs.a("push_sdk_channel");
    localhs.g(paramContext.getPackageName());
    localhs.e(paramContext.getPackageName());
    localhs.a(true);
    localhs.b(System.currentTimeMillis());
    localhs.f(a());
    bg.a(paramContext, localhs);
  }
  
  public static boolean a(hs paramhs, boolean paramBoolean)
  {
    if (paramhs == null) {
      paramhs = "item is null, verfiy ClientUploadDataItem failed.";
    }
    for (;;)
    {
      b.a(paramhs);
      return true;
      if ((!paramBoolean) && (TextUtils.isEmpty(paramhs.jdField_a_of_type_JavaLangString)))
      {
        paramhs = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
      }
      else if (TextUtils.isEmpty(paramhs.d))
      {
        paramhs = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
      }
      else if (TextUtils.isEmpty(paramhs.c))
      {
        paramhs = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
      }
      else if (!com.xiaomi.push.bf.a(paramhs.d))
      {
        paramhs = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
      }
      else if (!com.xiaomi.push.bf.a(paramhs.c))
      {
        paramhs = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
      }
      else
      {
        if ((paramhs.b == null) || (paramhs.b.length() <= 10240)) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("item.data is too large(");
        localStringBuilder.append(paramhs.b.length());
        localStringBuilder.append("), max size for data is ");
        localStringBuilder.append(10240);
        localStringBuilder.append(" , verfiy ClientUploadDataItem failed.");
        paramhs = localStringBuilder.toString();
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (!t.b()) || ("com.miui.hybrid".equals(paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */