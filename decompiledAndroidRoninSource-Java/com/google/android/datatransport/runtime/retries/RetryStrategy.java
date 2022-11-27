package com.google.android.datatransport.runtime.retries;

public abstract interface RetryStrategy<TInput, TResult>
{
  public abstract TInput shouldRetry(TInput paramTInput, TResult paramTResult);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\retries\RetryStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */