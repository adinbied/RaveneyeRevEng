package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzr
  extends WeakReference<Throwable>
{
  private final int zza;
  
  public zzr(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    if (paramThrowable != null)
    {
      this.zza = System.identityHashCode(paramThrowable);
      return;
    }
    throw new NullPointerException("The referent cannot be null");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzr)paramObject;
      if ((this.zza == ((zzr)paramObject).zza) && (get() == ((zzr)paramObject).get())) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */