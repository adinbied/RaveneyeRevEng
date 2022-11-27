package org.junit.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

public class MethodSorter
{
  public static final Comparator<Method> DEFAULT = new Comparator()
  {
    public int compare(Method paramAnonymousMethod1, Method paramAnonymousMethod2)
    {
      int i = paramAnonymousMethod1.getName().hashCode();
      int j = paramAnonymousMethod2.getName().hashCode();
      if (i != j)
      {
        if (i < j) {
          return -1;
        }
        return 1;
      }
      return MethodSorter.NAME_ASCENDING.compare(paramAnonymousMethod1, paramAnonymousMethod2);
    }
  };
  public static final Comparator<Method> NAME_ASCENDING = new Comparator()
  {
    public int compare(Method paramAnonymousMethod1, Method paramAnonymousMethod2)
    {
      int i = paramAnonymousMethod1.getName().compareTo(paramAnonymousMethod2.getName());
      if (i != 0) {
        return i;
      }
      return paramAnonymousMethod1.toString().compareTo(paramAnonymousMethod2.toString());
    }
  };
  
  public static Method[] getDeclaredMethods(Class<?> paramClass)
  {
    Comparator localComparator = getSorter((FixMethodOrder)paramClass.getAnnotation(FixMethodOrder.class));
    paramClass = paramClass.getDeclaredMethods();
    if (localComparator != null) {
      Arrays.sort(paramClass, localComparator);
    }
    return paramClass;
  }
  
  private static Comparator<Method> getSorter(FixMethodOrder paramFixMethodOrder)
  {
    if (paramFixMethodOrder == null) {
      return DEFAULT;
    }
    return paramFixMethodOrder.value().getComparator();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\MethodSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */