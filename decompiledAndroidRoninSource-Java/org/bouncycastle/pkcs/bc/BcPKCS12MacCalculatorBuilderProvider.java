package org.bouncycastle.pkcs.bc;

import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.bc.BcDigestProvider;
import org.bouncycastle.pkcs.PKCS12MacCalculatorBuilder;
import org.bouncycastle.pkcs.PKCS12MacCalculatorBuilderProvider;

public class BcPKCS12MacCalculatorBuilderProvider
  implements PKCS12MacCalculatorBuilderProvider
{
  private BcDigestProvider digestProvider;
  
  public BcPKCS12MacCalculatorBuilderProvider(BcDigestProvider paramBcDigestProvider)
  {
    this.digestProvider = paramBcDigestProvider;
  }
  
  public PKCS12MacCalculatorBuilder get(final AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    new PKCS12MacCalculatorBuilder()
    {
      public MacCalculator build(char[] paramAnonymousArrayOfChar)
        throws OperatorCreationException
      {
        PKCS12PBEParams localPKCS12PBEParams = PKCS12PBEParams.getInstance(paramAlgorithmIdentifier.getParameters());
        return PKCS12PBEUtils.createMacCalculator(paramAlgorithmIdentifier.getAlgorithm(), BcPKCS12MacCalculatorBuilderProvider.this.digestProvider.get(paramAlgorithmIdentifier), localPKCS12PBEParams, paramAnonymousArrayOfChar);
      }
      
      public AlgorithmIdentifier getDigestAlgorithmIdentifier()
      {
        return new AlgorithmIdentifier(paramAlgorithmIdentifier.getAlgorithm(), DERNull.INSTANCE);
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\bc\BcPKCS12MacCalculatorBuilderProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */