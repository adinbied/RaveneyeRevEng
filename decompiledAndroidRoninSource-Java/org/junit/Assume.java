package org.junit;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

public class Assume
{
  public static void assumeFalse(String paramString, boolean paramBoolean)
  {
    assumeTrue(paramString, paramBoolean ^ true);
  }
  
  public static void assumeFalse(boolean paramBoolean)
  {
    assumeTrue(paramBoolean ^ true);
  }
  
  public static void assumeNoException(String paramString, Throwable paramThrowable)
  {
    assumeThat(paramString, paramThrowable, CoreMatchers.nullValue());
  }
  
  public static void assumeNoException(Throwable paramThrowable)
  {
    assumeThat(paramThrowable, CoreMatchers.nullValue());
  }
  
  public static void assumeNotNull(Object... paramVarArgs)
  {
    assumeThat(Arrays.asList(paramVarArgs), CoreMatchers.everyItem(CoreMatchers.notNullValue()));
  }
  
  public static <T> void assumeThat(T paramT, Matcher<T> paramMatcher)
  {
    if (paramMatcher.matches(paramT)) {
      return;
    }
    throw new AssumptionViolatedException(paramT, paramMatcher);
  }
  
  public static <T> void assumeThat(String paramString, T paramT, Matcher<T> paramMatcher)
  {
    if (paramMatcher.matches(paramT)) {
      return;
    }
    throw new AssumptionViolatedException(paramString, paramT, paramMatcher);
  }
  
  public static void assumeTrue(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssumptionViolatedException(paramString);
  }
  
  public static void assumeTrue(boolean paramBoolean)
  {
    assumeThat(Boolean.valueOf(paramBoolean), CoreMatchers.is(Boolean.valueOf(true)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\Assume.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */