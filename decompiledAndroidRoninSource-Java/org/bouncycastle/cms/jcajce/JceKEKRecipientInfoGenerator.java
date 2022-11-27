package org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.bouncycastle.cms.KEKRecipientInfoGenerator;
import org.bouncycastle.operator.jcajce.JceSymmetricKeyWrapper;

public class JceKEKRecipientInfoGenerator
  extends KEKRecipientInfoGenerator
{
  public JceKEKRecipientInfoGenerator(KEKIdentifier paramKEKIdentifier, SecretKey paramSecretKey)
  {
    super(paramKEKIdentifier, new JceSymmetricKeyWrapper(paramSecretKey));
  }
  
  public JceKEKRecipientInfoGenerator(byte[] paramArrayOfByte, SecretKey paramSecretKey)
  {
    this(new KEKIdentifier(paramArrayOfByte, null, null), paramSecretKey);
  }
  
  public JceKEKRecipientInfoGenerator setProvider(String paramString)
  {
    ((JceSymmetricKeyWrapper)this.wrapper).setProvider(paramString);
    return this;
  }
  
  public JceKEKRecipientInfoGenerator setProvider(Provider paramProvider)
  {
    ((JceSymmetricKeyWrapper)this.wrapper).setProvider(paramProvider);
    return this;
  }
  
  public JceKEKRecipientInfoGenerator setSecureRandom(SecureRandom paramSecureRandom)
  {
    ((JceSymmetricKeyWrapper)this.wrapper).setSecureRandom(paramSecureRandom);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKEKRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */