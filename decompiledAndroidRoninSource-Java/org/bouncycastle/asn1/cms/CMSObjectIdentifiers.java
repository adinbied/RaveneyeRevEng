package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public abstract interface CMSObjectIdentifiers
{
  public static final ASN1ObjectIdentifier authEnvelopedData;
  public static final ASN1ObjectIdentifier authenticatedData;
  public static final ASN1ObjectIdentifier compressedData;
  public static final ASN1ObjectIdentifier data = PKCSObjectIdentifiers.data;
  public static final ASN1ObjectIdentifier digestedData;
  public static final ASN1ObjectIdentifier encryptedData;
  public static final ASN1ObjectIdentifier envelopedData;
  public static final ASN1ObjectIdentifier id_ri;
  public static final ASN1ObjectIdentifier id_ri_ocsp_response;
  public static final ASN1ObjectIdentifier id_ri_scvp = id_ri.branch("4");
  public static final ASN1ObjectIdentifier signedAndEnvelopedData;
  public static final ASN1ObjectIdentifier signedData = PKCSObjectIdentifiers.signedData;
  public static final ASN1ObjectIdentifier timestampedData;
  
  static
  {
    envelopedData = PKCSObjectIdentifiers.envelopedData;
    signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
    digestedData = PKCSObjectIdentifiers.digestedData;
    encryptedData = PKCSObjectIdentifiers.encryptedData;
    authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
    compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
    authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
    timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.16");
    id_ri = localASN1ObjectIdentifier;
    id_ri_ocsp_response = localASN1ObjectIdentifier.branch("2");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\CMSObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */