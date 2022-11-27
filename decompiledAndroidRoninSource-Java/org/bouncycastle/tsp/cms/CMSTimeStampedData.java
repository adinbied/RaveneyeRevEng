package org.bouncycastle.tsp.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.Evidence;
import org.bouncycastle.asn1.cms.TimeStampAndCRL;
import org.bouncycastle.asn1.cms.TimeStampTokenEvidence;
import org.bouncycastle.asn1.cms.TimeStampedData;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TimeStampToken;

public class CMSTimeStampedData
{
  private ContentInfo contentInfo;
  private TimeStampedData timeStampedData;
  private TimeStampDataUtil util;
  
  public CMSTimeStampedData(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      initialize(ContentInfo.getInstance(new ASN1InputStream(paramInputStream).readObject()));
      return;
    }
    catch (IllegalArgumentException paramInputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Malformed content: ");
      localStringBuilder.append(paramInputStream);
      throw new IOException(localStringBuilder.toString());
    }
    catch (ClassCastException paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Malformed content: ");
      localStringBuilder.append(paramInputStream);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public CMSTimeStampedData(ContentInfo paramContentInfo)
  {
    initialize(paramContentInfo);
  }
  
  public CMSTimeStampedData(byte[] paramArrayOfByte)
    throws IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private void initialize(ContentInfo paramContentInfo)
  {
    this.contentInfo = paramContentInfo;
    if (CMSObjectIdentifiers.timestampedData.equals(paramContentInfo.getContentType()))
    {
      paramContentInfo = TimeStampedData.getInstance(paramContentInfo.getContent());
      this.timeStampedData = paramContentInfo;
      this.util = new TimeStampDataUtil(paramContentInfo);
      return;
    }
    paramContentInfo = new StringBuilder();
    paramContentInfo.append("Malformed content - type must be ");
    paramContentInfo.append(CMSObjectIdentifiers.timestampedData.getId());
    throw new IllegalArgumentException(paramContentInfo.toString());
  }
  
  public CMSTimeStampedData addTimeStamp(TimeStampToken paramTimeStampToken)
    throws CMSException
  {
    TimeStampAndCRL[] arrayOfTimeStampAndCRL1 = this.util.getTimeStamps();
    TimeStampAndCRL[] arrayOfTimeStampAndCRL2 = new TimeStampAndCRL[arrayOfTimeStampAndCRL1.length + 1];
    System.arraycopy(arrayOfTimeStampAndCRL1, 0, arrayOfTimeStampAndCRL2, 0, arrayOfTimeStampAndCRL1.length);
    arrayOfTimeStampAndCRL2[arrayOfTimeStampAndCRL1.length] = new TimeStampAndCRL(paramTimeStampToken.toCMSSignedData().toASN1Structure());
    return new CMSTimeStampedData(new ContentInfo(CMSObjectIdentifiers.timestampedData, new TimeStampedData(this.timeStampedData.getDataUri(), this.timeStampedData.getMetaData(), this.timeStampedData.getContent(), new Evidence(new TimeStampTokenEvidence(arrayOfTimeStampAndCRL2)))));
  }
  
  public byte[] calculateNextHash(DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    return this.util.calculateNextHash(paramDigestCalculator);
  }
  
  public byte[] getContent()
  {
    if (this.timeStampedData.getContent() != null) {
      return this.timeStampedData.getContent().getOctets();
    }
    return null;
  }
  
  public URI getDataUri()
    throws URISyntaxException
  {
    DERIA5String localDERIA5String = this.timeStampedData.getDataUri();
    if (localDERIA5String != null) {
      return new URI(localDERIA5String.getString());
    }
    return null;
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.contentInfo.getEncoded();
  }
  
  public String getFileName()
  {
    return this.util.getFileName();
  }
  
  public String getMediaType()
  {
    return this.util.getMediaType();
  }
  
  public DigestCalculator getMessageImprintDigestCalculator(DigestCalculatorProvider paramDigestCalculatorProvider)
    throws OperatorCreationException
  {
    return this.util.getMessageImprintDigestCalculator(paramDigestCalculatorProvider);
  }
  
  public AttributeTable getOtherMetaData()
  {
    return this.util.getOtherMetaData();
  }
  
  public TimeStampToken[] getTimeStampTokens()
    throws CMSException
  {
    return this.util.getTimeStampTokens();
  }
  
  public void initialiseMessageImprintDigestCalculator(DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    this.util.initialiseMessageImprintDigestCalculator(paramDigestCalculator);
  }
  
  public void validate(DigestCalculatorProvider paramDigestCalculatorProvider, byte[] paramArrayOfByte)
    throws ImprintDigestInvalidException, CMSException
  {
    this.util.validate(paramDigestCalculatorProvider, paramArrayOfByte);
  }
  
  public void validate(DigestCalculatorProvider paramDigestCalculatorProvider, byte[] paramArrayOfByte, TimeStampToken paramTimeStampToken)
    throws ImprintDigestInvalidException, CMSException
  {
    this.util.validate(paramDigestCalculatorProvider, paramArrayOfByte, paramTimeStampToken);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\cms\CMSTimeStampedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */