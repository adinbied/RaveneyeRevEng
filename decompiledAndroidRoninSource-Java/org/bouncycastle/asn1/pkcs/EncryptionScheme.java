package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme
  extends ASN1Object
{
  private AlgorithmIdentifier algId;
  
  public EncryptionScheme(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.algId = new AlgorithmIdentifier(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
  
  private EncryptionScheme(ASN1Sequence paramASN1Sequence)
  {
    this.algId = AlgorithmIdentifier.getInstance(paramASN1Sequence);
  }
  
  public static EncryptionScheme getInstance(Object paramObject)
  {
    if ((paramObject instanceof EncryptionScheme)) {
      return (EncryptionScheme)paramObject;
    }
    if (paramObject != null) {
      return new EncryptionScheme(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getAlgorithm()
  {
    return this.algId.getAlgorithm();
  }
  
  public ASN1Encodable getParameters()
  {
    return this.algId.getParameters();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.algId.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\EncryptionScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */