package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class DSTU4145Params
  extends ASN1Object
{
  private static final byte[] DEFAULT_DKE = { -87, -42, -21, 69, -15, 60, 112, -126, -128, -60, -106, 123, 35, 31, 94, -83, -10, 88, -21, -92, -64, 55, 41, 29, 56, -39, 107, -16, 37, -54, 78, 23, -8, -23, 114, 13, -58, 21, -76, 58, 40, -105, 95, 11, -63, -34, -93, 100, 56, -75, 100, -22, 44, 23, -97, -48, 18, 62, 109, -72, -6, -59, 121, 4 };
  private byte[] dke = DEFAULT_DKE;
  private DSTU4145ECBinary ecbinary;
  private ASN1ObjectIdentifier namedCurve;
  
  public DSTU4145Params(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.namedCurve = paramASN1ObjectIdentifier;
  }
  
  public DSTU4145Params(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte)
  {
    this.namedCurve = paramASN1ObjectIdentifier;
    this.dke = Arrays.clone(paramArrayOfByte);
  }
  
  public DSTU4145Params(DSTU4145ECBinary paramDSTU4145ECBinary)
  {
    this.ecbinary = paramDSTU4145ECBinary;
  }
  
  public static byte[] getDefaultDKE()
  {
    return DEFAULT_DKE;
  }
  
  public static DSTU4145Params getInstance(Object paramObject)
  {
    if ((paramObject instanceof DSTU4145Params)) {
      return (DSTU4145Params)paramObject;
    }
    if (paramObject != null)
    {
      Object localObject = ASN1Sequence.getInstance(paramObject);
      if ((((ASN1Sequence)localObject).getObjectAt(0) instanceof ASN1ObjectIdentifier)) {
        paramObject = new DSTU4145Params(ASN1ObjectIdentifier.getInstance(((ASN1Sequence)localObject).getObjectAt(0)));
      } else {
        paramObject = new DSTU4145Params(DSTU4145ECBinary.getInstance(((ASN1Sequence)localObject).getObjectAt(0)));
      }
      if (((ASN1Sequence)localObject).size() == 2)
      {
        localObject = ASN1OctetString.getInstance(((ASN1Sequence)localObject).getObjectAt(1)).getOctets();
        ((DSTU4145Params)paramObject).dke = ((byte[])localObject);
        if (localObject.length == DEFAULT_DKE.length) {
          return (DSTU4145Params)paramObject;
        }
        throw new IllegalArgumentException("object parse error");
      }
      return (DSTU4145Params)paramObject;
    }
    throw new IllegalArgumentException("object parse error");
  }
  
  public byte[] getDKE()
  {
    return this.dke;
  }
  
  public DSTU4145ECBinary getECBinary()
  {
    return this.ecbinary;
  }
  
  public ASN1ObjectIdentifier getNamedCurve()
  {
    return this.namedCurve;
  }
  
  public boolean isNamedCurve()
  {
    return this.namedCurve != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.namedCurve;
    if (localObject == null) {
      localObject = this.ecbinary;
    }
    localASN1EncodableVector.add((ASN1Encodable)localObject);
    if (!Arrays.areEqual(this.dke, DEFAULT_DKE)) {
      localASN1EncodableVector.add(new DEROctetString(this.dke));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\ua\DSTU4145Params.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */