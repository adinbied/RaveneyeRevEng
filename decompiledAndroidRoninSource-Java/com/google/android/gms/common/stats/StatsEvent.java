package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    long l1 = getTimeMillis();
    int i = getEventType();
    long l2 = zzu();
    String str = zzv();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 53);
    localStringBuilder.append(l1);
    localStringBuilder.append("\t");
    localStringBuilder.append(i);
    localStringBuilder.append("\t");
    localStringBuilder.append(l2);
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public abstract long zzu();
  
  public abstract String zzv();
  
  public static abstract interface Types
  {
    public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
    public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\stats\StatsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */