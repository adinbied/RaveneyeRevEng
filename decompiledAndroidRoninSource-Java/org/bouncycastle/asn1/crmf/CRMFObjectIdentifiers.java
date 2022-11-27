package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public abstract interface CRMFObjectIdentifiers
{
  public static final ASN1ObjectIdentifier id_ct_encKeyWithID = PKCSObjectIdentifiers.id_ct.branch("21");
  public static final ASN1ObjectIdentifier id_pkip;
  public static final ASN1ObjectIdentifier id_pkix;
  public static final ASN1ObjectIdentifier id_regCtrl;
  public static final ASN1ObjectIdentifier id_regCtrl_authenticator;
  public static final ASN1ObjectIdentifier id_regCtrl_pkiArchiveOptions;
  public static final ASN1ObjectIdentifier id_regCtrl_pkiPublicationInfo;
  public static final ASN1ObjectIdentifier id_regCtrl_regToken;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
    id_pkix = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("5");
    id_pkip = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    id_regCtrl = localASN1ObjectIdentifier;
    id_regCtrl_regToken = localASN1ObjectIdentifier.branch("1");
    id_regCtrl_authenticator = id_regCtrl.branch("2");
    id_regCtrl_pkiPublicationInfo = id_regCtrl.branch("3");
    id_regCtrl_pkiArchiveOptions = id_regCtrl.branch("4");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\CRMFObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */