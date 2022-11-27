package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Inject;

class CreationContextFactory
{
  private final Context applicationContext;
  private final Clock monotonicClock;
  private final Clock wallClock;
  
  @Inject
  CreationContextFactory(Context paramContext, Clock paramClock1, Clock paramClock2)
  {
    this.applicationContext = paramContext;
    this.wallClock = paramClock1;
    this.monotonicClock = paramClock2;
  }
  
  CreationContext create(String paramString)
  {
    return CreationContext.create(this.applicationContext, this.wallClock, this.monotonicClock, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\CreationContextFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */