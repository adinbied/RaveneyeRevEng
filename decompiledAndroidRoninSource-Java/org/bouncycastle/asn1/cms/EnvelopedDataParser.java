package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

public class EnvelopedDataParser
{
  private ASN1Encodable _nextObject;
  private boolean _originatorInfoCalled;
  private ASN1SequenceParser _seq;
  private ASN1Integer _version;
  
  public EnvelopedDataParser(ASN1SequenceParser paramASN1SequenceParser)
    throws IOException
  {
    this._seq = paramASN1SequenceParser;
    this._version = ASN1Integer.getInstance(paramASN1SequenceParser.readObject());
  }
  
  public EncryptedContentInfoParser getEncryptedContentInfo()
    throws IOException
  {
    if (this._nextObject == null) {
      this._nextObject = this._seq.readObject();
    }
    ASN1Encodable localASN1Encodable = this._nextObject;
    Object localObject = null;
    if (localASN1Encodable != null)
    {
      localObject = (ASN1SequenceParser)localASN1Encodable;
      this._nextObject = null;
      localObject = new EncryptedContentInfoParser((ASN1SequenceParser)localObject);
    }
    return (EncryptedContentInfoParser)localObject;
  }
  
  public OriginatorInfo getOriginatorInfo()
    throws IOException
  {
    this._originatorInfoCalled = true;
    if (this._nextObject == null) {
      this._nextObject = this._seq.readObject();
    }
    Object localObject = this._nextObject;
    if (((localObject instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)localObject).getTagNo() == 0))
    {
      localObject = (ASN1SequenceParser)((ASN1TaggedObjectParser)this._nextObject).getObjectParser(16, false);
      this._nextObject = null;
      return OriginatorInfo.getInstance(((ASN1SequenceParser)localObject).toASN1Primitive());
    }
    return null;
  }
  
  public ASN1SetParser getRecipientInfos()
    throws IOException
  {
    if (!this._originatorInfoCalled) {
      getOriginatorInfo();
    }
    if (this._nextObject == null) {
      this._nextObject = this._seq.readObject();
    }
    ASN1SetParser localASN1SetParser = (ASN1SetParser)this._nextObject;
    this._nextObject = null;
    return localASN1SetParser;
  }
  
  public ASN1SetParser getUnprotectedAttrs()
    throws IOException
  {
    if (this._nextObject == null) {
      this._nextObject = this._seq.readObject();
    }
    ASN1Encodable localASN1Encodable = this._nextObject;
    if (localASN1Encodable != null)
    {
      this._nextObject = null;
      return (ASN1SetParser)((ASN1TaggedObjectParser)localASN1Encodable).getObjectParser(17, false);
    }
    return null;
  }
  
  public ASN1Integer getVersion()
  {
    return this._version;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\EnvelopedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */