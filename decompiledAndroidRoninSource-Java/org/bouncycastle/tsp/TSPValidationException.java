package org.bouncycastle.tsp;

public class TSPValidationException
  extends TSPException
{
  private int failureCode = -1;
  
  public TSPValidationException(String paramString)
  {
    super(paramString);
  }
  
  public TSPValidationException(String paramString, int paramInt)
  {
    super(paramString);
    this.failureCode = paramInt;
  }
  
  public int getFailureCode()
  {
    return this.failureCode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TSPValidationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */