package org.bouncycastle.asn1.bc;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.util.Arrays;

public class ObjectData
  extends ASN1Object
{
  private final String comment;
  private final ASN1GeneralizedTime creationDate;
  private final ASN1OctetString data;
  private final String identifier;
  private final ASN1GeneralizedTime lastModifiedDate;
  private final BigInteger type;
  
  public ObjectData(BigInteger paramBigInteger, String paramString1, Date paramDate1, Date paramDate2, byte[] paramArrayOfByte, String paramString2)
  {
    this.type = paramBigInteger;
    this.identifier = paramString1;
    this.creationDate = new DERGeneralizedTime(paramDate1);
    this.lastModifiedDate = new DERGeneralizedTime(paramDate2);
    this.data = new DEROctetString(Arrays.clone(paramArrayOfByte));
    this.comment = paramString2;
  }
  
  private ObjectData(ASN1Sequence paramASN1Sequence)
  {
    this.type = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0)).getValue();
    this.identifier = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(1)).getString();
    this.creationDate = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(2));
    this.lastModifiedDate = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(3));
    this.data = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(4));
    if (paramASN1Sequence.size() == 6) {
      paramASN1Sequence = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(5)).getString();
    } else {
      paramASN1Sequence = null;
    }
    this.comment = paramASN1Sequence;
  }
  
  public static ObjectData getInstance(Object paramObject)
  {
    if ((paramObject instanceof ObjectData)) {
      return (ObjectData)paramObject;
    }
    if (paramObject != null) {
      return new ObjectData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public ASN1GeneralizedTime getCreationDate()
  {
    return this.creationDate;
  }
  
  public byte[] getData()
  {
    return Arrays.clone(this.data.getOctets());
  }
  
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public ASN1GeneralizedTime getLastModifiedDate()
  {
    return this.lastModifiedDate;
  }
  
  public BigInteger getType()
  {
    return this.type;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(this.type));
    localASN1EncodableVector.add(new DERUTF8String(this.identifier));
    localASN1EncodableVector.add(this.creationDate);
    localASN1EncodableVector.add(this.lastModifiedDate);
    localASN1EncodableVector.add(this.data);
    String str = this.comment;
    if (str != null) {
      localASN1EncodableVector.add(new DERUTF8String(str));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\ObjectData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */