package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.DERIA5String;

public class TimeStampedDataParser
{
  private ASN1OctetStringParser content;
  private DERIA5String dataUri;
  private MetaData metaData;
  private ASN1SequenceParser parser;
  private Evidence temporalEvidence;
  private ASN1Integer version;
  
  private TimeStampedDataParser(ASN1SequenceParser paramASN1SequenceParser)
    throws IOException
  {
    this.parser = paramASN1SequenceParser;
    this.version = ASN1Integer.getInstance(paramASN1SequenceParser.readObject());
    Object localObject2 = paramASN1SequenceParser.readObject();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof DERIA5String))
    {
      this.dataUri = DERIA5String.getInstance(localObject2);
      localObject1 = paramASN1SequenceParser.readObject();
    }
    if (!(localObject1 instanceof MetaData))
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof ASN1SequenceParser)) {}
    }
    else
    {
      this.metaData = MetaData.getInstance(((ASN1Encodable)localObject1).toASN1Primitive());
      localObject2 = paramASN1SequenceParser.readObject();
    }
    if ((localObject2 instanceof ASN1OctetStringParser)) {
      this.content = ((ASN1OctetStringParser)localObject2);
    }
  }
  
  public static TimeStampedDataParser getInstance(Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof ASN1Sequence)) {
      return new TimeStampedDataParser(((ASN1Sequence)paramObject).parser());
    }
    if ((paramObject instanceof ASN1SequenceParser)) {
      return new TimeStampedDataParser((ASN1SequenceParser)paramObject);
    }
    return null;
  }
  
  public ASN1OctetStringParser getContent()
  {
    return this.content;
  }
  
  public DERIA5String getDataUri()
  {
    return this.dataUri;
  }
  
  public MetaData getMetaData()
  {
    return this.metaData;
  }
  
  public Evidence getTemporalEvidence()
    throws IOException
  {
    if (this.temporalEvidence == null) {
      this.temporalEvidence = Evidence.getInstance(this.parser.readObject().toASN1Primitive());
    }
    return this.temporalEvidence;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\TimeStampedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */