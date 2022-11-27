package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.matchers.JUnitMatchers;

class ExpectedExceptionMatcherBuilder
{
  private final List<Matcher<?>> matchers = new ArrayList();
  
  private Matcher<Throwable> allOfTheMatchers()
  {
    if (this.matchers.size() == 1) {
      return cast((Matcher)this.matchers.get(0));
    }
    return CoreMatchers.allOf(castedMatchers());
  }
  
  private Matcher<Throwable> cast(Matcher<?> paramMatcher)
  {
    return paramMatcher;
  }
  
  private List<Matcher<? super Throwable>> castedMatchers()
  {
    return new ArrayList(this.matchers);
  }
  
  void add(Matcher<?> paramMatcher)
  {
    this.matchers.add(paramMatcher);
  }
  
  Matcher<Throwable> build()
  {
    return JUnitMatchers.isThrowable(allOfTheMatchers());
  }
  
  boolean expectsThrowable()
  {
    return this.matchers.isEmpty() ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\ExpectedExceptionMatcherBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */