package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

public class X9ECPoint
  extends ASN1Object
{
  private ECCurve c;
  private final ASN1OctetString encoding;
  private ECPoint p;
  
  public X9ECPoint(ECCurve paramECCurve, ASN1OctetString paramASN1OctetString)
  {
    this(paramECCurve, paramASN1OctetString.getOctets());
  }
  
  public X9ECPoint(ECCurve paramECCurve, byte[] paramArrayOfByte)
  {
    this.c = paramECCurve;
    this.encoding = new DEROctetString(Arrays.clone(paramArrayOfByte));
  }
  
  public X9ECPoint(ECPoint paramECPoint)
  {
    this(paramECPoint, false);
  }
  
  public X9ECPoint(ECPoint paramECPoint, boolean paramBoolean)
  {
    this.p = paramECPoint.normalize();
    this.encoding = new DEROctetString(paramECPoint.getEncoded(paramBoolean));
  }
  
  public ECPoint getPoint()
  {
    try
    {
      if (this.p == null) {
        this.p = this.c.decodePoint(this.encoding.getOctets()).normalize();
      }
      ECPoint localECPoint = this.p;
      return localECPoint;
    }
    finally {}
  }
  
  public byte[] getPointEncoding()
  {
    return Arrays.clone(this.encoding.getOctets());
  }
  
  public boolean isPointCompressed()
  {
    byte[] arrayOfByte = this.encoding.getOctets();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (arrayOfByte != null)
    {
      bool1 = bool2;
      if (arrayOfByte.length > 0) {
        if (arrayOfByte[0] != 2)
        {
          bool1 = bool2;
          if (arrayOfByte[0] != 3) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.encoding;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X9ECPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */