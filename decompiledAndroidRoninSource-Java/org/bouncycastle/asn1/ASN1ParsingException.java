package org.bouncycastle.asn1;

public class ASN1ParsingException
  extends IllegalStateException
{
  private Throwable cause;
  
  public ASN1ParsingException(String paramString)
  {
    super(paramString);
  }
  
  public ASN1ParsingException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1ParsingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */