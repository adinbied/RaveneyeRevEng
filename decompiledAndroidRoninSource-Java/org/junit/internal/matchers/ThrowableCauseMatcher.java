package org.junit.internal.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ThrowableCauseMatcher<T extends Throwable>
  extends TypeSafeMatcher<T>
{
  private final Matcher<? extends Throwable> causeMatcher;
  
  public ThrowableCauseMatcher(Matcher<? extends Throwable> paramMatcher)
  {
    this.causeMatcher = paramMatcher;
  }
  
  @Factory
  public static <T extends Throwable> Matcher<T> hasCause(Matcher<? extends Throwable> paramMatcher)
  {
    return new ThrowableCauseMatcher(paramMatcher);
  }
  
  protected void describeMismatchSafely(T paramT, Description paramDescription)
  {
    paramDescription.appendText("cause ");
    this.causeMatcher.describeMismatch(paramT.getCause(), paramDescription);
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("exception with cause ");
    paramDescription.appendDescriptionOf(this.causeMatcher);
  }
  
  protected boolean matchesSafely(T paramT)
  {
    return this.causeMatcher.matches(paramT.getCause());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\matchers\ThrowableCauseMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */