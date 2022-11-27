package org.hamcrest;

public abstract class DiagnosingMatcher<T>
  extends BaseMatcher<T>
{
  public final void describeMismatch(Object paramObject, Description paramDescription)
  {
    matches(paramObject, paramDescription);
  }
  
  public final boolean matches(Object paramObject)
  {
    return matches(paramObject, Description.NONE);
  }
  
  protected abstract boolean matches(Object paramObject, Description paramDescription);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\DiagnosingMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */