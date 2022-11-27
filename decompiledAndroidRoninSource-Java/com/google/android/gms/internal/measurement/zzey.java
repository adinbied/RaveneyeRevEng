package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzey<E>
  extends AbstractCollection<E>
  implements Serializable
{
  private static final Object[] zza = new Object[0];
  
  @Deprecated
  public final boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@NullableDecl Object paramObject);
  
  @Deprecated
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray()
  {
    return toArray(zza);
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    zzeb.zza(paramArrayOfT);
    int i = size();
    Object localObject;
    if (paramArrayOfT.length < i)
    {
      localObject = zzb();
      if (localObject != null) {
        return Arrays.copyOfRange((Object[])localObject, zzc(), zzd(), paramArrayOfT.getClass());
      }
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    else
    {
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > i)
      {
        paramArrayOfT[i] = null;
        localObject = paramArrayOfT;
      }
    }
    zza((Object[])localObject, 0);
    return (T[])localObject;
  }
  
  int zza(Object[] paramArrayOfObject, int paramInt)
  {
    zzfx localzzfx = (zzfx)iterator();
    while (localzzfx.hasNext())
    {
      paramArrayOfObject[paramInt] = localzzfx.next();
      paramInt += 1;
    }
    return paramInt;
  }
  
  public abstract zzfx<E> zza();
  
  @NullableDecl
  Object[] zzb()
  {
    return null;
  }
  
  int zzc()
  {
    throw new UnsupportedOperationException();
  }
  
  int zzd()
  {
    throw new UnsupportedOperationException();
  }
  
  public zzfb<E> zze()
  {
    if (isEmpty()) {
      return zzfb.zzg();
    }
    return zzfb.zza(toArray());
  }
  
  abstract boolean zzf();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */