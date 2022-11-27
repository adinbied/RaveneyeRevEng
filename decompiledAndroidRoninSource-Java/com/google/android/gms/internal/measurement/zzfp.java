package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Map.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzfp<K, V>
  extends zzfc<K, V>
{
  static final zzfc<Object, Object> zza = new zzfp(null, new Object[0], 0);
  private final transient Object zzb;
  private final transient Object[] zzc;
  private final transient int zzd;
  
  private zzfp(Object paramObject, Object[] paramArrayOfObject, int paramInt)
  {
    this.zzb = paramObject;
    this.zzc = paramArrayOfObject;
    this.zzd = paramInt;
  }
  
  static <K, V> zzfp<K, V> zza(int paramInt, Object[] paramArrayOfObject)
  {
    if (paramInt == 0) {
      return (zzfp)zza;
    }
    Object localObject1 = null;
    int j = 0;
    int k = 0;
    int i = 0;
    if (paramInt == 1)
    {
      zzen.zza(paramArrayOfObject[0], paramArrayOfObject[1]);
      return new zzfp(null, paramArrayOfObject, 1);
    }
    zzeb.zzb(paramInt, paramArrayOfObject.length >> 1);
    int n = zzfg.zza(paramInt);
    if (paramInt == 1)
    {
      zzen.zza(paramArrayOfObject[0], paramArrayOfObject[1]);
    }
    else
    {
      int m = n - 1;
      Object localObject2;
      Object localObject3;
      if (n <= 128)
      {
        localObject2 = new byte[n];
        Arrays.fill((byte[])localObject2, (byte)-1);
        localObject1 = localObject2;
        if (i < paramInt)
        {
          k = i * 2;
          localObject1 = paramArrayOfObject[k];
          localObject3 = paramArrayOfObject[(k ^ 0x1)];
          zzen.zza(localObject1, localObject3);
          j = zzez.zza(localObject1.hashCode());
          for (;;)
          {
            j &= m;
            n = localObject2[j] & 0xFF;
            if (n == 255)
            {
              localObject2[j] = ((byte)k);
              i += 1;
              break;
            }
            if (paramArrayOfObject[n].equals(localObject1)) {
              break label204;
            }
            j += 1;
          }
          label204:
          throw zza(localObject1, localObject3, paramArrayOfObject, n);
        }
      }
      for (;;)
      {
        break;
        if (n <= 32768)
        {
          localObject2 = new short[n];
          Arrays.fill((short[])localObject2, (short)-1);
          i = j;
          localObject1 = localObject2;
          if (i < paramInt)
          {
            k = i * 2;
            localObject1 = paramArrayOfObject[k];
            localObject3 = paramArrayOfObject[(k ^ 0x1)];
            zzen.zza(localObject1, localObject3);
            j = zzez.zza(localObject1.hashCode());
            for (;;)
            {
              j &= m;
              n = localObject2[j] & 0xFFFF;
              if (n == 65535)
              {
                localObject2[j] = ((short)k);
                i += 1;
                break;
              }
              if (paramArrayOfObject[n].equals(localObject1)) {
                break label337;
              }
              j += 1;
            }
            label337:
            throw zza(localObject1, localObject3, paramArrayOfObject, n);
          }
        }
        else
        {
          localObject2 = new int[n];
          Arrays.fill((int[])localObject2, -1);
          i = k;
          localObject1 = localObject2;
          if (i < paramInt)
          {
            k = i * 2;
            localObject1 = paramArrayOfObject[k];
            localObject3 = paramArrayOfObject[(k ^ 0x1)];
            zzen.zza(localObject1, localObject3);
            j = zzez.zza(localObject1.hashCode());
            for (;;)
            {
              j &= m;
              n = localObject2[j];
              if (n == -1)
              {
                localObject2[j] = k;
                i += 1;
                break;
              }
              if (paramArrayOfObject[n].equals(localObject1)) {
                break label456;
              }
              j += 1;
            }
            label456:
            throw zza(localObject1, localObject3, paramArrayOfObject, n);
          }
        }
      }
    }
    return new zzfp(localObject1, paramArrayOfObject, paramInt);
  }
  
  private static IllegalArgumentException zza(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject, int paramInt)
  {
    paramObject1 = String.valueOf(paramObject1);
    paramObject2 = String.valueOf(paramObject2);
    String str = String.valueOf(paramArrayOfObject[paramInt]);
    paramArrayOfObject = String.valueOf(paramArrayOfObject[(paramInt ^ 0x1)]);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramObject1).length() + 39 + String.valueOf(paramObject2).length() + String.valueOf(str).length() + String.valueOf(paramArrayOfObject).length());
    localStringBuilder.append("Multiple entries with same key: ");
    localStringBuilder.append((String)paramObject1);
    localStringBuilder.append("=");
    localStringBuilder.append((String)paramObject2);
    localStringBuilder.append(" and ");
    localStringBuilder.append(str);
    localStringBuilder.append("=");
    localStringBuilder.append(paramArrayOfObject);
    return new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @NullableDecl
  public final V get(@NullableDecl Object paramObject)
  {
    Object localObject = this.zzb;
    Object[] arrayOfObject = this.zzc;
    int i = this.zzd;
    if (paramObject == null) {
      return null;
    }
    if (i == 1)
    {
      if (arrayOfObject[0].equals(paramObject)) {
        return (V)arrayOfObject[1];
      }
      return null;
    }
    if (localObject == null) {
      return null;
    }
    int k;
    if ((localObject instanceof byte[]))
    {
      localObject = (byte[])localObject;
      j = localObject.length;
      i = zzez.zza(paramObject.hashCode());
      for (;;)
      {
        i &= j - 1;
        k = localObject[i] & 0xFF;
        if (k == 255) {
          return null;
        }
        if (arrayOfObject[k].equals(paramObject)) {
          return (V)arrayOfObject[(k ^ 0x1)];
        }
        i += 1;
      }
    }
    if ((localObject instanceof short[]))
    {
      localObject = (short[])localObject;
      j = localObject.length;
      i = zzez.zza(paramObject.hashCode());
      for (;;)
      {
        i &= j - 1;
        k = localObject[i] & 0xFFFF;
        if (k == 65535) {
          return null;
        }
        if (arrayOfObject[k].equals(paramObject)) {
          return (V)arrayOfObject[(k ^ 0x1)];
        }
        i += 1;
      }
    }
    localObject = (int[])localObject;
    int j = localObject.length;
    i = zzez.zza(paramObject.hashCode());
    for (;;)
    {
      i &= j - 1;
      k = localObject[i];
      if (k == -1) {
        return null;
      }
      if (arrayOfObject[k].equals(paramObject)) {
        return (V)arrayOfObject[(k ^ 0x1)];
      }
      i += 1;
    }
  }
  
  public final int size()
  {
    return this.zzd;
  }
  
  final zzfg<Map.Entry<K, V>> zza()
  {
    return new zzfo(this, this.zzc, 0, this.zzd);
  }
  
  final zzfg<K> zzb()
  {
    return new zzfq(this, new zzft(this.zzc, 0, this.zzd));
  }
  
  final zzey<V> zzc()
  {
    return new zzft(this.zzc, 1, this.zzd);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */