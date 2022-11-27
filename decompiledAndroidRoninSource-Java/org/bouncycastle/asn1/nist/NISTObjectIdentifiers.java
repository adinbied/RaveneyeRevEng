package org.bouncycastle.asn1.nist;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface NISTObjectIdentifiers
{
  public static final ASN1ObjectIdentifier aes;
  public static final ASN1ObjectIdentifier dsa_with_sha224;
  public static final ASN1ObjectIdentifier dsa_with_sha256 = sigAlgs.branch("2");
  public static final ASN1ObjectIdentifier dsa_with_sha384 = sigAlgs.branch("3");
  public static final ASN1ObjectIdentifier dsa_with_sha512 = sigAlgs.branch("4");
  public static final ASN1ObjectIdentifier hashAlgs;
  public static final ASN1ObjectIdentifier id_aes128_CBC;
  public static final ASN1ObjectIdentifier id_aes128_CCM;
  public static final ASN1ObjectIdentifier id_aes128_CFB;
  public static final ASN1ObjectIdentifier id_aes128_ECB;
  public static final ASN1ObjectIdentifier id_aes128_GCM;
  public static final ASN1ObjectIdentifier id_aes128_OFB;
  public static final ASN1ObjectIdentifier id_aes128_wrap;
  public static final ASN1ObjectIdentifier id_aes128_wrap_pad;
  public static final ASN1ObjectIdentifier id_aes192_CBC;
  public static final ASN1ObjectIdentifier id_aes192_CCM;
  public static final ASN1ObjectIdentifier id_aes192_CFB;
  public static final ASN1ObjectIdentifier id_aes192_ECB;
  public static final ASN1ObjectIdentifier id_aes192_GCM;
  public static final ASN1ObjectIdentifier id_aes192_OFB;
  public static final ASN1ObjectIdentifier id_aes192_wrap;
  public static final ASN1ObjectIdentifier id_aes192_wrap_pad;
  public static final ASN1ObjectIdentifier id_aes256_CBC;
  public static final ASN1ObjectIdentifier id_aes256_CCM;
  public static final ASN1ObjectIdentifier id_aes256_CFB;
  public static final ASN1ObjectIdentifier id_aes256_ECB;
  public static final ASN1ObjectIdentifier id_aes256_GCM;
  public static final ASN1ObjectIdentifier id_aes256_OFB;
  public static final ASN1ObjectIdentifier id_aes256_wrap;
  public static final ASN1ObjectIdentifier id_aes256_wrap_pad;
  public static final ASN1ObjectIdentifier id_dsa_with_sha2;
  public static final ASN1ObjectIdentifier id_dsa_with_sha3_224 = sigAlgs.branch("5");
  public static final ASN1ObjectIdentifier id_dsa_with_sha3_256 = sigAlgs.branch("6");
  public static final ASN1ObjectIdentifier id_dsa_with_sha3_384 = sigAlgs.branch("7");
  public static final ASN1ObjectIdentifier id_dsa_with_sha3_512 = sigAlgs.branch("8");
  public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_224 = sigAlgs.branch("9");
  public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_256 = sigAlgs.branch("10");
  public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_384 = sigAlgs.branch("11");
  public static final ASN1ObjectIdentifier id_ecdsa_with_sha3_512 = sigAlgs.branch("12");
  public static final ASN1ObjectIdentifier id_hmacWithSHA3_224;
  public static final ASN1ObjectIdentifier id_hmacWithSHA3_256;
  public static final ASN1ObjectIdentifier id_hmacWithSHA3_384;
  public static final ASN1ObjectIdentifier id_hmacWithSHA3_512;
  public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_224 = sigAlgs.branch("13");
  public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_256 = sigAlgs.branch("14");
  public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_384 = sigAlgs.branch("15");
  public static final ASN1ObjectIdentifier id_rsassa_pkcs1_v1_5_with_sha3_512 = sigAlgs.branch("16");
  public static final ASN1ObjectIdentifier id_sha224;
  public static final ASN1ObjectIdentifier id_sha256;
  public static final ASN1ObjectIdentifier id_sha384;
  public static final ASN1ObjectIdentifier id_sha3_224;
  public static final ASN1ObjectIdentifier id_sha3_256;
  public static final ASN1ObjectIdentifier id_sha3_384;
  public static final ASN1ObjectIdentifier id_sha3_512;
  public static final ASN1ObjectIdentifier id_sha512;
  public static final ASN1ObjectIdentifier id_sha512_224;
  public static final ASN1ObjectIdentifier id_sha512_256;
  public static final ASN1ObjectIdentifier id_shake128;
  public static final ASN1ObjectIdentifier id_shake256;
  public static final ASN1ObjectIdentifier nistAlgorithm;
  public static final ASN1ObjectIdentifier sigAlgs;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.101.3.4");
    nistAlgorithm = localASN1ObjectIdentifier;
    localASN1ObjectIdentifier = localASN1ObjectIdentifier.branch("2");
    hashAlgs = localASN1ObjectIdentifier;
    id_sha256 = localASN1ObjectIdentifier.branch("1");
    id_sha384 = hashAlgs.branch("2");
    id_sha512 = hashAlgs.branch("3");
    id_sha224 = hashAlgs.branch("4");
    id_sha512_224 = hashAlgs.branch("5");
    id_sha512_256 = hashAlgs.branch("6");
    id_sha3_224 = hashAlgs.branch("7");
    id_sha3_256 = hashAlgs.branch("8");
    id_sha3_384 = hashAlgs.branch("9");
    id_sha3_512 = hashAlgs.branch("10");
    id_shake128 = hashAlgs.branch("11");
    id_shake256 = hashAlgs.branch("12");
    id_hmacWithSHA3_224 = hashAlgs.branch("13");
    id_hmacWithSHA3_256 = hashAlgs.branch("14");
    id_hmacWithSHA3_384 = hashAlgs.branch("15");
    id_hmacWithSHA3_512 = hashAlgs.branch("16");
    localASN1ObjectIdentifier = nistAlgorithm.branch("1");
    aes = localASN1ObjectIdentifier;
    id_aes128_ECB = localASN1ObjectIdentifier.branch("1");
    id_aes128_CBC = aes.branch("2");
    id_aes128_OFB = aes.branch("3");
    id_aes128_CFB = aes.branch("4");
    id_aes128_wrap = aes.branch("5");
    id_aes128_GCM = aes.branch("6");
    id_aes128_CCM = aes.branch("7");
    id_aes128_wrap_pad = aes.branch("8");
    id_aes192_ECB = aes.branch("21");
    id_aes192_CBC = aes.branch("22");
    id_aes192_OFB = aes.branch("23");
    id_aes192_CFB = aes.branch("24");
    id_aes192_wrap = aes.branch("25");
    id_aes192_GCM = aes.branch("26");
    id_aes192_CCM = aes.branch("27");
    id_aes192_wrap_pad = aes.branch("28");
    id_aes256_ECB = aes.branch("41");
    id_aes256_CBC = aes.branch("42");
    id_aes256_OFB = aes.branch("43");
    id_aes256_CFB = aes.branch("44");
    id_aes256_wrap = aes.branch("45");
    id_aes256_GCM = aes.branch("46");
    id_aes256_CCM = aes.branch("47");
    id_aes256_wrap_pad = aes.branch("48");
    localASN1ObjectIdentifier = nistAlgorithm.branch("3");
    sigAlgs = localASN1ObjectIdentifier;
    id_dsa_with_sha2 = localASN1ObjectIdentifier;
    dsa_with_sha224 = localASN1ObjectIdentifier.branch("1");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\nist\NISTObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */