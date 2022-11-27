package org.junit.internal.runners;

import java.util.Arrays;
import java.util.List;

@Deprecated
public class InitializationError
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private final List<Throwable> fErrors;
  
  public InitializationError(String paramString)
  {
    this(new Throwable[] { new Exception(paramString) });
  }
  
  public InitializationError(List<Throwable> paramList)
  {
    this.fErrors = paramList;
  }
  
  public InitializationError(Throwable... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
  }
  
  public List<Throwable> getCauses()
  {
    return this.fErrors;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\InitializationError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */