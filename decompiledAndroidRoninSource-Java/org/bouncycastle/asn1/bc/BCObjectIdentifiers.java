package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface BCObjectIdentifiers
{
  public static final ASN1ObjectIdentifier bc;
  public static final ASN1ObjectIdentifier bc_exch;
  public static final ASN1ObjectIdentifier bc_pbe;
  public static final ASN1ObjectIdentifier bc_pbe_sha1;
  public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12;
  public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc;
  public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc;
  public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc;
  public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs5;
  public static final ASN1ObjectIdentifier bc_pbe_sha224;
  public static final ASN1ObjectIdentifier bc_pbe_sha256;
  public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12;
  public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc;
  public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc;
  public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc;
  public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs5;
  public static final ASN1ObjectIdentifier bc_pbe_sha384;
  public static final ASN1ObjectIdentifier bc_pbe_sha512;
  public static final ASN1ObjectIdentifier bc_sig;
  public static final ASN1ObjectIdentifier newHope;
  public static final ASN1ObjectIdentifier sphincs256;
  public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512;
  public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512;
  public static final ASN1ObjectIdentifier sphincs256_with_SHA512;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
    bc = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    bc_pbe = localASN1ObjectIdentifier;
    bc_pbe_sha1 = localASN1ObjectIdentifier.branch("1");
    bc_pbe_sha256 = bc_pbe.branch("2.1");
    bc_pbe_sha384 = bc_pbe.branch("2.2");
    bc_pbe_sha512 = bc_pbe.branch("2.3");
    bc_pbe_sha224 = bc_pbe.branch("2.4");
    bc_pbe_sha1_pkcs5 = bc_pbe_sha1.branch("1");
    bc_pbe_sha1_pkcs12 = bc_pbe_sha1.branch("2");
    bc_pbe_sha256_pkcs5 = bc_pbe_sha256.branch("1");
    bc_pbe_sha256_pkcs12 = bc_pbe_sha256.branch("2");
    bc_pbe_sha1_pkcs12_aes128_cbc = bc_pbe_sha1_pkcs12.branch("1.2");
    bc_pbe_sha1_pkcs12_aes192_cbc = bc_pbe_sha1_pkcs12.branch("1.22");
    bc_pbe_sha1_pkcs12_aes256_cbc = bc_pbe_sha1_pkcs12.branch("1.42");
    bc_pbe_sha256_pkcs12_aes128_cbc = bc_pbe_sha256_pkcs12.branch("1.2");
    bc_pbe_sha256_pkcs12_aes192_cbc = bc_pbe_sha256_pkcs12.branch("1.22");
    bc_pbe_sha256_pkcs12_aes256_cbc = bc_pbe_sha256_pkcs12.branch("1.42");
    localASN1ObjectIdentifier = bc.branch("2");
    bc_sig = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("1");
    sphincs256 = localASN1ObjectIdentifier;
    sphincs256_with_BLAKE512 = localASN1ObjectIdentifier.branch("1");
    sphincs256_with_SHA512 = sphincs256.branch("2");
    sphincs256_with_SHA3_512 = sphincs256.branch("3");
    localASN1ObjectIdentifier = bc.branch("3");
    bc_exch = localASN1ObjectIdentifier;
    newHope = localASN1ObjectIdentifier.branch("1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\BCObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */