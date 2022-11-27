package com.drew.lang;

import java.nio.charset.Charset;

public final class Charsets
{
  public static final Charset ASCII = Charset.forName("US-ASCII");
  public static final Charset ISO_8859_1;
  public static final Charset UTF_16;
  public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
  public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  static
  {
    UTF_16 = Charset.forName("UTF-16");
    ISO_8859_1 = Charset.forName("ISO-8859-1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\Charsets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */