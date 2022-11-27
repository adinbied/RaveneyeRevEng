package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

public abstract interface Scheduler
{
  public abstract void schedule(TransportContext paramTransportContext, EventInternal paramEventInternal, TransportScheduleCallback paramTransportScheduleCallback);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\Scheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */