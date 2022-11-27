package org.bouncycastle.asn1.icao;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class DataGroupHash
  extends ASN1Object
{
  ASN1OctetString dataGroupHashValue;
  ASN1Integer dataGroupNumber;
  
  public DataGroupHash(int paramInt, ASN1OctetString paramASN1OctetString)
  {
    this.dataGroupNumber = new ASN1Integer(paramInt);
    this.dataGroupHashValue = paramASN1OctetString;
  }
  
  private DataGroupHash(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.dataGroupNumber = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
    this.dataGroupHashValue = ASN1OctetString.getInstance(paramASN1Sequence.nextElement());
  }
  
  public static DataGroupHash getInstance(Object paramObject)
  {
    if ((paramObject instanceof DataGroupHash)) {
      return (DataGroupHash)paramObject;
    }
    if (paramObject != null) {
      return new DataGroupHash(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1OctetString getDataGroupHashValue()
  {
    return this.dataGroupHashValue;
  }
  
  public int getDataGroupNumber()
  {
    return this.dataGroupNumber.getValue().intValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.dataGroupNumber);
    localASN1EncodableVector.add(this.dataGroupHashValue);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\icao\DataGroupHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */