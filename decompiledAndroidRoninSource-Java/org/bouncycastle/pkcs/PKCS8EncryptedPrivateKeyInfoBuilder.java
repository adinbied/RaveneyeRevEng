package org.bouncycastle.pkcs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.operator.OutputEncryptor;

public class PKCS8EncryptedPrivateKeyInfoBuilder
{
  private PrivateKeyInfo privateKeyInfo;
  
  public PKCS8EncryptedPrivateKeyInfoBuilder(PrivateKeyInfo paramPrivateKeyInfo)
  {
    this.privateKeyInfo = paramPrivateKeyInfo;
  }
  
  public PKCS8EncryptedPrivateKeyInfo build(OutputEncryptor paramOutputEncryptor)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      OutputStream localOutputStream = paramOutputEncryptor.getOutputStream(localByteArrayOutputStream);
      localOutputStream.write(this.privateKeyInfo.getEncoded());
      localOutputStream.close();
      paramOutputEncryptor = new PKCS8EncryptedPrivateKeyInfo(new EncryptedPrivateKeyInfo(paramOutputEncryptor.getAlgorithmIdentifier(), localByteArrayOutputStream.toByteArray()));
      return paramOutputEncryptor;
    }
    catch (IOException paramOutputEncryptor)
    {
      for (;;) {}
    }
    throw new IllegalStateException("cannot encode privateKeyInfo");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS8EncryptedPrivateKeyInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */