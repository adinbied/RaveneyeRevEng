package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzfb<E>
  extends zzey<E>
  implements List<E>, RandomAccess
{
  private static final zzfw<Object> zza = new zzfa(zzfm.zza, 0);
  
  public static <E> zzfb<E> zza(E paramE)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramE;
    int i = 0;
    while (i <= 0)
    {
      zzfn.zza(arrayOfObject[0], 0);
      i += 1;
    }
    return zzb(arrayOfObject, 1);
  }
  
  static <E> zzfb<E> zza(Object[] paramArrayOfObject)
  {
    return zzb(paramArrayOfObject, paramArrayOfObject.length);
  }
  
  static <E> zzfb<E> zzb(Object[] paramArrayOfObject, int paramInt)
  {
    if (paramInt == 0) {
      return zzfm.zza;
    }
    return new zzfm(paramArrayOfObject, paramInt);
  }
  
  public static <E> zzfb<E> zzg()
  {
    return zzfm.zza;
  }
  
  @Deprecated
  public final void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(@NullableDecl Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == zzeb.zza(this)) {
      return true;
    }
    if ((paramObject instanceof List))
    {
      Object localObject1 = (List)paramObject;
      int j = size();
      if (j == ((List)localObject1).size())
      {
        if (((this instanceof RandomAccess)) && ((localObject1 instanceof RandomAccess)))
        {
          i = 0;
          while (i < j)
          {
            if (!zzdz.zza(get(i), ((List)localObject1).get(i))) {
              break label170;
            }
            i += 1;
          }
          return true;
        }
        paramObject = (zzfb)this;
        j = ((zzfb)paramObject).size();
        localObject1 = ((List)localObject1).iterator();
        int i = 0;
        while (i < j)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label170;
          }
          Object localObject2 = ((zzfb)paramObject).get(i);
          i += 1;
          if (!zzdz.zza(localObject2, ((Iterator)localObject1).next())) {
            break label170;
          }
        }
        if (!((Iterator)localObject1).hasNext()) {
          return true;
        }
      }
    }
    label170:
    return false;
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
  
  public int indexOf(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    if ((this instanceof RandomAccess))
    {
      int k = size();
      int i = 0;
      int j = 0;
      if (paramObject == null)
      {
        i = j;
        while (i < k)
        {
          if (get(i) == null) {
            return i;
          }
          i += 1;
        }
      }
      while (i < k)
      {
        if (paramObject.equals(get(i))) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    ListIterator localListIterator = listIterator();
    while (localListIterator.hasNext()) {
      if (zzdz.zza(paramObject, localListIterator.next())) {
        return localListIterator.previousIndex();
      }
    }
    return -1;
  }
  
  public int lastIndexOf(@NullableDecl Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    if ((this instanceof RandomAccess))
    {
      if (paramObject == null)
      {
        i = size() - 1;
        while (i >= 0)
        {
          if (get(i) == null) {
            return i;
          }
          i -= 1;
        }
      }
      int i = size() - 1;
      while (i >= 0)
      {
        if (paramObject.equals(get(i))) {
          return i;
        }
        i -= 1;
      }
      return -1;
    }
    ListIterator localListIterator = listIterator(size());
    while (localListIterator.hasPrevious()) {
      if (zzdz.zza(paramObject, localListIterator.previous())) {
        return localListIterator.nextIndex();
      }
    }
    return -1;
  }
  
  @Deprecated
  public final E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  int zza(Object[] paramArrayOfObject, int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfObject[(paramInt + i)] = get(i);
      i += 1;
    }
    return paramInt + j;
  }
  
  public zzfb<E> zza(int paramInt1, int paramInt2)
  {
    zzeb.zza(paramInt1, paramInt2, size());
    paramInt2 -= paramInt1;
    if (paramInt2 == size()) {
      return this;
    }
    if (paramInt2 == 0) {
      return zzfm.zza;
    }
    return new zzfd(this, paramInt1, paramInt2);
  }
  
  public final zzfx<E> zza()
  {
    return (zzfw)listIterator();
  }
  
  public final zzfb<E> zze()
  {
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */