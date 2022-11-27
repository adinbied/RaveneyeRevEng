package org.hamcrest;

public abstract interface Matcher<T>
  extends SelfDescribing
{
  @Deprecated
  public abstract void _dont_implement_Matcher___instead_extend_BaseMatcher_();
  
  public abstract void describeMismatch(Object paramObject, Description paramDescription);
  
  public abstract boolean matches(Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\Matcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */