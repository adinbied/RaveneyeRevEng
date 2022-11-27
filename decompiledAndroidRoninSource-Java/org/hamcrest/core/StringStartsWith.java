package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringStartsWith
  extends SubstringMatcher
{
  public StringStartsWith(String paramString)
  {
    super(paramString);
  }
  
  @Factory
  public static Matcher<String> startsWith(String paramString)
  {
    return new StringStartsWith(paramString);
  }
  
  protected boolean evalSubstringOf(String paramString)
  {
    return paramString.startsWith(this.substring);
  }
  
  protected String relationship()
  {
    return "starting with";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\core\StringStartsWith.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */