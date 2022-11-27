package org.junit.runners;

import java.lang.reflect.Method;
import java.util.Comparator;
import org.junit.internal.MethodSorter;

public enum MethodSorters
{
  private final Comparator<Method> comparator;
  
  static
  {
    JVM = new MethodSorters("JVM", 1, null);
    MethodSorters localMethodSorters = new MethodSorters("DEFAULT", 2, MethodSorter.DEFAULT);
    DEFAULT = localMethodSorters;
    $VALUES = new MethodSorters[] { NAME_ASCENDING, JVM, localMethodSorters };
  }
  
  private MethodSorters(Comparator<Method> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  public Comparator<Method> getComparator()
  {
    return this.comparator;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\MethodSorters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */