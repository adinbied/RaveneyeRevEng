package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CreationContextFactory_Factory
  implements Factory<CreationContextFactory>
{
  private final Provider<Context> applicationContextProvider;
  private final Provider<Clock> monotonicClockProvider;
  private final Provider<Clock> wallClockProvider;
  
  public CreationContextFactory_Factory(Provider<Context> paramProvider, Provider<Clock> paramProvider1, Provider<Clock> paramProvider2)
  {
    this.applicationContextProvider = paramProvider;
    this.wallClockProvider = paramProvider1;
    this.monotonicClockProvider = paramProvider2;
  }
  
  public static CreationContextFactory_Factory create(Provider<Context> paramProvider, Provider<Clock> paramProvider1, Provider<Clock> paramProvider2)
  {
    return new CreationContextFactory_Factory(paramProvider, paramProvider1, paramProvider2);
  }
  
  public static CreationContextFactory newInstance(Context paramContext, Clock paramClock1, Clock paramClock2)
  {
    return new CreationContextFactory(paramContext, paramClock1, paramClock2);
  }
  
  public CreationContextFactory get()
  {
    return new CreationContextFactory((Context)this.applicationContextProvider.get(), (Clock)this.wallClockProvider.get(), (Clock)this.monotonicClockProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\CreationContextFactory_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */