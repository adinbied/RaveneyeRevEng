package org.bouncycastle.openssl.bc;

import org.bouncycastle.openssl.PEMDecryptor;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PasswordException;

public class BcPEMDecryptorProvider
  implements PEMDecryptorProvider
{
  private final char[] password;
  
  public BcPEMDecryptorProvider(char[] paramArrayOfChar)
  {
    this.password = paramArrayOfChar;
  }
  
  public PEMDecryptor get(final String paramString)
  {
    new PEMDecryptor()
    {
      public byte[] decrypt(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
        throws PEMException
      {
        if (BcPEMDecryptorProvider.this.password != null) {
          return PEMUtilities.crypt(false, paramAnonymousArrayOfByte1, BcPEMDecryptorProvider.this.password, paramString, paramAnonymousArrayOfByte2);
        }
        throw new PasswordException("Password is null, but a password is required");
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\bc\BcPEMDecryptorProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */