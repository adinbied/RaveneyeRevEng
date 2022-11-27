package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class aq
  extends k
{
  private static Map<String, String> i;
  public long a = 0L;
  public byte b = 0;
  public String c = "";
  public String d = "";
  public String e = "";
  public Map<String, String> f = null;
  public boolean g = true;
  private String h = "";
  
  static
  {
    HashMap localHashMap = new HashMap();
    i = localHashMap;
    localHashMap.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    this.c = parami.b(2, false);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = ((Map)parami.a(i, 5, false));
    this.h = parami.b(6, false);
    this.g = parami.a(7, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      paramj.a((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramj.a((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramj.a((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramj.a((Map)localObject, 5);
    }
    localObject = this.h;
    if (localObject != null) {
      paramj.a((String)localObject, 6);
    }
    paramj.a(this.g, 7);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */