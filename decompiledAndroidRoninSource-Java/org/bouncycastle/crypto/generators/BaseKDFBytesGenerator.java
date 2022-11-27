package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.DigestDerivationFunction;
import org.bouncycastle.crypto.params.ISO18033KDFParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Pack;

public class BaseKDFBytesGenerator
  implements DigestDerivationFunction
{
  private int counterStart;
  private Digest digest;
  private byte[] iv;
  private byte[] shared;
  
  protected BaseKDFBytesGenerator(int paramInt, Digest paramDigest)
  {
    this.counterStart = paramInt;
    this.digest = paramDigest;
  }
  
  public int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException
  {
    int j = paramInt2;
    paramInt2 = paramArrayOfByte.length;
    int k = paramInt1;
    if (paramInt2 - j >= k)
    {
      long l1 = j;
      int n = this.digest.getDigestSize();
      if (l1 <= 8589934591L)
      {
        long l2 = n;
        int i1 = (int)((l1 + l2 - 1L) / l2);
        byte[] arrayOfByte1 = new byte[this.digest.getDigestSize()];
        byte[] arrayOfByte2 = new byte[4];
        Pack.intToBigEndian(this.counterStart, arrayOfByte2, 0);
        paramInt2 = this.counterStart & 0xFF00;
        paramInt1 = 0;
        while (paramInt1 < i1)
        {
          Object localObject = this.digest;
          byte[] arrayOfByte3 = this.shared;
          ((Digest)localObject).update(arrayOfByte3, 0, arrayOfByte3.length);
          this.digest.update(arrayOfByte2, 0, 4);
          localObject = this.iv;
          if (localObject != null) {
            this.digest.update((byte[])localObject, 0, localObject.length);
          }
          this.digest.doFinal(arrayOfByte1, 0);
          if (j > n)
          {
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, k, n);
            k += n;
            j -= n;
          }
          else
          {
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, k, j);
          }
          int i = (byte)(arrayOfByte2[3] + 1);
          arrayOfByte2[3] = i;
          int m = paramInt2;
          if (i == 0)
          {
            m = paramInt2 + 256;
            Pack.intToBigEndian(m, arrayOfByte2, 0);
          }
          paramInt1 += 1;
          paramInt2 = m;
        }
        this.digest.reset();
        return (int)l1;
      }
      throw new IllegalArgumentException("Output length too large");
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
    if ((paramDerivationParameters instanceof ISO18033KDFParameters))
    {
      this.shared = ((ISO18033KDFParameters)paramDerivationParameters).getSeed();
      this.iv = null;
      return;
    }
    throw new IllegalArgumentException("KDF parameters required for generator");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\BaseKDFBytesGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */