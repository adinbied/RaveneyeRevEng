package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public abstract interface CMSAttributes
{
  public static final ASN1ObjectIdentifier cmsAlgorithmProtect = PKCSObjectIdentifiers.id_aa_cmsAlgorithmProtect;
  public static final ASN1ObjectIdentifier contentHint;
  public static final ASN1ObjectIdentifier contentType = PKCSObjectIdentifiers.pkcs_9_at_contentType;
  public static final ASN1ObjectIdentifier counterSignature;
  public static final ASN1ObjectIdentifier messageDigest = PKCSObjectIdentifiers.pkcs_9_at_messageDigest;
  public static final ASN1ObjectIdentifier signingTime = PKCSObjectIdentifiers.pkcs_9_at_signingTime;
  
  static
  {
    counterSignature = PKCSObjectIdentifiers.pkcs_9_at_counterSignature;
    contentHint = PKCSObjectIdentifiers.id_aa_contentHint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\CMSAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */