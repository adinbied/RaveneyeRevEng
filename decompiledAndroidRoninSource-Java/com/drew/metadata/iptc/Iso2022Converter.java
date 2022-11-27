package com.drew.metadata.iptc;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public final class Iso2022Converter
{
  private static final int DOT = 14844066;
  private static final byte ESC = 27;
  private static final String ISO_8859_1 = "ISO-8859-1";
  private static final byte LATIN_CAPITAL_A = 65;
  private static final byte LATIN_CAPITAL_G = 71;
  private static final byte PERCENT_SIGN = 37;
  private static final String UTF_8 = "UTF-8";
  
  public static String convertISO2022CharsetToJavaCharset(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length > 2) && (paramArrayOfByte[0] == 27) && (paramArrayOfByte[1] == 37) && (paramArrayOfByte[2] == 71)) {
      return "UTF-8";
    }
    if ((paramArrayOfByte.length > 3) && (paramArrayOfByte[0] == 27) && ((paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16) == 14844066) && (paramArrayOfByte[4] == 65)) {
      return "ISO-8859-1";
    }
    return null;
  }
  
  static Charset guessCharSet(byte[] paramArrayOfByte)
  {
    int i = 0;
    String str = System.getProperty("file.encoding");
    while (i < 3)
    {
      Charset localCharset = Charset.forName(new String[] { "UTF-8", str, "ISO-8859-1" }[i]);
      CharsetDecoder localCharsetDecoder = localCharset.newDecoder();
      try
      {
        localCharsetDecoder.decode(ByteBuffer.wrap(paramArrayOfByte));
        return localCharset;
      }
      catch (CharacterCodingException localCharacterCodingException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\iptc\Iso2022Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */