package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.KDFParameters;

public class ConcatenationKDFGenerator
  implements DerivationFunction
{
  private Digest digest;
  private int hLen;
  private byte[] otherInfo;
  private byte[] shared;
  
  public ConcatenationKDFGenerator(Digest paramDigest)
  {
    this.digest = paramDigest;
    this.hLen = paramDigest.getDigestSize();
  }
  
  private void ItoOSP(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = ((byte)(paramInt >>> 24));
    paramArrayOfByte[1] = ((byte)(paramInt >>> 16));
    paramArrayOfByte[2] = ((byte)(paramInt >>> 8));
    paramArrayOfByte[3] = ((byte)(paramInt >>> 0));
  }
  
  public int generateBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalArgumentException
  {
    if (paramArrayOfByte.length - paramInt2 >= paramInt1)
    {
      byte[] arrayOfByte1 = new byte[this.hLen];
      Object localObject1 = new byte[4];
      this.digest.reset();
      int j = this.hLen;
      int k = 1;
      int i = 1;
      Object localObject2;
      if (paramInt2 > j)
      {
        j = 0;
        for (;;)
        {
          ItoOSP(i, (byte[])localObject1);
          this.digest.update((byte[])localObject1, 0, 4);
          localObject2 = this.digest;
          byte[] arrayOfByte2 = this.shared;
          ((Digest)localObject2).update(arrayOfByte2, 0, arrayOfByte2.length);
          localObject2 = this.digest;
          arrayOfByte2 = this.otherInfo;
          ((Digest)localObject2).update(arrayOfByte2, 0, arrayOfByte2.length);
          this.digest.doFinal(arrayOfByte1, 0);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt1 + j, this.hLen);
          int m = this.hLen;
          j += m;
          k = i + 1;
          if (i >= paramInt2 / m) {
            break;
          }
          i = k;
        }
      }
      j = 0;
      if (j < paramInt2)
      {
        ItoOSP(k, (byte[])localObject1);
        this.digest.update((byte[])localObject1, 0, 4);
        localObject1 = this.digest;
        localObject2 = this.shared;
        ((Digest)localObject1).update((byte[])localObject2, 0, localObject2.length);
        localObject1 = this.digest;
        localObject2 = this.otherInfo;
        ((Digest)localObject1).update((byte[])localObject2, 0, localObject2.length);
        this.digest.doFinal(arrayOfByte1, 0);
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt1 + j, paramInt2 - j);
      }
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
      this.otherInfo = paramDerivationParameters.getIV();
      return;
    }
    throw new IllegalArgumentException("KDF parameters required for generator");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\kdf\ConcatenationKDFGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */