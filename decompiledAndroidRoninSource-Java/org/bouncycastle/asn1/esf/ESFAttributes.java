package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public abstract interface ESFAttributes
{
  public static final ASN1ObjectIdentifier archiveTimestamp = PKCSObjectIdentifiers.id_aa_ets_archiveTimestamp;
  public static final ASN1ObjectIdentifier archiveTimestampV2 = PKCSObjectIdentifiers.id_aa.branch("48");
  public static final ASN1ObjectIdentifier certCRLTimestamp;
  public static final ASN1ObjectIdentifier certValues;
  public static final ASN1ObjectIdentifier certificateRefs;
  public static final ASN1ObjectIdentifier commitmentType;
  public static final ASN1ObjectIdentifier contentTimestamp;
  public static final ASN1ObjectIdentifier escTimeStamp;
  public static final ASN1ObjectIdentifier otherSigCert;
  public static final ASN1ObjectIdentifier revocationRefs;
  public static final ASN1ObjectIdentifier revocationValues;
  public static final ASN1ObjectIdentifier sigPolicyId = PKCSObjectIdentifiers.id_aa_ets_sigPolicyId;
  public static final ASN1ObjectIdentifier signerAttr;
  public static final ASN1ObjectIdentifier signerLocation;
  
  static
  {
    commitmentType = PKCSObjectIdentifiers.id_aa_ets_commitmentType;
    signerLocation = PKCSObjectIdentifiers.id_aa_ets_signerLocation;
    signerAttr = PKCSObjectIdentifiers.id_aa_ets_signerAttr;
    otherSigCert = PKCSObjectIdentifiers.id_aa_ets_otherSigCert;
    contentTimestamp = PKCSObjectIdentifiers.id_aa_ets_contentTimestamp;
    certificateRefs = PKCSObjectIdentifiers.id_aa_ets_certificateRefs;
    revocationRefs = PKCSObjectIdentifiers.id_aa_ets_revocationRefs;
    certValues = PKCSObjectIdentifiers.id_aa_ets_certValues;
    revocationValues = PKCSObjectIdentifiers.id_aa_ets_revocationValues;
    escTimeStamp = PKCSObjectIdentifiers.id_aa_ets_escTimeStamp;
    certCRLTimestamp = PKCSObjectIdentifiers.id_aa_ets_certCRLTimestamp;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\ESFAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */