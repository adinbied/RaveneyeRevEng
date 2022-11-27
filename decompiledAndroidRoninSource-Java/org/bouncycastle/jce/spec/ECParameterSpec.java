package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECParameterSpec
  implements AlgorithmParameterSpec
{
  private ECPoint G;
  private ECCurve curve;
  private BigInteger h;
  private BigInteger n;
  private byte[] seed;
  
  public ECParameterSpec(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    this.curve = paramECCurve;
    this.G = paramECPoint.normalize();
    this.n = paramBigInteger;
    this.h = BigInteger.valueOf(1L);
    this.seed = null;
  }
  
  public ECParameterSpec(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.curve = paramECCurve;
    this.G = paramECPoint.normalize();
    this.n = paramBigInteger1;
    this.h = paramBigInteger2;
    this.seed = null;
  }
  
  public ECParameterSpec(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this.curve = paramECCurve;
    this.G = paramECPoint.normalize();
    this.n = paramBigInteger1;
    this.h = paramBigInteger2;
    this.seed = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ECParameterSpec;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ECParameterSpec)paramObject;
    bool1 = bool2;
    if (getCurve().equals(((ECParameterSpec)paramObject).getCurve()))
    {
      bool1 = bool2;
      if (getG().equals(((ECParameterSpec)paramObject).getG())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ECCurve getCurve()
  {
    return this.curve;
  }
  
  public ECPoint getG()
  {
    return this.G;
  }
  
  public BigInteger getH()
  {
    return this.h;
  }
  
  public BigInteger getN()
  {
    return this.n;
  }
  
  public byte[] getSeed()
  {
    return this.seed;
  }
  
  public int hashCode()
  {
    return getCurve().hashCode() ^ getG().hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ECParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */