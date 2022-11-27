package org.bouncycastle.cert.crmf.bc;

import java.security.SecureRandom;
import org.bouncycastle.cert.crmf.EncryptedValuePadder;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.MGF1BytesGenerator;
import org.bouncycastle.crypto.params.MGFParameters;

public class BcFixedLengthMGF1Padder
  implements EncryptedValuePadder
{
  private Digest dig = new SHA1Digest();
  private int length;
  private SecureRandom random;
  
  public BcFixedLengthMGF1Padder(int paramInt)
  {
    this(paramInt, null);
  }
  
  public BcFixedLengthMGF1Padder(int paramInt, SecureRandom paramSecureRandom)
  {
    this.length = paramInt;
    this.random = paramSecureRandom;
  }
  
  public byte[] getPaddedData(byte[] paramArrayOfByte)
  {
    int i1 = this.length;
    byte[] arrayOfByte1 = new byte[i1];
    int m = this.dig.getDigestSize();
    byte[] arrayOfByte2 = new byte[m];
    int n = this.length - this.dig.getDigestSize();
    byte[] arrayOfByte3 = new byte[n];
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    this.random.nextBytes(arrayOfByte2);
    MGF1BytesGenerator localMGF1BytesGenerator = new MGF1BytesGenerator(this.dig);
    localMGF1BytesGenerator.init(new MGFParameters(arrayOfByte2));
    int j = 0;
    localMGF1BytesGenerator.generateBytes(arrayOfByte3, 0, n);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, m);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, m, paramArrayOfByte.length);
    int k;
    for (int i = paramArrayOfByte.length + m;; i = k)
    {
      k = i + 1;
      i = j;
      if (k == i1) {
        break;
      }
      arrayOfByte1[k] = ((byte)(this.random.nextInt(255) + 1));
    }
    while (i != n)
    {
      j = i + m;
      arrayOfByte1[j] = ((byte)(arrayOfByte1[j] ^ arrayOfByte3[i]));
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public byte[] getUnpaddedData(byte[] paramArrayOfByte)
  {
    int j = this.dig.getDigestSize();
    byte[] arrayOfByte1 = new byte[j];
    int k = this.length - this.dig.getDigestSize();
    byte[] arrayOfByte2 = new byte[k];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, j);
    MGF1BytesGenerator localMGF1BytesGenerator = new MGF1BytesGenerator(this.dig);
    localMGF1BytesGenerator.init(new MGFParameters(arrayOfByte1));
    localMGF1BytesGenerator.generateBytes(arrayOfByte2, 0, k);
    int i = 0;
    while (i != k)
    {
      int m = i + j;
      paramArrayOfByte[m] = ((byte)(paramArrayOfByte[m] ^ arrayOfByte2[i]));
      i += 1;
    }
    i = paramArrayOfByte.length - 1;
    while (i != j)
    {
      if (paramArrayOfByte[i] == 0) {
        break label146;
      }
      i -= 1;
    }
    i = 0;
    label146:
    if (i != 0)
    {
      i -= j;
      arrayOfByte1 = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, i);
      return arrayOfByte1;
    }
    throw new IllegalStateException("bad padding in encoding");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\bc\BcFixedLengthMGF1Padder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */