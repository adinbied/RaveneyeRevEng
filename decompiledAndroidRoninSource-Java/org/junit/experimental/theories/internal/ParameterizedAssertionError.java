package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ParameterizedAssertionError
  extends AssertionError
{
  private static final long serialVersionUID = 1L;
  
  public ParameterizedAssertionError(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    super(String.format("%s(%s)", new Object[] { paramString, join(", ", paramVarArgs) }));
    initCause(paramThrowable);
  }
  
  public static String join(String paramString, Collection<Object> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localStringBuilder.append(stringValueOf(paramCollection.next()));
      if (paramCollection.hasNext()) {
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String join(String paramString, Object... paramVarArgs)
  {
    return join(paramString, Arrays.asList(paramVarArgs));
  }
  
  private static String stringValueOf(Object paramObject)
  {
    try
    {
      paramObject = String.valueOf(paramObject);
      return (String)paramObject;
    }
    finally
    {
      for (;;) {}
    }
    return "[toString failed]";
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ParameterizedAssertionError)) && (toString().equals(paramObject.toString()));
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\internal\ParameterizedAssertionError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */