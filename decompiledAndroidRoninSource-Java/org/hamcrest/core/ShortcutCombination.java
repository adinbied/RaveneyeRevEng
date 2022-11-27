package org.hamcrest.core;

import java.util.Iterator;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

abstract class ShortcutCombination<T>
  extends BaseMatcher<T>
{
  private final Iterable<Matcher<? super T>> matchers;
  
  public ShortcutCombination(Iterable<Matcher<? super T>> paramIterable)
  {
    this.matchers = paramIterable;
  }
  
  public abstract void describeTo(Description paramDescription);
  
  public void describeTo(Description paramDescription, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    paramDescription.appendList("(", localStringBuilder.toString(), ")", this.matchers);
  }
  
  public abstract boolean matches(Object paramObject);
  
  protected boolean matches(Object paramObject, boolean paramBoolean)
  {
    Iterator localIterator = this.matchers.iterator();
    while (localIterator.hasNext()) {
      if (((Matcher)localIterator.next()).matches(paramObject) == paramBoolean) {
        return paramBoolean;
      }
    }
    return paramBoolean ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\core\ShortcutCombination.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */