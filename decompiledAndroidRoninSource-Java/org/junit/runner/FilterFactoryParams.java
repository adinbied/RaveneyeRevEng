package org.junit.runner;

public final class FilterFactoryParams
{
  private final String args;
  private final Description topLevelDescription;
  
  public FilterFactoryParams(Description paramDescription, String paramString)
  {
    if ((paramString != null) && (paramDescription != null))
    {
      this.topLevelDescription = paramDescription;
      this.args = paramString;
      return;
    }
    throw null;
  }
  
  public String getArgs()
  {
    return this.args;
  }
  
  public Description getTopLevelDescription()
  {
    return this.topLevelDescription;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\FilterFactoryParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */