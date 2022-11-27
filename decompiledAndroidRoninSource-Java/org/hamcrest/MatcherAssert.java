package org.hamcrest;

public class MatcherAssert
{
  public static <T> void assertThat(T paramT, Matcher<? super T> paramMatcher)
  {
    assertThat("", paramT, paramMatcher);
  }
  
  public static <T> void assertThat(String paramString, T paramT, Matcher<? super T> paramMatcher)
  {
    if (paramMatcher.matches(paramT)) {
      return;
    }
    StringDescription localStringDescription = new StringDescription();
    localStringDescription.appendText(paramString).appendText("\nExpected: ").appendDescriptionOf(paramMatcher).appendText("\n     but: ");
    paramMatcher.describeMismatch(paramT, localStringDescription);
    throw new AssertionError(localStringDescription.toString());
  }
  
  public static void assertThat(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new AssertionError(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\MatcherAssert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */