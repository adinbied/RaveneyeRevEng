package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdu<T>
  extends zzdy<T>
{
  static final zzdu<Object> zza = new zzdu();
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    return paramObject == this;
  }
  
  public final int hashCode()
  {
    return 2040732332;
  }
  
  public final String toString()
  {
    return "Optional.absent()";
  }
  
  public final boolean zza()
  {
    return false;
  }
  
  public final T zzb()
  {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */