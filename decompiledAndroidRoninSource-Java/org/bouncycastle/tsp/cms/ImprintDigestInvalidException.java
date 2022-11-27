package org.bouncycastle.tsp.cms;

import org.bouncycastle.tsp.TimeStampToken;

public class ImprintDigestInvalidException
  extends Exception
{
  private TimeStampToken token;
  
  public ImprintDigestInvalidException(String paramString, TimeStampToken paramTimeStampToken)
  {
    super(paramString);
    this.token = paramTimeStampToken;
  }
  
  public TimeStampToken getTimeStampToken()
  {
    return this.token;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\cms\ImprintDigestInvalidException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */