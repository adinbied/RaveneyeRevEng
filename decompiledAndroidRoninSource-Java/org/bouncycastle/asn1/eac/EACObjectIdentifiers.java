package org.bouncycastle.asn1.eac;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface EACObjectIdentifiers
{
  public static final ASN1ObjectIdentifier bsi_de;
  public static final ASN1ObjectIdentifier id_CA;
  public static final ASN1ObjectIdentifier id_CA_DH;
  public static final ASN1ObjectIdentifier id_CA_DH_3DES_CBC_CBC;
  public static final ASN1ObjectIdentifier id_CA_ECDH;
  public static final ASN1ObjectIdentifier id_CA_ECDH_3DES_CBC_CBC;
  public static final ASN1ObjectIdentifier id_EAC_ePassport = bsi_de.branch("3.1.2.1");
  public static final ASN1ObjectIdentifier id_PK;
  public static final ASN1ObjectIdentifier id_PK_DH;
  public static final ASN1ObjectIdentifier id_PK_ECDH;
  public static final ASN1ObjectIdentifier id_TA;
  public static final ASN1ObjectIdentifier id_TA_ECDSA;
  public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_1;
  public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_224;
  public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_256;
  public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_384;
  public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_512;
  public static final ASN1ObjectIdentifier id_TA_RSA;
  public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_1;
  public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_256;
  public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_512;
  public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_1;
  public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_256;
  public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_512;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
    bsi_de = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("2.2.1");
    id_PK = localASN1ObjectIdentifier;
    id_PK_DH = localASN1ObjectIdentifier.branch("1");
    id_PK_ECDH = id_PK.branch("2");
    localASN1ObjectIdentifier = bsi_de.branch("2.2.3");
    id_CA = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    id_CA_DH = localASN1ObjectIdentifier;
    id_CA_DH_3DES_CBC_CBC = localASN1ObjectIdentifier.branch("1");
    localASN1ObjectIdentifier = id_CA.branch("2");
    id_CA_ECDH = localASN1ObjectIdentifier;
    id_CA_ECDH_3DES_CBC_CBC = localASN1ObjectIdentifier.branch("1");
    localASN1ObjectIdentifier = bsi_de.branch("2.2.2");
    id_TA = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    id_TA_RSA = localASN1ObjectIdentifier;
    id_TA_RSA_v1_5_SHA_1 = localASN1ObjectIdentifier.branch("1");
    id_TA_RSA_v1_5_SHA_256 = id_TA_RSA.branch("2");
    id_TA_RSA_PSS_SHA_1 = id_TA_RSA.branch("3");
    id_TA_RSA_PSS_SHA_256 = id_TA_RSA.branch("4");
    id_TA_RSA_v1_5_SHA_512 = id_TA_RSA.branch("5");
    id_TA_RSA_PSS_SHA_512 = id_TA_RSA.branch("6");
    localASN1ObjectIdentifier = id_TA.branch("2");
    id_TA_ECDSA = localASN1ObjectIdentifier;
    id_TA_ECDSA_SHA_1 = localASN1ObjectIdentifier.branch("1");
    id_TA_ECDSA_SHA_224 = id_TA_ECDSA.branch("2");
    id_TA_ECDSA_SHA_256 = id_TA_ECDSA.branch("3");
    id_TA_ECDSA_SHA_384 = id_TA_ECDSA.branch("4");
    id_TA_ECDSA_SHA_512 = id_TA_ECDSA.branch("5");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\EACObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */