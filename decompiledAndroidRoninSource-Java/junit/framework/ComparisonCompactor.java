package junit.framework;

public class ComparisonCompactor
{
  private static final String DELTA_END = "]";
  private static final String DELTA_START = "[";
  private static final String ELLIPSIS = "...";
  private String fActual;
  private int fContextLength;
  private String fExpected;
  private int fPrefix;
  private int fSuffix;
  
  public ComparisonCompactor(int paramInt, String paramString1, String paramString2)
  {
    this.fContextLength = paramInt;
    this.fExpected = paramString1;
    this.fActual = paramString2;
  }
  
  private boolean areStringsEqual()
  {
    return false;
  }
  
  private String compactString(String paramString)
  {
    return null;
  }
  
  private String computeCommonPrefix()
  {
    return null;
  }
  
  private String computeCommonSuffix()
  {
    return null;
  }
  
  /* Error */
  private void findCommonPrefix()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void findCommonSuffix()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String compact(String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\ComparisonCompactor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */