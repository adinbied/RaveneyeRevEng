package org.bouncycastle.cms;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class DefaultCMSSignatureEncryptionAlgorithmFinder
  implements CMSSignatureEncryptionAlgorithmFinder
{
  private static final Set RSA_PKCS1d5;
  
  static
  {
    HashSet localHashSet = new HashSet();
    RSA_PKCS1d5 = localHashSet;
    localHashSet.add(PKCSObjectIdentifiers.md2WithRSAEncryption);
    RSA_PKCS1d5.add(PKCSObjectIdentifiers.md4WithRSAEncryption);
    RSA_PKCS1d5.add(PKCSObjectIdentifiers.md5WithRSAEncryption);
    RSA_PKCS1d5.add(PKCSObjectIdentifiers.sha1WithRSAEncryption);
    RSA_PKCS1d5.add(OIWObjectIdentifiers.md4WithRSAEncryption);
    RSA_PKCS1d5.add(OIWObjectIdentifiers.md4WithRSA);
    RSA_PKCS1d5.add(OIWObjectIdentifiers.md5WithRSA);
    RSA_PKCS1d5.add(OIWObjectIdentifiers.sha1WithRSA);
    RSA_PKCS1d5.add(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
    RSA_PKCS1d5.add(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
    RSA_PKCS1d5.add(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
  }
  
  public AlgorithmIdentifier findEncryptionAlgorithm(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    AlgorithmIdentifier localAlgorithmIdentifier = paramAlgorithmIdentifier;
    if (RSA_PKCS1d5.contains(paramAlgorithmIdentifier.getAlgorithm())) {
      localAlgorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
    }
    return localAlgorithmIdentifier;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\DefaultCMSSignatureEncryptionAlgorithmFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */