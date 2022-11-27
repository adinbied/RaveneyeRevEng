package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzgl<E>
  extends AbstractList<E>
  implements zzii<E>
{
  private boolean zza = true;
  
  public void add(int paramInt, E paramE)
  {
    zzc();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    zzc();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    zzc();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    zzc();
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    zzc();
    super.clear();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    if (!(paramObject instanceof RandomAccess)) {
      return super.equals(paramObject);
    }
    paramObject = (List)paramObject;
    int j = size();
    if (j != ((List)paramObject).size()) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!get(i).equals(((List)paramObject).get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    int k = size();
    int j = 1;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode();
      i += 1;
    }
    return j;
  }
  
  public E remove(int paramInt)
  {
    zzc();
    return (E)super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    zzc();
    int i = indexOf(paramObject);
    if (i == -1) {
      return false;
    }
    remove(i);
    return true;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    zzc();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    zzc();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    zzc();
    return (E)super.set(paramInt, paramE);
  }
  
  public boolean zza()
  {
    return this.zza;
  }
  
  public final void zzb()
  {
    this.zza = false;
  }
  
  protected final void zzc()
  {
    if (this.zza) {
      return;
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */