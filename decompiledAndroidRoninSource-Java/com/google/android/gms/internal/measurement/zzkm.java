package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzkm
  implements Iterator<Map.Entry<K, V>>
{
  private int zza = -1;
  private boolean zzb;
  private Iterator<Map.Entry<K, V>> zzc;
  
  private zzkm(zzke paramzzke) {}
  
  private final Iterator<Map.Entry<K, V>> zza()
  {
    if (this.zzc == null) {
      this.zzc = zzke.zzc(this.zzd).entrySet().iterator();
    }
    return this.zzc;
  }
  
  public final boolean hasNext()
  {
    if (this.zza + 1 >= zzke.zzb(this.zzd).size()) {
      return (!zzke.zzc(this.zzd).isEmpty()) && (zza().hasNext());
    }
    return true;
  }
  
  public final void remove()
  {
    if (this.zzb)
    {
      this.zzb = false;
      zzke.zza(this.zzd);
      if (this.zza < zzke.zzb(this.zzd).size())
      {
        zzke localzzke = this.zzd;
        int i = this.zza;
        this.zza = (i - 1);
        zzke.zza(localzzke, i);
        return;
      }
      zza().remove();
      return;
    }
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzkm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */