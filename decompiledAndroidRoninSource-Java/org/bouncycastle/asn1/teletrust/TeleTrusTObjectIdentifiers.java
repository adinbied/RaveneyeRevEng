package org.bouncycastle.asn1.teletrust;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface TeleTrusTObjectIdentifiers
{
  public static final ASN1ObjectIdentifier brainpoolP160r1;
  public static final ASN1ObjectIdentifier brainpoolP160t1 = versionOne.branch("2");
  public static final ASN1ObjectIdentifier brainpoolP192r1 = versionOne.branch("3");
  public static final ASN1ObjectIdentifier brainpoolP192t1 = versionOne.branch("4");
  public static final ASN1ObjectIdentifier brainpoolP224r1 = versionOne.branch("5");
  public static final ASN1ObjectIdentifier brainpoolP224t1 = versionOne.branch("6");
  public static final ASN1ObjectIdentifier brainpoolP256r1 = versionOne.branch("7");
  public static final ASN1ObjectIdentifier brainpoolP256t1 = versionOne.branch("8");
  public static final ASN1ObjectIdentifier brainpoolP320r1 = versionOne.branch("9");
  public static final ASN1ObjectIdentifier brainpoolP320t1 = versionOne.branch("10");
  public static final ASN1ObjectIdentifier brainpoolP384r1 = versionOne.branch("11");
  public static final ASN1ObjectIdentifier brainpoolP384t1 = versionOne.branch("12");
  public static final ASN1ObjectIdentifier brainpoolP512r1 = versionOne.branch("13");
  public static final ASN1ObjectIdentifier brainpoolP512t1 = versionOne.branch("14");
  public static final ASN1ObjectIdentifier ecSign;
  public static final ASN1ObjectIdentifier ecSignWithRipemd160;
  public static final ASN1ObjectIdentifier ecSignWithSha1;
  public static final ASN1ObjectIdentifier ecc_brainpool;
  public static final ASN1ObjectIdentifier ellipticCurve;
  public static final ASN1ObjectIdentifier ripemd128;
  public static final ASN1ObjectIdentifier ripemd160;
  public static final ASN1ObjectIdentifier ripemd256;
  public static final ASN1ObjectIdentifier rsaSignatureWithripemd128;
  public static final ASN1ObjectIdentifier rsaSignatureWithripemd160;
  public static final ASN1ObjectIdentifier rsaSignatureWithripemd256;
  public static final ASN1ObjectIdentifier teleTrusTAlgorithm;
  public static final ASN1ObjectIdentifier teleTrusTRSAsignatureAlgorithm;
  public static final ASN1ObjectIdentifier versionOne;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.3");
    teleTrusTAlgorithm = localASN1ObjectIdentifier;
    ripemd160 = localASN1ObjectIdentifier.branch("2.1");
    ripemd128 = teleTrusTAlgorithm.branch("2.2");
    ripemd256 = teleTrusTAlgorithm.branch("2.3");
    localASN1ObjectIdentifier = teleTrusTAlgorithm.branch("3.1");
    teleTrusTRSAsignatureAlgorithm = localASN1ObjectIdentifier;
    rsaSignatureWithripemd160 = localASN1ObjectIdentifier.branch("2");
    rsaSignatureWithripemd128 = teleTrusTRSAsignatureAlgorithm.branch("3");
    rsaSignatureWithripemd256 = teleTrusTRSAsignatureAlgorithm.branch("4");
    localASN1ObjectIdentifier = teleTrusTAlgorithm.branch("3.2");
    ecSign = localASN1ObjectIdentifier;
    ecSignWithSha1 = localASN1ObjectIdentifier.branch("1");
    ecSignWithRipemd160 = ecSign.branch("2");
    localASN1ObjectIdentifier = teleTrusTAlgorithm.branch("3.2.8");
    ecc_brainpool = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    ellipticCurve = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    versionOne = localASN1ObjectIdentifier;
    brainpoolP160r1 = localASN1ObjectIdentifier.branch("1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\teletrust\TeleTrusTObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */