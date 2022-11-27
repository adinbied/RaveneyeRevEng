package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zziv
  extends zzgl<Long>
  implements zzif, zzjt, RandomAccess
{
  private static final zziv zza;
  private long[] zzb;
  private int zzc;
  
  static
  {
    zziv localzziv = new zziv(new long[0], 0);
    zza = localzziv;
    localzziv.zzb();
  }
  
  zziv()
  {
    this(new long[10], 0);
  }
  
  private zziv(long[] paramArrayOfLong, int paramInt)
  {
    this.zzb = paramArrayOfLong;
    this.zzc = paramInt;
  }
  
  public static zziv zzd()
  {
    return zza;
  }
  
  private final void zzd(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zze(paramInt));
  }
  
  private final String zze(int paramInt)
  {
    int i = this.zzc;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Long> paramCollection)
  {
    zzc();
    zzic.zza(paramCollection);
    if (!(paramCollection instanceof zziv)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zziv)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      long[] arrayOfLong = this.zzb;
      if (i > arrayOfLong.length) {
        this.zzb = Arrays.copyOf(arrayOfLong, i);
      }
      System.arraycopy(paramCollection.zzb, 0, this.zzb, this.zzc, paramCollection.zzc);
      this.zzc = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zziv)) {
      return super.equals(paramObject);
    }
    paramObject = (zziv)paramObject;
    if (this.zzc != ((zziv)paramObject).zzc) {
      return false;
    }
    paramObject = ((zziv)paramObject).zzb;
    int i = 0;
    while (i < this.zzc)
    {
      if (this.zzb[i] != paramObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.zzc)
    {
      j = j * 31 + zzic.zza(this.zzb[i]);
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Long)) {
      return -1;
    }
    long l = ((Long)paramObject).longValue();
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (this.zzb[i] == l) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2)
  {
    zzc();
    if (paramInt2 >= paramInt1)
    {
      long[] arrayOfLong = this.zzb;
      System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, this.zzc - paramInt2);
      this.zzc -= paramInt2 - paramInt1;
      this.modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size()
  {
    return this.zzc;
  }
  
  public final void zza(long paramLong)
  {
    zzc();
    int i = this.zzc;
    long[] arrayOfLong1 = this.zzb;
    if (i == arrayOfLong1.length)
    {
      long[] arrayOfLong2 = new long[i * 3 / 2 + 1];
      System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, i);
      this.zzb = arrayOfLong2;
    }
    arrayOfLong1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfLong1[i] = paramLong;
  }
  
  public final long zzb(int paramInt)
  {
    zzd(paramInt);
    return this.zzb[paramInt];
  }
  
  public final zzif zzc(int paramInt)
  {
    if (paramInt >= this.zzc) {
      return new zziv(Arrays.copyOf(this.zzb, paramInt), this.zzc);
    }
    throw new IllegalArgumentException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zziv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */