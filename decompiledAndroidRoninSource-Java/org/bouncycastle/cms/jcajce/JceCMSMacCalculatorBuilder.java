package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.jcajce.io.MacOutputStream;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.jcajce.JceGenericKey;

public class JceCMSMacCalculatorBuilder
{
  private AlgorithmParameters algorithmParameters;
  private EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  private final int keySize;
  private final ASN1ObjectIdentifier macOID;
  private SecureRandom random;
  
  public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this(paramASN1ObjectIdentifier, -1);
  }
  
  public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt)
  {
    this.macOID = paramASN1ObjectIdentifier;
    this.keySize = paramInt;
  }
  
  public MacCalculator build()
    throws CMSException
  {
    return new CMSMacCalculator(this.macOID, this.keySize, this.algorithmParameters, this.random);
  }
  
  public JceCMSMacCalculatorBuilder setAlgorithmParameters(AlgorithmParameters paramAlgorithmParameters)
  {
    this.algorithmParameters = paramAlgorithmParameters;
    return this;
  }
  
  public JceCMSMacCalculatorBuilder setProvider(String paramString)
  {
    this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    return this;
  }
  
  public JceCMSMacCalculatorBuilder setProvider(Provider paramProvider)
  {
    this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    return this;
  }
  
  public JceCMSMacCalculatorBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
  
  private class CMSMacCalculator
    implements MacCalculator
  {
    private AlgorithmIdentifier algorithmIdentifier;
    private SecretKey encKey;
    private Mac mac;
    
    CMSMacCalculator(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt, AlgorithmParameters paramAlgorithmParameters, SecureRandom paramSecureRandom)
      throws CMSException
    {
      KeyGenerator localKeyGenerator = JceCMSMacCalculatorBuilder.this.helper.createKeyGenerator(paramASN1ObjectIdentifier);
      SecureRandom localSecureRandom = paramSecureRandom;
      if (paramSecureRandom == null) {
        localSecureRandom = new SecureRandom();
      }
      if (paramInt < 0) {
        localKeyGenerator.init(localSecureRandom);
      } else {
        localKeyGenerator.init(paramInt, localSecureRandom);
      }
      this.encKey = localKeyGenerator.generateKey();
      paramSecureRandom = paramAlgorithmParameters;
      if (paramAlgorithmParameters == null) {
        paramSecureRandom = JceCMSMacCalculatorBuilder.this.helper.generateParameters(paramASN1ObjectIdentifier, this.encKey, localSecureRandom);
      }
      this.algorithmIdentifier = JceCMSMacCalculatorBuilder.this.helper.getAlgorithmIdentifier(paramASN1ObjectIdentifier, paramSecureRandom);
      this.mac = JceCMSMacCalculatorBuilder.this.helper.createContentMac(this.encKey, this.algorithmIdentifier);
    }
    
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
      return this.algorithmIdentifier;
    }
    
    public GenericKey getKey()
    {
      return new JceGenericKey(this.algorithmIdentifier, this.encKey);
    }
    
    public byte[] getMac()
    {
      return this.mac.doFinal();
    }
    
    public OutputStream getOutputStream()
    {
      return new MacOutputStream(this.mac);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceCMSMacCalculatorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */