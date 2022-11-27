package org.bouncycastle.cms.bc;

import java.io.InputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.RecipientOperator;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.operator.InputDecryptor;

public class BcPasswordEnvelopedRecipient
  extends BcPasswordRecipient
{
  public BcPasswordEnvelopedRecipient(char[] paramArrayOfChar)
  {
    super(paramArrayOfChar);
  }
  
  public RecipientOperator getRecipientOperator(AlgorithmIdentifier paramAlgorithmIdentifier1, final AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws CMSException
  {
    new RecipientOperator(new InputDecryptor()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return paramAlgorithmIdentifier2;
      }
      
      public InputStream getInputStream(InputStream paramAnonymousInputStream)
      {
        if ((this.val$dataCipher instanceof BufferedBlockCipher)) {
          return new CipherInputStream(paramAnonymousInputStream, (BufferedBlockCipher)this.val$dataCipher);
        }
        return new CipherInputStream(paramAnonymousInputStream, (StreamCipher)this.val$dataCipher);
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcPasswordEnvelopedRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */