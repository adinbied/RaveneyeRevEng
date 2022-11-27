package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.IssuerSerial;

public class OtherCertID
  extends ASN1Object
{
  private IssuerSerial issuerSerial;
  private ASN1Encodable otherCertHash;
  
  private OtherCertID(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      boolean bool = paramASN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1OctetString;
      localObject = paramASN1Sequence.getObjectAt(0);
      if (bool) {
        localObject = ASN1OctetString.getInstance(localObject);
      } else {
        localObject = DigestInfo.getInstance(localObject);
      }
      this.otherCertHash = ((ASN1Encodable)localObject);
      if (paramASN1Sequence.size() > 1) {
        this.issuerSerial = IssuerSerial.getInstance(paramASN1Sequence.getObjectAt(1));
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public OtherCertID(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.otherCertHash = new DigestInfo(paramAlgorithmIdentifier, paramArrayOfByte);
  }
  
  public OtherCertID(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte, IssuerSerial paramIssuerSerial)
  {
    this.otherCertHash = new DigestInfo(paramAlgorithmIdentifier, paramArrayOfByte);
    this.issuerSerial = paramIssuerSerial;
  }
  
  public static OtherCertID getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherCertID)) {
      return (OtherCertID)paramObject;
    }
    if (paramObject != null) {
      return new OtherCertID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getAlgorithmHash()
  {
    if ((this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString)) {
      return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
    }
    return DigestInfo.getInstance(this.otherCertHash).getAlgorithmId();
  }
  
  public byte[] getCertHash()
  {
    if ((this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString)) {
      return ((ASN1OctetString)this.otherCertHash.toASN1Primitive()).getOctets();
    }
    return DigestInfo.getInstance(this.otherCertHash).getDigest();
  }
  
  public IssuerSerial getIssuerSerial()
  {
    return this.issuerSerial;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.otherCertHash);
    IssuerSerial localIssuerSerial = this.issuerSerial;
    if (localIssuerSerial != null) {
      localASN1EncodableVector.add(localIssuerSerial);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ess\OtherCertID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */