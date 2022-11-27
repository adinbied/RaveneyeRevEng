package org.hamcrest;

import java.util.Arrays;
import java.util.Iterator;
import org.hamcrest.internal.ArrayIterator;
import org.hamcrest.internal.SelfDescribingValueIterator;

public abstract class BaseDescription
  implements Description
{
  private Description appendList(String paramString1, String paramString2, String paramString3, Iterator<? extends SelfDescribing> paramIterator)
  {
    append(paramString1);
    for (int i = 0; paramIterator.hasNext(); i = 1)
    {
      if (i != 0) {
        append(paramString2);
      }
      appendDescriptionOf((SelfDescribing)paramIterator.next());
    }
    append(paramString3);
    return this;
  }
  
  private <T> Description appendValueList(String paramString1, String paramString2, String paramString3, Iterator<T> paramIterator)
  {
    return appendList(paramString1, paramString2, paramString3, new SelfDescribingValueIterator(paramIterator));
  }
  
  private String descriptionOf(Object paramObject)
  {
    try
    {
      localObject = String.valueOf(paramObject);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramObject.getClass().getName());
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(Integer.toHexString(paramObject.hashCode()));
    return ((StringBuilder)localObject).toString();
  }
  
  private void toJavaSyntax(char paramChar)
  {
    if (paramChar != '\t')
    {
      if (paramChar != '\n')
      {
        if (paramChar != '\r')
        {
          if (paramChar != '"')
          {
            append(paramChar);
            return;
          }
          append("\\\"");
          return;
        }
        append("\\r");
        return;
      }
      append("\\n");
      return;
    }
    append("\\t");
  }
  
  private void toJavaSyntax(String paramString)
  {
    append('"');
    int i = 0;
    while (i < paramString.length())
    {
      toJavaSyntax(paramString.charAt(i));
      i += 1;
    }
    append('"');
  }
  
  protected abstract void append(char paramChar);
  
  protected void append(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      append(paramString.charAt(i));
      i += 1;
    }
  }
  
  public Description appendDescriptionOf(SelfDescribing paramSelfDescribing)
  {
    paramSelfDescribing.describeTo(this);
    return this;
  }
  
  public Description appendList(String paramString1, String paramString2, String paramString3, Iterable<? extends SelfDescribing> paramIterable)
  {
    return appendList(paramString1, paramString2, paramString3, paramIterable.iterator());
  }
  
  public Description appendText(String paramString)
  {
    append(paramString);
    return this;
  }
  
  public Description appendValue(Object paramObject)
  {
    if (paramObject == null)
    {
      append("null");
      return this;
    }
    if ((paramObject instanceof String))
    {
      toJavaSyntax((String)paramObject);
      return this;
    }
    if ((paramObject instanceof Character))
    {
      append('"');
      toJavaSyntax(((Character)paramObject).charValue());
      append('"');
      return this;
    }
    if ((paramObject instanceof Short))
    {
      append('<');
      append(descriptionOf(paramObject));
      append("s>");
      return this;
    }
    if ((paramObject instanceof Long))
    {
      append('<');
      append(descriptionOf(paramObject));
      append("L>");
      return this;
    }
    if ((paramObject instanceof Float))
    {
      append('<');
      append(descriptionOf(paramObject));
      append("F>");
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      appendValueList("[", ", ", "]", new ArrayIterator(paramObject));
      return this;
    }
    append('<');
    append(descriptionOf(paramObject));
    append('>');
    return this;
  }
  
  public <T> Description appendValueList(String paramString1, String paramString2, String paramString3, Iterable<T> paramIterable)
  {
    return appendValueList(paramString1, paramString2, paramString3, paramIterable.iterator());
  }
  
  public <T> Description appendValueList(String paramString1, String paramString2, String paramString3, T... paramVarArgs)
  {
    return appendValueList(paramString1, paramString2, paramString3, Arrays.asList(paramVarArgs));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\BaseDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */