package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS12ParametersGenerator
  extends PBEParametersGenerator
{
  public static final int IV_MATERIAL = 2;
  public static final int KEY_MATERIAL = 1;
  public static final int MAC_MATERIAL = 3;
  private Digest digest;
  private int u;
  private int v;
  
  public PKCS12ParametersGenerator(Digest paramDigest)
  {
    this.digest = paramDigest;
    if ((paramDigest instanceof ExtendedDigest))
    {
      this.u = paramDigest.getDigestSize();
      this.v = ((ExtendedDigest)paramDigest).getByteLength();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Digest ");
    localStringBuilder.append(paramDigest.getAlgorithmName());
    localStringBuilder.append(" unsupported");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void adjust(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int i = (paramArrayOfByte2[(paramArrayOfByte2.length - 1)] & 0xFF) + (paramArrayOfByte1[(paramArrayOfByte2.length + paramInt - 1)] & 0xFF) + 1;
    paramArrayOfByte1[(paramArrayOfByte2.length + paramInt - 1)] = ((byte)i);
    int j = i >>> 8;
    i = paramArrayOfByte2.length - 2;
    while (i >= 0)
    {
      int m = paramArrayOfByte2[i];
      int k = paramInt + i;
      j += (m & 0xFF) + (paramArrayOfByte1[k] & 0xFF);
      paramArrayOfByte1[k] = ((byte)j);
      j >>>= 8;
      i -= 1;
    }
  }
  
  private byte[] generateDerivedKey(int paramInt1, int paramInt2)
  {
    int j = this.v;
    byte[] arrayOfByte2 = new byte[j];
    byte[] arrayOfByte3 = new byte[paramInt2];
    int i = 0;
    while (i != j)
    {
      arrayOfByte2[i] = ((byte)paramInt1);
      i += 1;
    }
    if ((this.salt != null) && (this.salt.length != 0))
    {
      paramInt1 = this.v;
      i = this.salt.length;
      k = this.v;
      i = paramInt1 * ((i + k - 1) / k);
      localObject2 = new byte[i];
      paramInt1 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramInt1 == i) {
          break;
        }
        localObject2[paramInt1] = this.salt[(paramInt1 % this.salt.length)];
        paramInt1 += 1;
      }
    }
    Object localObject1 = new byte[0];
    if ((this.password != null) && (this.password.length != 0))
    {
      paramInt1 = this.v;
      i = this.password.length;
      k = this.v;
      i = paramInt1 * ((i + k - 1) / k);
      arrayOfByte1 = new byte[i];
      paramInt1 = 0;
      for (;;)
      {
        localObject2 = arrayOfByte1;
        if (paramInt1 == i) {
          break;
        }
        arrayOfByte1[paramInt1] = this.password[(paramInt1 % this.password.length)];
        paramInt1 += 1;
      }
    }
    Object localObject2 = new byte[0];
    int k = localObject1.length + localObject2.length;
    byte[] arrayOfByte1 = new byte[k];
    System.arraycopy(localObject1, 0, arrayOfByte1, 0, localObject1.length);
    System.arraycopy(localObject2, 0, arrayOfByte1, localObject1.length, localObject2.length);
    int m = this.v;
    localObject1 = new byte[m];
    int n = this.u;
    int i1 = (paramInt2 + n - 1) / n;
    localObject2 = new byte[n];
    paramInt1 = 1;
    while (paramInt1 <= i1)
    {
      this.digest.update(arrayOfByte2, 0, j);
      this.digest.update(arrayOfByte1, 0, k);
      this.digest.doFinal((byte[])localObject2, 0);
      i = 1;
      while (i < this.iterationCount)
      {
        this.digest.update((byte[])localObject2, 0, n);
        this.digest.doFinal((byte[])localObject2, 0);
        i += 1;
      }
      i = 0;
      while (i != m)
      {
        localObject1[i] = localObject2[(i % n)];
        i += 1;
      }
      i = 0;
      int i2;
      for (;;)
      {
        i2 = this.v;
        if (i == k / i2) {
          break;
        }
        adjust(arrayOfByte1, i2 * i, (byte[])localObject1);
        i += 1;
      }
      if (paramInt1 == i1)
      {
        i = paramInt1 - 1;
        i2 = this.u;
        System.arraycopy(localObject2, 0, arrayOfByte3, i * i2, paramInt2 - i * i2);
      }
      else
      {
        System.arraycopy(localObject2, 0, arrayOfByte3, (paramInt1 - 1) * this.u, n);
      }
      paramInt1 += 1;
    }
    return arrayOfByte3;
  }
  
  public CipherParameters generateDerivedMacParameters(int paramInt)
  {
    paramInt /= 8;
    return new KeyParameter(generateDerivedKey(3, paramInt), 0, paramInt);
  }
  
  public CipherParameters generateDerivedParameters(int paramInt)
  {
    paramInt /= 8;
    return new KeyParameter(generateDerivedKey(1, paramInt), 0, paramInt);
  }
  
  public CipherParameters generateDerivedParameters(int paramInt1, int paramInt2)
  {
    paramInt1 /= 8;
    paramInt2 /= 8;
    byte[] arrayOfByte1 = generateDerivedKey(1, paramInt1);
    byte[] arrayOfByte2 = generateDerivedKey(2, paramInt2);
    return new ParametersWithIV(new KeyParameter(arrayOfByte1, 0, paramInt1), arrayOfByte2, 0, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\PKCS12ParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */