package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.CharToByteConverter;

public class PBKDF1Key
  implements PBKDFKey
{
  private final CharToByteConverter converter;
  private final char[] password;
  
  public PBKDF1Key(char[] paramArrayOfChar, CharToByteConverter paramCharToByteConverter)
  {
    char[] arrayOfChar = new char[paramArrayOfChar.length];
    this.password = arrayOfChar;
    this.converter = paramCharToByteConverter;
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public String getAlgorithm()
  {
    return "PBKDF1";
  }
  
  public byte[] getEncoded()
  {
    return this.converter.convert(this.password);
  }
  
  public String getFormat()
  {
    return this.converter.getType();
  }
  
  public char[] getPassword()
  {
    return this.password;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PBKDF1Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */