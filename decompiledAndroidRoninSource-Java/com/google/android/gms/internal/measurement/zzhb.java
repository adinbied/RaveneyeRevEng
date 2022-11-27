package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

class zzhb
  extends zzgy
{
  protected final byte[] zzb;
  
  zzhb(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.zzb = paramArrayOfByte;
      return;
    }
    throw null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzgr)) {
      return false;
    }
    if (zza() != ((zzgr)paramObject).zza()) {
      return false;
    }
    if (zza() == 0) {
      return true;
    }
    if ((paramObject instanceof zzhb))
    {
      paramObject = (zzhb)paramObject;
      int i = zzd();
      int j = ((zzgr)paramObject).zzd();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return zza((zzgr)paramObject, 0, zza());
    }
    return paramObject.equals(this);
  }
  
  public byte zza(int paramInt)
  {
    return this.zzb[paramInt];
  }
  
  public int zza()
  {
    return this.zzb.length;
  }
  
  protected final int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzic.zza(paramInt1, this.zzb, zze(), paramInt3);
  }
  
  public final zzgr zza(int paramInt1, int paramInt2)
  {
    paramInt1 = zzb(0, paramInt2, zza());
    if (paramInt1 == 0) {
      return zzgr.zza;
    }
    return new zzgu(this.zzb, zze(), paramInt1);
  }
  
  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzb, zze(), zza(), paramCharset);
  }
  
  final void zza(zzgo paramzzgo)
    throws IOException
  {
    paramzzgo.zza(this.zzb, zze(), zza());
  }
  
  final boolean zza(zzgr paramzzgr, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramzzgr.zza())
    {
      if (paramInt2 <= paramzzgr.zza())
      {
        if ((paramzzgr instanceof zzhb))
        {
          paramzzgr = (zzhb)paramzzgr;
          byte[] arrayOfByte1 = this.zzb;
          byte[] arrayOfByte2 = paramzzgr.zzb;
          int j = zze();
          int i = zze();
          paramInt1 = paramzzgr.zze();
          while (i < j + paramInt2)
          {
            if (arrayOfByte1[i] != arrayOfByte2[paramInt1]) {
              return false;
            }
            i += 1;
            paramInt1 += 1;
          }
          return true;
        }
        return paramzzgr.zza(0, paramInt2).equals(zza(0, paramInt2));
      }
      paramInt1 = paramzzgr.zza();
      paramzzgr = new StringBuilder(59);
      paramzzgr.append("Ran off end of other: 0, ");
      paramzzgr.append(paramInt2);
      paramzzgr.append(", ");
      paramzzgr.append(paramInt1);
      throw new IllegalArgumentException(paramzzgr.toString());
    }
    paramInt1 = zza();
    paramzzgr = new StringBuilder(40);
    paramzzgr.append("Length too large: ");
    paramzzgr.append(paramInt2);
    paramzzgr.append(paramInt1);
    throw new IllegalArgumentException(paramzzgr.toString());
  }
  
  byte zzb(int paramInt)
  {
    return this.zzb[paramInt];
  }
  
  public final boolean zzc()
  {
    int i = zze();
    return zzla.zza(this.zzb, i, zza() + i);
  }
  
  protected int zze()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */