package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

public final class PriorityMapping
{
  private static EnumMap<Priority, Integer> PRIORITY_INT_MAP;
  private static SparseArray<Priority> PRIORITY_MAP = new SparseArray();
  
  static
  {
    Object localObject = new EnumMap(Priority.class);
    PRIORITY_INT_MAP = (EnumMap)localObject;
    ((EnumMap)localObject).put(Priority.DEFAULT, Integer.valueOf(0));
    PRIORITY_INT_MAP.put(Priority.VERY_LOW, Integer.valueOf(1));
    PRIORITY_INT_MAP.put(Priority.HIGHEST, Integer.valueOf(2));
    localObject = PRIORITY_INT_MAP.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Priority localPriority = (Priority)((Iterator)localObject).next();
      PRIORITY_MAP.append(((Integer)PRIORITY_INT_MAP.get(localPriority)).intValue(), localPriority);
    }
  }
  
  public static int toInt(Priority paramPriority)
  {
    Object localObject = (Integer)PRIORITY_INT_MAP.get(paramPriority);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PriorityMapping is missing known Priority value ");
    ((StringBuilder)localObject).append(paramPriority);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static Priority valueOf(int paramInt)
  {
    Object localObject = (Priority)PRIORITY_MAP.get(paramInt);
    if (localObject != null) {
      return (Priority)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown Priority for value ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtim\\util\PriorityMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */