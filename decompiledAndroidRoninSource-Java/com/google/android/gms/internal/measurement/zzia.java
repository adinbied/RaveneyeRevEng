package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzia
  extends zzgl<Integer>
  implements zzig, zzjt, RandomAccess
{
  private static final zzia zza;
  private int[] zzb;
  private int zzc;
  
  static
  {
    zzia localzzia = new zzia(new int[0], 0);
    zza = localzzia;
    localzzia.zzb();
  }
  
  zzia()
  {
    this(new int[10], 0);
  }
  
  private zzia(int[] paramArrayOfInt, int paramInt)
  {
    this.zzb = paramArrayOfInt;
    this.zzc = paramInt;
  }
  
  public static zzia zzd()
  {
    return zza;
  }
  
  private final void zze(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzf(paramInt));
  }
  
  private final String zzf(int paramInt)
  {
    int i = this.zzc;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Integer> paramCollection)
  {
    zzc();
    zzic.zza(paramCollection);
    if (!(paramCollection instanceof zzia)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzia)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      int[] arrayOfInt = this.zzb;
      if (i > arrayOfInt.length) {
        this.zzb = Arrays.copyOf(arrayOfInt, i);
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
    if (!(paramObject instanceof zzia)) {
      return super.equals(paramObject);
    }
    paramObject = (zzia)paramObject;
    if (this.zzc != ((zzia)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzia)paramObject).zzb;
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
      j = j * 31 + this.zzb[i];
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return -1;
    }
    int j = ((Integer)paramObject).intValue();
    int k = size();
    int i = 0;
    while (i < k)
    {
      if (this.zzb[i] == j) {
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
      int[] arrayOfInt = this.zzb;
      System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.zzc - paramInt2);
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
  
  public final zzig zzb(int paramInt)
  {
    if (paramInt >= this.zzc) {
      return new zzia(Arrays.copyOf(this.zzb, paramInt), this.zzc);
    }
    throw new IllegalArgumentException();
  }
  
  public final int zzc(int paramInt)
  {
    zze(paramInt);
    return this.zzb[paramInt];
  }
  
  public final void zzd(int paramInt)
  {
    zzc();
    int i = this.zzc;
    int[] arrayOfInt1 = this.zzb;
    if (i == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      this.zzb = arrayOfInt2;
    }
    arrayOfInt1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */