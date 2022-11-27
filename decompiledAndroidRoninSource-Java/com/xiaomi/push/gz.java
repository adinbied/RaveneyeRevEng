package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.providers.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class gz
{
  private static volatile int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static al jdField_a_of_type_ComXiaomiPushAl = new al(true);
  private static a jdField_a_of_type_ComXiaomiPushProvidersA = null;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static String jdField_a_of_type_JavaLangString;
  private static List<a> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_a_of_type_Int == -1) {
      jdField_a_of_type_Int = b(paramContext);
    }
    return jdField_a_of_type_Int;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    return paramString.getBytes().length;
  }
  
  private static long a(int paramInt, long paramLong1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = paramLong2;
      if ((paramLong2 - l > 30000L) && (paramLong1 > 1024L)) {
        return paramLong1 * 2L;
      }
    }
    if (paramInt == 0) {
      paramInt = 13;
    } else {
      paramInt = 11;
    }
    return paramLong1 * paramInt / 10L;
  }
  
  private static a a(Context paramContext)
  {
    a locala = jdField_a_of_type_ComXiaomiPushProvidersA;
    if (locala != null) {
      return locala;
    }
    paramContext = new a(paramContext);
    jdField_a_of_type_ComXiaomiPushProvidersA = paramContext;
    return paramContext;
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        paramContext = jdField_a_of_type_JavaLangString;
        return paramContext;
      }
      return "";
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_Int = b(paramContext);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    a(paramContext, paramString, a(a(paramContext), paramLong1, paramBoolean1, paramLong2, paramBoolean2), paramBoolean1, paramLong2);
  }
  
  private static void a(a parama)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a(parama))
      {
        locala.jdField_b_of_type_Long += parama.jdField_b_of_type_Long;
        return;
      }
    }
    jdField_a_of_type_JavaUtilList.add(parama);
  }
  
  public static void a(String paramString)
  {
    try
    {
      if ((!l.d()) && (!TextUtils.isEmpty(paramString))) {
        jdField_a_of_type_JavaLangString = paramString;
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static int b(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return -1;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return -1;
      }
      return paramContext.getType();
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  private static void b(Context paramContext, List<a> paramList)
  {
    try
    {
      synchronized (a.jdField_a_of_type_JavaLangObject)
      {
        paramContext = a(paramContext).getWritableDatabase();
        paramContext.beginTransaction();
        try
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            a locala = (a)paramList.next();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("package_name", locala.jdField_a_of_type_JavaLangString);
            localContentValues.put("message_ts", Long.valueOf(locala.jdField_a_of_type_Long));
            localContentValues.put("network_type", Integer.valueOf(locala.jdField_a_of_type_Int));
            localContentValues.put("bytes", Long.valueOf(locala.jdField_b_of_type_Long));
            localContentValues.put("rcv", Integer.valueOf(locala.jdField_b_of_type_Int));
            localContentValues.put("imsi", locala.jdField_b_of_type_JavaLangString);
            paramContext.insert("traffic", null, localContentValues);
          }
          paramContext.setTransactionSuccessful();
          paramContext.endTransaction();
          return;
        }
        finally
        {
          paramContext.endTransaction();
        }
      }
      return;
    }
    catch (SQLiteException paramContext)
    {
      b.a(paramContext);
    }
  }
  
  static class a
  {
    public int a;
    public long a;
    public String a;
    public int b;
    public long b;
    public String b;
    
    public a(String paramString1, long paramLong1, int paramInt1, int paramInt2, String paramString2, long paramLong2)
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_b_of_type_Long = paramLong2;
    }
    
    public boolean a(a parama)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */