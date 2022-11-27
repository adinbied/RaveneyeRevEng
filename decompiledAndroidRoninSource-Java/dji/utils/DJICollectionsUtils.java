package dji.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public final class DJICollectionsUtils
{
  public static <T> boolean equals(List<T> paramList1, List<T> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      if (paramList1.size() != paramList2.size()) {
        return false;
      }
      int j = paramList1.size();
      int i = 0;
      while (i < j)
      {
        if (!Objects.equals(paramList1.get(i), paramList2.get(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isEmpty(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static boolean isEmpty(Map<?, ?> paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }
  
  public static boolean isOutOfBound(Collection<?> paramCollection, int paramInt)
  {
    return (isEmpty(paramCollection)) || (paramInt < 0) || (paramInt >= paramCollection.size());
  }
  
  public static int safeSize(Collection<?> paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
  
  public static int safeSize(Map<?, ?> paramMap)
  {
    if (paramMap == null) {
      return 0;
    }
    return paramMap.size();
  }
  
  public static <T> T[] toArray(Collection<T> paramCollection, Class<T> paramClass)
  {
    if (isEmpty(paramCollection)) {
      return (Object[])Array.newInstance(paramClass, 0);
    }
    return paramCollection.toArray((Object[])Array.newInstance(paramClass, paramCollection.size()));
  }
  
  public static <T> List<T> trim(List<T> paramList)
  {
    if (paramList == null) {
      return Collections.emptyList();
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    return paramList;
  }
  
  public static <K, V> Map<K, V> trim(Map<K, V> paramMap)
  {
    if (paramMap == null) {
      return Collections.emptyMap();
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if ((Map.Entry)localIterator.next() == null) {
        localIterator.remove();
      }
    }
    return paramMap;
  }
  
  public static <T> Set<T> trim(Set<T> paramSet)
  {
    if (paramSet == null) {
      return Collections.emptySet();
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    return paramSet;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\DJICollectionsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */