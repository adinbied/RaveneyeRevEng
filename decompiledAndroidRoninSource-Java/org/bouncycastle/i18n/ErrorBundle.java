package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TimeZone;

public class ErrorBundle
  extends MessageBundle
{
  public static final String DETAIL_ENTRY = "details";
  public static final String SUMMARY_ENTRY = "summary";
  
  public ErrorBundle(String paramString1, String paramString2)
    throws NullPointerException
  {
    super(paramString1, paramString2);
  }
  
  public ErrorBundle(String paramString1, String paramString2, String paramString3)
    throws NullPointerException, UnsupportedEncodingException
  {
    super(paramString1, paramString2, paramString3);
  }
  
  public ErrorBundle(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
    throws NullPointerException, UnsupportedEncodingException
  {
    super(paramString1, paramString2, paramString3, paramArrayOfObject);
  }
  
  public ErrorBundle(String paramString1, String paramString2, Object[] paramArrayOfObject)
    throws NullPointerException
  {
    super(paramString1, paramString2, paramArrayOfObject);
  }
  
  public String getDetail(Locale paramLocale)
    throws MissingEntryException
  {
    return getEntry("details", paramLocale, TimeZone.getDefault());
  }
  
  public String getDetail(Locale paramLocale, TimeZone paramTimeZone)
    throws MissingEntryException
  {
    return getEntry("details", paramLocale, paramTimeZone);
  }
  
  public String getSummary(Locale paramLocale)
    throws MissingEntryException
  {
    return getEntry("summary", paramLocale, TimeZone.getDefault());
  }
  
  public String getSummary(Locale paramLocale, TimeZone paramTimeZone)
    throws MissingEntryException
  {
    return getEntry("summary", paramLocale, paramTimeZone);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\ErrorBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */