package org.hamcrest;

public abstract class BaseMatcher<T>
  implements Matcher<T>
{
  @Deprecated
  public final void _dont_implement_Matcher___instead_extend_BaseMatcher_() {}
  
  public void describeMismatch(Object paramObject, Description paramDescription)
  {
    paramDescription.appendText("was ").appendValue(paramObject);
  }
  
  public String toString()
  {
    return StringDescription.toString(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\BaseMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */