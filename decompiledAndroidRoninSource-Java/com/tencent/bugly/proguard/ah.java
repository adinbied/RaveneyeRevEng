package com.tencent.bugly.proguard;

public final class ah
  extends k
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  private String d = "";
  private String e = "";
  
  public final void a(i parami)
  {
    this.a = parami.b(0, true);
    this.d = parami.b(1, false);
    this.b = parami.b(2, false);
    this.e = parami.b(3, false);
    this.c = parami.b(4, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    String str = this.d;
    if (str != null) {
      paramj.a(str, 1);
    }
    str = this.b;
    if (str != null) {
      paramj.a(str, 2);
    }
    str = this.e;
    if (str != null) {
      paramj.a(str, 3);
    }
    str = this.c;
    if (str != null) {
      paramj.a(str, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */