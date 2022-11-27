package org.bouncycastle.asn1.gm;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface GMObjectIdentifiers
{
  public static final ASN1ObjectIdentifier hmac_sm3;
  public static final ASN1ObjectIdentifier id_sm9PublicKey;
  public static final ASN1ObjectIdentifier sm1_cbc;
  public static final ASN1ObjectIdentifier sm1_cfb1;
  public static final ASN1ObjectIdentifier sm1_cfb128;
  public static final ASN1ObjectIdentifier sm1_cfb8;
  public static final ASN1ObjectIdentifier sm1_ecb;
  public static final ASN1ObjectIdentifier sm1_ofb128;
  public static final ASN1ObjectIdentifier sm2encrypt;
  public static final ASN1ObjectIdentifier sm2encrypt_recommendedParameters;
  public static final ASN1ObjectIdentifier sm2encrypt_specifiedParameters;
  public static final ASN1ObjectIdentifier sm2encrypt_with_blake2b512;
  public static final ASN1ObjectIdentifier sm2encrypt_with_blake2s256;
  public static final ASN1ObjectIdentifier sm2encrypt_with_md5;
  public static final ASN1ObjectIdentifier sm2encrypt_with_rmd160;
  public static final ASN1ObjectIdentifier sm2encrypt_with_sha1;
  public static final ASN1ObjectIdentifier sm2encrypt_with_sha224;
  public static final ASN1ObjectIdentifier sm2encrypt_with_sha256;
  public static final ASN1ObjectIdentifier sm2encrypt_with_sha384;
  public static final ASN1ObjectIdentifier sm2encrypt_with_sha512;
  public static final ASN1ObjectIdentifier sm2encrypt_with_sm3;
  public static final ASN1ObjectIdentifier sm2encrypt_with_whirlpool;
  public static final ASN1ObjectIdentifier sm2exchange;
  public static final ASN1ObjectIdentifier sm2p256v1;
  public static final ASN1ObjectIdentifier sm2sign;
  public static final ASN1ObjectIdentifier sm2sign_with_blake2b512 = sm_scheme.branch("521");
  public static final ASN1ObjectIdentifier sm2sign_with_blake2s256 = sm_scheme.branch("522");
  public static final ASN1ObjectIdentifier sm2sign_with_rmd160;
  public static final ASN1ObjectIdentifier sm2sign_with_sha1;
  public static final ASN1ObjectIdentifier sm2sign_with_sha224;
  public static final ASN1ObjectIdentifier sm2sign_with_sha256;
  public static final ASN1ObjectIdentifier sm2sign_with_sha384;
  public static final ASN1ObjectIdentifier sm2sign_with_sha512;
  public static final ASN1ObjectIdentifier sm2sign_with_sm3;
  public static final ASN1ObjectIdentifier sm2sign_with_whirlpool;
  public static final ASN1ObjectIdentifier sm3;
  public static final ASN1ObjectIdentifier sm5;
  public static final ASN1ObjectIdentifier sm6_cbc;
  public static final ASN1ObjectIdentifier sm6_cfb128;
  public static final ASN1ObjectIdentifier sm6_ecb;
  public static final ASN1ObjectIdentifier sm6_ofb128;
  public static final ASN1ObjectIdentifier sm9encrypt;
  public static final ASN1ObjectIdentifier sm9keyagreement;
  public static final ASN1ObjectIdentifier sm9sign;
  public static final ASN1ObjectIdentifier sm_scheme;
  public static final ASN1ObjectIdentifier sms4_cbc;
  public static final ASN1ObjectIdentifier sms4_ccm;
  public static final ASN1ObjectIdentifier sms4_cfb1;
  public static final ASN1ObjectIdentifier sms4_cfb128;
  public static final ASN1ObjectIdentifier sms4_cfb8;
  public static final ASN1ObjectIdentifier sms4_ctr;
  public static final ASN1ObjectIdentifier sms4_ecb;
  public static final ASN1ObjectIdentifier sms4_gcm;
  public static final ASN1ObjectIdentifier sms4_ocb;
  public static final ASN1ObjectIdentifier sms4_ofb128;
  public static final ASN1ObjectIdentifier sms4_wrap;
  public static final ASN1ObjectIdentifier sms4_wrap_pad;
  public static final ASN1ObjectIdentifier sms4_xts;
  public static final ASN1ObjectIdentifier ssf33_cbc;
  public static final ASN1ObjectIdentifier ssf33_cfb1;
  public static final ASN1ObjectIdentifier ssf33_cfb128;
  public static final ASN1ObjectIdentifier ssf33_cfb8;
  public static final ASN1ObjectIdentifier ssf33_ecb;
  public static final ASN1ObjectIdentifier ssf33_ofb128;
  public static final ASN1ObjectIdentifier wapip192v1;
  
  static
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.156.10197.1");
    sm_scheme = localASN1ObjectIdentifier;
    sm6_ecb = localASN1ObjectIdentifier.branch("101.1");
    sm6_cbc = sm_scheme.branch("101.2");
    sm6_ofb128 = sm_scheme.branch("101.3");
    sm6_cfb128 = sm_scheme.branch("101.4");
    sm1_ecb = sm_scheme.branch("102.1");
    sm1_cbc = sm_scheme.branch("102.2");
    sm1_ofb128 = sm_scheme.branch("102.3");
    sm1_cfb128 = sm_scheme.branch("102.4");
    sm1_cfb1 = sm_scheme.branch("102.5");
    sm1_cfb8 = sm_scheme.branch("102.6");
    ssf33_ecb = sm_scheme.branch("103.1");
    ssf33_cbc = sm_scheme.branch("103.2");
    ssf33_ofb128 = sm_scheme.branch("103.3");
    ssf33_cfb128 = sm_scheme.branch("103.4");
    ssf33_cfb1 = sm_scheme.branch("103.5");
    ssf33_cfb8 = sm_scheme.branch("103.6");
    sms4_ecb = sm_scheme.branch("104.1");
    sms4_cbc = sm_scheme.branch("104.2");
    sms4_ofb128 = sm_scheme.branch("104.3");
    sms4_cfb128 = sm_scheme.branch("104.4");
    sms4_cfb1 = sm_scheme.branch("104.5");
    sms4_cfb8 = sm_scheme.branch("104.6");
    sms4_ctr = sm_scheme.branch("104.7");
    sms4_gcm = sm_scheme.branch("104.8");
    sms4_ccm = sm_scheme.branch("104.9");
    sms4_xts = sm_scheme.branch("104.10");
    sms4_wrap = sm_scheme.branch("104.11");
    sms4_wrap_pad = sm_scheme.branch("104.12");
    sms4_ocb = sm_scheme.branch("104.100");
    sm5 = sm_scheme.branch("201");
    sm2p256v1 = sm_scheme.branch("301");
    sm2sign = sm_scheme.branch("301.1");
    sm2exchange = sm_scheme.branch("301.2");
    sm2encrypt = sm_scheme.branch("301.3");
    wapip192v1 = sm_scheme.branch("301.101");
    sm2encrypt_recommendedParameters = sm2encrypt.branch("1");
    sm2encrypt_specifiedParameters = sm2encrypt.branch("2");
    sm2encrypt_with_sm3 = sm2encrypt.branch("2.1");
    sm2encrypt_with_sha1 = sm2encrypt.branch("2.2");
    sm2encrypt_with_sha224 = sm2encrypt.branch("2.3");
    sm2encrypt_with_sha256 = sm2encrypt.branch("2.4");
    sm2encrypt_with_sha384 = sm2encrypt.branch("2.5");
    sm2encrypt_with_sha512 = sm2encrypt.branch("2.6");
    sm2encrypt_with_rmd160 = sm2encrypt.branch("2.7");
    sm2encrypt_with_whirlpool = sm2encrypt.branch("2.8");
    sm2encrypt_with_blake2b512 = sm2encrypt.branch("2.9");
    sm2encrypt_with_blake2s256 = sm2encrypt.branch("2.10");
    sm2encrypt_with_md5 = sm2encrypt.branch("2.11");
    id_sm9PublicKey = sm_scheme.branch("302");
    sm9sign = sm_scheme.branch("302.1");
    sm9keyagreement = sm_scheme.branch("302.2");
    sm9encrypt = sm_scheme.branch("302.3");
    localASN1ObjectIdentifier = sm_scheme.branch("401");
    sm3 = localASN1ObjectIdentifier;
    hmac_sm3 = localASN1ObjectIdentifier.branch("2");
    sm2sign_with_sm3 = sm_scheme.branch("501");
    sm2sign_with_sha1 = sm_scheme.branch("502");
    sm2sign_with_sha256 = sm_scheme.branch("503");
    sm2sign_with_sha512 = sm_scheme.branch("504");
    sm2sign_with_sha224 = sm_scheme.branch("505");
    sm2sign_with_sha384 = sm_scheme.branch("506");
    sm2sign_with_rmd160 = sm_scheme.branch("507");
    sm2sign_with_whirlpool = sm_scheme.branch("520");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\gm\GMObjectIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */