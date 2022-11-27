package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzgr
  implements Serializable, Iterable<Byte>
{
  public static final zzgr zza = new zzhb(zzic.zzb);
  private static final zzgx zzb;
  private static final Comparator<zzgr> zzd = new zzgt();
  private int zzc = 0;
  
  static
  {
    Object localObject;
    if (zzgk.zza()) {
      localObject = new zzha(null);
    } else {
      localObject = new zzgv(null);
    }
    zzb = (zzgx)localObject;
  }
  
  public static zzgr zza(String paramString)
  {
    return new zzhb(paramString.getBytes(zzic.zza));
  }
  
  static zzgr zza(byte[] paramArrayOfByte)
  {
    return new zzhb(paramArrayOfByte);
  }
  
  public static zzgr zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new zzhb(zzb.zza(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  private static int zzb(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  static int zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 < paramInt1)
        {
          localStringBuilder = new StringBuilder(66);
          localStringBuilder.append("Beginning index larger than ending index: ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramInt2);
          throw new IndexOutOfBoundsException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder(37);
        localStringBuilder.append("End index: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramInt3);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("Beginning index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    return i;
  }
  
  static zzgz zzc(int paramInt)
  {
    return new zzgz(paramInt, null);
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    int j = this.zzc;
    int i = j;
    if (j == 0)
    {
      i = zza();
      j = zza(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.zzc = i;
    }
    return i;
  }
  
  public final String toString()
  {
    Locale localLocale = Locale.ROOT;
    String str2 = Integer.toHexString(System.identityHashCode(this));
    int i = zza();
    String str1;
    if (zza() <= 50) {
      str1 = zzkn.zza(this);
    } else {
      str1 = String.valueOf(zzkn.zza(zza(0, 47))).concat("...");
    }
    return String.format(localLocale, "<ByteString@%s size=%d contents=\"%s\">", new Object[] { str2, Integer.valueOf(i), str1 });
  }
  
  public abstract byte zza(int paramInt);
  
  public abstract int zza();
  
  protected abstract int zza(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract zzgr zza(int paramInt1, int paramInt2);
  
  protected abstract String zza(Charset paramCharset);
  
  abstract void zza(zzgo paramzzgo)
    throws IOException;
  
  abstract byte zzb(int paramInt);
  
  public final String zzb()
  {
    Charset localCharset = zzic.zza;
    if (zza() == 0) {
      return "";
    }
    return zza(localCharset);
  }
  
  public abstract boolean zzc();
  
  protected final int zzd()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */