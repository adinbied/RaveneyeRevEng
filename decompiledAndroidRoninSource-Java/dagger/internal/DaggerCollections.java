package dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public final class DaggerCollections
{
  private static final int MAX_POWER_OF_TWO = 1073741824;
  
  private static int calculateInitialCapacity(int paramInt)
  {
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return Integer.MAX_VALUE;
  }
  
  public static boolean hasDuplicates(List<?> paramList)
  {
    int i = paramList.size();
    boolean bool = false;
    if (i < 2) {
      return false;
    }
    HashSet localHashSet = new HashSet(paramList);
    if (paramList.size() != localHashSet.size()) {
      bool = true;
    }
    return bool;
  }
  
  static <T> HashSet<T> newHashSetWithExpectedSize(int paramInt)
  {
    return new HashSet(calculateInitialCapacity(paramInt));
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int paramInt)
  {
    return new LinkedHashMap(calculateInitialCapacity(paramInt));
  }
  
  public static <T> List<T> presizedList(int paramInt)
  {
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    return new ArrayList(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\DaggerCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */