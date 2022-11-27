package junit.framework;

public class AssertionFailedError
  extends AssertionError
{
  private static final long serialVersionUID = 1L;
  
  public AssertionFailedError() {}
  
  public AssertionFailedError(String paramString)
  {
    super(defaultString(paramString));
  }
  
  private static String defaultString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\AssertionFailedError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */