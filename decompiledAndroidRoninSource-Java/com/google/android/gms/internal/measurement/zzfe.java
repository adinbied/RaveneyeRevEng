package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class zzfe<K, V>
  extends zzek<K, V>
  implements Serializable
{
  private final transient zzfc<K, ? extends zzey<V>> zza;
  private final transient int zzb;
  
  zzfe(zzfc<K, ? extends zzey<V>> paramzzfc, int paramInt)
  {
    this.zza = paramzzfc;
    this.zzb = paramInt;
  }
  
  public final boolean zza(@NullableDecl Object paramObject)
  {
    return (paramObject != null) && (super.zza(paramObject));
  }
  
  final Map<K, Collection<V>> zzb()
  {
    throw new AssertionError("should never be called");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */