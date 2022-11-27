package org.junit;

import org.hamcrest.Matcher;

public class AssumptionViolatedException
  extends org.junit.internal.AssumptionViolatedException
{
  private static final long serialVersionUID = 1L;
  
  public <T> AssumptionViolatedException(T paramT, Matcher<T> paramMatcher)
  {
    super(paramT, paramMatcher);
  }
  
  public AssumptionViolatedException(String paramString)
  {
    super(paramString);
  }
  
  public <T> AssumptionViolatedException(String paramString, T paramT, Matcher<T> paramMatcher)
  {
    super(paramString, paramT, paramMatcher);
  }
  
  public AssumptionViolatedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\AssumptionViolatedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */