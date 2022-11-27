package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class al
  extends k
  implements Cloneable
{
  private static ArrayList<ak> b;
  public ArrayList<ak> a = null;
  
  public final void a(i parami)
  {
    if (b == null)
    {
      b = new ArrayList();
      ak localak = new ak();
      b.add(localak);
    }
    this.a = ((ArrayList)parami.a(b, 0, true));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */