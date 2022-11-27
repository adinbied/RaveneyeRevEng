package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

public class CMSAlgorithm
{
  public static final ASN1ObjectIdentifier AES128_CBC;
  public static final ASN1ObjectIdentifier AES128_CCM;
  public static final ASN1ObjectIdentifier AES128_GCM;
  public static final ASN1ObjectIdentifier AES128_WRAP;
  public static final ASN1ObjectIdentifier AES192_CBC;
  public static final ASN1ObjectIdentifier AES192_CCM;
  public static final ASN1ObjectIdentifier AES192_GCM;
  public static final ASN1ObjectIdentifier AES192_WRAP;
  public static final ASN1ObjectIdentifier AES256_CBC;
  public static final ASN1ObjectIdentifier AES256_CCM;
  public static final ASN1ObjectIdentifier AES256_GCM;
  public static final ASN1ObjectIdentifier AES256_WRAP;
  public static final ASN1ObjectIdentifier CAMELLIA128_CBC;
  public static final ASN1ObjectIdentifier CAMELLIA128_WRAP;
  public static final ASN1ObjectIdentifier CAMELLIA192_CBC;
  public static final ASN1ObjectIdentifier CAMELLIA192_WRAP;
  public static final ASN1ObjectIdentifier CAMELLIA256_CBC;
  public static final ASN1ObjectIdentifier CAMELLIA256_WRAP;
  public static final ASN1ObjectIdentifier CAST5_CBC;
  public static final ASN1ObjectIdentifier DES_CBC = OIWObjectIdentifiers.desCBC.intern();
  public static final ASN1ObjectIdentifier DES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.intern();
  public static final ASN1ObjectIdentifier DES_EDE3_WRAP;
  public static final ASN1ObjectIdentifier ECCDH_SHA1KDF;
  public static final ASN1ObjectIdentifier ECCDH_SHA224KDF;
  public static final ASN1ObjectIdentifier ECCDH_SHA256KDF;
  public static final ASN1ObjectIdentifier ECCDH_SHA384KDF;
  public static final ASN1ObjectIdentifier ECCDH_SHA512KDF;
  public static final ASN1ObjectIdentifier ECDH_SHA1KDF;
  public static final ASN1ObjectIdentifier ECDH_SHA224KDF;
  public static final ASN1ObjectIdentifier ECDH_SHA256KDF;
  public static final ASN1ObjectIdentifier ECDH_SHA384KDF;
  public static final ASN1ObjectIdentifier ECDH_SHA512KDF;
  public static final ASN1ObjectIdentifier ECMQV_SHA1KDF;
  public static final ASN1ObjectIdentifier ECMQV_SHA224KDF;
  public static final ASN1ObjectIdentifier ECMQV_SHA256KDF;
  public static final ASN1ObjectIdentifier ECMQV_SHA384KDF;
  public static final ASN1ObjectIdentifier ECMQV_SHA512KDF;
  public static final ASN1ObjectIdentifier GOST3411 = CryptoProObjectIdentifiers.gostR3411.intern();
  public static final ASN1ObjectIdentifier IDEA_CBC;
  public static final ASN1ObjectIdentifier MD5;
  public static final ASN1ObjectIdentifier RC2_CBC = PKCSObjectIdentifiers.RC2_CBC.intern();
  public static final ASN1ObjectIdentifier RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128.intern();
  public static final ASN1ObjectIdentifier RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160.intern();
  public static final ASN1ObjectIdentifier RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256.intern();
  public static final ASN1ObjectIdentifier SEED_CBC;
  public static final ASN1ObjectIdentifier SEED_WRAP;
  public static final ASN1ObjectIdentifier SHA1;
  public static final ASN1ObjectIdentifier SHA224;
  public static final ASN1ObjectIdentifier SHA256;
  public static final ASN1ObjectIdentifier SHA384;
  public static final ASN1ObjectIdentifier SHA512;
  
  static
  {
    IDEA_CBC = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2").intern();
    CAST5_CBC = new ASN1ObjectIdentifier("1.2.840.113533.7.66.10").intern();
    AES128_CBC = NISTObjectIdentifiers.id_aes128_CBC.intern();
    AES192_CBC = NISTObjectIdentifiers.id_aes192_CBC.intern();
    AES256_CBC = NISTObjectIdentifiers.id_aes256_CBC.intern();
    AES128_CCM = NISTObjectIdentifiers.id_aes128_CCM.intern();
    AES192_CCM = NISTObjectIdentifiers.id_aes192_CCM.intern();
    AES256_CCM = NISTObjectIdentifiers.id_aes256_CCM.intern();
    AES128_GCM = NISTObjectIdentifiers.id_aes128_GCM.intern();
    AES192_GCM = NISTObjectIdentifiers.id_aes192_GCM.intern();
    AES256_GCM = NISTObjectIdentifiers.id_aes256_GCM.intern();
    CAMELLIA128_CBC = NTTObjectIdentifiers.id_camellia128_cbc.intern();
    CAMELLIA192_CBC = NTTObjectIdentifiers.id_camellia192_cbc.intern();
    CAMELLIA256_CBC = NTTObjectIdentifiers.id_camellia256_cbc.intern();
    SEED_CBC = KISAObjectIdentifiers.id_seedCBC.intern();
    DES_EDE3_WRAP = PKCSObjectIdentifiers.id_alg_CMS3DESwrap.intern();
    AES128_WRAP = NISTObjectIdentifiers.id_aes128_wrap.intern();
    AES192_WRAP = NISTObjectIdentifiers.id_aes192_wrap.intern();
    AES256_WRAP = NISTObjectIdentifiers.id_aes256_wrap.intern();
    CAMELLIA128_WRAP = NTTObjectIdentifiers.id_camellia128_wrap.intern();
    CAMELLIA192_WRAP = NTTObjectIdentifiers.id_camellia192_wrap.intern();
    CAMELLIA256_WRAP = NTTObjectIdentifiers.id_camellia256_wrap.intern();
    SEED_WRAP = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.intern();
    ECDH_SHA1KDF = X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme.intern();
    ECCDH_SHA1KDF = X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme.intern();
    ECMQV_SHA1KDF = X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme.intern();
    ECDH_SHA224KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme.intern();
    ECCDH_SHA224KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme.intern();
    ECMQV_SHA224KDF = SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme.intern();
    ECDH_SHA256KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme.intern();
    ECCDH_SHA256KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme.intern();
    ECMQV_SHA256KDF = SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme.intern();
    ECDH_SHA384KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme.intern();
    ECCDH_SHA384KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme.intern();
    ECMQV_SHA384KDF = SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme.intern();
    ECDH_SHA512KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme.intern();
    ECCDH_SHA512KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme.intern();
    ECMQV_SHA512KDF = SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme.intern();
    SHA1 = OIWObjectIdentifiers.idSHA1.intern();
    SHA224 = NISTObjectIdentifiers.id_sha224.intern();
    SHA256 = NISTObjectIdentifiers.id_sha256.intern();
    SHA384 = NISTObjectIdentifiers.id_sha384.intern();
    SHA512 = NISTObjectIdentifiers.id_sha512.intern();
    MD5 = PKCSObjectIdentifiers.md5.intern();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */