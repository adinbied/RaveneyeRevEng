package org.bouncycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.util.Arrays;

public class PKCS12KeyWithParameters
  extends PKCS12Key
  implements PBEKey
{
  private final int iterationCount;
  private final byte[] salt;
  
  public PKCS12KeyWithParameters(char[] paramArrayOfChar, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar, paramBoolean);
    this.salt = Arrays.clone(paramArrayOfByte);
    this.iterationCount = paramInt;
  }
  
  public PKCS12KeyWithParameters(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PKCS12KeyWithParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */