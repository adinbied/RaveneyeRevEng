package org.bouncycastle.util.encoders;

public class DecoderException
  extends IllegalStateException
{
  private Throwable cause;
  
  DecoderException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\DecoderException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */