package org.bouncycastle.openssl.jcajce;

import java.security.PrivateKey;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PKCS8Generator;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.util.io.pem.PemGenerationException;

public class JcaPKCS8Generator
  extends PKCS8Generator
{
  public JcaPKCS8Generator(PrivateKey paramPrivateKey, OutputEncryptor paramOutputEncryptor)
    throws PemGenerationException
  {
    super(PrivateKeyInfo.getInstance(paramPrivateKey.getEncoded()), paramOutputEncryptor);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JcaPKCS8Generator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */