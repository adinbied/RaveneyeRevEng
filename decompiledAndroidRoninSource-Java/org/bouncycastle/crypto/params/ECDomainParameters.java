package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

public class ECDomainParameters
  implements ECConstants
{
  private ECPoint G;
  private ECCurve curve;
  private BigInteger h;
  private BigInteger n;
  private byte[] seed;
  
  public ECDomainParameters(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    this(paramECCurve, paramECPoint, paramBigInteger, ONE, null);
  }
  
  public ECDomainParameters(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramECCurve, paramECPoint, paramBigInteger1, paramBigInteger2, null);
  }
  
  public ECDomainParameters(ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    this.curve = paramECCurve;
    this.G = paramECPoint.normalize();
    this.n = paramBigInteger1;
    this.h = paramBigInteger2;
    this.seed = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof ECDomainParameters))
    {
      paramObject = (ECDomainParameters)paramObject;
      return (this.curve.equals(((ECDomainParameters)paramObject).curve)) && (this.G.equals(((ECDomainParameters)paramObject).G)) && (this.n.equals(((ECDomainParameters)paramObject).n)) && (this.h.equals(((ECDomainParameters)paramObject).h));
    }
    return false;
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
    return Arrays.clone(this.seed);
  }
  
  public int hashCode()
  {
    return ((this.curve.hashCode() * 37 ^ this.G.hashCode()) * 37 ^ this.n.hashCode()) * 37 ^ this.h.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ECDomainParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */