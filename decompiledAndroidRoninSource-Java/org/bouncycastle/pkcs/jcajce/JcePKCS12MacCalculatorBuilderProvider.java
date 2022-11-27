package org.bouncycastle.pkcs.jcajce;

import java.io.OutputStream;
import java.math.BigInteger;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.io.MacOutputStream;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCS12MacCalculatorBuilder;
import org.bouncycastle.pkcs.PKCS12MacCalculatorBuilderProvider;

public class JcePKCS12MacCalculatorBuilderProvider
  implements PKCS12MacCalculatorBuilderProvider
{
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  
  public PKCS12MacCalculatorBuilder get(final AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    new PKCS12MacCalculatorBuilder()
    {
      public MacCalculator build(final char[] paramAnonymousArrayOfChar)
        throws OperatorCreationException
      {
        final Object localObject = PKCS12PBEParams.getInstance(paramAlgorithmIdentifier.getParameters());
        try
        {
          final ASN1ObjectIdentifier localASN1ObjectIdentifier = paramAlgorithmIdentifier.getAlgorithm();
          final Mac localMac = JcePKCS12MacCalculatorBuilderProvider.this.helper.createMac(localASN1ObjectIdentifier.getId());
          PBEParameterSpec localPBEParameterSpec = new PBEParameterSpec(((PKCS12PBEParams)localObject).getIV(), ((PKCS12PBEParams)localObject).getIterations().intValue());
          paramAnonymousArrayOfChar = new PKCS12Key(paramAnonymousArrayOfChar);
          localMac.init(paramAnonymousArrayOfChar, localPBEParameterSpec);
          paramAnonymousArrayOfChar = new MacCalculator()
          {
            public AlgorithmIdentifier getAlgorithmIdentifier()
            {
              return new AlgorithmIdentifier(localASN1ObjectIdentifier, localObject);
            }
            
            public GenericKey getKey()
            {
              return new GenericKey(getAlgorithmIdentifier(), paramAnonymousArrayOfChar.getEncoded());
            }
            
            public byte[] getMac()
            {
              return localMac.doFinal();
            }
            
            public OutputStream getOutputStream()
            {
              return new MacOutputStream(localMac);
            }
          };
          return paramAnonymousArrayOfChar;
        }
        catch (Exception paramAnonymousArrayOfChar)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unable to create MAC calculator: ");
          ((StringBuilder)localObject).append(paramAnonymousArrayOfChar.getMessage());
          throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramAnonymousArrayOfChar);
        }
      }
      
      public AlgorithmIdentifier getDigestAlgorithmIdentifier()
      {
        return new AlgorithmIdentifier(paramAlgorithmIdentifier.getAlgorithm(), DERNull.INSTANCE);
      }
    };
  }
  
  public JcePKCS12MacCalculatorBuilderProvider setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcePKCS12MacCalculatorBuilderProvider setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\jcajce\JcePKCS12MacCalculatorBuilderProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */