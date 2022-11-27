package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

public class SignedDataParser
{
  private boolean _certsCalled;
  private boolean _crlsCalled;
  private Object _nextObject;
  private ASN1SequenceParser _seq;
  private ASN1Integer _version;
  
  private SignedDataParser(ASN1SequenceParser paramASN1SequenceParser)
    throws IOException
  {
    this._seq = paramASN1SequenceParser;
    this._version = ((ASN1Integer)paramASN1SequenceParser.readObject());
  }
  
  public static SignedDataParser getInstance(Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof ASN1Sequence)) {
      return new SignedDataParser(((ASN1Sequence)paramObject).parser());
    }
    if ((paramObject instanceof ASN1SequenceParser)) {
      return new SignedDataParser((ASN1SequenceParser)paramObject);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown object encountered: ");
    localStringBuilder.append(paramObject.getClass().getName());
    throw new IOException(localStringBuilder.toString());
  }
  
  public ASN1SetParser getCertificates()
    throws IOException
  {
    this._certsCalled = true;
    Object localObject = this._seq.readObject();
    this._nextObject = localObject;
    if (((localObject instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)localObject).getTagNo() == 0))
    {
      localObject = (ASN1SetParser)((ASN1TaggedObjectParser)this._nextObject).getObjectParser(17, false);
      this._nextObject = null;
      return (ASN1SetParser)localObject;
    }
    return null;
  }
  
  public ASN1SetParser getCrls()
    throws IOException
  {
    if (this._certsCalled)
    {
      this._crlsCalled = true;
      if (this._nextObject == null) {
        this._nextObject = this._seq.readObject();
      }
      Object localObject = this._nextObject;
      if (((localObject instanceof ASN1TaggedObjectParser)) && (((ASN1TaggedObjectParser)localObject).getTagNo() == 1))
      {
        localObject = (ASN1SetParser)((ASN1TaggedObjectParser)this._nextObject).getObjectParser(17, false);
        this._nextObject = null;
        return (ASN1SetParser)localObject;
      }
      return null;
    }
    throw new IOException("getCerts() has not been called.");
  }
  
  public ASN1SetParser getDigestAlgorithms()
    throws IOException
  {
    ASN1Encodable localASN1Encodable = this._seq.readObject();
    if ((localASN1Encodable instanceof ASN1Set)) {
      return ((ASN1Set)localASN1Encodable).parser();
    }
    return (ASN1SetParser)localASN1Encodable;
  }
  
  public ContentInfoParser getEncapContentInfo()
    throws IOException
  {
    return new ContentInfoParser((ASN1SequenceParser)this._seq.readObject());
  }
  
  public ASN1SetParser getSignerInfos()
    throws IOException
  {
    if ((this._certsCalled) && (this._crlsCalled))
    {
      if (this._nextObject == null) {
        this._nextObject = this._seq.readObject();
      }
      return (ASN1SetParser)this._nextObject;
    }
    throw new IOException("getCerts() and/or getCrls() has not been called.");
  }
  
  public ASN1Integer getVersion()
  {
    return this._version;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\SignedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */