package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzhv
  extends zzgl<Float>
  implements zzii<Float>, zzjt, RandomAccess
{
  private static final zzhv zza;
  private float[] zzb;
  private int zzc;
  
  static
  {
    zzhv localzzhv = new zzhv(new float[0], 0);
    zza = localzzhv;
    localzzhv.zzb();
  }
  
  zzhv()
  {
    this(new float[10], 0);
  }
  
  private zzhv(float[] paramArrayOfFloat, int paramInt)
  {
    this.zzb = paramArrayOfFloat;
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
  
  public final boolean addAll(Collection<? extends Float> paramCollection)
  {
    zzc();
    zzic.zza(paramCollection);
    if (!(paramCollection instanceof zzhv)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzhv)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      float[] arrayOfFloat = this.zzb;
      if (i > arrayOfFloat.length) {
        this.zzb = Arrays.copyOf(arrayOfFloat, i);
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
    if (!(paramObject instanceof zzhv)) {
      return super.equals(paramObject);
    }
    paramObject = (zzhv)paramObject;
    if (this.zzc != ((zzhv)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzhv)paramObject).zzb;
    int i = 0;
    while (i < this.zzc)
    {
      if (Float.floatToIntBits(this.zzb[i]) != Float.floatToIntBits(paramObject[i])) {
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
      j = j * 31 + Float.floatToIntBits(this.zzb[i]);
      i += 1;
    }
    return j;
  }
  
  public final int indexOf(Object paramObject)
  {
    if (!(paramObject instanceof Float)) {
      return -1;
    }
    float f = ((Float)paramObject).floatValue();
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (this.zzb[i] == f) {
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
      float[] arrayOfFloat = this.zzb;
      System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, this.zzc - paramInt2);
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
  
  public final void zza(float paramFloat)
  {
    zzc();
    int i = this.zzc;
    float[] arrayOfFloat1 = this.zzb;
    if (i == arrayOfFloat1.length)
    {
      float[] arrayOfFloat2 = new float[i * 3 / 2 + 1];
      System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, i);
      this.zzb = arrayOfFloat2;
    }
    arrayOfFloat1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfFloat1[i] = paramFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */