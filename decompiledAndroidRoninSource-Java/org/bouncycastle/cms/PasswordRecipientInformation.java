package org.bouncycastle.cms;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Integers;

public class PasswordRecipientInformation
  extends RecipientInformation
{
  static Map BLOCKSIZES;
  static Map KEYSIZES = new HashMap();
  private PasswordRecipientInfo info;
  
  static
  {
    HashMap localHashMap = new HashMap();
    BLOCKSIZES = localHashMap;
    localHashMap.put(CMSAlgorithm.DES_EDE3_CBC, Integers.valueOf(8));
    BLOCKSIZES.put(CMSAlgorithm.AES128_CBC, Integers.valueOf(16));
    BLOCKSIZES.put(CMSAlgorithm.AES192_CBC, Integers.valueOf(16));
    BLOCKSIZES.put(CMSAlgorithm.AES256_CBC, Integers.valueOf(16));
    KEYSIZES.put(CMSAlgorithm.DES_EDE3_CBC, Integers.valueOf(192));
    KEYSIZES.put(CMSAlgorithm.AES128_CBC, Integers.valueOf(128));
    KEYSIZES.put(CMSAlgorithm.AES192_CBC, Integers.valueOf(192));
    KEYSIZES.put(CMSAlgorithm.AES256_CBC, Integers.valueOf(256));
  }
  
  PasswordRecipientInformation(PasswordRecipientInfo paramPasswordRecipientInfo, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    super(paramPasswordRecipientInfo.getKeyEncryptionAlgorithm(), paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
    this.info = paramPasswordRecipientInfo;
    this.rid = new PasswordRecipientId();
  }
  
  public String getKeyDerivationAlgOID()
  {
    if (this.info.getKeyDerivationAlgorithm() != null) {
      return this.info.getKeyDerivationAlgorithm().getAlgorithm().getId();
    }
    return null;
  }
  
  public byte[] getKeyDerivationAlgParams()
  {
    try
    {
      if (this.info.getKeyDerivationAlgorithm() != null)
      {
        Object localObject = this.info.getKeyDerivationAlgorithm().getParameters();
        if (localObject != null)
        {
          localObject = ((ASN1Encodable)localObject).toASN1Primitive().getEncoded();
          return (byte[])localObject;
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception getting encryption parameters ");
      localStringBuilder.append(localException);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public AlgorithmIdentifier getKeyDerivationAlgorithm()
  {
    return this.info.getKeyDerivationAlgorithm();
  }
  
  protected RecipientOperator getRecipientOperator(Recipient paramRecipient)
    throws CMSException, IOException
  {
    paramRecipient = (PasswordRecipient)paramRecipient;
    AlgorithmIdentifier localAlgorithmIdentifier = AlgorithmIdentifier.getInstance(AlgorithmIdentifier.getInstance(this.info.getKeyEncryptionAlgorithm()).getParameters());
    int i = ((Integer)KEYSIZES.get(localAlgorithmIdentifier.getAlgorithm())).intValue();
    byte[] arrayOfByte = paramRecipient.calculateDerivedKey(paramRecipient.getPasswordConversionScheme(), getKeyDerivationAlgorithm(), i);
    return paramRecipient.getRecipientOperator(localAlgorithmIdentifier, this.messageAlgorithm, arrayOfByte, this.info.getEncryptedKey().getOctets());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\PasswordRecipientInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */