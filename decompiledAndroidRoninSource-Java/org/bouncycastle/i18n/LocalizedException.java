package org.bouncycastle.i18n;

import java.util.Locale;

public class LocalizedException
  extends Exception
{
  private Throwable cause;
  protected ErrorBundle message;
  
  public LocalizedException(ErrorBundle paramErrorBundle)
  {
    super(paramErrorBundle.getText(Locale.getDefault()));
    this.message = paramErrorBundle;
  }
  
  public LocalizedException(ErrorBundle paramErrorBundle, Throwable paramThrowable)
  {
    super(paramErrorBundle.getText(Locale.getDefault()));
    this.message = paramErrorBundle;
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public ErrorBundle getErrorMessage()
  {
    return this.message;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\LocalizedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */