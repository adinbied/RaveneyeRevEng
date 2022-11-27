package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OcspListID
  extends ASN1Object
{
  private ASN1Sequence ocspResponses;
  
  private OcspListID(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 1)
    {
      paramASN1Sequence = (ASN1Sequence)paramASN1Sequence.getObjectAt(0);
      this.ocspResponses = paramASN1Sequence;
      paramASN1Sequence = paramASN1Sequence.getObjects();
      while (paramASN1Sequence.hasMoreElements()) {
        OcspResponsesID.getInstance(paramASN1Sequence.nextElement());
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public OcspListID(OcspResponsesID[] paramArrayOfOcspResponsesID)
  {
    this.ocspResponses = new DERSequence(paramArrayOfOcspResponsesID);
  }
  
  public static OcspListID getInstance(Object paramObject)
  {
    if ((paramObject instanceof OcspListID)) {
      return (OcspListID)paramObject;
    }
    if (paramObject != null) {
      return new OcspListID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public OcspResponsesID[] getOcspResponses()
  {
    int j = this.ocspResponses.size();
    OcspResponsesID[] arrayOfOcspResponsesID = new OcspResponsesID[j];
    int i = 0;
    while (i < j)
    {
      arrayOfOcspResponsesID[i] = OcspResponsesID.getInstance(this.ocspResponses.getObjectAt(i));
      i += 1;
    }
    return arrayOfOcspResponsesID;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.ocspResponses);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\OcspListID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */