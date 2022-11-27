package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class HKDFBytesGenerator
  implements DerivationFunction
{
  private byte[] currentT;
  private int generatedBytes;
  private HMac hMacHash;
  private int hashLen;
  private byte[] info;
  
  public HKDFBytesGenerator(Digest paramDigest)
  {
    this.hMacHash = new HMac(paramDigest);
    this.hashLen = paramDigest.getDigestSize();
  }
  
  private void expandNext()
    throws DataLengthException
  {
    int i = this.generatedBytes;
    int j = this.hashLen;
    int k = i / j + 1;
    if (k < 256)
    {
      if (i != 0) {
        this.hMacHash.update(this.currentT, 0, j);
      }
      HMac localHMac = this.hMacHash;
      byte[] arrayOfByte = this.info;
      localHMac.update(arrayOfByte, 0, arrayOfByte.length);
      this.hMacHash.update((byte)k);
      this.hMacHash.doFinal(this.currentT, 0);
      return;
    }
    throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
  }
  
  private KeyParameter extract(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      this.hMacHash.init(new KeyParameter(new byte[this.hashLen]));
    } else {
      this.hMacHash.init(new KeyParameter(paramArrayOfByte1));
    }
    this.hMacHash.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    paramArrayOfByte1 = new byte[this.hashLen];
    this.hMacHash.doFinal(paramArrayOfByte1, 0);
    return new KeyParameter(paramArrayOfByte1);
  }
  
  public int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException
  {
    int i = this.generatedBytes;
    int j = this.hashLen;
    if (i + paramInt2 <= j * 255)
    {
      if (i % j == 0) {
        expandNext();
      }
      j = this.generatedBytes;
      int k = this.hashLen;
      i = Math.min(k - j % k, paramInt2);
      System.arraycopy(this.currentT, j % k, paramArrayOfByte, paramInt1, i);
      this.generatedBytes += i;
      k = paramInt2 - i;
      j = paramInt1;
      paramInt1 = k;
      for (;;)
      {
        j += i;
        if (paramInt1 <= 0) {
          break;
        }
        expandNext();
        i = Math.min(this.hashLen, paramInt1);
        System.arraycopy(this.currentT, 0, paramArrayOfByte, j, i);
        this.generatedBytes += i;
        paramInt1 -= i;
      }
      return paramInt2;
    }
    throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
  }
  
  public Digest getDigest()
  {
    return this.hMacHash.getUnderlyingDigest();
  }
  
  public void init(DerivationParameters paramDerivationParameters)
  {
    if ((paramDerivationParameters instanceof HKDFParameters))
    {
      HKDFParameters localHKDFParameters = (HKDFParameters)paramDerivationParameters;
      KeyParameter localKeyParameter;
      if (localHKDFParameters.skipExtract())
      {
        paramDerivationParameters = this.hMacHash;
        localKeyParameter = new KeyParameter(localHKDFParameters.getIKM());
      }
      else
      {
        paramDerivationParameters = this.hMacHash;
        localKeyParameter = extract(localHKDFParameters.getSalt(), localHKDFParameters.getIKM());
      }
      paramDerivationParameters.init(localKeyParameter);
      this.info = localHKDFParameters.getInfo();
      this.generatedBytes = 0;
      this.currentT = new byte[this.hashLen];
      return;
    }
    throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\HKDFBytesGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */