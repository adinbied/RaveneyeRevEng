package com.google.android.gms.internal.location;

import android.os.DeadObjectException;
import android.os.IInterface;

public abstract interface zzbj<T extends IInterface>
{
  public abstract void checkConnected();
  
  public abstract T getService()
    throws DeadObjectException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */