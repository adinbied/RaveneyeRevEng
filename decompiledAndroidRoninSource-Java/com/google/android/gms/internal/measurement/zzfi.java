package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;

public final class zzfi<K, V>
  extends zzfh<K, V>
{
  public final zzfj<K, V> zza()
  {
    Object localObject1 = this.zza.entrySet();
    if (((Collection)localObject1).isEmpty()) {
      return zzew.zza;
    }
    zzff localzzff = new zzff(((Collection)localObject1).size());
    Iterator localIterator = ((Collection)localObject1).iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      Object localObject3 = ((Map.Entry)localObject1).getKey();
      Object localObject2 = (Collection)((Map.Entry)localObject1).getValue();
      int k;
      int i;
      int m;
      if (((localObject2 instanceof zzfg)) && (!(localObject2 instanceof SortedSet)))
      {
        localObject1 = (zzfg)localObject2;
        if (!((zzey)localObject1).zzf()) {}
      }
      else
      {
        localObject2 = ((Collection)localObject2).toArray();
        k = localObject2.length;
        while (k != 0) {
          if (k != 1)
          {
            int i5 = zzfg.zza(k);
            Object[] arrayOfObject = new Object[i5];
            int i4 = i5 - 1;
            int n = 0;
            i = 0;
            int i3;
            for (m = 0; n < k; m = i3)
            {
              localObject1 = zzfn.zza(localObject2[n], n);
              int i6 = localObject1.hashCode();
              int i2 = zzez.zza(i6);
              int i1;
              for (;;)
              {
                i1 = i2 & i4;
                Object localObject4 = arrayOfObject[i1];
                if (localObject4 == null)
                {
                  localObject2[i] = localObject1;
                  arrayOfObject[i1] = localObject1;
                  i3 = m + i6;
                  i1 = i + 1;
                  break;
                }
                i1 = i;
                i3 = m;
                if (localObject4.equals(localObject1)) {
                  break;
                }
                i2 += 1;
              }
              n += 1;
              i = i1;
            }
            Arrays.fill((Object[])localObject2, i, k, null);
            if (i == 1)
            {
              localObject1 = new zzfu(localObject2[0], m);
              break label415;
            }
            if (zzfg.zza(i) < i5 / 2)
            {
              k = i;
            }
            else
            {
              k = localObject2.length;
              localObject1 = localObject2;
              if (i < (k >> 1) + (k >> 2)) {
                localObject1 = Arrays.copyOf((Object[])localObject2, i);
              }
              localObject1 = new zzfs((Object[])localObject1, m, arrayOfObject, i4, i);
              break label415;
            }
          }
          else
          {
            localObject1 = new zzfu(localObject2[0]);
            break label415;
          }
        }
        localObject1 = zzfs.zza;
      }
      label415:
      if (!((zzfg)localObject1).isEmpty())
      {
        m = localzzff.zzb + 1 << 1;
        if (m > localzzff.zza.length)
        {
          localObject2 = localzzff.zza;
          i = localzzff.zza.length;
          if (m >= 0)
          {
            k = i + (i >> 1) + 1;
            i = k;
            if (k < m) {
              i = Integer.highestOneBit(m - 1) << 1;
            }
            k = i;
            if (i < 0) {
              k = Integer.MAX_VALUE;
            }
            localzzff.zza = Arrays.copyOf((Object[])localObject2, k);
            localzzff.zzc = false;
          }
          else
          {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
          }
        }
        zzen.zza(localObject3, localObject1);
        localzzff.zza[(localzzff.zzb * 2)] = localObject3;
        localzzff.zza[(localzzff.zzb * 2 + 1)] = localObject1;
        localzzff.zzb += 1;
        j += ((zzfg)localObject1).size();
      }
    }
    localzzff.zzc = true;
    return new zzfj(zzfp.zza(localzzff.zzb, localzzff.zza), j, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */