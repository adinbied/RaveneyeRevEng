package org.bouncycastle.est;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ESTException
  extends IOException
{
  private static final long MAX_ERROR_BODY = 8192L;
  private InputStream body;
  private Throwable cause;
  private int statusCode;
  
  public ESTException(String paramString)
  {
    this(paramString, null);
  }
  
  public ESTException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
    this.body = null;
    this.statusCode = 0;
  }
  
  public ESTException(String paramString, Throwable paramThrowable, int paramInt, InputStream paramInputStream)
  {
    super(paramString);
    this.cause = paramThrowable;
    this.statusCode = paramInt;
    if (paramInputStream != null)
    {
      paramString = new byte[' '];
      paramThrowable = new ByteArrayOutputStream();
    }
    try
    {
      for (;;)
      {
        paramInt = paramInputStream.read(paramString);
        if (paramInt < 0) {
          break;
        }
        if (paramThrowable.size() + paramInt > 8192L)
        {
          paramThrowable.write(paramString, 0, 8192 - paramThrowable.size());
          break;
        }
        paramThrowable.write(paramString, 0, paramInt);
      }
      paramThrowable.flush();
      paramThrowable.close();
      this.body = new ByteArrayInputStream(paramThrowable.toByteArray());
      paramInputStream.close();
      return;
    }
    catch (Exception paramString) {}
    this.body = null;
    return;
  }
  
  public InputStream getBody()
  {
    return this.body;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.getMessage());
    localStringBuilder.append(" HTTP Status Code: ");
    localStringBuilder.append(this.statusCode);
    return localStringBuilder.toString();
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */