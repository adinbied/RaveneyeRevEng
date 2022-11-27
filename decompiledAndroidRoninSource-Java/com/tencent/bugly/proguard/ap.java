package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class ap
  extends k
  implements Cloneable
{
  private static ao m;
  private static Map<String, String> n;
  public boolean a = true;
  public boolean b = true;
  public boolean c = true;
  public String d = "";
  public String e = "";
  public ao f = null;
  public Map<String, String> g = null;
  public long h = 0L;
  public int i = 0;
  private String j = "";
  private String k = "";
  private int l = 0;
  
  static
  {
    m = new ao();
    HashMap localHashMap = new HashMap();
    n = localHashMap;
    localHashMap.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(0, true);
    this.b = parami.a(1, true);
    this.c = parami.a(2, true);
    this.d = parami.b(3, false);
    this.e = parami.b(4, false);
    this.f = ((ao)parami.a(m, 5, false));
    this.g = ((Map)parami.a(n, 6, false));
    this.h = parami.a(this.h, 7, false);
    this.j = parami.b(8, false);
    this.k = parami.b(9, false);
    this.l = parami.a(this.l, 10, false);
    this.i = parami.a(this.i, 11, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    paramj.a(this.c, 2);
    Object localObject = this.d;
    if (localObject != null) {
      paramj.a((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramj.a((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramj.a((k)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramj.a((Map)localObject, 6);
    }
    paramj.a(this.h, 7);
    localObject = this.j;
    if (localObject != null) {
      paramj.a((String)localObject, 8);
    }
    localObject = this.k;
    if (localObject != null) {
      paramj.a((String)localObject, 9);
    }
    paramj.a(this.l, 10);
    paramj.a(this.i, 11);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new h(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "enable");
    paramStringBuilder.a(this.b, "enableUserInfo");
    paramStringBuilder.a(this.c, "enableQuery");
    paramStringBuilder.a(this.d, "url");
    paramStringBuilder.a(this.e, "expUrl");
    paramStringBuilder.a(this.f, "security");
    paramStringBuilder.a(this.g, "valueMap");
    paramStringBuilder.a(this.h, "strategylastUpdateTime");
    paramStringBuilder.a(this.j, "httpsUrl");
    paramStringBuilder.a(this.k, "httpsExpUrl");
    paramStringBuilder.a(this.l, "eventRecordCount");
    paramStringBuilder.a(this.i, "eventTimeInterval");
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;) {}
    }
    if (o) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (ap)paramObject;
    return (l.a(this.a, ((ap)paramObject).a)) && (l.a(this.b, ((ap)paramObject).b)) && (l.a(this.c, ((ap)paramObject).c)) && (l.a(this.d, ((ap)paramObject).d)) && (l.a(this.e, ((ap)paramObject).e)) && (l.a(this.f, ((ap)paramObject).f)) && (l.a(this.g, ((ap)paramObject).g)) && (l.a(this.h, ((ap)paramObject).h)) && (l.a(this.j, ((ap)paramObject).j)) && (l.a(this.k, ((ap)paramObject).k)) && (l.a(this.l, ((ap)paramObject).l)) && (l.a(this.i, ((ap)paramObject).i));
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */