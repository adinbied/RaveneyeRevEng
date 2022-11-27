package org.hamcrest;

public abstract class CustomTypeSafeMatcher<T>
  extends TypeSafeMatcher<T>
{
  private final String fixedDescription;
  
  public CustomTypeSafeMatcher(String paramString)
  {
    if (paramString != null)
    {
      this.fixedDescription = paramString;
      return;
    }
    throw new IllegalArgumentException("Description must be non null!");
  }
  
  public final void describeTo(Description paramDescription)
  {
    paramDescription.appendText(this.fixedDescription);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\CustomTypeSafeMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */