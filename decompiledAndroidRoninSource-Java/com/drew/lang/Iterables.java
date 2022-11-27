package com.drew.lang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Iterables
{
  public static <E> List<E> toList(Iterable<E> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramIterable.next());
    }
    return localArrayList;
  }
  
  public static <E> Set<E> toSet(Iterable<E> paramIterable)
  {
    HashSet localHashSet = new HashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localHashSet.add(paramIterable.next());
    }
    return localHashSet;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\Iterables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */