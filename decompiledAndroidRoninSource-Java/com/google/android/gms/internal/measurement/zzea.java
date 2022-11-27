package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzea<T>
  extends zzdy<T>
{
  private final T zza;
  
  zzea(T paramT)
  {
    this.zza = paramT;
  }
  
  public final boolean equals(@NullableDecl Object paramObject)
  {
    if ((paramObject instanceof zzea))
    {
      paramObject = (zzea)paramObject;
      return this.zza.equals(((zzea)paramObject).zza);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode() + 1502476572;
  }
  
  public final String toString()
  {
    String str = String.valueOf(this.zza);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 13);
    localStringBuilder.append("Optional.of(");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final boolean zza()
  {
    return true;
  }
  
  public final T zzb()
  {
    return (T)this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */