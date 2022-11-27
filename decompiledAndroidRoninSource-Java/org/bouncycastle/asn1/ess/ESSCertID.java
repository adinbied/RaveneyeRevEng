package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.IssuerSerial;

public class ESSCertID
  extends ASN1Object
{
  private ASN1OctetString certHash;
  private IssuerSerial issuerSerial;
  
  private ESSCertID(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      this.certHash = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() > 1) {
        this.issuerSerial = IssuerSerial.getInstance(paramASN1Sequence.getObjectAt(1));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public ESSCertID(byte[] paramArrayOfByte)
  {
    this.certHash = new DEROctetString(paramArrayOfByte);
  }
  
  public ESSCertID(byte[] paramArrayOfByte, IssuerSerial paramIssuerSerial)
  {
    this.certHash = new DEROctetString(paramArrayOfByte);
    this.issuerSerial = paramIssuerSerial;
  }
  
  public static ESSCertID getInstance(Object paramObject)
  {
    if ((paramObject instanceof ESSCertID)) {
      return (ESSCertID)paramObject;
    }
    if (paramObject != null) {
      return new ESSCertID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getCertHash()
  {
    return this.certHash.getOctets();
  }
  
  public IssuerSerial getIssuerSerial()
  {
    return this.issuerSerial;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certHash);
    IssuerSerial localIssuerSerial = this.issuerSerial;
    if (localIssuerSerial != null) {
      localASN1EncodableVector.add(localIssuerSerial);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ess\ESSCertID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */