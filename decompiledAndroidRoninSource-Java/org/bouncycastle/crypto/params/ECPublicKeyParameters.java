package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.ECPoint;

public class ECPublicKeyParameters
  extends ECKeyParameters
{
  private final ECPoint Q = validate(paramECPoint);
  
  public ECPublicKeyParameters(ECPoint paramECPoint, ECDomainParameters paramECDomainParameters)
  {
    super(false, paramECDomainParameters);
  }
  
  private ECPoint validate(ECPoint paramECPoint)
  {
    if (paramECPoint != null)
    {
      if (!paramECPoint.isInfinity())
      {
        paramECPoint = paramECPoint.normalize();
        if (paramECPoint.isValid()) {
          return paramECPoint;
        }
        throw new IllegalArgumentException("point not on curve");
      }
      throw new IllegalArgumentException("point at infinity");
    }
    throw new IllegalArgumentException("point has null value");
  }
  
  public ECPoint getQ()
  {
    return this.Q;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ECPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */