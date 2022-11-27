package org.bouncycastle.cms.jcajce;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.PasswordRecipient;

public abstract class JcePasswordRecipient
  implements PasswordRecipient
{
  protected EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  private char[] password;
  private int schemeID = 1;
  
  JcePasswordRecipient(char[] paramArrayOfChar)
  {
    this.password = paramArrayOfChar;
  }
  
  public byte[] calculateDerivedKey(int paramInt1, AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt2)
    throws CMSException
  {
    return this.helper.calculateDerivedKey(paramInt1, this.password, paramAlgorithmIdentifier, paramInt2);
  }
  
  protected Key extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws CMSException
  {
    Cipher localCipher = this.helper.createRFC3211Wrapper(paramAlgorithmIdentifier1.getAlgorithm());
    try
    {
      paramAlgorithmIdentifier1 = new IvParameterSpec(ASN1OctetString.getInstance(paramAlgorithmIdentifier1.getParameters()).getOctets());
      localCipher.init(4, new SecretKeySpec(paramArrayOfByte1, localCipher.getAlgorithm()), paramAlgorithmIdentifier1);
      paramAlgorithmIdentifier1 = localCipher.unwrap(paramArrayOfByte2, paramAlgorithmIdentifier2.getAlgorithm().getId(), 3);
      return paramAlgorithmIdentifier1;
    }
    catch (GeneralSecurityException paramAlgorithmIdentifier1)
    {
      paramAlgorithmIdentifier2 = new StringBuilder();
      paramAlgorithmIdentifier2.append("cannot process content encryption key: ");
      paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getMessage());
      throw new CMSException(paramAlgorithmIdentifier2.toString(), paramAlgorithmIdentifier1);
    }
  }
  
  public char[] getPassword()
  {
    return this.password;
  }
  
  public int getPasswordConversionScheme()
  {
    return this.schemeID;
  }
  
  public JcePasswordRecipient setPasswordConversionScheme(int paramInt)
  {
    this.schemeID = paramInt;
    return this;
  }
  
  public JcePasswordRecipient setProvider(String paramString)
  {
    this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    return this;
  }
  
  public JcePasswordRecipient setProvider(Provider paramProvider)
  {
    this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JcePasswordRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */