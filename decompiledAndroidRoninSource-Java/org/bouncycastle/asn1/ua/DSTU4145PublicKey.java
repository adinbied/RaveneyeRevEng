package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECPoint;

public class DSTU4145PublicKey
  extends ASN1Object
{
  private ASN1OctetString pubKey;
  
  private DSTU4145PublicKey(ASN1OctetString paramASN1OctetString)
  {
    this.pubKey = paramASN1OctetString;
  }
  
  public DSTU4145PublicKey(ECPoint paramECPoint)
  {
    this.pubKey = new DEROctetString(DSTU4145PointEncoder.encodePoint(paramECPoint));
  }
  
  public static DSTU4145PublicKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof DSTU4145PublicKey)) {
      return (DSTU4145PublicKey)paramObject;
    }
    if (paramObject != null) {
      return new DSTU4145PublicKey(ASN1OctetString.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.pubKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\ua\DSTU4145PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */