package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzkg
  implements Iterator<Map.Entry<K, V>>
{
  private int zza = zzke.zzb(this.zzc).size();
  private Iterator<Map.Entry<K, V>> zzb;
  
  private zzkg(zzke paramzzke) {}
  
  private final Iterator<Map.Entry<K, V>> zza()
  {
    if (this.zzb == null) {
      this.zzb = zzke.zzd(this.zzc).entrySet().iterator();
    }
    return this.zzb;
  }
  
  public final boolean hasNext()
  {
    int i = this.zza;
    return ((i > 0) && (i <= zzke.zzb(this.zzc).size())) || (zza().hasNext());
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */