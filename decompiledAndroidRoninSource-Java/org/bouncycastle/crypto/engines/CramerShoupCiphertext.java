package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class CramerShoupCiphertext
{
  BigInteger e;
  BigInteger u1;
  BigInteger u2;
  BigInteger v;
  
  public CramerShoupCiphertext() {}
  
  public CramerShoupCiphertext(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    this.u1 = paramBigInteger1;
    this.u2 = paramBigInteger2;
    this.e = paramBigInteger3;
    this.v = paramBigInteger4;
  }
  
  public CramerShoupCiphertext(byte[] paramArrayOfByte)
  {
    int j = Pack.bigEndianToInt(paramArrayOfByte, 0) + 4;
    this.u1 = new BigInteger(Arrays.copyOfRange(paramArrayOfByte, 4, j));
    int i = Pack.bigEndianToInt(paramArrayOfByte, j);
    j += 4;
    i += j;
    this.u2 = new BigInteger(Arrays.copyOfRange(paramArrayOfByte, j, i));
    j = Pack.bigEndianToInt(paramArrayOfByte, i);
    i += 4;
    j += i;
    this.e = new BigInteger(Arrays.copyOfRange(paramArrayOfByte, i, j));
    i = Pack.bigEndianToInt(paramArrayOfByte, j);
    j += 4;
    this.v = new BigInteger(Arrays.copyOfRange(paramArrayOfByte, j, i + j));
  }
  
  public BigInteger getE()
  {
    return this.e;
  }
  
  public BigInteger getU1()
  {
    return this.u1;
  }
  
  public BigInteger getU2()
  {
    return this.u2;
  }
  
  public BigInteger getV()
  {
    return this.v;
  }
  
  public void setE(BigInteger paramBigInteger)
  {
    this.e = paramBigInteger;
  }
  
  public void setU1(BigInteger paramBigInteger)
  {
    this.u1 = paramBigInteger;
  }
  
  public void setU2(BigInteger paramBigInteger)
  {
    this.u2 = paramBigInteger;
  }
  
  public void setV(BigInteger paramBigInteger)
  {
    this.v = paramBigInteger;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte1 = this.u1.toByteArray();
    int m = arrayOfByte1.length;
    byte[] arrayOfByte2 = this.u2.toByteArray();
    int k = arrayOfByte2.length;
    byte[] arrayOfByte3 = this.e.toByteArray();
    int j = arrayOfByte3.length;
    byte[] arrayOfByte4 = this.v.toByteArray();
    int i = arrayOfByte4.length;
    byte[] arrayOfByte5 = new byte[m + k + j + i + 16];
    Pack.intToBigEndian(m, arrayOfByte5, 0);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 4, m);
    m += 4;
    Pack.intToBigEndian(k, arrayOfByte5, m);
    m += 4;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, m, k);
    k = m + k;
    Pack.intToBigEndian(j, arrayOfByte5, k);
    k += 4;
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, k, j);
    j = k + j;
    Pack.intToBigEndian(i, arrayOfByte5, j);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, j + 4, i);
    return arrayOfByte5;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("u1: ");
    localStringBuilder.append(this.u1.toString());
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nu2: ");
    localStringBuilder.append(this.u2.toString());
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\ne: ");
    localStringBuilder.append(this.e.toString());
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nv: ");
    localStringBuilder.append(this.v.toString());
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\CramerShoupCiphertext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */