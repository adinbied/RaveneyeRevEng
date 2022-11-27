package org.bouncycastle.asn1.iana;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface IANAObjectIdentifiers
{
  public static final ASN1ObjectIdentifier SNMPv2;
  public static final ASN1ObjectIdentifier _private;
  public static final ASN1ObjectIdentifier directory;
  public static final ASN1ObjectIdentifier experimental;
  public static final ASN1ObjectIdentifier hmacMD5;
  public static final ASN1ObjectIdentifier hmacRIPEMD160 = isakmpOakley.branch("4");
  public static final ASN1ObjectIdentifier hmacSHA1;
  public static final ASN1ObjectIdentifier hmacTIGER;
  public static final ASN1ObjectIdentifier internet;
  public static final ASN1ObjectIdentifier ipsec;
  public static final ASN1ObjectIdentifier isakmpOakley;
  public static final ASN1ObjectIdentifier mail;
  public static final ASN1ObjectIdentifier mgmt;
  public static final ASN1ObjectIdentifier pkix;
  public static final ASN1ObjectIdentifier security;
  public static final ASN1ObjectIdentifier security_mechanisms;
  public static final ASN1ObjectIdentifier security_nametypes;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1");
    internet = localASN1ObjectIdentifier;
    directory = localASN1ObjectIdentifier.branch("1");
    mgmt = internet.branch("2");
    experimental = internet.branch("3");
    _private = internet.branch("4");
    security = internet.branch("5");
    SNMPv2 = internet.branch("6");
    mail = internet.branch("7");
    security_mechanisms = security.branch("5");
    security_nametypes = security.branch("6");
    pkix = security_mechanisms.branch("6");
    localASN1ObjectIdentifier = security_mechanisms.branch("8");
    ipsec = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    isakmpOakley = localASN1ObjectIdentifier;
    hmacMD5 = localASN1ObjectIdentifier.branch("1");
    hmacSHA1 = isakmpOakley.branch("2");
    hmacTIGER = isakmpOakley.branch("3");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\iana\IANAObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */