package com.google.android.datatransport.runtime.time;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class TimeModule_EventClockFactory
  implements Factory<Clock>
{
  private static final TimeModule_EventClockFactory INSTANCE = new TimeModule_EventClockFactory();
  
  public static TimeModule_EventClockFactory create()
  {
    return INSTANCE;
  }
  
  public static Clock eventClock()
  {
    return (Clock)Preconditions.checkNotNull(TimeModule.eventClock(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public Clock get()
  {
    return eventClock();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\time\TimeModule_EventClockFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */