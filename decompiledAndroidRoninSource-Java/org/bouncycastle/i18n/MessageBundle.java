package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TimeZone;

public class MessageBundle
  extends TextBundle
{
  public static final String TITLE_ENTRY = "title";
  
  public MessageBundle(String paramString1, String paramString2)
    throws NullPointerException
  {
    super(paramString1, paramString2);
  }
  
  public MessageBundle(String paramString1, String paramString2, String paramString3)
    throws NullPointerException, UnsupportedEncodingException
  {
    super(paramString1, paramString2, paramString3);
  }
  
  public MessageBundle(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
    throws NullPointerException, UnsupportedEncodingException
  {
    super(paramString1, paramString2, paramString3, paramArrayOfObject);
  }
  
  public MessageBundle(String paramString1, String paramString2, Object[] paramArrayOfObject)
    throws NullPointerException
  {
    super(paramString1, paramString2, paramArrayOfObject);
  }
  
  public String getTitle(Locale paramLocale)
    throws MissingEntryException
  {
    return getEntry("title", paramLocale, TimeZone.getDefault());
  }
  
  public String getTitle(Locale paramLocale, TimeZone paramTimeZone)
    throws MissingEntryException
  {
    return getEntry("title", paramLocale, paramTimeZone);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\MessageBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */