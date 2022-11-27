package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzio<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, zzim> zza;
  
  private zzio(Map.Entry<K, zzim> paramEntry)
  {
    this.zza = paramEntry;
  }
  
  public final K getKey()
  {
    return (K)this.zza.getKey();
  }
  
  public final Object getValue()
  {
    if ((zzim)this.zza.getValue() == null) {
      return null;
    }
    return zzim.zza();
  }
  
  public final Object setValue(Object paramObject)
  {
    if ((paramObject instanceof zzjh)) {
      return ((zzim)this.zza.getValue()).zza((zzjh)paramObject);
    }
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzim zza()
  {
    return (zzim)this.zza.getValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */