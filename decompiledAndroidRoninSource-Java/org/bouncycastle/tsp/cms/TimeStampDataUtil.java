package org.bouncycastle.tsp.cms;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.Evidence;
import org.bouncycastle.asn1.cms.TimeStampAndCRL;
import org.bouncycastle.asn1.cms.TimeStampTokenEvidence;
import org.bouncycastle.asn1.cms.TimeStampedData;
import org.bouncycastle.asn1.cms.TimeStampedDataParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.tsp.TimeStampTokenInfo;
import org.bouncycastle.util.Arrays;

class TimeStampDataUtil
{
  private final MetaDataUtil metaDataUtil;
  private final TimeStampAndCRL[] timeStamps;
  
  TimeStampDataUtil(TimeStampedData paramTimeStampedData)
  {
    this.metaDataUtil = new MetaDataUtil(paramTimeStampedData.getMetaData());
    this.timeStamps = paramTimeStampedData.getTemporalEvidence().getTstEvidence().toTimeStampAndCRLArray();
  }
  
  TimeStampDataUtil(TimeStampedDataParser paramTimeStampedDataParser)
    throws IOException
  {
    this.metaDataUtil = new MetaDataUtil(paramTimeStampedDataParser.getMetaData());
    this.timeStamps = paramTimeStampedDataParser.getTemporalEvidence().getTstEvidence().toTimeStampAndCRLArray();
  }
  
  private void compareDigest(TimeStampToken paramTimeStampToken, byte[] paramArrayOfByte)
    throws ImprintDigestInvalidException
  {
    if (Arrays.areEqual(paramArrayOfByte, paramTimeStampToken.getTimeStampInfo().getMessageImprintDigest())) {
      return;
    }
    throw new ImprintDigestInvalidException("hash calculated is different from MessageImprintDigest found in TimeStampToken", paramTimeStampToken);
  }
  
  byte[] calculateNextHash(DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    Object localObject = this.timeStamps;
    localObject = localObject[(localObject.length - 1)];
    OutputStream localOutputStream = paramDigestCalculator.getOutputStream();
    try
    {
      localOutputStream.write(((TimeStampAndCRL)localObject).getEncoded("DER"));
      localOutputStream.close();
      paramDigestCalculator = paramDigestCalculator.getDigest();
      return paramDigestCalculator;
    }
    catch (IOException paramDigestCalculator)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception calculating hash: ");
      ((StringBuilder)localObject).append(paramDigestCalculator.getMessage());
      throw new CMSException(((StringBuilder)localObject).toString(), paramDigestCalculator);
    }
  }
  
  String getFileName()
  {
    return this.metaDataUtil.getFileName();
  }
  
  String getMediaType()
  {
    return this.metaDataUtil.getMediaType();
  }
  
  DigestCalculator getMessageImprintDigestCalculator(DigestCalculatorProvider paramDigestCalculatorProvider)
    throws OperatorCreationException
  {
    try
    {
      paramDigestCalculatorProvider = paramDigestCalculatorProvider.get(new AlgorithmIdentifier(getTimeStampToken(this.timeStamps[0]).getTimeStampInfo().getMessageImprintAlgOID()));
      initialiseMessageImprintDigestCalculator(paramDigestCalculatorProvider);
      return paramDigestCalculatorProvider;
    }
    catch (CMSException paramDigestCalculatorProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to extract algorithm ID: ");
      localStringBuilder.append(paramDigestCalculatorProvider.getMessage());
      throw new OperatorCreationException(localStringBuilder.toString(), paramDigestCalculatorProvider);
    }
  }
  
  AttributeTable getOtherMetaData()
  {
    return new AttributeTable(this.metaDataUtil.getOtherMetaData());
  }
  
  TimeStampToken getTimeStampToken(TimeStampAndCRL paramTimeStampAndCRL)
    throws CMSException
  {
    paramTimeStampAndCRL = paramTimeStampAndCRL.getTimeStampToken();
    try
    {
      paramTimeStampAndCRL = new TimeStampToken(paramTimeStampAndCRL);
      return paramTimeStampAndCRL;
    }
    catch (IllegalArgumentException paramTimeStampAndCRL)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("token data invalid: ");
      localStringBuilder.append(paramTimeStampAndCRL.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramTimeStampAndCRL);
    }
    catch (TSPException paramTimeStampAndCRL)
    {
      if ((paramTimeStampAndCRL.getCause() instanceof CMSException)) {
        throw ((CMSException)paramTimeStampAndCRL.getCause());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("token data invalid: ");
      localStringBuilder.append(paramTimeStampAndCRL.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramTimeStampAndCRL);
    }
    catch (IOException paramTimeStampAndCRL)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to parse token data: ");
      localStringBuilder.append(paramTimeStampAndCRL.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramTimeStampAndCRL);
    }
  }
  
  TimeStampToken[] getTimeStampTokens()
    throws CMSException
  {
    TimeStampToken[] arrayOfTimeStampToken = new TimeStampToken[this.timeStamps.length];
    int i = 0;
    for (;;)
    {
      TimeStampAndCRL[] arrayOfTimeStampAndCRL = this.timeStamps;
      if (i >= arrayOfTimeStampAndCRL.length) {
        break;
      }
      arrayOfTimeStampToken[i] = getTimeStampToken(arrayOfTimeStampAndCRL[i]);
      i += 1;
    }
    return arrayOfTimeStampToken;
  }
  
  TimeStampAndCRL[] getTimeStamps()
  {
    return this.timeStamps;
  }
  
  void initialiseMessageImprintDigestCalculator(DigestCalculator paramDigestCalculator)
    throws CMSException
  {
    this.metaDataUtil.initialiseMessageImprintDigestCalculator(paramDigestCalculator);
  }
  
  void validate(DigestCalculatorProvider paramDigestCalculatorProvider, byte[] paramArrayOfByte)
    throws ImprintDigestInvalidException, CMSException
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.timeStamps;
      if (i < localObject.length) {
        try
        {
          localObject = getTimeStampToken(localObject[i]);
          if (i > 0)
          {
            paramArrayOfByte = paramDigestCalculatorProvider.get(((TimeStampToken)localObject).getTimeStampInfo().getHashAlgorithm());
            paramArrayOfByte.getOutputStream().write(this.timeStamps[(i - 1)].getEncoded("DER"));
            paramArrayOfByte = paramArrayOfByte.getDigest();
          }
          compareDigest((TimeStampToken)localObject, paramArrayOfByte);
          i += 1;
        }
        catch (OperatorCreationException paramDigestCalculatorProvider)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("cannot create digest: ");
          paramArrayOfByte.append(paramDigestCalculatorProvider.getMessage());
          throw new CMSException(paramArrayOfByte.toString(), paramDigestCalculatorProvider);
        }
        catch (IOException paramDigestCalculatorProvider)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("exception calculating hash: ");
          paramArrayOfByte.append(paramDigestCalculatorProvider.getMessage());
          throw new CMSException(paramArrayOfByte.toString(), paramDigestCalculatorProvider);
        }
      }
    }
  }
  
  void validate(DigestCalculatorProvider paramDigestCalculatorProvider, byte[] paramArrayOfByte, TimeStampToken paramTimeStampToken)
    throws ImprintDigestInvalidException, CMSException
  {
    try
    {
      byte[] arrayOfByte = paramTimeStampToken.getEncoded();
      int i = 0;
      for (;;)
      {
        Object localObject = this.timeStamps;
        if (i < localObject.length) {
          try
          {
            localObject = getTimeStampToken(localObject[i]);
            if (i > 0)
            {
              paramArrayOfByte = paramDigestCalculatorProvider.get(((TimeStampToken)localObject).getTimeStampInfo().getHashAlgorithm());
              paramArrayOfByte.getOutputStream().write(this.timeStamps[(i - 1)].getEncoded("DER"));
              paramArrayOfByte = paramArrayOfByte.getDigest();
            }
            compareDigest((TimeStampToken)localObject, paramArrayOfByte);
            boolean bool = Arrays.areEqual(((TimeStampToken)localObject).getEncoded(), arrayOfByte);
            if (bool) {
              return;
            }
            i += 1;
          }
          catch (OperatorCreationException paramDigestCalculatorProvider)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("cannot create digest: ");
            paramArrayOfByte.append(paramDigestCalculatorProvider.getMessage());
            throw new CMSException(paramArrayOfByte.toString(), paramDigestCalculatorProvider);
          }
          catch (IOException paramDigestCalculatorProvider)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("exception calculating hash: ");
            paramArrayOfByte.append(paramDigestCalculatorProvider.getMessage());
            throw new CMSException(paramArrayOfByte.toString(), paramDigestCalculatorProvider);
          }
        }
      }
      throw new ImprintDigestInvalidException("passed in token not associated with timestamps present", paramTimeStampToken);
    }
    catch (IOException paramDigestCalculatorProvider)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("exception encoding timeStampToken: ");
      paramArrayOfByte.append(paramDigestCalculatorProvider.getMessage());
      throw new CMSException(paramArrayOfByte.toString(), paramDigestCalculatorProvider);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\cms\TimeStampDataUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */