package org.bouncycastle.jcajce.provider.asymmetric;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSAUtil;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DSA
{
  private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.dsa.";
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      paramConfigurableProvider.addAlgorithm("AlgorithmParameters.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
      paramConfigurableProvider.addAlgorithm("AlgorithmParameterGenerator.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("KeyPairGenerator.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
      paramConfigurableProvider.addAlgorithm("KeyFactory.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
      paramConfigurableProvider.addAlgorithm("Signature.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
      paramConfigurableProvider.addAlgorithm("Signature.NONEWITHDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
      paramConfigurableProvider.addAlgorithm("Signature.DETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
      paramConfigurableProvider.addAlgorithm("Signature.SHA1WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
      paramConfigurableProvider.addAlgorithm("Signature.SHA224WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
      paramConfigurableProvider.addAlgorithm("Signature.SHA256WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
      paramConfigurableProvider.addAlgorithm("Signature.SHA384WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
      paramConfigurableProvider.addAlgorithm("Signature.SHA512WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
      paramConfigurableProvider.addAlgorithm("Signature.DDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
      paramConfigurableProvider.addAlgorithm("Signature.SHA1WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
      paramConfigurableProvider.addAlgorithm("Signature.SHA224WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
      paramConfigurableProvider.addAlgorithm("Signature.SHA256WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
      paramConfigurableProvider.addAlgorithm("Signature.SHA384WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
      paramConfigurableProvider.addAlgorithm("Signature.SHA512WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-224WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_224");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-256WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_256");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-384WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_384");
      paramConfigurableProvider.addAlgorithm("Signature.SHA3-512WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_512");
      addSignatureAlgorithm(paramConfigurableProvider, "SHA224", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", NISTObjectIdentifiers.dsa_with_sha224);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA256", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", NISTObjectIdentifiers.dsa_with_sha256);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA384", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", NISTObjectIdentifiers.dsa_with_sha384);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA512", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", NISTObjectIdentifiers.dsa_with_sha512);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-224", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_224", NISTObjectIdentifiers.id_dsa_with_sha3_224);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-256", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_256", NISTObjectIdentifiers.id_dsa_with_sha3_256);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-384", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_384", NISTObjectIdentifiers.id_dsa_with_sha3_384);
      addSignatureAlgorithm(paramConfigurableProvider, "SHA3-512", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_512", NISTObjectIdentifiers.id_dsa_with_sha3_512);
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA/DSA", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1withDSA", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.DSAwithSHA1", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WithDSA", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.DSAWithSHA1", "DSA");
      paramConfigurableProvider.addAlgorithm("Alg.Alias.Signature.1.2.840.10040.4.3", "DSA");
      KeyFactorySpi localKeyFactorySpi = new KeyFactorySpi();
      int i = 0;
      while (i != DSAUtil.dsaOids.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Alg.Alias.Signature.");
        localStringBuilder.append(DSAUtil.dsaOids[i]);
        paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), "DSA");
        registerOid(paramConfigurableProvider, DSAUtil.dsaOids[i], "DSA", localKeyFactorySpi);
        registerOidAlgorithmParameterGenerator(paramConfigurableProvider, DSAUtil.dsaOids[i], "DSA");
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\DSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */