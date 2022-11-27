package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

public class GLVTypeBParameters
{
  protected final BigInteger beta;
  protected final int bits;
  protected final BigInteger g1;
  protected final BigInteger g2;
  protected final BigInteger lambda;
  protected final BigInteger v1A;
  protected final BigInteger v1B;
  protected final BigInteger v2A;
  protected final BigInteger v2B;
  
  public GLVTypeBParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger[] paramArrayOfBigInteger1, BigInteger[] paramArrayOfBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, int paramInt)
  {
    checkVector(paramArrayOfBigInteger1, "v1");
    checkVector(paramArrayOfBigInteger2, "v2");
    this.beta = paramBigInteger1;
    this.lambda = paramBigInteger2;
    this.v1A = paramArrayOfBigInteger1[0];
    this.v1B = paramArrayOfBigInteger1[1];
    this.v2A = paramArrayOfBigInteger2[0];
    this.v2B = paramArrayOfBigInteger2[1];
    this.g1 = paramBigInteger3;
    this.g2 = paramBigInteger4;
    this.bits = paramInt;
  }
  
  private static void checkVector(BigInteger[] paramArrayOfBigInteger, String paramString)
  {
    if ((paramArrayOfBigInteger != null) && (paramArrayOfBigInteger.length == 2) && (paramArrayOfBigInteger[0] != null) && (paramArrayOfBigInteger[1] != null)) {
      return;
    }
    paramArrayOfBigInteger = new StringBuilder();
    paramArrayOfBigInteger.append("'");
    paramArrayOfBigInteger.append(paramString);
    paramArrayOfBigInteger.append("' must consist of exactly 2 (non-null) values");
    throw new IllegalArgumentException(paramArrayOfBigInteger.toString());
  }
  
  public BigInteger getBeta()
  {
    return this.beta;
  }
  
  public int getBits()
  {
    return this.bits;
  }
  
  public BigInteger getG1()
  {
    return this.g1;
  }
  
  public BigInteger getG2()
  {
    return this.g2;
  }
  
  public BigInteger getLambda()
  {
    return this.lambda;
  }
  
  public BigInteger[] getV1()
  {
    return new BigInteger[] { this.v1A, this.v1B };
  }
  
  public BigInteger getV1A()
  {
    return this.v1A;
  }
  
  public BigInteger getV1B()
  {
    return this.v1B;
  }
  
  public BigInteger[] getV2()
  {
    return new BigInteger[] { this.v2A, this.v2B };
  }
  
  public BigInteger getV2A()
  {
    return this.v2A;
  }
  
  public BigInteger getV2B()
  {
    return this.v2B;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\endo\GLVTypeBParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */