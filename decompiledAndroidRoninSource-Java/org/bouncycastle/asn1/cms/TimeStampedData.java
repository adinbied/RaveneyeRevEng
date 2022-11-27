package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERIA5String;

public class TimeStampedData
  extends ASN1Object
{
  private ASN1OctetString content;
  private DERIA5String dataUri;
  private MetaData metaData;
  private Evidence temporalEvidence;
  private ASN1Integer version;
  
  private TimeStampedData(ASN1Sequence paramASN1Sequence)
  {
    this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    int j = 1;
    if ((paramASN1Sequence.getObjectAt(1) instanceof DERIA5String))
    {
      this.dataUri = DERIA5String.getInstance(paramASN1Sequence.getObjectAt(1));
      j = 2;
    }
    int i;
    if (!(paramASN1Sequence.getObjectAt(j) instanceof MetaData))
    {
      i = j;
      if (!(paramASN1Sequence.getObjectAt(j) instanceof ASN1Sequence)) {}
    }
    else
    {
      this.metaData = MetaData.getInstance(paramASN1Sequence.getObjectAt(j));
      i = j + 1;
    }
    j = i;
    if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1OctetString))
    {
      this.content = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(i));
      j = i + 1;
    }
    this.temporalEvidence = Evidence.getInstance(paramASN1Sequence.getObjectAt(j));
  }
  
  public TimeStampedData(DERIA5String paramDERIA5String, MetaData paramMetaData, ASN1OctetString paramASN1OctetString, Evidence paramEvidence)
  {
    this.version = new ASN1Integer(1L);
    this.dataUri = paramDERIA5String;
    this.metaData = paramMetaData;
    this.content = paramASN1OctetString;
    this.temporalEvidence = paramEvidence;
  }
  
  public static TimeStampedData getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof TimeStampedData))) {
      return new TimeStampedData(ASN1Sequence.getInstance(paramObject));
    }
    return (TimeStampedData)paramObject;
  }
  
  public ASN1OctetString getContent()
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
  {
    return this.temporalEvidence;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    Object localObject = this.dataUri;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.metaData;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.content;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localASN1EncodableVector.add(this.temporalEvidence);
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\TimeStampedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */