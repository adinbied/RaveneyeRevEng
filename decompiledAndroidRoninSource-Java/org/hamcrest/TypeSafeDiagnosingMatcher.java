package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;

public abstract class TypeSafeDiagnosingMatcher<T>
  extends BaseMatcher<T>
{
  private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("matchesSafely", 2, 0);
  private final Class<?> expectedType;
  
  protected TypeSafeDiagnosingMatcher()
  {
    this(TYPE_FINDER);
  }
  
  protected TypeSafeDiagnosingMatcher(Class<?> paramClass)
  {
    this.expectedType = paramClass;
  }
  
  protected TypeSafeDiagnosingMatcher(ReflectiveTypeFinder paramReflectiveTypeFinder)
  {
    this.expectedType = paramReflectiveTypeFinder.findExpectedType(getClass());
  }
  
  public final void describeMismatch(Object paramObject, Description paramDescription)
  {
    if ((paramObject != null) && (this.expectedType.isInstance(paramObject)))
    {
      matchesSafely(paramObject, paramDescription);
      return;
    }
    super.describeMismatch(paramObject, paramDescription);
  }
  
  public final boolean matches(Object paramObject)
  {
    return (paramObject != null) && (this.expectedType.isInstance(paramObject)) && (matchesSafely(paramObject, new Description.NullDescription()));
  }
  
  protected abstract boolean matchesSafely(T paramT, Description paramDescription);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\TypeSafeDiagnosingMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */