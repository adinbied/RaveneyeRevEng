package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;

public abstract class FeatureMatcher<T, U>
  extends TypeSafeDiagnosingMatcher<T>
{
  private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("featureValueOf", 1, 0);
  private final String featureDescription;
  private final String featureName;
  private final Matcher<? super U> subMatcher;
  
  public FeatureMatcher(Matcher<? super U> paramMatcher, String paramString1, String paramString2)
  {
    super(TYPE_FINDER);
    this.subMatcher = paramMatcher;
    this.featureDescription = paramString1;
    this.featureName = paramString2;
  }
  
  public final void describeTo(Description paramDescription)
  {
    paramDescription.appendText(this.featureDescription).appendText(" ").appendDescriptionOf(this.subMatcher);
  }
  
  protected abstract U featureValueOf(T paramT);
  
  protected boolean matchesSafely(T paramT, Description paramDescription)
  {
    paramT = featureValueOf(paramT);
    if (!this.subMatcher.matches(paramT))
    {
      paramDescription.appendText(this.featureName).appendText(" ");
      this.subMatcher.describeMismatch(paramT, paramDescription);
      return false;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\FeatureMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */