package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public abstract interface CommitmentTypeIdentifier
{
  public static final ASN1ObjectIdentifier proofOfApproval = PKCSObjectIdentifiers.id_cti_ets_proofOfApproval;
  public static final ASN1ObjectIdentifier proofOfCreation = PKCSObjectIdentifiers.id_cti_ets_proofOfCreation;
  public static final ASN1ObjectIdentifier proofOfDelivery;
  public static final ASN1ObjectIdentifier proofOfOrigin = PKCSObjectIdentifiers.id_cti_ets_proofOfOrigin;
  public static final ASN1ObjectIdentifier proofOfReceipt = PKCSObjectIdentifiers.id_cti_ets_proofOfReceipt;
  public static final ASN1ObjectIdentifier proofOfSender;
  
  static
  {
    proofOfDelivery = PKCSObjectIdentifiers.id_cti_ets_proofOfDelivery;
    proofOfSender = PKCSObjectIdentifiers.id_cti_ets_proofOfSender;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CommitmentTypeIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */