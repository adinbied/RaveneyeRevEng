package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

public abstract class CreationContext
{
  private static final String DEFAULT_BACKEND_NAME = "cct";
  
  public static CreationContext create(Context paramContext, Clock paramClock1, Clock paramClock2)
  {
    return new AutoValue_CreationContext(paramContext, paramClock1, paramClock2, "cct");
  }
  
  public static CreationContext create(Context paramContext, Clock paramClock1, Clock paramClock2, String paramString)
  {
    return new AutoValue_CreationContext(paramContext, paramClock1, paramClock2, paramString);
  }
  
  public abstract Context getApplicationContext();
  
  public abstract String getBackendName();
  
  public abstract Clock getMonotonicClock();
  
  public abstract Clock getWallClock();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\CreationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */