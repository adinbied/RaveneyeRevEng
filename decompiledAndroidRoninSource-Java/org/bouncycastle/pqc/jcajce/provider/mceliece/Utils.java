package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.util.DigestFactory;

class Utils
{
  static AlgorithmIdentifier getDigAlgId(String paramString)
  {
    if (paramString.equals("SHA-1")) {
      return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    }
    if (paramString.equals("SHA-224")) {
      return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE);
    }
    if (paramString.equals("SHA-256")) {
      return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE);
    }
    if (paramString.equals("SHA-384")) {
      return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE);
    }
    if (paramString.equals("SHA-512")) {
      return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognised digest algorithm: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static Digest getDigest(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    if (paramAlgorithmIdentifier.getAlgorithm().equals(OIWObjectIdentifiers.idSHA1)) {
      return DigestFactory.createSHA1();
    }
    if (paramAlgorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha224)) {
      return DigestFactory.createSHA224();
    }
    if (paramAlgorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha256)) {
      return DigestFactory.createSHA256();
    }
    if (paramAlgorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha384)) {
      return DigestFactory.createSHA384();
    }
    if (paramAlgorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha512)) {
      return DigestFactory.createSHA512();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unrecognised OID in digest algorithm identifier: ");
    localStringBuilder.append(paramAlgorithmIdentifier.getAlgorithm());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */