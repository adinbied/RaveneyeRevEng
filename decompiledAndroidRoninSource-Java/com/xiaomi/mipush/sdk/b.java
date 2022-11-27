package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.i;
import java.util.Map;
import org.json.JSONObject;

public class b
{
  private static volatile b jdField_a_of_type_ComXiaomiMipushSdkB;
  private Context jdField_a_of_type_AndroidContentContext;
  private a jdField_a_of_type_ComXiaomiMipushSdkB$a;
  String jdField_a_of_type_JavaLangString;
  private Map<String, a> jdField_a_of_type_JavaUtilMap;
  
  private b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("mipush", 0);
  }
  
  public static b a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiMipushSdkB == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiMipushSdkB == null) {
          jdField_a_of_type_ComXiaomiMipushSdkB = new b(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiMipushSdkB;
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.jdField_a_of_type_Int;
  }
  
  public a a(String paramString)
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComXiaomiMipushSdkB$a.a();
  }
  
  /* Error */
  public void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(String arg1, a arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComXiaomiMipushSdkB$a.a(paramString1, paramString2, paramString3);
  }
  
  /* Error */
  public void a(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.a(paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComXiaomiMipushSdkB$a.b();
  }
  
  /* Error */
  public void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComXiaomiMipushSdkB$a.b(paramString1, paramString2, paramString3);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.c;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.a();
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.d;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.jdField_b_of_type_Boolean;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.g;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.jdField_a_of_type_Boolean ^ true;
  }
  
  public String f()
  {
    return this.jdField_a_of_type_ComXiaomiMipushSdkB$a.h;
  }
  
  public static class a
  {
    public int a;
    private Context a;
    public String a;
    public boolean a;
    public String b;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    
    public a(Context paramContext)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
    
    public static a a(Context paramContext, String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramContext = new a(paramContext);
        paramContext.jdField_a_of_type_JavaLangString = paramString.getString("appId");
        paramContext.jdField_b_of_type_JavaLangString = paramString.getString("appToken");
        paramContext.c = paramString.getString("regId");
        paramContext.d = paramString.getString("regSec");
        paramContext.f = paramString.getString("devId");
        paramContext.e = paramString.getString("vName");
        paramContext.jdField_a_of_type_Boolean = paramString.getBoolean("valid");
        paramContext.jdField_b_of_type_Boolean = paramString.getBoolean("paused");
        paramContext.jdField_a_of_type_Int = paramString.getInt("envType");
        paramContext.g = paramString.getString("regResource");
        return paramContext;
      }
      finally
      {
        com.xiaomi.channel.commonutils.logger.b.a(paramContext);
      }
      return null;
    }
    
    private String a()
    {
      return null;
    }
    
    public static String a(a parama)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("appId", parama.jdField_a_of_type_JavaLangString);
        localJSONObject.put("appToken", parama.jdField_b_of_type_JavaLangString);
        localJSONObject.put("regId", parama.c);
        localJSONObject.put("regSec", parama.d);
        localJSONObject.put("devId", parama.f);
        localJSONObject.put("vName", parama.e);
        localJSONObject.put("valid", parama.jdField_a_of_type_Boolean);
        localJSONObject.put("paused", parama.jdField_b_of_type_Boolean);
        localJSONObject.put("envType", parama.jdField_a_of_type_Int);
        localJSONObject.put("regResource", parama.g);
        parama = localJSONObject.toString();
        return parama;
      }
      finally
      {
        com.xiaomi.channel.commonutils.logger.b.a(parama);
      }
      return null;
    }
    
    /* Error */
    public void a()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void a(int paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
    }
    
    public void a(String paramString1, String paramString2)
    {
      this.c = paramString1;
      this.d = paramString2;
      this.f = i.l(this.jdField_a_of_type_AndroidContentContext);
      this.e = a();
      this.jdField_a_of_type_Boolean = true;
    }
    
    /* Error */
    public void a(String arg1, String arg2, String arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void a(boolean paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
    
    public boolean a()
    {
      return false;
    }
    
    public boolean a(String paramString1, String paramString2)
    {
      return false;
    }
    
    /* Error */
    public void b()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void b(String arg1, String arg2, String arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void c(String paramString1, String paramString2, String paramString3)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.g = paramString3;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */