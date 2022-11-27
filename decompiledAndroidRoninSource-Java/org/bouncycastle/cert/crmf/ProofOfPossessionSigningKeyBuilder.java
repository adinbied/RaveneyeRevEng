package org.bouncycastle.cert.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.crmf.CertRequest;
import org.bouncycastle.asn1.crmf.PKMACValue;
import org.bouncycastle.asn1.crmf.POPOSigningKey;
import org.bouncycastle.asn1.crmf.POPOSigningKeyInput;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentSigner;

public class ProofOfPossessionSigningKeyBuilder
{
  private CertRequest certRequest;
  private GeneralName name;
  private SubjectPublicKeyInfo pubKeyInfo;
  private PKMACValue publicKeyMAC;
  
  public ProofOfPossessionSigningKeyBuilder(CertRequest paramCertRequest)
  {
    this.certRequest = paramCertRequest;
  }
  
  public ProofOfPossessionSigningKeyBuilder(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.pubKeyInfo = paramSubjectPublicKeyInfo;
  }
  
  public POPOSigningKey build(ContentSigner paramContentSigner)
  {
    if ((this.name != null) && (this.publicKeyMAC != null)) {
      throw new IllegalStateException("name and publicKeyMAC cannot both be set.");
    }
    CertRequest localCertRequest = this.certRequest;
    Object localObject;
    if (localCertRequest != null)
    {
      localObject = null;
      CRMFUtil.derEncodeToStream(localCertRequest, paramContentSigner.getOutputStream());
    }
    else
    {
      localObject = this.name;
      if (localObject != null) {
        localObject = new POPOSigningKeyInput((GeneralName)localObject, this.pubKeyInfo);
      } else {
        localObject = new POPOSigningKeyInput(this.publicKeyMAC, this.pubKeyInfo);
      }
      CRMFUtil.derEncodeToStream((ASN1Encodable)localObject, paramContentSigner.getOutputStream());
    }
    return new POPOSigningKey((POPOSigningKeyInput)localObject, paramContentSigner.getAlgorithmIdentifier(), new DERBitString(paramContentSigner.getSignature()));
  }
  
  public ProofOfPossessionSigningKeyBuilder setPublicKeyMac(PKMACValueGenerator paramPKMACValueGenerator, char[] paramArrayOfChar)
    throws CRMFException
  {
    this.publicKeyMAC = paramPKMACValueGenerator.generate(paramArrayOfChar, this.pubKeyInfo);
    return this;
  }
  
  public ProofOfPossessionSigningKeyBuilder setSender(GeneralName paramGeneralName)
  {
    this.name = paramGeneralName;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\ProofOfPossessionSigningKeyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */