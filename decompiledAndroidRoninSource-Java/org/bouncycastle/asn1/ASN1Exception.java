package org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Exception
  extends IOException
{
  private Throwable cause;
  
  ASN1Exception(String paramString)
  {
    super(paramString);
  }
  
  ASN1Exception(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Exception.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */