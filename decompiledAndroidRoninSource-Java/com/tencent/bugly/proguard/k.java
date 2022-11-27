package com.tencent.bugly.proguard;

import java.io.Serializable;

public abstract class k
  implements Serializable
{
  public abstract void a(i parami);
  
  public abstract void a(j paramj);
  
  public abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */