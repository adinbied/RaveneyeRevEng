package org.bouncycastle.pkcs.jcajce;

import java.io.OutputStream;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
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

public class JcePKCS12MacCalculatorBuilder
  implements PKCS12MacCalculatorBuilder
{
  private ASN1ObjectIdentifier algorithm;
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  private int iterationCount = 1024;
  private SecureRandom random;
  private int saltLength;
  
  public JcePKCS12MacCalculatorBuilder()
  {
    this(OIWObjectIdentifiers.idSHA1);
  }
  
  public JcePKCS12MacCalculatorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.algorithm = paramASN1ObjectIdentifier;
  }
  
  public MacCalculator build(final char[] paramArrayOfChar)
    throws OperatorCreationException
  {
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    try
    {
      localObject = this.helper.createMac(this.algorithm.getId());
      int i = ((Mac)localObject).getMacLength();
      this.saltLength = i;
      final byte[] arrayOfByte = new byte[i];
      this.random.nextBytes(arrayOfByte);
      PBEParameterSpec localPBEParameterSpec = new PBEParameterSpec(arrayOfByte, this.iterationCount);
      paramArrayOfChar = new PKCS12Key(paramArrayOfChar);
      ((Mac)localObject).init(paramArrayOfChar, localPBEParameterSpec);
      paramArrayOfChar = new MacCalculator()
      {
        public AlgorithmIdentifier getAlgorithmIdentifier()
        {
          return new AlgorithmIdentifier(JcePKCS12MacCalculatorBuilder.this.algorithm, new PKCS12PBEParams(arrayOfByte, JcePKCS12MacCalculatorBuilder.this.iterationCount));
        }
        
        public GenericKey getKey()
        {
          return new GenericKey(getAlgorithmIdentifier(), paramArrayOfChar.getEncoded());
        }
        
        public byte[] getMac()
        {
          return localObject.doFinal();
        }
        
        public OutputStream getOutputStream()
        {
          return new MacOutputStream(localObject);
        }
      };
      return paramArrayOfChar;
    }
    catch (Exception paramArrayOfChar)
    {
      final Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to create MAC calculator: ");
      ((StringBuilder)localObject).append(paramArrayOfChar.getMessage());
      throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramArrayOfChar);
    }
  }
  
  public AlgorithmIdentifier getDigestAlgorithmIdentifier()
  {
    return new AlgorithmIdentifier(this.algorithm, DERNull.INSTANCE);
  }
  
  public JcePKCS12MacCalculatorBuilder setIterationCount(int paramInt)
  {
    this.iterationCount = paramInt;
    return this;
  }
  
  public JcePKCS12MacCalculatorBuilder setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcePKCS12MacCalculatorBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\jcajce\JcePKCS12MacCalculatorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */