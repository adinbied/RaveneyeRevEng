package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class HMacDSAKCalculator
  implements DSAKCalculator
{
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private final byte[] K;
  private final byte[] V;
  private final HMac hMac;
  private BigInteger n;
  
  public HMacDSAKCalculator(Digest paramDigest)
  {
    paramDigest = new HMac(paramDigest);
    this.hMac = paramDigest;
    this.V = new byte[paramDigest.getMacSize()];
    this.K = new byte[this.hMac.getMacSize()];
  }
  
  private BigInteger bitsToInt(byte[] paramArrayOfByte)
  {
    BigInteger localBigInteger2 = new BigInteger(1, paramArrayOfByte);
    BigInteger localBigInteger1 = localBigInteger2;
    if (paramArrayOfByte.length * 8 > this.n.bitLength()) {
      localBigInteger1 = localBigInteger2.shiftRight(paramArrayOfByte.length * 8 - this.n.bitLength());
    }
    return localBigInteger1;
  }
  
  public void init(BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this.n = paramBigInteger1;
    Arrays.fill(this.V, (byte)1);
    Arrays.fill(this.K, (byte)0);
    int i = (paramBigInteger1.bitLength() + 7) / 8;
    byte[] arrayOfByte1 = new byte[i];
    paramBigInteger2 = BigIntegers.asUnsignedByteArray(paramBigInteger2);
    System.arraycopy(paramBigInteger2, 0, arrayOfByte1, i - paramBigInteger2.length, paramBigInteger2.length);
    int j = (paramBigInteger1.bitLength() + 7) / 8;
    byte[] arrayOfByte2 = new byte[j];
    paramArrayOfByte = bitsToInt(paramArrayOfByte);
    paramBigInteger2 = paramArrayOfByte;
    if (paramArrayOfByte.compareTo(paramBigInteger1) >= 0) {
      paramBigInteger2 = paramArrayOfByte.subtract(paramBigInteger1);
    }
    paramBigInteger1 = BigIntegers.asUnsignedByteArray(paramBigInteger2);
    System.arraycopy(paramBigInteger1, 0, arrayOfByte2, j - paramBigInteger1.length, paramBigInteger1.length);
    this.hMac.init(new KeyParameter(this.K));
    paramBigInteger1 = this.hMac;
    paramBigInteger2 = this.V;
    paramBigInteger1.update(paramBigInteger2, 0, paramBigInteger2.length);
    this.hMac.update((byte)0);
    this.hMac.update(arrayOfByte1, 0, i);
    this.hMac.update(arrayOfByte2, 0, j);
    this.hMac.doFinal(this.K, 0);
    this.hMac.init(new KeyParameter(this.K));
    paramBigInteger1 = this.hMac;
    paramBigInteger2 = this.V;
    paramBigInteger1.update(paramBigInteger2, 0, paramBigInteger2.length);
    this.hMac.doFinal(this.V, 0);
    paramBigInteger1 = this.hMac;
    paramBigInteger2 = this.V;
    paramBigInteger1.update(paramBigInteger2, 0, paramBigInteger2.length);
    this.hMac.update((byte)1);
    this.hMac.update(arrayOfByte1, 0, i);
    this.hMac.update(arrayOfByte2, 0, j);
    this.hMac.doFinal(this.K, 0);
    this.hMac.init(new KeyParameter(this.K));
    paramBigInteger1 = this.hMac;
    paramBigInteger2 = this.V;
    paramBigInteger1.update(paramBigInteger2, 0, paramBigInteger2.length);
    this.hMac.doFinal(this.V, 0);
  }
  
  public void init(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    throw new IllegalStateException("Operation not supported");
  }
  
  public boolean isDeterministic()
  {
    return true;
  }
  
  public BigInteger nextK()
  {
    int j = (this.n.bitLength() + 7) / 8;
    byte[] arrayOfByte1 = new byte[j];
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        localObject = this.hMac;
        arrayOfByte2 = this.V;
        ((HMac)localObject).update(arrayOfByte2, 0, arrayOfByte2.length);
        this.hMac.doFinal(this.V, 0);
        int k = Math.min(j - i, this.V.length);
        System.arraycopy(this.V, 0, arrayOfByte1, i, k);
        i += k;
      }
      Object localObject = bitsToInt(arrayOfByte1);
      if ((((BigInteger)localObject).compareTo(ZERO) > 0) && (((BigInteger)localObject).compareTo(this.n) < 0)) {
        return (BigInteger)localObject;
      }
      localObject = this.hMac;
      byte[] arrayOfByte2 = this.V;
      ((HMac)localObject).update(arrayOfByte2, 0, arrayOfByte2.length);
      this.hMac.update((byte)0);
      this.hMac.doFinal(this.K, 0);
      this.hMac.init(new KeyParameter(this.K));
      localObject = this.hMac;
      arrayOfByte2 = this.V;
      ((HMac)localObject).update(arrayOfByte2, 0, arrayOfByte2.length);
      this.hMac.doFinal(this.V, 0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\HMacDSAKCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */