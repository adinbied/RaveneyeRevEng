package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyTransRecipientId;
import org.bouncycastle.cms.RecipientOperator;
import org.bouncycastle.jcajce.io.CipherInputStream;
import org.bouncycastle.operator.InputDecryptor;

public class JceKTSKeyTransEnvelopedRecipient
  extends JceKTSKeyTransRecipient
{
  public JceKTSKeyTransEnvelopedRecipient(PrivateKey paramPrivateKey, KeyTransRecipientId paramKeyTransRecipientId)
    throws IOException
  {
    super(paramPrivateKey, getPartyVInfoFromRID(paramKeyTransRecipientId));
  }
  
  public RecipientOperator getRecipientOperator(AlgorithmIdentifier paramAlgorithmIdentifier1, final AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CMSException
  {
    paramAlgorithmIdentifier1 = extractSecretKey(paramAlgorithmIdentifier1, paramAlgorithmIdentifier2, paramArrayOfByte);
    new RecipientOperator(new InputDecryptor()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return paramAlgorithmIdentifier2;
      }
      
      public InputStream getInputStream(InputStream paramAnonymousInputStream)
      {
        return new CipherInputStream(paramAnonymousInputStream, this.val$dataCipher);
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKTSKeyTransEnvelopedRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */