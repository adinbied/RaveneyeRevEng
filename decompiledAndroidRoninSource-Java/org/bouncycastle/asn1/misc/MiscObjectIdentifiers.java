package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface MiscObjectIdentifiers
{
  public static final ASN1ObjectIdentifier as_sys_sec_alg_ideaCBC;
  public static final ASN1ObjectIdentifier blake2;
  public static final ASN1ObjectIdentifier cast5CBC;
  public static final ASN1ObjectIdentifier cryptlib;
  public static final ASN1ObjectIdentifier cryptlib_algorithm;
  public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_CBC;
  public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_CFB;
  public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_ECB;
  public static final ASN1ObjectIdentifier cryptlib_algorithm_blowfish_OFB;
  public static final ASN1ObjectIdentifier entrust;
  public static final ASN1ObjectIdentifier entrustVersionExtension;
  public static final ASN1ObjectIdentifier id_blake2b160;
  public static final ASN1ObjectIdentifier id_blake2b256 = blake2.branch("1.8");
  public static final ASN1ObjectIdentifier id_blake2b384 = blake2.branch("1.12");
  public static final ASN1ObjectIdentifier id_blake2b512 = blake2.branch("1.16");
  public static final ASN1ObjectIdentifier netscape;
  public static final ASN1ObjectIdentifier netscapeBaseURL;
  public static final ASN1ObjectIdentifier netscapeCARevocationURL;
  public static final ASN1ObjectIdentifier netscapeCApolicyURL;
  public static final ASN1ObjectIdentifier netscapeCertComment;
  public static final ASN1ObjectIdentifier netscapeCertType;
  public static final ASN1ObjectIdentifier netscapeRenewalURL;
  public static final ASN1ObjectIdentifier netscapeRevocationURL;
  public static final ASN1ObjectIdentifier netscapeSSLServerName;
  public static final ASN1ObjectIdentifier novell;
  public static final ASN1ObjectIdentifier novellSecurityAttribs;
  public static final ASN1ObjectIdentifier verisign;
  public static final ASN1ObjectIdentifier verisignBitString_6_13;
  public static final ASN1ObjectIdentifier verisignCzagExtension;
  public static final ASN1ObjectIdentifier verisignDnbDunsNumber;
  public static final ASN1ObjectIdentifier verisignIssStrongCrypto;
  public static final ASN1ObjectIdentifier verisignOnSiteJurisdictionHash;
  public static final ASN1ObjectIdentifier verisignPrivate_6_9;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113730.1");
    netscape = localASN1ObjectIdentifier;
    netscapeCertType = localASN1ObjectIdentifier.branch("1");
    netscapeBaseURL = netscape.branch("2");
    netscapeRevocationURL = netscape.branch("3");
    netscapeCARevocationURL = netscape.branch("4");
    netscapeRenewalURL = netscape.branch("7");
    netscapeCApolicyURL = netscape.branch("8");
    netscapeSSLServerName = netscape.branch("12");
    netscapeCertComment = netscape.branch("13");
    localASN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113733.1");
    verisign = localASN1ObjectIdentifier;
    verisignCzagExtension = localASN1ObjectIdentifier.branch("6.3");
    verisignPrivate_6_9 = verisign.branch("6.9");
    verisignOnSiteJurisdictionHash = verisign.branch("6.11");
    verisignBitString_6_13 = verisign.branch("6.13");
    verisignDnbDunsNumber = verisign.branch("6.15");
    verisignIssStrongCrypto = verisign.branch("8.1");
    localASN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113719");
    novell = localASN1ObjectIdentifier;
    novellSecurityAttribs = localASN1ObjectIdentifier.branch("1.9.4.1");
    localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.113533.7");
    entrust = localASN1ObjectIdentifier;
    entrustVersionExtension = localASN1ObjectIdentifier.branch("65.0");
    cast5CBC = entrust.branch("66.10");
    as_sys_sec_alg_ideaCBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
    localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.3029");
    cryptlib = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    cryptlib_algorithm = localASN1ObjectIdentifier;
    cryptlib_algorithm_blowfish_ECB = localASN1ObjectIdentifier.branch("1.1");
    cryptlib_algorithm_blowfish_CBC = cryptlib_algorithm.branch("1.2");
    cryptlib_algorithm_blowfish_CFB = cryptlib_algorithm.branch("1.3");
    cryptlib_algorithm_blowfish_OFB = cryptlib_algorithm.branch("1.4");
    localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.1722.12.2");
    blake2 = localASN1ObjectIdentifier;
    id_blake2b160 = localASN1ObjectIdentifier.branch("1.5");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\misc\MiscObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */