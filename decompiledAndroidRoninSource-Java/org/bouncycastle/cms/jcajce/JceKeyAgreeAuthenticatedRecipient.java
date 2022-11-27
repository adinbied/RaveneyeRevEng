package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.Key;
import java.security.PrivateKey;
import javax.crypto.Mac;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.RecipientOperator;
import org.bouncycastle.jcajce.io.MacOutputStream;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.jcajce.JceGenericKey;

public class JceKeyAgreeAuthenticatedRecipient
  extends JceKeyAgreeRecipient
{
  public JceKeyAgreeAuthenticatedRecipient(PrivateKey paramPrivateKey)
  {
    super(paramPrivateKey);
  }
  
  public RecipientOperator getRecipientOperator(final AlgorithmIdentifier paramAlgorithmIdentifier1, final AlgorithmIdentifier paramAlgorithmIdentifier2, SubjectPublicKeyInfo paramSubjectPublicKeyInfo, ASN1OctetString paramASN1OctetString, byte[] paramArrayOfByte)
    throws CMSException
  {
    paramAlgorithmIdentifier1 = extractSecretKey(paramAlgorithmIdentifier1, paramAlgorithmIdentifier2, paramSubjectPublicKeyInfo, paramASN1OctetString, paramArrayOfByte);
    new RecipientOperator(new MacCalculator()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return paramAlgorithmIdentifier2;
      }
      
      public GenericKey getKey()
      {
        return new JceGenericKey(paramAlgorithmIdentifier2, paramAlgorithmIdentifier1);
      }
      
      public byte[] getMac()
      {
        return this.val$dataMac.doFinal();
      }
      
      public OutputStream getOutputStream()
      {
        return new MacOutputStream(this.val$dataMac);
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKeyAgreeAuthenticatedRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */