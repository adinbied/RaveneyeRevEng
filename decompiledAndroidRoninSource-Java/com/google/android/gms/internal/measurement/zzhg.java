package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzhg
  extends zzgo
{
  private static final Logger zzb = Logger.getLogger(zzhg.class.getName());
  private static final boolean zzc = zzkx.zza();
  zzhj zza;
  
  public static int zza(int paramInt, zziq paramzziq)
  {
    paramInt = zzg(paramInt << 3);
    int i = paramzziq.zzb();
    return paramInt + (zzg(i) + i);
  }
  
  public static int zza(zziq paramzziq)
  {
    int i = paramzziq.zzb();
    return zzg(i) + i;
  }
  
  static int zza(zzjh paramzzjh, zzjz paramzzjz)
  {
    paramzzjh = (zzgh)paramzzjh;
    int j = paramzzjh.zzbl();
    int i = j;
    if (j == -1)
    {
      i = paramzzjz.zzb(paramzzjh);
      paramzzjh.zzc(i);
    }
    return zzg(i) + i;
  }
  
  public static zzhg zza(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzb(double paramDouble)
  {
    return 8;
  }
  
  public static int zzb(float paramFloat)
  {
    return 4;
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zzg(paramInt << 3) + 8;
  }
  
  public static int zzb(int paramInt, float paramFloat)
  {
    return zzg(paramInt << 3) + 4;
  }
  
  public static int zzb(int paramInt, zziq paramzziq)
  {
    return (zzg(8) << 1) + zzg(2, paramInt) + zza(3, paramzziq);
  }
  
  public static int zzb(int paramInt, zzjh paramzzjh)
  {
    return (zzg(8) << 1) + zzg(2, paramInt) + (zzg(24) + zzb(paramzzjh));
  }
  
  static int zzb(int paramInt, zzjh paramzzjh, zzjz paramzzjz)
  {
    return zzg(paramInt << 3) + zza(paramzzjh, paramzzjz);
  }
  
  public static int zzb(int paramInt, String paramString)
  {
    return zzg(paramInt << 3) + zzb(paramString);
  }
  
  public static int zzb(int paramInt, boolean paramBoolean)
  {
    return zzg(paramInt << 3) + 1;
  }
  
  public static int zzb(zzgr paramzzgr)
  {
    int i = paramzzgr.zza();
    return zzg(i) + i;
  }
  
  public static int zzb(zzjh paramzzjh)
  {
    int i = paramzzjh.zzbo();
    return zzg(i) + i;
  }
  
  public static int zzb(String paramString)
  {
    try
    {
      i = zzla.zza(paramString);
    }
    catch (zzld localzzld)
    {
      int i;
      for (;;) {}
    }
    i = paramString.getBytes(zzic.zza).length;
    return zzg(i) + i;
  }
  
  public static int zzb(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int zzb(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return zzg(i) + i;
  }
  
  public static int zzc(int paramInt, zzgr paramzzgr)
  {
    paramInt = zzg(paramInt << 3);
    int i = paramzzgr.zza();
    return paramInt + (zzg(i) + i);
  }
  
  @Deprecated
  static int zzc(int paramInt, zzjh paramzzjh, zzjz paramzzjz)
  {
    int j = zzg(paramInt << 3);
    paramzzjh = (zzgh)paramzzjh;
    int i = paramzzjh.zzbl();
    paramInt = i;
    if (i == -1)
    {
      paramInt = paramzzjz.zzb(paramzzjh);
      paramzzjh.zzc(paramInt);
    }
    return (j << 1) + paramInt;
  }
  
  @Deprecated
  public static int zzc(zzjh paramzzjh)
  {
    return paramzzjh.zzbo();
  }
  
  public static int zzd(int paramInt, long paramLong)
  {
    return zzg(paramInt << 3) + zze(paramLong);
  }
  
  public static int zzd(int paramInt, zzgr paramzzgr)
  {
    return (zzg(8) << 1) + zzg(2, paramInt) + zzc(3, paramzzgr);
  }
  
  public static int zzd(long paramLong)
  {
    return zze(paramLong);
  }
  
  public static int zze(int paramInt)
  {
    return zzg(paramInt << 3);
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zzg(paramInt << 3) + zze(paramLong);
  }
  
  public static int zze(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0xFFFFFFF800000000 & paramLong) != 0L)
    {
      j = 6;
      paramLong >>>= 28;
    }
    else
    {
      j = 2;
    }
    int i = j;
    long l = paramLong;
    if ((0xFFFFFFFFFFE00000 & paramLong) != 0L)
    {
      i = j + 2;
      l = paramLong >>> 14;
    }
    int j = i;
    if ((l & 0xFFFFFFFFFFFFC000) != 0L) {
      j = i + 1;
    }
    return j;
  }
  
  public static int zzf(int paramInt)
  {
    if (paramInt >= 0) {
      return zzg(paramInt);
    }
    return 10;
  }
  
  public static int zzf(int paramInt1, int paramInt2)
  {
    return zzg(paramInt1 << 3) + zzf(paramInt2);
  }
  
  public static int zzf(int paramInt, long paramLong)
  {
    return zzg(paramInt << 3) + zze(zzi(paramLong));
  }
  
  public static int zzf(long paramLong)
  {
    return zze(zzi(paramLong));
  }
  
  public static int zzg(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzg(int paramInt1, int paramInt2)
  {
    return zzg(paramInt1 << 3) + zzg(paramInt2);
  }
  
  public static int zzg(int paramInt, long paramLong)
  {
    return zzg(paramInt << 3) + 8;
  }
  
  public static int zzg(long paramLong)
  {
    return 8;
  }
  
  public static int zzh(int paramInt)
  {
    return zzg(zzm(paramInt));
  }
  
  public static int zzh(int paramInt1, int paramInt2)
  {
    return zzg(paramInt1 << 3) + zzg(zzm(paramInt2));
  }
  
  public static int zzh(int paramInt, long paramLong)
  {
    return zzg(paramInt << 3) + 8;
  }
  
  public static int zzh(long paramLong)
  {
    return 8;
  }
  
  public static int zzi(int paramInt)
  {
    return 4;
  }
  
  public static int zzi(int paramInt1, int paramInt2)
  {
    return zzg(paramInt1 << 3) + 4;
  }
  
  private static long zzi(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int zzj(int paramInt)
  {
    return 4;
  }
  
  public static int zzj(int paramInt1, int paramInt2)
  {
    return zzg(paramInt1 << 3) + 4;
  }
  
  public static int zzk(int paramInt)
  {
    return zzf(paramInt);
  }
  
  public static int zzk(int paramInt1, int paramInt2)
  {
    return zzg(paramInt1 << 3) + zzf(paramInt2);
  }
  
  @Deprecated
  public static int zzl(int paramInt)
  {
    return zzg(paramInt);
  }
  
  private static int zzm(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public abstract int zza();
  
  public abstract void zza(byte paramByte)
    throws IOException;
  
  public final void zza(double paramDouble)
    throws IOException
  {
    zzc(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(float paramFloat)
    throws IOException
  {
    zzd(Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt)
    throws IOException;
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzc(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    zze(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public abstract void zza(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zza(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zza(int paramInt, zzgr paramzzgr)
    throws IOException;
  
  public abstract void zza(int paramInt, zzjh paramzzjh)
    throws IOException;
  
  abstract void zza(int paramInt, zzjh paramzzjh, zzjz paramzzjz)
    throws IOException;
  
  public abstract void zza(int paramInt, String paramString)
    throws IOException;
  
  public abstract void zza(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void zza(long paramLong)
    throws IOException;
  
  public abstract void zza(zzgr paramzzgr)
    throws IOException;
  
  public abstract void zza(zzjh paramzzjh)
    throws IOException;
  
  public abstract void zza(String paramString)
    throws IOException;
  
  final void zza(String paramString, zzld paramzzld)
    throws IOException
  {
    zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzld);
    paramString = paramString.getBytes(zzic.zza);
    try
    {
      zzb(paramString.length);
      zza(paramString, 0, paramString.length);
      return;
    }
    catch (zzb paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzb(paramString);
    }
  }
  
  public final void zza(boolean paramBoolean)
    throws IOException
  {
    zza((byte)paramBoolean);
  }
  
  public final void zzb()
  {
    if (zza() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public abstract void zzb(int paramInt)
    throws IOException;
  
  public abstract void zzb(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zza(paramInt, zzi(paramLong));
  }
  
  public abstract void zzb(int paramInt, zzgr paramzzgr)
    throws IOException;
  
  public final void zzb(long paramLong)
    throws IOException
  {
    zza(zzi(paramLong));
  }
  
  abstract void zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public final void zzc(int paramInt)
    throws IOException
  {
    zzb(zzm(paramInt));
  }
  
  public abstract void zzc(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzc(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void zzc(long paramLong)
    throws IOException;
  
  public abstract void zzd(int paramInt)
    throws IOException;
  
  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    zzc(paramInt1, zzm(paramInt2));
  }
  
  public abstract void zze(int paramInt1, int paramInt2)
    throws IOException;
  
  private static final class zza
    extends zzhg
  {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;
    private int zze;
    
    zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      if (paramArrayOfByte != null)
      {
        if ((paramInt2 | 0x0 | paramArrayOfByte.length - paramInt2) >= 0)
        {
          this.zzb = paramArrayOfByte;
          this.zzc = 0;
          this.zze = 0;
          this.zzd = paramInt2;
          return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt2) }));
      }
      throw new NullPointerException("buffer");
    }
    
    private final void zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.zzb, this.zze, paramInt2);
        this.zze += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new zzhg.zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final int zza()
    {
      return this.zzd - this.zze;
    }
    
    public final void zza(byte paramByte)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.zzb;
        int i = this.zze;
        this.zze = (i + 1);
        arrayOfByte[i] = paramByte;
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzhg.zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zza(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzb(paramInt);
        return;
      }
      zza(paramInt);
    }
    
    public final void zza(int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt1 << 3 | paramInt2);
    }
    
    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zza(paramInt, 0);
      zza(paramLong);
    }
    
    public final void zza(int paramInt, zzgr paramzzgr)
      throws IOException
    {
      zza(paramInt, 2);
      zza(paramzzgr);
    }
    
    public final void zza(int paramInt, zzjh paramzzjh)
      throws IOException
    {
      zza(1, 3);
      zzc(2, paramInt);
      zza(3, 2);
      zza(paramzzjh);
      zza(1, 4);
    }
    
    final void zza(int paramInt, zzjh paramzzjh, zzjz paramzzjz)
      throws IOException
    {
      zza(paramInt, 2);
      zzgh localzzgh = (zzgh)paramzzjh;
      int i = localzzgh.zzbl();
      paramInt = i;
      if (i == -1)
      {
        paramInt = paramzzjz.zzb(localzzgh);
        localzzgh.zzc(paramInt);
      }
      zzb(paramInt);
      paramzzjz.zza(paramzzjh, this.zza);
    }
    
    public final void zza(int paramInt, String paramString)
      throws IOException
    {
      zza(paramInt, 2);
      zza(paramString);
    }
    
    public final void zza(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zza(paramInt, 0);
      zza((byte)paramBoolean);
    }
    
    public final void zza(long paramLong)
      throws IOException
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (zzhg.zzc())
      {
        l = paramLong;
        if (zza() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzkx.zza(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzkx.zza(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
            paramLong >>>= 7;
          }
        }
      }
      for (;;)
      {
        if ((l & 0xFFFFFFFFFFFFFF80) == 0L) {}
        try
        {
          arrayOfByte = this.zzb;
          i = this.zze;
          this.zze = (i + 1);
          arrayOfByte[i] = ((byte)(int)l);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new zzhg.zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.zzb;
        i = this.zze;
        this.zze = (i + 1);
        arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
        l >>>= 7;
      }
    }
    
    public final void zza(zzgr paramzzgr)
      throws IOException
    {
      zzb(paramzzgr.zza());
      paramzzgr.zza(this);
    }
    
    public final void zza(zzjh paramzzjh)
      throws IOException
    {
      zzb(paramzzjh.zzbo());
      paramzzjh.zza(this);
    }
    
    public final void zza(String paramString)
      throws IOException
    {
      int i = this.zze;
      try
      {
        int k = zzg(paramString.length() * 3);
        int j = zzg(paramString.length());
        if (j == k)
        {
          k = i + j;
          this.zze = k;
          k = zzla.zza(paramString, this.zzb, k, zza());
          this.zze = i;
          zzb(k - i - j);
          this.zze = k;
          return;
        }
        zzb(zzla.zza(paramString));
        this.zze = zzla.zza(paramString, this.zzb, this.zze, zza());
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzhg.zzb(paramString);
      }
      catch (zzld localzzld)
      {
        this.zze = i;
        zza(paramString, localzzld);
      }
    }
    
    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void zzb(int paramInt)
      throws IOException
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (zzhg.zzc())
      {
        i = paramInt;
        if (!zzgk.zza())
        {
          i = paramInt;
          if (zza() >= 5)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzkx.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzkx.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzkx.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzkx.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzkx.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzkx.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            paramInt >>>= 7;
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = this.zzb;
              i = this.zze;
              this.zze = (i + 1);
              zzkx.zza(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzkx.zza(arrayOfByte, i, (byte)(paramInt | 0x80));
            arrayOfByte = this.zzb;
            i = this.zze;
            this.zze = (i + 1);
            zzkx.zza(arrayOfByte, i, (byte)(paramInt >>> 7));
            return;
          }
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0) {}
        try
        {
          arrayOfByte = this.zzb;
          paramInt = this.zze;
          this.zze = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)i);
          return;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new zzhg.zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
        arrayOfByte = this.zzb;
        paramInt = this.zze;
        this.zze = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
    }
    
    public final void zzb(int paramInt1, int paramInt2)
      throws IOException
    {
      zza(paramInt1, 0);
      zza(paramInt2);
    }
    
    public final void zzb(int paramInt, zzgr paramzzgr)
      throws IOException
    {
      zza(1, 3);
      zzc(2, paramInt);
      zza(3, paramzzgr);
      zza(1, 4);
    }
    
    public final void zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzb(paramInt2);
      zzc(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zza(paramInt1, 0);
      zzb(paramInt2);
    }
    
    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zza(paramInt, 1);
      zzc(paramLong);
    }
    
    public final void zzc(long paramLong)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.zzb;
        int j = this.zze;
        int i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(int)paramLong);
        arrayOfByte = this.zzb;
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(int)(paramLong >> 8));
        arrayOfByte = this.zzb;
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(int)(paramLong >> 16));
        arrayOfByte = this.zzb;
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(int)(paramLong >> 24));
        arrayOfByte = this.zzb;
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(int)(paramLong >> 32));
        arrayOfByte = this.zzb;
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(int)(paramLong >> 40));
        arrayOfByte = this.zzb;
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(int)(paramLong >> 48));
        arrayOfByte = this.zzb;
        this.zze = (i + 1);
        arrayOfByte[i] = ((byte)(int)(paramLong >> 56));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzhg.zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zzd(int paramInt)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.zzb;
        int j = this.zze;
        int i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)paramInt);
        arrayOfByte = this.zzb;
        j = i + 1;
        this.zze = j;
        arrayOfByte[i] = ((byte)(paramInt >> 8));
        arrayOfByte = this.zzb;
        i = j + 1;
        this.zze = i;
        arrayOfByte[j] = ((byte)(paramInt >> 16));
        arrayOfByte = this.zzb;
        this.zze = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >>> 24));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzhg.zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void zze(int paramInt1, int paramInt2)
      throws IOException
    {
      zza(paramInt1, 5);
      zzd(paramInt2);
    }
  }
  
  public static final class zzb
    extends IOException
  {
    zzb()
    {
      super();
    }
    
    zzb(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    zzb(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */