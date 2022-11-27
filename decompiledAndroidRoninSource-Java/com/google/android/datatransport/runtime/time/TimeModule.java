package com.google.android.datatransport.runtime.time;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class TimeModule
{
  @Provides
  static Clock eventClock()
  {
    return new WallTimeClock();
  }
  
  @Provides
  static Clock uptimeClock()
  {
    return new UptimeClock();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\time\TimeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */