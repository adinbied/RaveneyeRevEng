package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzhl
  extends zzgl<Double>
  implements zzii<Double>, zzjt, RandomAccess
{
  private static final zzhl zza;
  private double[] zzb;
  private int zzc;
  
  static
  {
    zzhl localzzhl = new zzhl(new double[0], 0);
    zza = localzzhl;
    localzzhl.zzb();
  }
  
  zzhl()
  {
    this(new double[10], 0);
  }
  
  private zzhl(double[] paramArrayOfDouble, int paramInt)
  {
    this.zzb = paramArrayOfDouble;
    this.zzc = paramInt;
  }
  
  private final void zzb(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzc)) {
      return;
    }
    throw new IndexOutOfBoundsException(zzc(paramInt));
  }
  
  private final String zzc(int paramInt)
  {
    int i = this.zzc;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Double> paramCollection)
  {
    zzc();
    zzic.zza(paramCollection);
    if (!(paramCollection instanceof zzhl)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzhl)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      double[] arrayOfDouble = this.zzb;
      if (i > arrayOfDouble.length) {
        this.zzb = Arrays.copyOf(arrayOfDouble, i);
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
    if (!(paramObject instanceof zzhl)) {
      return super.equals(paramObject);
    }
    paramObject = (zzhl)paramObject;
    if (this.zzc != ((zzhl)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzhl)paramObject).zzb;
    int i = 0;
    while (i < this.zzc)
    {
      if (Double.doubleToLongBits(this.zzb[i]) != Double.doubleToLongBits(paramObject[i])) {
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
      j = j * 31 + zzic.zza(Double.doubleToLongBits(this.zzb[i]));
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Double)) {
      return -1;
    }
    double d = ((Double)paramObject).doubleValue();
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (this.zzb[i] == d) {
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
      double[] arrayOfDouble = this.zzb;
      System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, this.zzc - paramInt2);
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
  
  public final void zza(double paramDouble)
  {
    zzc();
    int i = this.zzc;
    double[] arrayOfDouble1 = this.zzb;
    if (i == arrayOfDouble1.length)
    {
      double[] arrayOfDouble2 = new double[i * 3 / 2 + 1];
      System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, 0, i);
      this.zzb = arrayOfDouble2;
    }
    arrayOfDouble1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfDouble1[i] = paramDouble;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */