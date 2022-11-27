package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class ai
  extends k
  implements Cloneable
{
  private static ArrayList<String> c;
  private String a = "";
  private ArrayList<String> b = null;
  
  public final void a(i parami)
  {
    this.a = parami.b(0, true);
    if (c == null)
    {
      ArrayList localArrayList = new ArrayList();
      c = localArrayList;
      localArrayList.add("");
    }
    this.b = ((ArrayList)parami.a(c, 1, false));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      paramj.a(localArrayList, 1);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */