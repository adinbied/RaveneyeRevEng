package org.bouncycastle.tsp.cms;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.Evidence;
import org.bouncycastle.asn1.cms.TimeStampAndCRL;
import org.bouncycastle.asn1.cms.TimeStampTokenEvidence;
import org.bouncycastle.asn1.cms.TimeStampedData;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.util.io.Streams;

public class CMSTimeStampedDataGenerator
  extends CMSTimeStampedGenerator
{
  public CMSTimeStampedData generate(TimeStampToken paramTimeStampToken)
    throws CMSException
  {
    return generate(paramTimeStampToken, (InputStream)null);
  }
  
  public CMSTimeStampedData generate(TimeStampToken paramTimeStampToken, InputStream paramInputStream)
    throws CMSException
  {
    Object localObject2 = new ByteArrayOutputStream();
    if (paramInputStream != null) {
      try
      {
        Streams.pipeAll(paramInputStream, (OutputStream)localObject2);
      }
      catch (IOException paramTimeStampToken)
      {
        paramInputStream = new StringBuilder();
        paramInputStream.append("exception encapsulating content: ");
        paramInputStream.append(paramTimeStampToken.getMessage());
        throw new CMSException(paramInputStream.toString(), paramTimeStampToken);
      }
    }
    int i = ((ByteArrayOutputStream)localObject2).size();
    Object localObject1 = null;
    if (i != 0) {
      paramInputStream = new BEROctetString(((ByteArrayOutputStream)localObject2).toByteArray());
    } else {
      paramInputStream = null;
    }
    localObject2 = new TimeStampAndCRL(paramTimeStampToken.toCMSSignedData().toASN1Structure());
    paramTimeStampToken = (TimeStampToken)localObject1;
    if (this.dataUri != null) {
      paramTimeStampToken = new DERIA5String(this.dataUri.toString());
    }
    return new CMSTimeStampedData(new ContentInfo(CMSObjectIdentifiers.timestampedData, new TimeStampedData(paramTimeStampToken, this.metaData, paramInputStream, new Evidence(new TimeStampTokenEvidence((TimeStampAndCRL)localObject2)))));
  }
  
  public CMSTimeStampedData generate(TimeStampToken paramTimeStampToken, byte[] paramArrayOfByte)
    throws CMSException
  {
    return generate(paramTimeStampToken, new ByteArrayInputStream(paramArrayOfByte));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\cms\CMSTimeStampedDataGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */