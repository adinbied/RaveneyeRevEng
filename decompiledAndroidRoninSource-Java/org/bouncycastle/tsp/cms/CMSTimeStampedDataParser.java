package org.bouncycastle.tsp.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfoParser;
import org.bouncycastle.asn1.cms.TimeStampedDataParser;
import org.bouncycastle.cms.CMSContentInfoParser;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.util.io.Streams;

public class CMSTimeStampedDataParser
  extends CMSContentInfoParser
{
  private TimeStampedDataParser timeStampedData;
  private TimeStampDataUtil util;
  
  public CMSTimeStampedDataParser(InputStream paramInputStream)
    throws CMSException
  {
    super(paramInputStream);
    initialize(this._contentInfo);
  }
  
  public CMSTimeStampedDataParser(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private void initialize(ContentInfoParser paramContentInfoParser)
    throws CMSException
  {
    try
    {
      if (CMSObjectIdentifiers.timestampedData.equals(paramContentInfoParser.getContentType()))
      {
        this.timeStampedData = TimeStampedDataParser.getInstance(paramContentInfoParser.getContent(16));
        return;
      }
      paramContentInfoParser = new StringBuilder();
      paramContentInfoParser.append("Malformed content - type must be ");
      paramContentInfoParser.append(CMSObjectIdentifiers.timestampedData.getId());
      throw new IllegalArgumentException(paramContentInfoParser.toString());
    }
    catch (IOException paramContentInfoParser)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parsing exception: ");
      localStringBuilder.append(paramContentInfoParser.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramContentInfoParser);
    }
  }
  
  private void parseTimeStamps()
    throws CMSException
  {
    try
    {
      if (this.util == null)
      {
        InputStream localInputStream = getContent();
        if (localInputStream != null) {
          Streams.drain(localInputStream);
        }
        this.util = new TimeStampDataUtil(this.timeStampedData);
      }
      return;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to parse evidence block: ");
      localStringBuilder.append(localIOException.getMessage());
      throw new CMSException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public byte[] calculateNextHash(DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    return this.util.calculateNextHash(paramDigestCalculator);
  }
  
  public InputStream getContent()
  {
    if (this.timeStampedData.getContent() != null) {
      return this.timeStampedData.getContent().getOctetStream();
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
    try
    {
      parseTimeStamps();
      return this.util.getMessageImprintDigestCalculator(paramDigestCalculatorProvider);
    }
    catch (CMSException paramDigestCalculatorProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to extract algorithm ID: ");
      localStringBuilder.append(paramDigestCalculatorProvider.getMessage());
      throw new OperatorCreationException(localStringBuilder.toString(), paramDigestCalculatorProvider);
    }
  }
  
  public AttributeTable getOtherMetaData()
  {
    return this.util.getOtherMetaData();
  }
  
  public TimeStampToken[] getTimeStampTokens()
    throws CMSException
  {
    parseTimeStamps();
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
    parseTimeStamps();
    this.util.validate(paramDigestCalculatorProvider, paramArrayOfByte);
  }
  
  public void validate(DigestCalculatorProvider paramDigestCalculatorProvider, byte[] paramArrayOfByte, TimeStampToken paramTimeStampToken)
    throws ImprintDigestInvalidException, CMSException
  {
    parseTimeStamps();
    this.util.validate(paramDigestCalculatorProvider, paramArrayOfByte, paramTimeStampToken);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\cms\CMSTimeStampedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */