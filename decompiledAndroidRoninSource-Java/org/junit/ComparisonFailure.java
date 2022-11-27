package org.junit;

public class ComparisonFailure
  extends AssertionError
{
  private static final int MAX_CONTEXT_LENGTH = 20;
  private static final long serialVersionUID = 1L;
  private String fActual;
  private String fExpected;
  
  public ComparisonFailure(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.fExpected = paramString2;
    this.fActual = paramString3;
  }
  
  public String getActual()
  {
    return this.fActual;
  }
  
  public String getExpected()
  {
    return this.fExpected;
  }
  
  public String getMessage()
  {
    return new ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
  }
  
  private static class ComparisonCompactor
  {
    private static final String DIFF_END = "]";
    private static final String DIFF_START = "[";
    private static final String ELLIPSIS = "...";
    private final String actual;
    private final int contextLength;
    private final String expected;
    
    public ComparisonCompactor(int paramInt, String paramString1, String paramString2)
    {
      this.contextLength = paramInt;
      this.expected = paramString1;
      this.actual = paramString2;
    }
    
    private String sharedPrefix()
    {
      int j = Math.min(this.expected.length(), this.actual.length());
      int i = 0;
      while (i < j)
      {
        if (this.expected.charAt(i) != this.actual.charAt(i)) {
          return this.expected.substring(0, i);
        }
        i += 1;
      }
      return this.expected.substring(0, j);
    }
    
    private String sharedSuffix(String paramString)
    {
      int j = Math.min(this.expected.length() - paramString.length(), this.actual.length() - paramString.length());
      int i = 0;
      while (i <= j - 1)
      {
        paramString = this.expected;
        int k = paramString.charAt(paramString.length() - 1 - i);
        paramString = this.actual;
        if (k != paramString.charAt(paramString.length() - 1 - i)) {
          break;
        }
        i += 1;
      }
      paramString = this.expected;
      return paramString.substring(paramString.length() - i);
    }
    
    public String compact(String paramString)
    {
      Object localObject1 = this.expected;
      if (localObject1 != null)
      {
        String str1 = this.actual;
        if ((str1 != null) && (!((String)localObject1).equals(str1)))
        {
          localObject1 = new DiffExtractor(null);
          str1 = ((DiffExtractor)localObject1).compactPrefix();
          String str2 = ((DiffExtractor)localObject1).compactSuffix();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(((DiffExtractor)localObject1).expectedDiff());
          ((StringBuilder)localObject2).append(str2);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append(((DiffExtractor)localObject1).actualDiff());
          localStringBuilder.append(str2);
          return Assert.format(paramString, localObject2, localStringBuilder.toString());
        }
      }
      return Assert.format(paramString, this.expected, this.actual);
    }
    
    private class DiffExtractor
    {
      private final String sharedPrefix;
      private final String sharedSuffix;
      
      private DiffExtractor()
      {
        String str = ComparisonFailure.ComparisonCompactor.this.sharedPrefix();
        this.sharedPrefix = str;
        this.sharedSuffix = ComparisonFailure.ComparisonCompactor.this.sharedSuffix(str);
      }
      
      private String extractDiff(String paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(paramString.substring(this.sharedPrefix.length(), paramString.length() - this.sharedSuffix.length()));
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      
      public String actualDiff()
      {
        return extractDiff(ComparisonFailure.ComparisonCompactor.this.actual);
      }
      
      public String compactPrefix()
      {
        if (this.sharedPrefix.length() <= ComparisonFailure.ComparisonCompactor.this.contextLength) {
          return this.sharedPrefix;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("...");
        String str = this.sharedPrefix;
        localStringBuilder.append(str.substring(str.length() - ComparisonFailure.ComparisonCompactor.this.contextLength));
        return localStringBuilder.toString();
      }
      
      public String compactSuffix()
      {
        if (this.sharedSuffix.length() <= ComparisonFailure.ComparisonCompactor.this.contextLength) {
          return this.sharedSuffix;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.sharedSuffix.substring(0, ComparisonFailure.ComparisonCompactor.this.contextLength));
        localStringBuilder.append("...");
        return localStringBuilder.toString();
      }
      
      public String expectedDiff()
      {
        return extractDiff(ComparisonFailure.ComparisonCompactor.this.expected);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\ComparisonFailure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */