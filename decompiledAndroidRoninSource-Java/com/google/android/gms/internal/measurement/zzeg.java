package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzeg<T>
  implements zzec<T>, Serializable
{
  @NullableDecl
  private final T zza;
  
  zzeg(@NullableDecl T paramT)
  {
    this.zza = paramT;
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof zzeg))
    {
      paramObject = (zzeg)paramObject;
      return zzdz.zza(this.zza, ((zzeg)paramObject).zza);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.zza });
  }
  
  public final String toString()
  {
    String str = String.valueOf(this.zza);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 22);
    localStringBuilder.append("Suppliers.ofInstance(");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final T zza()
  {
    return (T)this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */