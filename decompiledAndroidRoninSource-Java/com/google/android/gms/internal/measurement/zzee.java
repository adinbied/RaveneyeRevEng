package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzee<T>
  implements zzec<T>, Serializable
{
  private final zzec<T> zza;
  private volatile transient boolean zzb;
  @NullableDecl
  private transient T zzc;
  
  zzee(zzec<T> paramzzec)
  {
    this.zza = ((zzec)zzeb.zza(paramzzec));
  }
  
  public final String toString()
  {
    if (this.zzb)
    {
      localObject = String.valueOf(this.zzc);
      localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 25);
      localStringBuilder.append("<supplier that returned ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(">");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = this.zza;
    }
    Object localObject = String.valueOf(localObject);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 19);
    localStringBuilder.append("Suppliers.memoize(");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
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
          return (T)localObject1;
        }
      }
      finally {}
    }
    return (T)this.zzc;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */