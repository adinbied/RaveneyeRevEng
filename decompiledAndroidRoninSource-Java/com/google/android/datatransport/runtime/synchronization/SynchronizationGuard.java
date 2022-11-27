package com.google.android.datatransport.runtime.synchronization;

public abstract interface SynchronizationGuard
{
  public abstract <T> T runCriticalSection(CriticalSection<T> paramCriticalSection);
  
  public static abstract interface CriticalSection<T>
  {
    public abstract T execute();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\synchronization\SynchronizationGuard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */