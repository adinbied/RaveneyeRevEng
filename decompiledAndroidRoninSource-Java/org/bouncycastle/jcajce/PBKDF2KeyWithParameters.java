package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.util.Arrays;

public class PBKDF2KeyWithParameters
  extends PBKDF2Key
  implements PBEKey
{
  private final int iterationCount;
  private final byte[] salt;
  
  public PBKDF2KeyWithParameters(char[] paramArrayOfChar, CharToByteConverter paramCharToByteConverter, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar, paramCharToByteConverter);
    this.salt = Arrays.clone(paramArrayOfByte);
    this.iterationCount = paramInt;
  }
  
  public int getIterationCount()
  {
    return this.iterationCount;
  }
  
  public byte[] getSalt()
  {
    return this.salt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PBKDF2KeyWithParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */