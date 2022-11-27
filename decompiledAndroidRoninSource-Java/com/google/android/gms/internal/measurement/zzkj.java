package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzkj
  implements Comparable<zzkj>, Map.Entry<K, V>
{
  private final K zza;
  private V zzb;
  
  zzkj(K paramK, V paramV)
  {
    this.zza = paramV;
    Object localObject;
    this.zzb = localObject;
  }
  
  zzkj(Map.Entry<K, V> paramEntry)
  {
    this(paramEntry, (Comparable)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
  }
  
  private static boolean zza(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return (zza(this.zza, ((Map.Entry)paramObject).getKey())) && (zza(this.zzb, ((Map.Entry)paramObject).getValue()));
  }
  
  public final V getValue()
  {
    return (V)this.zzb;
  }
  
  public final int hashCode()
  {
    Object localObject = this.zza;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.zzb;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public final V setValue(V paramV)
  {
    zzke.zza(this.zzc);
    Object localObject = this.zzb;
    this.zzb = paramV;
    return (V)localObject;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(this.zza);
    String str2 = String.valueOf(this.zzb);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */