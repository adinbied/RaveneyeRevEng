package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsInstanceOf
  extends DiagnosingMatcher<Object>
{
  private final Class<?> expectedClass;
  private final Class<?> matchableClass;
  
  public IsInstanceOf(Class<?> paramClass)
  {
    this.expectedClass = paramClass;
    this.matchableClass = matchableClass(paramClass);
  }
  
  @Factory
  public static <T> Matcher<T> any(Class<T> paramClass)
  {
    return new IsInstanceOf(paramClass);
  }
  
  @Factory
  public static <T> Matcher<T> instanceOf(Class<?> paramClass)
  {
    return new IsInstanceOf(paramClass);
  }
  
  private static Class<?> matchableClass(Class<?> paramClass)
  {
    if (Boolean.TYPE.equals(paramClass)) {
      return Boolean.class;
    }
    if (Byte.TYPE.equals(paramClass)) {
      return Byte.class;
    }
    if (Character.TYPE.equals(paramClass)) {
      return Character.class;
    }
    if (Double.TYPE.equals(paramClass)) {
      return Double.class;
    }
    if (Float.TYPE.equals(paramClass)) {
      return Float.class;
    }
    if (Integer.TYPE.equals(paramClass)) {
      return Integer.class;
    }
    if (Long.TYPE.equals(paramClass)) {
      return Long.class;
    }
    Object localObject = paramClass;
    if (Short.TYPE.equals(paramClass)) {
      localObject = Short.class;
    }
    return (Class<?>)localObject;
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("an instance of ").appendText(this.expectedClass.getName());
  }
  
  protected boolean matches(Object paramObject, Description paramDescription)
  {
    if (paramObject == null)
    {
      paramDescription.appendText("null");
      return false;
    }
    if (!this.matchableClass.isInstance(paramObject))
    {
      paramDescription = paramDescription.appendValue(paramObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" is a ");
      localStringBuilder.append(paramObject.getClass().getName());
      paramDescription.appendText(localStringBuilder.toString());
      return false;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\core\IsInstanceOf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */