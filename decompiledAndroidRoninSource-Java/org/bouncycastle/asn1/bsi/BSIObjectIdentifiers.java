package org.bouncycastle.asn1.bsi;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface BSIObjectIdentifiers
{
  public static final ASN1ObjectIdentifier bsi_de;
  public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160 = ecdsa_plain_signatures.branch("6");
  public static final ASN1ObjectIdentifier ecdsa_plain_SHA1;
  public static final ASN1ObjectIdentifier ecdsa_plain_SHA224;
  public static final ASN1ObjectIdentifier ecdsa_plain_SHA256;
  public static final ASN1ObjectIdentifier ecdsa_plain_SHA384;
  public static final ASN1ObjectIdentifier ecdsa_plain_SHA512;
  public static final ASN1ObjectIdentifier ecdsa_plain_signatures;
  public static final ASN1ObjectIdentifier id_ecc;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
    bsi_de = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1.1");
    id_ecc = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("4.1");
    ecdsa_plain_signatures = localASN1ObjectIdentifier;
    ecdsa_plain_SHA1 = localASN1ObjectIdentifier.branch("1");
    ecdsa_plain_SHA224 = ecdsa_plain_signatures.branch("2");
    ecdsa_plain_SHA256 = ecdsa_plain_signatures.branch("3");
    ecdsa_plain_SHA384 = ecdsa_plain_signatures.branch("4");
    ecdsa_plain_SHA512 = ecdsa_plain_signatures.branch("5");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bsi\BSIObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */