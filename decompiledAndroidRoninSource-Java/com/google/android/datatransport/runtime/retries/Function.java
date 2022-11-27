package com.google.android.datatransport.runtime.retries;

public abstract interface Function<TInput, TResult, TException extends Throwable>
{
  public abstract TResult apply(TInput paramTInput)
    throws Throwable;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\retries\Function.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */