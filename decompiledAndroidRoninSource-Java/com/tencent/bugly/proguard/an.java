package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class an
  extends k
{
  private static byte[] i;
  private static Map<String, String> j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public long d = 0L;
  public String e = "";
  private String f = "";
  private String g = "";
  private Map<String, String> h = null;
  
  static
  {
    Object localObject = (byte[])new byte[1];
    i = (byte[])localObject;
    ((byte[])localObject)[0] = 0;
    localObject = new HashMap();
    j = (Map)localObject;
    ((Map)localObject).put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    this.c = ((byte[])parami.c(2, false));
    this.f = parami.b(3, false);
    this.d = parami.a(this.d, 4, false);
    this.g = parami.b(5, false);
    this.e = parami.b(6, false);
    this.h = ((Map)parami.a(j, 7, false));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      paramj.a((byte[])localObject, 2);
    }
    localObject = this.f;
    if (localObject != null) {
      paramj.a((String)localObject, 3);
    }
    paramj.a(this.d, 4);
    localObject = this.g;
    if (localObject != null) {
      paramj.a((String)localObject, 5);
    }
    localObject = this.e;
    if (localObject != null) {
      paramj.a((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramj.a((Map)localObject, 7);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */