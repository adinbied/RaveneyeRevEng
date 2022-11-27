package org.bouncycastle.pkcs.jcajce;

import java.security.PrivateKey;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfoBuilder;

public class JcaPKCS8EncryptedPrivateKeyInfoBuilder
  extends PKCS8EncryptedPrivateKeyInfoBuilder
{
  public JcaPKCS8EncryptedPrivateKeyInfoBuilder(PrivateKey paramPrivateKey)
  {
    super(PrivateKeyInfo.getInstance(paramPrivateKey.getEncoded()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\jcajce\JcaPKCS8EncryptedPrivateKeyInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */