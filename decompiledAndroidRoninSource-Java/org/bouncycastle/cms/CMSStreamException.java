package org.bouncycastle.cms;

import java.io.IOException;

public class CMSStreamException
  extends IOException
{
  private final Throwable underlying;
  
  CMSStreamException(String paramString)
  {
    super(paramString);
    this.underlying = null;
  }
  
  CMSStreamException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.underlying = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.underlying;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSStreamException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */