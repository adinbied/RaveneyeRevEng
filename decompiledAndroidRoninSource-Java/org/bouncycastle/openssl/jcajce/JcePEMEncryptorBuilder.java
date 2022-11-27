package org.bouncycastle.openssl.jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openssl.PEMEncryptor;
import org.bouncycastle.openssl.PEMException;

public class JcePEMEncryptorBuilder
{
  private final String algorithm;
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  private SecureRandom random;
  
  public JcePEMEncryptorBuilder(String paramString)
  {
    this.algorithm = paramString;
  }
  
  public PEMEncryptor build(final char[] paramArrayOfChar)
  {
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    int i;
    if (this.algorithm.startsWith("AES-")) {
      i = 16;
    } else {
      i = 8;
    }
    final byte[] arrayOfByte = new byte[i];
    this.random.nextBytes(arrayOfByte);
    new PEMEncryptor()
    {
      public byte[] encrypt(byte[] paramAnonymousArrayOfByte)
        throws PEMException
      {
        return PEMUtilities.crypt(true, JcePEMEncryptorBuilder.this.helper, paramAnonymousArrayOfByte, paramArrayOfChar, JcePEMEncryptorBuilder.this.algorithm, arrayOfByte);
      }
      
      public String getAlgorithm()
      {
        return JcePEMEncryptorBuilder.this.algorithm;
      }
      
      public byte[] getIV()
      {
        return arrayOfByte;
      }
    };
  }
  
  public JcePEMEncryptorBuilder setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcePEMEncryptorBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
  
  public JcePEMEncryptorBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JcePEMEncryptorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */