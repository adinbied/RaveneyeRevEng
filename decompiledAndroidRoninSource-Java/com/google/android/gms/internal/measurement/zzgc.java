package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzgc
  extends WeakReference<Throwable>
{
  private final int zza;
  
  public zzgc(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
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
      paramObject = (zzgc)paramObject;
      if ((this.zza == ((zzgc)paramObject).zza) && (get() == ((zzgc)paramObject).get())) {
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */