package org.bouncycastle.asn1.eac;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;

public abstract class PublicKeyDataObject
  extends ASN1Object
{
  public static PublicKeyDataObject getInstance(Object paramObject)
  {
    if ((paramObject instanceof PublicKeyDataObject)) {
      return (PublicKeyDataObject)paramObject;
    }
    if (paramObject != null)
    {
      paramObject = ASN1Sequence.getInstance(paramObject);
      if (ASN1ObjectIdentifier.getInstance(((ASN1Sequence)paramObject).getObjectAt(0)).on(EACObjectIdentifiers.id_TA_ECDSA)) {
        return new ECDSAPublicKey((ASN1Sequence)paramObject);
      }
      return new RSAPublicKey((ASN1Sequence)paramObject);
    }
    return null;
  }
  
  public abstract ASN1ObjectIdentifier getUsage();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\PublicKeyDataObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */