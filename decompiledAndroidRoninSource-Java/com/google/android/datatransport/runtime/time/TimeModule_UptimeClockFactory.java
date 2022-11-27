package com.google.android.datatransport.runtime.time;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class TimeModule_UptimeClockFactory
  implements Factory<Clock>
{
  private static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();
  
  public static TimeModule_UptimeClockFactory create()
  {
    return INSTANCE;
  }
  
  public static Clock uptimeClock()
  {
    return (Clock)Preconditions.checkNotNull(TimeModule.uptimeClock(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public Clock get()
  {
    return uptimeClock();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\time\TimeModule_UptimeClockFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */