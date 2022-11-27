package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.io.Streams;

public abstract class RecipientInformation
{
  private AuthAttributesProvider additionalData;
  protected AlgorithmIdentifier keyEncAlg;
  protected AlgorithmIdentifier messageAlgorithm;
  private RecipientOperator operator;
  private byte[] resultMac;
  protected RecipientId rid;
  protected CMSSecureReadable secureReadable;
  
  RecipientInformation(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    this.keyEncAlg = paramAlgorithmIdentifier1;
    this.messageAlgorithm = paramAlgorithmIdentifier2;
    this.secureReadable = paramCMSSecureReadable;
    this.additionalData = paramAuthAttributesProvider;
  }
  
  private byte[] encodeObj(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    if (paramASN1Encodable != null) {
      return paramASN1Encodable.toASN1Primitive().getEncoded();
    }
    return null;
  }
  
  public byte[] getContent(Recipient paramRecipient)
    throws CMSException
  {
    try
    {
      paramRecipient = CMSUtils.streamToByteArray(getContentStream(paramRecipient).getContentStream());
      return paramRecipient;
    }
    catch (IOException paramRecipient)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to parse internal stream: ");
      localStringBuilder.append(paramRecipient.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramRecipient);
    }
  }
  
  public byte[] getContentDigest()
  {
    CMSSecureReadable localCMSSecureReadable = this.secureReadable;
    if ((localCMSSecureReadable instanceof CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable)) {
      return ((CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable)localCMSSecureReadable).getDigest();
    }
    return null;
  }
  
  public CMSTypedStream getContentStream(Recipient paramRecipient)
    throws CMSException, IOException
  {
    paramRecipient = getRecipientOperator(paramRecipient);
    this.operator = paramRecipient;
    if (this.additionalData != null) {
      return new CMSTypedStream(this.secureReadable.getInputStream());
    }
    return new CMSTypedStream(paramRecipient.getInputStream(this.secureReadable.getInputStream()));
  }
  
  public String getKeyEncryptionAlgOID()
  {
    return this.keyEncAlg.getAlgorithm().getId();
  }
  
  public byte[] getKeyEncryptionAlgParams()
  {
    try
    {
      byte[] arrayOfByte = encodeObj(this.keyEncAlg.getParameters());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception getting encryption parameters ");
      localStringBuilder.append(localException);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public AlgorithmIdentifier getKeyEncryptionAlgorithm()
  {
    return this.keyEncAlg;
  }
  
  public byte[] getMac()
  {
    if ((this.resultMac == null) && (this.operator.isMacBased()))
    {
      if (this.additionalData != null) {
        try
        {
          Streams.drain(this.operator.getInputStream(new ByteArrayInputStream(this.additionalData.getAuthAttributes().getEncoded("DER"))));
        }
        catch (IOException localIOException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unable to drain input: ");
          localStringBuilder.append(localIOException.getMessage());
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      this.resultMac = this.operator.getMac();
    }
    return this.resultMac;
  }
  
  public RecipientId getRID()
  {
    return this.rid;
  }
  
  protected abstract RecipientOperator getRecipientOperator(Recipient paramRecipient)
    throws CMSException, IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\RecipientInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */