package org.bouncycastle.cms.jcajce;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.PasswordRecipientInfoGenerator;
import org.bouncycastle.operator.GenericKey;

public class JcePasswordRecipientInfoGenerator
  extends PasswordRecipientInfoGenerator
{
  private EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  
  public JcePasswordRecipientInfoGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier, char[] paramArrayOfChar)
  {
    super(paramASN1ObjectIdentifier, paramArrayOfChar);
  }
  
  protected byte[] calculateDerivedKey(int paramInt1, AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt2)
    throws CMSException
  {
    return this.helper.calculateDerivedKey(paramInt1, this.password, paramAlgorithmIdentifier, paramInt2);
  }
  
  public byte[] generateEncryptedBytes(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte, GenericKey paramGenericKey)
    throws CMSException
  {
    paramGenericKey = this.helper.getJceKey(paramGenericKey);
    Cipher localCipher = this.helper.createRFC3211Wrapper(paramAlgorithmIdentifier.getAlgorithm());
    try
    {
      paramAlgorithmIdentifier = new IvParameterSpec(ASN1OctetString.getInstance(paramAlgorithmIdentifier.getParameters()).getOctets());
      localCipher.init(3, new SecretKeySpec(paramArrayOfByte, localCipher.getAlgorithm()), paramAlgorithmIdentifier);
      paramAlgorithmIdentifier = localCipher.wrap(paramGenericKey);
      return paramAlgorithmIdentifier;
    }
    catch (GeneralSecurityException paramAlgorithmIdentifier)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("cannot process content encryption key: ");
      paramArrayOfByte.append(paramAlgorithmIdentifier.getMessage());
      throw new CMSException(paramArrayOfByte.toString(), paramAlgorithmIdentifier);
    }
  }
  
  public JcePasswordRecipientInfoGenerator setProvider(String paramString)
  {
    this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    return this;
  }
  
  public JcePasswordRecipientInfoGenerator setProvider(Provider paramProvider)
  {
    this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JcePasswordRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */