package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgp
  extends zzgl<Boolean>
  implements zzii<Boolean>, zzjt, RandomAccess
{
  private static final zzgp zza;
  private boolean[] zzb;
  private int zzc;
  
  static
  {
    zzgp localzzgp = new zzgp(new boolean[0], 0);
    zza = localzzgp;
    localzzgp.zzb();
  }
  
  zzgp()
  {
    this(new boolean[10], 0);
  }
  
  private zzgp(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.zzb = paramArrayOfBoolean;
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
  
  public final boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    zzc();
    zzic.zza(paramCollection);
    if (!(paramCollection instanceof zzgp)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (zzgp)paramCollection;
    int i = paramCollection.zzc;
    if (i == 0) {
      return false;
    }
    int j = this.zzc;
    if (Integer.MAX_VALUE - j >= i)
    {
      i = j + i;
      boolean[] arrayOfBoolean = this.zzb;
      if (i > arrayOfBoolean.length) {
        this.zzb = Arrays.copyOf(arrayOfBoolean, i);
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
    if (!(paramObject instanceof zzgp)) {
      return super.equals(paramObject);
    }
    paramObject = (zzgp)paramObject;
    if (this.zzc != ((zzgp)paramObject).zzc) {
      return false;
    }
    paramObject = ((zzgp)paramObject).zzb;
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
    if (!(paramObject instanceof Boolean)) {
      return -1;
    }
    int k = ((Boolean)paramObject).booleanValue();
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (this.zzb[i] == k) {
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
      boolean[] arrayOfBoolean = this.zzb;
      System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, this.zzc - paramInt2);
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
  
  public final void zza(boolean paramBoolean)
  {
    zzc();
    int i = this.zzc;
    boolean[] arrayOfBoolean1 = this.zzb;
    if (i == arrayOfBoolean1.length)
    {
      boolean[] arrayOfBoolean2 = new boolean[i * 3 / 2 + 1];
      System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, 0, i);
      this.zzb = arrayOfBoolean2;
    }
    arrayOfBoolean1 = this.zzb;
    i = this.zzc;
    this.zzc = (i + 1);
    arrayOfBoolean1[i] = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */