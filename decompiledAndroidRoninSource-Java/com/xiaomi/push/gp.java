package com.xiaomi.push;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class gp
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private List<gi> jdField_a_of_type_JavaUtilList = null;
  private String b;
  private String c;
  private String d;
  
  public gp(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<gi> paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.b = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public gp(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramBundle.getInt("ext_err_code");
    if (paramBundle.containsKey("ext_err_type")) {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("ext_err_type");
    }
    this.b = paramBundle.getString("ext_err_cond");
    this.c = paramBundle.getString("ext_err_reason");
    this.d = paramBundle.getString("ext_err_msg");
    paramBundle = paramBundle.getParcelableArray("ext_exts");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramBundle.length);
      int j = paramBundle.length;
      int i = 0;
      while (i < j)
      {
        gi localgi = gi.a((Bundle)paramBundle[i]);
        if (localgi != null) {
          this.jdField_a_of_type_JavaUtilList.add(localgi);
        }
        i += 1;
      }
    }
  }
  
  public gp(a parama)
  {
    a(parama);
    this.d = null;
  }
  
  private void a(a parama)
  {
    this.b = a.a(parama);
  }
  
  public Bundle a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public List<gi> a()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static class a
  {
    public static final a a;
    public static final a b = new a("forbidden");
    public static final a c = new a("bad-request");
    public static final a d = new a("conflict");
    public static final a e = new a("feature-not-implemented");
    public static final a f = new a("gone");
    public static final a g = new a("item-not-found");
    public static final a h = new a("jid-malformed");
    public static final a i = new a("not-acceptable");
    public static final a j = new a("not-allowed");
    public static final a k = new a("not-authorized");
    public static final a l = new a("payment-required");
    public static final a m = new a("recipient-unavailable");
    public static final a n = new a("redirect");
    public static final a o = new a("registration-required");
    public static final a p = new a("remote-server-error");
    public static final a q = new a("remote-server-not-found");
    public static final a r = new a("remote-server-timeout");
    public static final a s = new a("resource-constraint");
    public static final a t = new a("service-unavailable");
    public static final a u = new a("subscription-required");
    public static final a v = new a("undefined-condition");
    public static final a w = new a("unexpected-request");
    public static final a x = new a("request-timeout");
    private String a;
    
    static
    {
      jdField_a_of_type_ComXiaomiPushGp$a = new a("internal-server-error");
    }
    
    public a(String paramString)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    
    public String toString()
    {
      return this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */