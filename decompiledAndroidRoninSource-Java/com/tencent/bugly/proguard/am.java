package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class am
  extends k
{
  private static byte[] y;
  private static Map<String, String> z;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public byte[] h = null;
  public String i = "";
  public String j = "";
  public Map<String, String> k = null;
  public String l = "";
  public long m = 0L;
  public String n = "";
  public String o = "";
  public String p = "";
  public long q = 0L;
  public String r = "";
  public String s = "";
  public String t = "";
  private String u = "";
  private String v = "";
  private String w = "";
  private String x = "";
  
  static
  {
    Object localObject = (byte[])new byte[1];
    y = (byte[])localObject;
    ((byte[])localObject)[0] = 0;
    localObject = new HashMap();
    z = (Map)localObject;
    ((Map)localObject).put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, true);
    this.c = parami.b(2, true);
    this.d = parami.b(3, true);
    this.e = parami.b(4, false);
    this.f = parami.b(5, true);
    this.g = parami.a(this.g, 6, true);
    this.h = ((byte[])parami.c(7, true));
    this.i = parami.b(8, false);
    this.j = parami.b(9, false);
    this.k = ((Map)parami.a(z, 10, false));
    this.l = parami.b(11, false);
    this.m = parami.a(this.m, 12, false);
    this.n = parami.b(13, false);
    this.o = parami.b(14, false);
    this.p = parami.b(15, false);
    this.q = parami.a(this.q, 16, false);
    this.u = parami.b(17, false);
    this.r = parami.b(18, false);
    this.v = parami.b(19, false);
    this.w = parami.b(20, false);
    this.s = parami.b(21, false);
    this.t = parami.b(22, false);
    this.x = parami.b(23, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    paramj.a(this.d, 3);
    Object localObject = this.e;
    if (localObject != null) {
      paramj.a((String)localObject, 4);
    }
    paramj.a(this.f, 5);
    paramj.a(this.g, 6);
    paramj.a(this.h, 7);
    localObject = this.i;
    if (localObject != null) {
      paramj.a((String)localObject, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      paramj.a((String)localObject, 9);
    }
    localObject = this.k;
    if (localObject != null) {
      paramj.a((Map)localObject, 10);
    }
    localObject = this.l;
    if (localObject != null) {
      paramj.a((String)localObject, 11);
    }
    paramj.a(this.m, 12);
    localObject = this.n;
    if (localObject != null) {
      paramj.a((String)localObject, 13);
    }
    localObject = this.o;
    if (localObject != null) {
      paramj.a((String)localObject, 14);
    }
    localObject = this.p;
    if (localObject != null) {
      paramj.a((String)localObject, 15);
    }
    paramj.a(this.q, 16);
    localObject = this.u;
    if (localObject != null) {
      paramj.a((String)localObject, 17);
    }
    localObject = this.r;
    if (localObject != null) {
      paramj.a((String)localObject, 18);
    }
    localObject = this.v;
    if (localObject != null) {
      paramj.a((String)localObject, 19);
    }
    localObject = this.w;
    if (localObject != null) {
      paramj.a((String)localObject, 20);
    }
    localObject = this.s;
    if (localObject != null) {
      paramj.a((String)localObject, 21);
    }
    localObject = this.t;
    if (localObject != null) {
      paramj.a((String)localObject, 22);
    }
    localObject = this.x;
    if (localObject != null) {
      paramj.a((String)localObject, 23);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */