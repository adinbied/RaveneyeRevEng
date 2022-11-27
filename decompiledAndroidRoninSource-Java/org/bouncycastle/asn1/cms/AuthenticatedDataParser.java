package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class AuthenticatedDataParser
{
  private ASN1Encodable nextObject;
  private boolean originatorInfoCalled;
  private ASN1SequenceParser seq;
  private ASN1Integer version;
  
  public AuthenticatedDataParser(ASN1SequenceParser paramASN1SequenceParser)
    throws IOException
  {
    this.seq = paramASN1SequenceParser;
    this.version = ASN1Integer.getInstance(paramASN1SequenceParser.readObject());
  }
  
  public ASN1SetParser getAuthAttrs()
    throws IOException
  {
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    ASN1Encodable localASN1Encodable = this.nextObject;
    if ((localASN1Encodable instanceof ASN1TaggedObjectParser))
    {
      this.nextObject = null;
      return (ASN1SetParser)((ASN1TaggedObjectParser)localASN1Encodable).getObjectParser(17, false);
    }
    return null;
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
    throws IOException
  {
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    Object localObject = this.nextObject;
    if ((localObject instanceof ASN1TaggedObjectParser))
    {
      localObject = AlgorithmIdentifier.getInstance((ASN1TaggedObject)((ASN1Encodable)localObject).toASN1Primitive(), false);
      this.nextObject = null;
      return (AlgorithmIdentifier)localObject;
    }
    return null;
  }
  
  public ContentInfoParser getEnapsulatedContentInfo()
    throws IOException
  {
    return getEncapsulatedContentInfo();
  }
  
  public ContentInfoParser getEncapsulatedContentInfo()
    throws IOException
  {
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    ASN1Encodable localASN1Encodable = this.nextObject;
    Object localObject = null;
    if (localASN1Encodable != null)
    {
      localObject = (ASN1SequenceParser)localASN1Encodable;
      this.nextObject = null;
      localObject = new ContentInfoParser((ASN1SequenceParser)localObject);
    }
    return (ContentInfoParser)localObject;
  }
  
  public ASN1OctetString getMac()
    throws IOException
  {
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    ASN1Encodable localASN1Encodable = this.nextObject;
    this.nextObject = null;
    return ASN1OctetString.getInstance(localASN1Encodable.toASN1Primitive());
  }
  
  public AlgorithmIdentifier getMacAlgorithm()
    throws IOException
  {
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    Object localObject = this.nextObject;
    if (localObject != null)
    {
      localObject = (ASN1SequenceParser)localObject;
      this.nextObject = null;
      return AlgorithmIdentifier.getInstance(((ASN1SequenceParser)localObject).toASN1Primitive());
    }
    return null;
  }
  
  public OriginatorInfo getOriginatorInfo()
    throws IOException
  {
    this.originatorInfoCalled = true;
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    Object localObject = this.nextObject;
    if (((localObject instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)localObject).getTagNo() == 0))
    {
      localObject = (ASN1SequenceParser)((ASN1TaggedObjectParser)this.nextObject).getObjectParser(16, false);
      this.nextObject = null;
      return OriginatorInfo.getInstance(((ASN1SequenceParser)localObject).toASN1Primitive());
    }
    return null;
  }
  
  public ASN1SetParser getRecipientInfos()
    throws IOException
  {
    if (!this.originatorInfoCalled) {
      getOriginatorInfo();
    }
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    ASN1SetParser localASN1SetParser = (ASN1SetParser)this.nextObject;
    this.nextObject = null;
    return localASN1SetParser;
  }
  
  public ASN1SetParser getUnauthAttrs()
    throws IOException
  {
    if (this.nextObject == null) {
      this.nextObject = this.seq.readObject();
    }
    ASN1Encodable localASN1Encodable = this.nextObject;
    if (localASN1Encodable != null)
    {
      this.nextObject = null;
      return (ASN1SetParser)((ASN1TaggedObjectParser)localASN1Encodable).getObjectParser(17, false);
    }
    return null;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\AuthenticatedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */