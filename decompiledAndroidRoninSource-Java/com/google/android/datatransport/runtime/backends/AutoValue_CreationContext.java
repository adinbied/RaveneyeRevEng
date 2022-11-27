package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

final class AutoValue_CreationContext
  extends CreationContext
{
  private final Context applicationContext;
  private final String backendName;
  private final Clock monotonicClock;
  private final Clock wallClock;
  
  AutoValue_CreationContext(Context paramContext, Clock paramClock1, Clock paramClock2, String paramString)
  {
    if (paramContext != null)
    {
      this.applicationContext = paramContext;
      if (paramClock1 != null)
      {
        this.wallClock = paramClock1;
        if (paramClock2 != null)
        {
          this.monotonicClock = paramClock2;
          if (paramString != null)
          {
            this.backendName = paramString;
            return;
          }
          throw new NullPointerException("Null backendName");
        }
        throw new NullPointerException("Null monotonicClock");
      }
      throw new NullPointerException("Null wallClock");
    }
    throw new NullPointerException("Null applicationContext");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CreationContext))
    {
      paramObject = (CreationContext)paramObject;
      return (this.applicationContext.equals(((CreationContext)paramObject).getApplicationContext())) && (this.wallClock.equals(((CreationContext)paramObject).getWallClock())) && (this.monotonicClock.equals(((CreationContext)paramObject).getMonotonicClock())) && (this.backendName.equals(((CreationContext)paramObject).getBackendName()));
    }
    return false;
  }
  
  public Context getApplicationContext()
  {
    return this.applicationContext;
  }
  
  public String getBackendName()
  {
    return this.backendName;
  }
  
  public Clock getMonotonicClock()
  {
    return this.monotonicClock;
  }
  
  public Clock getWallClock()
  {
    return this.wallClock;
  }
  
  public int hashCode()
  {
    return (((this.applicationContext.hashCode() ^ 0xF4243) * 1000003 ^ this.wallClock.hashCode()) * 1000003 ^ this.monotonicClock.hashCode()) * 1000003 ^ this.backendName.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CreationContext{applicationContext=");
    localStringBuilder.append(this.applicationContext);
    localStringBuilder.append(", wallClock=");
    localStringBuilder.append(this.wallClock);
    localStringBuilder.append(", monotonicClock=");
    localStringBuilder.append(this.monotonicClock);
    localStringBuilder.append(", backendName=");
    localStringBuilder.append(this.backendName);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\AutoValue_CreationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */