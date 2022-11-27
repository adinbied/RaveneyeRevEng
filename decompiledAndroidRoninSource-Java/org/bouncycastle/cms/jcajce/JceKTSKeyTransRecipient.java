package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.KeyTransRecipient;
import org.bouncycastle.cms.KeyTransRecipientId;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.operator.jcajce.JceKTSKeyUnwrapper;
import org.bouncycastle.util.encoders.Hex;

public abstract class JceKTSKeyTransRecipient
  implements KeyTransRecipient
{
  private static final byte[] ANONYMOUS_SENDER = Hex.decode("0c14416e6f6e796d6f75732053656e64657220202020");
  protected EnvelopedDataHelper contentHelper;
  protected Map extraMappings;
  protected EnvelopedDataHelper helper;
  private final byte[] partyVInfo;
  private PrivateKey recipientKey;
  protected boolean unwrappedKeyMustBeEncodable;
  protected boolean validateKeySize;
  
  public JceKTSKeyTransRecipient(PrivateKey paramPrivateKey, byte[] paramArrayOfByte)
  {
    EnvelopedDataHelper localEnvelopedDataHelper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    this.helper = localEnvelopedDataHelper;
    this.contentHelper = localEnvelopedDataHelper;
    this.extraMappings = new HashMap();
    this.validateKeySize = false;
    this.recipientKey = paramPrivateKey;
    this.partyVInfo = paramArrayOfByte;
  }
  
  protected static byte[] getPartyVInfoFromRID(KeyTransRecipientId paramKeyTransRecipientId)
    throws IOException
  {
    if (paramKeyTransRecipientId.getSerialNumber() != null) {
      return new IssuerAndSerialNumber(paramKeyTransRecipientId.getIssuer(), paramKeyTransRecipientId.getSerialNumber()).getEncoded("DER");
    }
    return new DEROctetString(paramKeyTransRecipientId.getSubjectKeyIdentifier()).getEncoded();
  }
  
  protected Key extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CMSException
  {
    paramAlgorithmIdentifier1 = this.helper.createAsymmetricUnwrapper(paramAlgorithmIdentifier1, this.recipientKey, ANONYMOUS_SENDER, this.partyVInfo);
    try
    {
      paramAlgorithmIdentifier1 = this.helper.getJceKey(paramAlgorithmIdentifier2.getAlgorithm(), paramAlgorithmIdentifier1.generateUnwrappedKey(paramAlgorithmIdentifier2, paramArrayOfByte));
      if (this.validateKeySize) {
        this.helper.keySizeCheck(paramAlgorithmIdentifier2, paramAlgorithmIdentifier1);
      }
      return paramAlgorithmIdentifier1;
    }
    catch (OperatorException paramAlgorithmIdentifier1)
    {
      paramAlgorithmIdentifier2 = new StringBuilder();
      paramAlgorithmIdentifier2.append("exception unwrapping key: ");
      paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getMessage());
      throw new CMSException(paramAlgorithmIdentifier2.toString(), paramAlgorithmIdentifier1);
    }
  }
  
  public JceKTSKeyTransRecipient setAlgorithmMapping(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    this.extraMappings.put(paramASN1ObjectIdentifier, paramString);
    return this;
  }
  
  public JceKTSKeyTransRecipient setContentProvider(String paramString)
  {
    this.contentHelper = CMSUtils.createContentHelper(paramString);
    return this;
  }
  
  public JceKTSKeyTransRecipient setContentProvider(Provider paramProvider)
  {
    this.contentHelper = CMSUtils.createContentHelper(paramProvider);
    return this;
  }
  
  public JceKTSKeyTransRecipient setKeySizeValidation(boolean paramBoolean)
  {
    this.validateKeySize = paramBoolean;
    return this;
  }
  
  public JceKTSKeyTransRecipient setProvider(String paramString)
  {
    paramString = new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    this.helper = paramString;
    this.contentHelper = paramString;
    return this;
  }
  
  public JceKTSKeyTransRecipient setProvider(Provider paramProvider)
  {
    paramProvider = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    this.helper = paramProvider;
    this.contentHelper = paramProvider;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKTSKeyTransRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */