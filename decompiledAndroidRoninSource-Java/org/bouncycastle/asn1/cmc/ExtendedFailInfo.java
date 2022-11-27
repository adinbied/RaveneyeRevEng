package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ExtendedFailInfo
  extends ASN1Object
{
  private final ASN1ObjectIdentifier failInfoOID;
  private final ASN1Encodable failInfoValue;
  
  public ExtendedFailInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.failInfoOID = paramASN1ObjectIdentifier;
    this.failInfoValue = paramASN1Encodable;
  }
  
  private ExtendedFailInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.failInfoOID = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.failInfoValue = paramASN1Sequence.getObjectAt(1);
      return;
    }
    throw new IllegalArgumentException("Sequence must be 2 elements.");
  }
  
  public static ExtendedFailInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof ExtendedFailInfo)) {
      return (ExtendedFailInfo)paramObject;
    }
    if ((paramObject instanceof ASN1Encodable))
    {
      paramObject = ((ASN1Encodable)paramObject).toASN1Primitive();
      if ((paramObject instanceof ASN1Sequence)) {
        return new ExtendedFailInfo((ASN1Sequence)paramObject);
      }
    }
    else if ((paramObject instanceof byte[]))
    {
      return getInstance(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getFailInfoOID()
  {
    return this.failInfoOID;
  }
  
  public ASN1Encodable getFailInfoValue()
  {
    return this.failInfoValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(new ASN1Encodable[] { this.failInfoOID, this.failInfoValue });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\ExtendedFailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */