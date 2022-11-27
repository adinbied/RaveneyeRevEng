package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.util.Arrays;

public class PBKDF2Key
  implements PBKDFKey
{
  private final CharToByteConverter converter;
  private final char[] password;
  
  public PBKDF2Key(char[] paramArrayOfChar, CharToByteConverter paramCharToByteConverter)
  {
    this.password = Arrays.clone(paramArrayOfChar);
    this.converter = paramCharToByteConverter;
  }
  
  public String getAlgorithm()
  {
    return "PBKDF2";
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PBKDF2Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */