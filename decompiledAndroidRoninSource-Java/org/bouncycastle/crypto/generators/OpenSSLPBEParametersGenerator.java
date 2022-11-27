package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

public class OpenSSLPBEParametersGenerator
  extends PBEParametersGenerator
{
  private Digest digest = DigestFactory.createMD5();
  
  private byte[] generateDerivedKey(int paramInt)
  {
    int k = this.digest.getDigestSize();
    byte[] arrayOfByte1 = new byte[k];
    byte[] arrayOfByte2 = new byte[paramInt];
    int i = 0;
    for (;;)
    {
      this.digest.update(this.password, 0, this.password.length);
      this.digest.update(this.salt, 0, this.salt.length);
      this.digest.doFinal(arrayOfByte1, 0);
      int j;
      if (paramInt > k) {
        j = k;
      } else {
        j = paramInt;
      }
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, j);
      i += j;
      paramInt -= j;
      if (paramInt == 0) {
        return arrayOfByte2;
      }
      this.digest.reset();
      this.digest.update(arrayOfByte1, 0, k);
    }
  }
  
  public CipherParameters generateDerivedMacParameters(int paramInt)
  {
    return generateDerivedParameters(paramInt);
  }
  
  public CipherParameters generateDerivedParameters(int paramInt)
  {
    paramInt /= 8;
    return new KeyParameter(generateDerivedKey(paramInt), 0, paramInt);
  }
  
  public CipherParameters generateDerivedParameters(int paramInt1, int paramInt2)
  {
    paramInt1 /= 8;
    paramInt2 /= 8;
    byte[] arrayOfByte = generateDerivedKey(paramInt1 + paramInt2);
    return new ParametersWithIV(new KeyParameter(arrayOfByte, 0, paramInt1), arrayOfByte, paramInt1, paramInt2);
  }
  
  public void init(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super.init(paramArrayOfByte1, paramArrayOfByte2, 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\OpenSSLPBEParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */