package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;

public abstract interface PQCObjectIdentifiers
{
  public static final ASN1ObjectIdentifier gmss;
  public static final ASN1ObjectIdentifier gmssWithSha1;
  public static final ASN1ObjectIdentifier gmssWithSha224;
  public static final ASN1ObjectIdentifier gmssWithSha256;
  public static final ASN1ObjectIdentifier gmssWithSha384;
  public static final ASN1ObjectIdentifier gmssWithSha512;
  public static final ASN1ObjectIdentifier mcEliece;
  public static final ASN1ObjectIdentifier mcElieceCca2;
  public static final ASN1ObjectIdentifier mcElieceFujisaki;
  public static final ASN1ObjectIdentifier mcElieceKobara_Imai;
  public static final ASN1ObjectIdentifier mcEliecePointcheval;
  public static final ASN1ObjectIdentifier newHope = BCObjectIdentifiers.newHope;
  public static final ASN1ObjectIdentifier rainbow;
  public static final ASN1ObjectIdentifier rainbowWithSha1;
  public static final ASN1ObjectIdentifier rainbowWithSha224;
  public static final ASN1ObjectIdentifier rainbowWithSha256;
  public static final ASN1ObjectIdentifier rainbowWithSha384;
  public static final ASN1ObjectIdentifier rainbowWithSha512;
  public static final ASN1ObjectIdentifier sphincs256;
  public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512;
  public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512;
  public static final ASN1ObjectIdentifier sphincs256_with_SHA512;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
    rainbow = localASN1ObjectIdentifier;
    rainbowWithSha1 = localASN1ObjectIdentifier.branch("1");
    rainbowWithSha224 = rainbow.branch("2");
    rainbowWithSha256 = rainbow.branch("3");
    rainbowWithSha384 = rainbow.branch("4");
    rainbowWithSha512 = rainbow.branch("5");
    localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.3");
    gmss = localASN1ObjectIdentifier;
    gmssWithSha1 = localASN1ObjectIdentifier.branch("1");
    gmssWithSha224 = gmss.branch("2");
    gmssWithSha256 = gmss.branch("3");
    gmssWithSha384 = gmss.branch("4");
    gmssWithSha512 = gmss.branch("5");
    mcEliece = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    mcElieceCca2 = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    mcElieceFujisaki = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.1");
    mcEliecePointcheval = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.2");
    mcElieceKobara_Imai = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2.3");
    sphincs256 = BCObjectIdentifiers.sphincs256;
    sphincs256_with_BLAKE512 = BCObjectIdentifiers.sphincs256_with_BLAKE512;
    sphincs256_with_SHA512 = BCObjectIdentifiers.sphincs256_with_SHA512;
    sphincs256_with_SHA3_512 = BCObjectIdentifiers.sphincs256_with_SHA3_512;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\PQCObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */