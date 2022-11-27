package com.xiaomi.push;

import android.os.Bundle;

public class gk
  extends gl
{
  private boolean a = false;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private String c = null;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  
  public gk() {}
  
  public gk(Bundle paramBundle)
  {
    super(paramBundle);
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("ext_msg_type");
    this.d = paramBundle.getString("ext_msg_lang");
    this.c = paramBundle.getString("ext_msg_thread");
    this.e = paramBundle.getString("ext_msg_sub");
    this.f = paramBundle.getString("ext_msg_body");
    this.g = paramBundle.getString("ext_body_encode");
    this.h = paramBundle.getString("ext_msg_appid");
    this.a = paramBundle.getBoolean("ext_msg_trans", false);
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("ext_msg_encrypt", false);
    this.i = paramBundle.getString("ext_msg_seq");
    this.j = paramBundle.getString("ext_msg_mseq");
    this.k = paramBundle.getString("ext_msg_fseq");
    this.l = paramBundle.getString("ext_msg_status");
  }
  
  public Bundle a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.f = paramString1;
    this.g = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.i = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public String c()
  {
    return this.h;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public String d()
  {
    return this.i;
  }
  
  public void d(String paramString)
  {
    this.k = paramString;
  }
  
  public String e()
  {
    return this.j;
  }
  
  public void e(String paramString)
  {
    this.l = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String f()
  {
    return this.k;
  }
  
  public void f(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String g()
  {
    return this.l;
  }
  
  public void g(String paramString)
  {
    this.e = paramString;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public void h(String paramString)
  {
    this.f = paramString;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public void i(String paramString)
  {
    this.c = paramString;
  }
  
  public void j(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */