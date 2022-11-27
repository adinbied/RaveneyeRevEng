package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public class HKDFParameters
  implements DerivationParameters
{
  private final byte[] ikm;
  private final byte[] info;
  private final byte[] salt;
  private final boolean skipExpand;
  
  private HKDFParameters(byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1 != null)
    {
      this.ikm = Arrays.clone(paramArrayOfByte1);
      this.skipExpand = paramBoolean;
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
        this.salt = Arrays.clone(paramArrayOfByte2);
      } else {
        this.salt = null;
      }
      if (paramArrayOfByte3 == null)
      {
        this.info = new byte[0];
        return;
      }
      this.info = Arrays.clone(paramArrayOfByte3);
      return;
    }
    throw new IllegalArgumentException("IKM (input keying material) should not be null");
  }
  
  public HKDFParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this(paramArrayOfByte1, false, paramArrayOfByte2, paramArrayOfByte3);
  }
  
  public static HKDFParameters defaultParameters(byte[] paramArrayOfByte)
  {
    return new HKDFParameters(paramArrayOfByte, false, null, null);
  }
  
  public static HKDFParameters skipExtractParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new HKDFParameters(paramArrayOfByte1, true, null, paramArrayOfByte2);
  }
  
  public byte[] getIKM()
  {
    return Arrays.clone(this.ikm);
  }
  
  public byte[] getInfo()
  {
    return Arrays.clone(this.info);
  }
  
  public byte[] getSalt()
  {
    return Arrays.clone(this.salt);
  }
  
  public boolean skipExtract()
  {
    return this.skipExpand;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\HKDFParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */