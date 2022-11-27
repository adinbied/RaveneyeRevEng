package com.google.android.gms.tasks;

public abstract class CancellationToken
{
  public abstract boolean isCancellationRequested();
  
  public abstract CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\CancellationToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */