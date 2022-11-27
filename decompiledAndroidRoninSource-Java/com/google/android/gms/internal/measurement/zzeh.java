package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzeh<T>
  implements zzec<T>
{
  private volatile zzec<T> zza;
  private volatile boolean zzb;
  @NullableDecl
  private T zzc;
  
  zzeh(zzec<T> paramzzec)
  {
    this.zza = ((zzec)zzeb.zza(paramzzec));
  }
  
  public final String toString()
  {
    Object localObject2 = this.zza;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = String.valueOf(this.zzc);
      localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 25);
      ((StringBuilder)localObject2).append("<supplier that returned ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(">");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = String.valueOf(localObject1);
    localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 19);
    ((StringBuilder)localObject2).append("Suppliers.memoize(");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    return ((StringBuilder)localObject2).toString();
  }
  
  public final T zza()
  {
    if (!this.zzb) {
      try
      {
        if (!this.zzb)
        {
          Object localObject1 = this.zza.zza();
          this.zzc = localObject1;
          this.zzb = true;
          this.zza = null;
          return (T)localObject1;
        }
      }
      finally {}
    }
    return (T)this.zzc;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */