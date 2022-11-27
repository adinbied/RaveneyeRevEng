package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class gl
{
  private static long jdField_a_of_type_Long = 0L;
  protected static final String a;
  public static final DateFormat a;
  private static String b;
  private static String c;
  private gp jdField_a_of_type_ComXiaomiPushGp = null;
  private List<gi> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private final Map<String, Object> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String d = b;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = Locale.getDefault().getLanguage().toLowerCase();
    b = null;
    Object localObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    jdField_a_of_type_JavaTextDateFormat = (DateFormat)localObject;
    ((DateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(gw.a(5));
    ((StringBuilder)localObject).append("-");
    c = ((StringBuilder)localObject).toString();
  }
  
  public gl() {}
  
  public gl(Bundle paramBundle)
  {
    this.f = paramBundle.getString("ext_to");
    this.g = paramBundle.getString("ext_from");
    this.h = paramBundle.getString("ext_chid");
    this.e = paramBundle.getString("ext_pkt_id");
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("ext_exts");
    if (arrayOfParcelable != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(arrayOfParcelable.length);
      int k = arrayOfParcelable.length;
      int j = 0;
      while (j < k)
      {
        gi localgi = gi.a((Bundle)arrayOfParcelable[j]);
        if (localgi != null) {
          this.jdField_a_of_type_JavaUtilList.add(localgi);
        }
        j += 1;
      }
    }
    paramBundle = paramBundle.getBundle("ext_ERROR");
    if (paramBundle != null) {
      this.jdField_a_of_type_ComXiaomiPushGp = new gp(paramBundle);
    }
  }
  
  public static String i()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(c);
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l;
      ((StringBuilder)localObject1).append(Long.toString(l));
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public static String q()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public Bundle a()
  {
    return null;
  }
  
  public gi a(String paramString)
  {
    return a(paramString, null);
  }
  
  public gi a(String paramString1, String paramString2)
  {
    return null;
  }
  
  public gp a()
  {
    return this.jdField_a_of_type_ComXiaomiPushGp;
  }
  
  public Object a(String paramString)
  {
    return null;
  }
  
  public abstract String a();
  
  public Collection<gi> a()
  {
    return null;
  }
  
  public void a(gi paramgi)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramgi);
  }
  
  public void a(gp paramgp)
  {
    this.jdField_a_of_type_ComXiaomiPushGp = paramgp;
  }
  
  public Collection<String> b()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String j()
  {
    return null;
  }
  
  public String k()
  {
    return this.h;
  }
  
  public void k(String paramString)
  {
    this.e = paramString;
  }
  
  public String l()
  {
    return this.f;
  }
  
  public void l(String paramString)
  {
    this.h = paramString;
  }
  
  public String m()
  {
    return this.g;
  }
  
  public void m(String paramString)
  {
    this.f = paramString;
  }
  
  public String n()
  {
    return this.i;
  }
  
  public void n(String paramString)
  {
    this.g = paramString;
  }
  
  protected String o()
  {
    return null;
  }
  
  public void o(String paramString)
  {
    this.i = paramString;
  }
  
  public String p()
  {
    return this.d;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */