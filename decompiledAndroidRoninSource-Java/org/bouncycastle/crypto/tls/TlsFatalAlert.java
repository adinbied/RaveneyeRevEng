package org.bouncycastle.crypto.tls;

import java.io.IOException;

public class TlsFatalAlert
  extends IOException
{
  private static final long serialVersionUID = 3584313123679111168L;
  protected Throwable alertCause;
  protected short alertDescription;
  
  public TlsFatalAlert(short paramShort)
  {
    this(paramShort, null);
  }
  
  public TlsFatalAlert(short paramShort, Throwable paramThrowable)
  {
    super(AlertDescription.getText(paramShort));
    this.alertDescription = paramShort;
    this.alertCause = paramThrowable;
  }
  
  public short getAlertDescription()
  {
    return this.alertDescription;
  }
  
  public Throwable getCause()
  {
    return this.alertCause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsFatalAlert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */