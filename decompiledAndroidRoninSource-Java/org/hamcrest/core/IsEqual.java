package org.hamcrest.core;

import java.lang.reflect.Array;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsEqual<T>
  extends BaseMatcher<T>
{
  private final Object expectedValue;
  
  public IsEqual(T paramT)
  {
    this.expectedValue = paramT;
  }
  
  private static boolean areArrayElementsEqual(Object paramObject1, Object paramObject2)
  {
    int i = 0;
    while (i < Array.getLength(paramObject1))
    {
      if (!areEqual(Array.get(paramObject1, i), Array.get(paramObject2, i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean areArrayLengthsEqual(Object paramObject1, Object paramObject2)
  {
    return Array.getLength(paramObject1) == Array.getLength(paramObject2);
  }
  
  private static boolean areArraysEqual(Object paramObject1, Object paramObject2)
  {
    return (areArrayLengthsEqual(paramObject1, paramObject2)) && (areArrayElementsEqual(paramObject1, paramObject2));
  }
  
  private static boolean areEqual(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    if ((paramObject2 != null) && (isArray(paramObject1))) {
      return (isArray(paramObject2)) && (areArraysEqual(paramObject1, paramObject2));
    }
    return paramObject1.equals(paramObject2);
  }
  
  @Factory
  public static <T> Matcher<T> equalTo(T paramT)
  {
    return new IsEqual(paramT);
  }
  
  private static boolean isArray(Object paramObject)
  {
    return paramObject.getClass().isArray();
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendValue(this.expectedValue);
  }
  
  public boolean matches(Object paramObject)
  {
    return areEqual(paramObject, this.expectedValue);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\core\IsEqual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */