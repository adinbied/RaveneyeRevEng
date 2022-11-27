package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface X509ObjectIdentifiers
{
  public static final ASN1ObjectIdentifier commonName = new ASN1ObjectIdentifier("2.5.4.3").intern();
  public static final ASN1ObjectIdentifier countryName = new ASN1ObjectIdentifier("2.5.4.6").intern();
  public static final ASN1ObjectIdentifier crlAccessMethod = id_ad_caIssuers;
  public static final ASN1ObjectIdentifier id_SHA1;
  public static final ASN1ObjectIdentifier id_ad;
  public static final ASN1ObjectIdentifier id_ad_caIssuers;
  public static final ASN1ObjectIdentifier id_ad_ocsp;
  public static final ASN1ObjectIdentifier id_at_name;
  public static final ASN1ObjectIdentifier id_at_telephoneNumber;
  public static final ASN1ObjectIdentifier id_ce;
  public static final ASN1ObjectIdentifier id_ea_rsa;
  public static final ASN1ObjectIdentifier id_pe;
  public static final ASN1ObjectIdentifier id_pkix;
  public static final ASN1ObjectIdentifier localityName = new ASN1ObjectIdentifier("2.5.4.7").intern();
  public static final ASN1ObjectIdentifier ocspAccessMethod;
  public static final ASN1ObjectIdentifier organization;
  public static final ASN1ObjectIdentifier organizationalUnitName;
  public static final ASN1ObjectIdentifier ripemd160;
  public static final ASN1ObjectIdentifier ripemd160WithRSAEncryption;
  public static final ASN1ObjectIdentifier stateOrProvinceName = new ASN1ObjectIdentifier("2.5.4.8").intern();
  
  static
  {
    organization = new ASN1ObjectIdentifier("2.5.4.10").intern();
    organizationalUnitName = new ASN1ObjectIdentifier("2.5.4.11").intern();
    id_at_telephoneNumber = new ASN1ObjectIdentifier("2.5.4.20").intern();
    id_at_name = new ASN1ObjectIdentifier("2.5.4.41").intern();
    id_SHA1 = new ASN1ObjectIdentifier("1.3.14.3.2.26").intern();
    ripemd160 = new ASN1ObjectIdentifier("1.3.36.3.2.1").intern();
    ripemd160WithRSAEncryption = new ASN1ObjectIdentifier("1.3.36.3.3.1.2").intern();
    id_ea_rsa = new ASN1ObjectIdentifier("2.5.8.1.1").intern();
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
    id_pkix = localASN1ObjectIdentifier;
    id_pe = localASN1ObjectIdentifier.branch("1");
    id_ce = new ASN1ObjectIdentifier("2.5.29");
    localASN1ObjectIdentifier = id_pkix.branch("48");
    id_ad = localASN1ObjectIdentifier;
    id_ad_caIssuers = localASN1ObjectIdentifier.branch("2").intern();
    localASN1ObjectIdentifier = id_ad.branch("1").intern();
    id_ad_ocsp = localASN1ObjectIdentifier;
    ocspAccessMethod = localASN1ObjectIdentifier;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509ObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */