package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

public class PKCS5S2ParametersGenerator
  extends PBEParametersGenerator
{
  private Mac hMac;
  private byte[] state;
  
  public PKCS5S2ParametersGenerator()
  {
    this(DigestFactory.createSHA1());
  }
  
  public PKCS5S2ParametersGenerator(Digest paramDigest)
  {
    paramDigest = new HMac(paramDigest);
    this.hMac = paramDigest;
    this.state = new byte[paramDigest.getMacSize()];
  }
  
  private void F(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramArrayOfByte1 != null) {
        this.hMac.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      }
      this.hMac.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      this.hMac.doFinal(this.state, 0);
      paramArrayOfByte1 = this.state;
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, paramInt2, paramArrayOfByte1.length);
      int i = 1;
      while (i < paramInt1)
      {
        paramArrayOfByte1 = this.hMac;
        paramArrayOfByte2 = this.state;
        paramArrayOfByte1.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
        this.hMac.doFinal(this.state, 0);
        int j = 0;
        for (;;)
        {
          paramArrayOfByte1 = this.state;
          if (j == paramArrayOfByte1.length) {
            break;
          }
          int k = paramInt2 + j;
          int m = paramArrayOfByte3[k];
          paramArrayOfByte3[k] = ((byte)(paramArrayOfByte1[j] ^ m));
          j += 1;
        }
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("iteration count must be at least 1.");
  }
  
  private byte[] generateDerivedKey(int paramInt)
  {
    int m = this.hMac.getMacSize();
    int n = (paramInt + m - 1) / m;
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[n * m];
    KeyParameter localKeyParameter = new KeyParameter(this.password);
    this.hMac.init(localKeyParameter);
    int j = 0;
    paramInt = 1;
    while (paramInt <= n)
    {
      int k = 3;
      for (;;)
      {
        int i = (byte)(arrayOfByte1[k] + 1);
        arrayOfByte1[k] = i;
        if (i != 0) {
          break;
        }
        k -= 1;
      }
      F(this.salt, this.iterationCount, arrayOfByte1, arrayOfByte2, j);
      j += m;
      paramInt += 1;
    }
    return arrayOfByte2;
  }
  
  public CipherParameters generateDerivedMacParameters(int paramInt)
  {
    return generateDerivedParameters(paramInt);
  }
  
  public CipherParameters generateDerivedParameters(int paramInt)
  {
    paramInt /= 8;
    return new KeyParameter(Arrays.copyOfRange(generateDerivedKey(paramInt), 0, paramInt), 0, paramInt);
  }
  
  public CipherParameters generateDerivedParameters(int paramInt1, int paramInt2)
  {
    paramInt1 /= 8;
    paramInt2 /= 8;
    byte[] arrayOfByte = generateDerivedKey(paramInt1 + paramInt2);
    return new ParametersWithIV(new KeyParameter(arrayOfByte, 0, paramInt1), arrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\PKCS5S2ParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */