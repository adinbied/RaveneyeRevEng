package org.bouncycastle.openssl.jcajce;

import java.security.Provider;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openssl.PEMDecryptor;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PasswordException;

public class JcePEMDecryptorProviderBuilder
{
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  
  public PEMDecryptorProvider build(final char[] paramArrayOfChar)
  {
    new PEMDecryptorProvider()
    {
      public PEMDecryptor get(final String paramAnonymousString)
      {
        new PEMDecryptor()
        {
          public byte[] decrypt(byte[] paramAnonymous2ArrayOfByte1, byte[] paramAnonymous2ArrayOfByte2)
            throws PEMException
          {
            if (JcePEMDecryptorProviderBuilder.1.this.val$password != null) {
              return PEMUtilities.crypt(false, JcePEMDecryptorProviderBuilder.this.helper, paramAnonymous2ArrayOfByte1, JcePEMDecryptorProviderBuilder.1.this.val$password, paramAnonymousString, paramAnonymous2ArrayOfByte2);
            }
            throw new PasswordException("Password is null, but a password is required");
          }
        };
      }
    };
  }
  
  public JcePEMDecryptorProviderBuilder setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcePEMDecryptorProviderBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JcePEMDecryptorProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */