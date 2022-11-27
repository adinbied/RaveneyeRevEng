package org.bouncycastle.jce.provider;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.KDFParameters;

public class BrokenKDF2BytesGenerator
  implements DerivationFunction
{
  private Digest digest;
  private byte[] iv;
  private byte[] shared;
  
  public BrokenKDF2BytesGenerator(Digest paramDigest)
  {
    this.digest = paramDigest;
  }
  
  public int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException
  {
    if (paramArrayOfByte.length - paramInt2 >= paramInt1)
    {
      long l = paramInt2 * 8L;
      if (l > this.digest.getDigestSize() * 8L * 2147483648L) {
        new IllegalArgumentException("Output length to large");
      }
      int k = (int)(l / this.digest.getDigestSize());
      int m = this.digest.getDigestSize();
      byte[] arrayOfByte1 = new byte[m];
      int j = 1;
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt1 <= k)
      {
        Digest localDigest = this.digest;
        byte[] arrayOfByte2 = this.shared;
        localDigest.update(arrayOfByte2, 0, arrayOfByte2.length);
        this.digest.update((byte)(paramInt1 & 0xFF));
        this.digest.update((byte)(paramInt1 >> 8 & 0xFF));
        this.digest.update((byte)(paramInt1 >> 16 & 0xFF));
        this.digest.update((byte)(paramInt1 >> 24 & 0xFF));
        localDigest = this.digest;
        arrayOfByte2 = this.iv;
        localDigest.update(arrayOfByte2, 0, arrayOfByte2.length);
        this.digest.doFinal(arrayOfByte1, 0);
        j = paramInt2 - i;
        if (j > m)
        {
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, i, m);
          i += m;
        }
        else
        {
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, i, j);
        }
        paramInt1 += 1;
      }
      this.digest.reset();
      return paramInt2;
    }
    throw new DataLengthException("output buffer too small");
  }
  
  public Digest getDigest()
  {
    return this.digest;
  }
  
  public void init(DerivationParameters paramDerivationParameters)
  {
    if ((paramDerivationParameters instanceof KDFParameters))
    {
      paramDerivationParameters = (KDFParameters)paramDerivationParameters;
      this.shared = paramDerivationParameters.getSharedSecret();
      this.iv = paramDerivationParameters.getIV();
      return;
    }
    throw new IllegalArgumentException("KDF parameters required for generator");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\BrokenKDF2BytesGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */