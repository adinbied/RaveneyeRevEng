package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzgh<MessageType extends zzgh<MessageType, BuilderType>, BuilderType extends zzgg<MessageType, BuilderType>>
  implements zzjh
{
  protected int zza = 0;
  
  protected static <T> void zza(Iterable<T> paramIterable, List<? super T> paramList)
  {
    zzic.zza(paramIterable);
    Object localObject;
    int i;
    if ((paramIterable instanceof zzis))
    {
      localObject = ((zzis)paramIterable).zzd();
      paramIterable = (zzis)paramList;
      j = paramList.size();
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = paramList.next();
        if (localObject == null)
        {
          i = paramIterable.size();
          paramList = new StringBuilder(37);
          paramList.append("Element at index ");
          paramList.append(i - j);
          paramList.append(" is null.");
          paramList = paramList.toString();
          i = paramIterable.size() - 1;
          while (i >= j)
          {
            paramIterable.remove(i);
            i -= 1;
          }
          throw new NullPointerException(paramList);
        }
        if ((localObject instanceof zzgr)) {
          paramIterable.zza((zzgr)localObject);
        } else {
          paramIterable.add((String)localObject);
        }
      }
      return;
    }
    if ((paramIterable instanceof zzjt))
    {
      paramList.addAll((Collection)paramIterable);
      return;
    }
    if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection))) {
      ((ArrayList)paramList).ensureCapacity(paramList.size() + ((Collection)paramIterable).size());
    }
    int j = paramList.size();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localObject = paramIterable.next();
      if (localObject == null)
      {
        i = paramList.size();
        paramIterable = new StringBuilder(37);
        paramIterable.append("Element at index ");
        paramIterable.append(i - j);
        paramIterable.append(" is null.");
        paramIterable = paramIterable.toString();
        i = paramList.size() - 1;
        while (i >= j)
        {
          paramList.remove(i);
          i -= 1;
        }
        throw new NullPointerException(paramIterable);
      }
      paramList.add(localObject);
    }
  }
  
  public final zzgr zzbj()
  {
    try
    {
      Object localObject = zzgr.zzc(zzbo());
      zza(((zzgz)localObject).zzb());
      localObject = ((zzgz)localObject).zza();
      return (zzgr)localObject;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 62 + "ByteString".length());
      localStringBuilder.append("Serializing ");
      localStringBuilder.append(str);
      localStringBuilder.append(" to a ");
      localStringBuilder.append("ByteString");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public final byte[] zzbk()
  {
    try
    {
      byte[] arrayOfByte = new byte[zzbo()];
      localObject = zzhg.zza(arrayOfByte);
      zza((zzhg)localObject);
      ((zzhg)localObject).zzb();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Object localObject = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 62 + "byte array".length());
      localStringBuilder.append("Serializing ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" to a ");
      localStringBuilder.append("byte array");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  int zzbl()
  {
    throw new UnsupportedOperationException();
  }
  
  void zzc(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */