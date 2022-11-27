package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class GetCert
  extends ASN1Object
{
  private final GeneralName issuerName;
  private final BigInteger serialNumber;
  
  private GetCert(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.issuerName = GeneralName.getInstance(paramASN1Sequence.getObjectAt(0));
      this.serialNumber = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1)).getValue();
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public GetCert(GeneralName paramGeneralName, BigInteger paramBigInteger)
  {
    this.issuerName = paramGeneralName;
    this.serialNumber = paramBigInteger;
  }
  
  public static GetCert getInstance(Object paramObject)
  {
    if ((paramObject instanceof GetCert)) {
      return (GetCert)paramObject;
    }
    if (paramObject != null) {
      return new GetCert(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GeneralName getIssuerName()
  {
    return this.issuerName;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.issuerName);
    localASN1EncodableVector.add(new ASN1Integer(this.serialNumber));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\GetCert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */