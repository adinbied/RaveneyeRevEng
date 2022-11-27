package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class db
{
  protected static Context a;
  private static a jdField_a_of_type_ComXiaomiPushDb$a;
  private static db jdField_a_of_type_ComXiaomiPushDb;
  protected static boolean a;
  protected static Map<String, cx> b;
  private static String jdField_c_of_type_JavaLangString;
  private static String d;
  private long jdField_a_of_type_Long = 0L;
  private da jdField_a_of_type_ComXiaomiPushDa;
  protected b a;
  private String jdField_a_of_type_JavaLangString = "0";
  protected Map<String, cy> a;
  private final long jdField_b_of_type_Long = 15L;
  private String jdField_b_of_type_JavaLangString = "isp_prov_city_country_ip";
  private long jdField_c_of_type_Long = 0L;
  
  static
  {
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Boolean = false;
  }
  
  protected db(Context paramContext, da paramda, b paramb, String paramString)
  {
    this(paramContext, paramda, paramb, paramString, null, null);
  }
  
  protected db(Context paramContext, da paramda, b paramb, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComXiaomiPushDb$b = paramb;
    paramb = paramda;
    if (paramda == null) {
      paramb = new dc(this);
    }
    this.jdField_a_of_type_ComXiaomiPushDa = paramb;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (paramString2 == null) {
      paramString2 = paramContext.getPackageName();
    }
    jdField_c_of_type_JavaLangString = paramString2;
    if (paramString3 == null) {
      paramString3 = f();
    }
    d = paramString3;
  }
  
  public static db a()
  {
    try
    {
      if (jdField_a_of_type_ComXiaomiPushDb != null)
      {
        db localdb = jdField_a_of_type_ComXiaomiPushDb;
        return localdb;
      }
      throw new IllegalStateException("the host manager is not initialized yet.");
    }
    finally {}
  }
  
  static String a()
  {
    Object localObject1 = jdField_a_of_type_AndroidContentContext;
    if (localObject1 == null) {
      return "unknown";
    }
    try
    {
      localObject1 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
      if (localObject1 == null) {
        return "unknown";
      }
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if (localObject1 == null) {
        return "unknown";
      }
      StringBuilder localStringBuilder;
      if (((NetworkInfo)localObject1).getType() == 1)
      {
        localObject1 = (WifiManager)jdField_a_of_type_AndroidContentContext.getSystemService("wifi");
        if ((localObject1 != null) && (((WifiManager)localObject1).getConnectionInfo() != null))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("WIFI-");
          localStringBuilder.append(((WifiManager)localObject1).getConnectionInfo().getSSID());
          return localStringBuilder.toString();
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((NetworkInfo)localObject1).getTypeName());
        localStringBuilder.append("-");
        localStringBuilder.append(((NetworkInfo)localObject1).getSubtypeName());
        localObject1 = localStringBuilder.toString();
        return (String)localObject1;
      }
      return "unknown";
    }
    finally {}
    return "unknown";
  }
  
  static String a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length();
        Object localObject = paramString.getBytes("UTF-8");
        i = 0;
        if (i < localObject.length)
        {
          int k = localObject[i];
          int m = k & 0xF0;
          if (m != 240) {
            localObject[i] = ((byte)(k & 0xF ^ (byte)((k >> 4) + j & 0xF) | m));
          }
        }
        else
        {
          localObject = new String((byte[])localObject);
          return (String)localObject;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return paramString;
      }
      i += 1;
    }
  }
  
  private ArrayList<cx> a(ArrayList<String> paramArrayList)
  {
    return null;
  }
  
  public static void a(Context paramContext, da paramda, b paramb, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Context localContext = paramContext.getApplicationContext();
      jdField_a_of_type_AndroidContentContext = localContext;
      if (localContext == null) {
        jdField_a_of_type_AndroidContentContext = paramContext;
      }
      if (jdField_a_of_type_ComXiaomiPushDb == null) {
        if (jdField_a_of_type_ComXiaomiPushDb$a == null) {
          jdField_a_of_type_ComXiaomiPushDb = new db(paramContext, paramda, paramb, paramString1, paramString2, paramString3);
        } else {
          jdField_a_of_type_ComXiaomiPushDb = jdField_a_of_type_ComXiaomiPushDb$a.a(paramContext, paramda, paramb, paramString1);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(a parama)
  {
    try
    {
      jdField_a_of_type_ComXiaomiPushDb$a = parama;
      jdField_a_of_type_ComXiaomiPushDb = null;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    cx localcx = (cx)jdField_b_of_type_JavaUtilMap.get(paramString1);
    Map localMap = jdField_b_of_type_JavaUtilMap;
    if (localcx == null) {}
    try
    {
      localcx = new cx(paramString1);
      localcx.a(604800000L);
      localcx.a(paramString2);
      jdField_b_of_type_JavaUtilMap.put(paramString1, localcx);
      break label63;
      localcx.a(paramString2);
      label63:
      return;
    }
    finally {}
  }
  
  private String f()
  {
    return null;
  }
  
  public cx a(String paramString)
  {
    return null;
  }
  
  public cx a(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  protected String a(ArrayList<String> paramArrayList, String paramString1, String paramString2, boolean paramBoolean)
  {
    return null;
  }
  
  protected JSONObject a()
  {
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  public void a(String arg1, cx arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected boolean a()
  {
    for (;;)
    {
      return false;
    }
  }
  
  public cx b(String paramString)
  {
    return a(paramString, true);
  }
  
  protected String b()
  {
    return null;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected cx c(String paramString)
  {
    return null;
  }
  
  public String c()
  {
    return null;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected cx d(String paramString)
  {
    return null;
  }
  
  protected String d()
  {
    return null;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected String e()
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract db a(Context paramContext, da paramda, db.b paramb, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract String a(String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */