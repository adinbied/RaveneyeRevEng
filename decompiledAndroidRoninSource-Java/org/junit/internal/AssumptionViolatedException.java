package org.junit.internal;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

public class AssumptionViolatedException
  extends RuntimeException
  implements SelfDescribing
{
  private static final long serialVersionUID = 2L;
  private final String fAssumption;
  private final Matcher<?> fMatcher;
  private final Object fValue;
  private final boolean fValueMatcher;
  
  @Deprecated
  public AssumptionViolatedException(Object paramObject, Matcher<?> paramMatcher)
  {
    this(null, true, paramObject, paramMatcher);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString)
  {
    this(paramString, false, null, null);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString, Object paramObject, Matcher<?> paramMatcher)
  {
    this(paramString, true, paramObject, paramMatcher);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString, Throwable paramThrowable)
  {
    this(paramString, false, null, null);
    initCause(paramThrowable);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString, boolean paramBoolean, Object paramObject, Matcher<?> paramMatcher)
  {
    this.fAssumption = paramString;
    this.fValue = paramObject;
    this.fMatcher = paramMatcher;
    this.fValueMatcher = paramBoolean;
    if ((paramObject instanceof Throwable)) {
      initCause((Throwable)paramObject);
    }
  }
  
  public void describeTo(Description paramDescription)
  {
    String str = this.fAssumption;
    if (str != null) {
      paramDescription.appendText(str);
    }
    if (this.fValueMatcher)
    {
      if (this.fAssumption != null) {
        paramDescription.appendText(": ");
      }
      paramDescription.appendText("got: ");
      paramDescription.appendValue(this.fValue);
      if (this.fMatcher != null)
      {
        paramDescription.appendText(", expected: ");
        paramDescription.appendDescriptionOf(this.fMatcher);
      }
    }
  }
  
  public String getMessage()
  {
    return StringDescription.asString(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\AssumptionViolatedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */