package org.junit.internal.matchers;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StacktracePrintingMatcher<T extends Throwable>
  extends TypeSafeMatcher<T>
{
  private final Matcher<T> throwableMatcher;
  
  public StacktracePrintingMatcher(Matcher<T> paramMatcher)
  {
    this.throwableMatcher = paramMatcher;
  }
  
  @Factory
  public static <T extends Exception> Matcher<T> isException(Matcher<T> paramMatcher)
  {
    return new StacktracePrintingMatcher(paramMatcher);
  }
  
  @Factory
  public static <T extends Throwable> Matcher<T> isThrowable(Matcher<T> paramMatcher)
  {
    return new StacktracePrintingMatcher(paramMatcher);
  }
  
  private String readStacktrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  protected void describeMismatchSafely(T paramT, Description paramDescription)
  {
    this.throwableMatcher.describeMismatch(paramT, paramDescription);
    paramDescription.appendText("\nStacktrace was: ");
    paramDescription.appendText(readStacktrace(paramT));
  }
  
  public void describeTo(Description paramDescription)
  {
    this.throwableMatcher.describeTo(paramDescription);
  }
  
  protected boolean matchesSafely(T paramT)
  {
    return this.throwableMatcher.matches(paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\matchers\StacktracePrintingMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */