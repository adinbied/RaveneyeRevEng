package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class l
{
  private static int jdField_a_of_type_Int = 0;
  private static Map<String, o> jdField_a_of_type_JavaUtilMap;
  private static int b = -1;
  
  public static int a()
  {
    for (;;)
    {
      int j;
      try
      {
        i = jdField_a_of_type_Int;
        if (i == 0)
        {
          try
          {
            boolean bool = TextUtils.isEmpty(a("ro.miui.ui.version.code"));
            j = 1;
            if (!bool) {
              break label108;
            }
            if (TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
              break label103;
            }
          }
          finally
          {
            b.a("get isMIUI failed", localThrowable);
            jdField_a_of_type_Int = 0;
          }
          jdField_a_of_type_Int = i;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isMIUI's value is: ");
          localStringBuilder.append(jdField_a_of_type_Int);
          b.b(localStringBuilder.toString());
        }
        else
        {
          i = jdField_a_of_type_Int;
          return i;
        }
      }
      finally {}
      label103:
      int i = 0;
      break label110;
      label108:
      i = 1;
      label110:
      if (i != 0) {
        i = j;
      } else {
        i = 2;
      }
    }
  }
  
  public static o a(String paramString)
  {
    o localo = b(paramString);
    paramString = localo;
    if (localo == null) {
      paramString = o.b;
    }
    return paramString;
  }
  
  public static String a()
  {
    try
    {
      int i = t.a();
      if ((a()) && (i > 0))
      {
        if (i < 2) {
          return "alpha";
        }
        if (i < 3) {
          return "development";
        }
        return "stable";
      }
      return "";
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = (String)ba.a("android.os.SystemProperties", "get", new Object[] { paramString, "" });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      b.a(paramString);
      return null;
    }
    finally {}
    return null;
  }
  
  private static void a()
  {
    if (jdField_a_of_type_JavaUtilMap != null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    jdField_a_of_type_JavaUtilMap = localHashMap;
    localHashMap.put("CN", o.a);
    jdField_a_of_type_JavaUtilMap.put("FI", o.c);
    jdField_a_of_type_JavaUtilMap.put("SE", o.c);
    jdField_a_of_type_JavaUtilMap.put("NO", o.c);
    jdField_a_of_type_JavaUtilMap.put("FO", o.c);
    jdField_a_of_type_JavaUtilMap.put("EE", o.c);
    jdField_a_of_type_JavaUtilMap.put("LV", o.c);
    jdField_a_of_type_JavaUtilMap.put("LT", o.c);
    jdField_a_of_type_JavaUtilMap.put("BY", o.c);
    jdField_a_of_type_JavaUtilMap.put("MD", o.c);
    jdField_a_of_type_JavaUtilMap.put("UA", o.c);
    jdField_a_of_type_JavaUtilMap.put("PL", o.c);
    jdField_a_of_type_JavaUtilMap.put("CZ", o.c);
    jdField_a_of_type_JavaUtilMap.put("SK", o.c);
    jdField_a_of_type_JavaUtilMap.put("HU", o.c);
    jdField_a_of_type_JavaUtilMap.put("DE", o.c);
    jdField_a_of_type_JavaUtilMap.put("AT", o.c);
    jdField_a_of_type_JavaUtilMap.put("CH", o.c);
    jdField_a_of_type_JavaUtilMap.put("LI", o.c);
    jdField_a_of_type_JavaUtilMap.put("GB", o.c);
    jdField_a_of_type_JavaUtilMap.put("IE", o.c);
    jdField_a_of_type_JavaUtilMap.put("NL", o.c);
    jdField_a_of_type_JavaUtilMap.put("BE", o.c);
    jdField_a_of_type_JavaUtilMap.put("LU", o.c);
    jdField_a_of_type_JavaUtilMap.put("FR", o.c);
    jdField_a_of_type_JavaUtilMap.put("RO", o.c);
    jdField_a_of_type_JavaUtilMap.put("BG", o.c);
    jdField_a_of_type_JavaUtilMap.put("RS", o.c);
    jdField_a_of_type_JavaUtilMap.put("MK", o.c);
    jdField_a_of_type_JavaUtilMap.put("AL", o.c);
    jdField_a_of_type_JavaUtilMap.put("GR", o.c);
    jdField_a_of_type_JavaUtilMap.put("SI", o.c);
    jdField_a_of_type_JavaUtilMap.put("HR", o.c);
    jdField_a_of_type_JavaUtilMap.put("IT", o.c);
    jdField_a_of_type_JavaUtilMap.put("SM", o.c);
    jdField_a_of_type_JavaUtilMap.put("MT", o.c);
    jdField_a_of_type_JavaUtilMap.put("ES", o.c);
    jdField_a_of_type_JavaUtilMap.put("PT", o.c);
    jdField_a_of_type_JavaUtilMap.put("AD", o.c);
    jdField_a_of_type_JavaUtilMap.put("CY", o.c);
    jdField_a_of_type_JavaUtilMap.put("DK", o.c);
    jdField_a_of_type_JavaUtilMap.put("RU", o.d);
    jdField_a_of_type_JavaUtilMap.put("IN", o.e);
  }
  
  public static boolean a()
  {
    try
    {
      int i = a();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static o b(String paramString)
  {
    a();
    return (o)jdField_a_of_type_JavaUtilMap.get(paramString.toUpperCase());
  }
  
  public static String b()
  {
    Object localObject2 = s.a("ro.miui.region", "");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = s.a("persist.sys.oppo.region", "");
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = s.a("ro.oppo.regionmark", "");
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = s.a("ro.hw.country", "");
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = s.a("ro.csc.countryiso_code", "");
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = s.a("ro.product.country.region", "");
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = s.a("gsm.vivo.countrycode", "");
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = s.a("persist.sys.oem.region", "");
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = s.a("ro.product.locale.region", "");
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = s.a("persist.sys.country", "");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get region from system, region = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      b.a(((StringBuilder)localObject2).toString());
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = Locale.getDefault().getCountry();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("locale.default.country = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      b.a(((StringBuilder)localObject1).toString());
    }
    return (String)localObject2;
  }
  
  public static boolean b()
  {
    try
    {
      int i = a();
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean c()
  {
    if (b < 0)
    {
      Object localObject = ba.a("miui.external.SdkHelper", "isMiuiSystem", new Object[0]);
      b = 0;
      if ((localObject != null) && ((localObject instanceof Boolean)) && (!((Boolean)Boolean.class.cast(localObject)).booleanValue())) {
        b = 1;
      }
    }
    return b > 0;
  }
  
  public static boolean d()
  {
    return o.a.name().equalsIgnoreCase(a(b()).name()) ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */