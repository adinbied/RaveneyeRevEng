package org.bouncycastle.jcajce.util;

import java.io.IOException;
import java.security.AlgorithmParameters;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;

public class JcaJceUtils
{
  public static ASN1Encodable extractParameters(AlgorithmParameters paramAlgorithmParameters)
    throws IOException
  {
    try
    {
      ASN1Primitive localASN1Primitive = ASN1Primitive.fromByteArray(paramAlgorithmParameters.getEncoded("ASN.1"));
      return localASN1Primitive;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return ASN1Primitive.fromByteArray(paramAlgorithmParameters.getEncoded());
  }
  
  public static String getDigestAlgName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    if (PKCSObjectIdentifiers.md5.equals(paramASN1ObjectIdentifier)) {
      return "MD5";
    }
    if (OIWObjectIdentifiers.idSHA1.equals(paramASN1ObjectIdentifier)) {
      return "SHA1";
    }
    if (NISTObjectIdentifiers.id_sha224.equals(paramASN1ObjectIdentifier)) {
      return "SHA224";
    }
    if (NISTObjectIdentifiers.id_sha256.equals(paramASN1ObjectIdentifier)) {
      return "SHA256";
    }
    if (NISTObjectIdentifiers.id_sha384.equals(paramASN1ObjectIdentifier)) {
      return "SHA384";
    }
    if (NISTObjectIdentifiers.id_sha512.equals(paramASN1ObjectIdentifier)) {
      return "SHA512";
    }
    if (TeleTrusTObjectIdentifiers.ripemd128.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD128";
    }
    if (TeleTrusTObjectIdentifiers.ripemd160.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD160";
    }
    if (TeleTrusTObjectIdentifiers.ripemd256.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD256";
    }
    if (CryptoProObjectIdentifiers.gostR3411.equals(paramASN1ObjectIdentifier)) {
      return "GOST3411";
    }
    return paramASN1ObjectIdentifier.getId();
  }
  
  public static void loadParameters(AlgorithmParameters paramAlgorithmParameters, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    try
    {
      paramAlgorithmParameters.init(paramASN1Encodable.toASN1Primitive().getEncoded(), "ASN.1");
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    paramAlgorithmParameters.init(paramASN1Encodable.toASN1Primitive().getEncoded());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajc\\util\JcaJceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */