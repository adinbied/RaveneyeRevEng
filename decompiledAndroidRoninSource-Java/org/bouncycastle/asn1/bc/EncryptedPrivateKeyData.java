package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.x509.Certificate;

public class EncryptedPrivateKeyData
  extends ASN1Object
{
  private final Certificate[] certificateChain;
  private final EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;
  
  private EncryptedPrivateKeyData(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    this.encryptedPrivateKeyInfo = EncryptedPrivateKeyInfo.getInstance(paramASN1Sequence.getObjectAt(0));
    paramASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
    this.certificateChain = new Certificate[paramASN1Sequence.size()];
    for (;;)
    {
      Certificate[] arrayOfCertificate = this.certificateChain;
      if (i == arrayOfCertificate.length) {
        break;
      }
      arrayOfCertificate[i] = Certificate.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
  }
  
  public EncryptedPrivateKeyData(EncryptedPrivateKeyInfo paramEncryptedPrivateKeyInfo, Certificate[] paramArrayOfCertificate)
  {
    this.encryptedPrivateKeyInfo = paramEncryptedPrivateKeyInfo;
    paramEncryptedPrivateKeyInfo = new Certificate[paramArrayOfCertificate.length];
    this.certificateChain = paramEncryptedPrivateKeyInfo;
    System.arraycopy(paramArrayOfCertificate, 0, paramEncryptedPrivateKeyInfo, 0, paramArrayOfCertificate.length);
  }
  
  public static EncryptedPrivateKeyData getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptedPrivateKeyData)) {
      return (EncryptedPrivateKeyData)paramObject;
    }
    if (paramObject != null) {
      return new EncryptedPrivateKeyData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Certificate[] getCertificateChain()
  {
    Certificate[] arrayOfCertificate1 = this.certificateChain;
    Certificate[] arrayOfCertificate2 = new Certificate[arrayOfCertificate1.length];
    System.arraycopy(arrayOfCertificate1, 0, arrayOfCertificate2, 0, arrayOfCertificate1.length);
    return arrayOfCertificate2;
  }
  
  public EncryptedPrivateKeyInfo getEncryptedPrivateKeyInfo()
  {
    return this.encryptedPrivateKeyInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.encryptedPrivateKeyInfo);
    localASN1EncodableVector.add(new DERSequence(this.certificateChain));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\EncryptedPrivateKeyData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */