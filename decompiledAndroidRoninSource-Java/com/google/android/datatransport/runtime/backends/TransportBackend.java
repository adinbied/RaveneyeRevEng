package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;

public abstract interface TransportBackend
{
  public abstract EventInternal decorate(EventInternal paramEventInternal);
  
  public abstract BackendResponse send(BackendRequest paramBackendRequest);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\TransportBackend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */