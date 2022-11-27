package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECNamedDomainParameters
  extends ECDomainParameters
{
  private ASN1ObjectIdentifier name;
  
  public ECNamedDomainParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    this(paramASN1ObjectIdentifier, paramECCurve, paramECPoint, paramBigInteger, null, null);
  }
  
  public ECNamedDomainParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramASN1ObjectIdentifier, paramECCurve, paramECPoint, paramBigInteger1, paramBigInteger2, null);
  }
  
  public ECNamedDomainParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ECCurve paramECCurve, ECPoint paramECPoint, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    super(paramECCurve, paramECPoint, paramBigInteger1, paramBigInteger2, paramArrayOfByte);
    this.name = paramASN1ObjectIdentifier;
  }
  
  public ASN1ObjectIdentifier getName()
  {
    return this.name;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ECNamedDomainParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */