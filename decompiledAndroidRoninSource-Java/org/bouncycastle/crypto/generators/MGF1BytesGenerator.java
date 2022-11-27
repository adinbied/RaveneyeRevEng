package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.MGFParameters;

public class MGF1BytesGenerator
  implements DerivationFunction
{
  private Digest digest;
  private int hLen;
  private byte[] seed;
  
  public MGF1BytesGenerator(Digest paramDigest)
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
      byte[] arrayOfByte2 = new byte[4];
      this.digest.reset();
      int i;
      Digest localDigest;
      byte[] arrayOfByte3;
      int j;
      if (paramInt2 > this.hLen)
      {
        i = 0;
        do
        {
          ItoOSP(i, arrayOfByte2);
          localDigest = this.digest;
          arrayOfByte3 = this.seed;
          localDigest.update(arrayOfByte3, 0, arrayOfByte3.length);
          this.digest.update(arrayOfByte2, 0, 4);
          this.digest.doFinal(arrayOfByte1, 0);
          j = this.hLen;
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, i * j + paramInt1, j);
          j = i + 1;
          i = j;
        } while (j < paramInt2 / this.hLen);
      }
      else
      {
        j = 0;
      }
      if (this.hLen * j < paramInt2)
      {
        ItoOSP(j, arrayOfByte2);
        localDigest = this.digest;
        arrayOfByte3 = this.seed;
        localDigest.update(arrayOfByte3, 0, arrayOfByte3.length);
        this.digest.update(arrayOfByte2, 0, 4);
        this.digest.doFinal(arrayOfByte1, 0);
        i = this.hLen;
        System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt1 + j * i, paramInt2 - j * i);
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
    if ((paramDerivationParameters instanceof MGFParameters))
    {
      this.seed = ((MGFParameters)paramDerivationParameters).getSeed();
      return;
    }
    throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\MGF1BytesGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */