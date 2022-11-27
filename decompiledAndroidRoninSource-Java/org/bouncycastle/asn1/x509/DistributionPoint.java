package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

public class DistributionPoint
  extends ASN1Object
{
  GeneralNames cRLIssuer;
  DistributionPointName distributionPoint;
  ReasonFlags reasons;
  
  public DistributionPoint(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      ASN1TaggedObject localASN1TaggedObject = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(i));
      int j = localASN1TaggedObject.getTagNo();
      if (j != 0)
      {
        if (j != 1)
        {
          if (j == 2)
          {
            this.cRLIssuer = GeneralNames.getInstance(localASN1TaggedObject, false);
          }
          else
          {
            paramASN1Sequence = new StringBuilder();
            paramASN1Sequence.append("Unknown tag encountered in structure: ");
            paramASN1Sequence.append(localASN1TaggedObject.getTagNo());
            throw new IllegalArgumentException(paramASN1Sequence.toString());
          }
        }
        else {
          this.reasons = new ReasonFlags(DERBitString.getInstance(localASN1TaggedObject, false));
        }
      }
      else {
        this.distributionPoint = DistributionPointName.getInstance(localASN1TaggedObject, true);
      }
      i += 1;
    }
  }
  
  public DistributionPoint(DistributionPointName paramDistributionPointName, ReasonFlags paramReasonFlags, GeneralNames paramGeneralNames)
  {
    this.distributionPoint = paramDistributionPointName;
    this.reasons = paramReasonFlags;
    this.cRLIssuer = paramGeneralNames;
  }
  
  private void appendObject(StringBuffer paramStringBuffer, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString2);
    paramStringBuffer.append(":");
    paramStringBuffer.append(paramString1);
    paramStringBuffer.append("    ");
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString3);
    paramStringBuffer.append(paramString1);
  }
  
  public static DistributionPoint getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DistributionPoint)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new DistributionPoint((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid DistributionPoint: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DistributionPoint)paramObject;
  }
  
  public static DistributionPoint getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public GeneralNames getCRLIssuer()
  {
    return this.cRLIssuer;
  }
  
  public DistributionPointName getDistributionPoint()
  {
    return this.distributionPoint;
  }
  
  public ReasonFlags getReasons()
  {
    return this.reasons;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.distributionPoint;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(0, (ASN1Encodable)localObject));
    }
    localObject = this.reasons;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
    }
    localObject = this.cRLIssuer;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    String str = Strings.lineSeparator();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DistributionPoint: [");
    localStringBuffer.append(str);
    Object localObject = this.distributionPoint;
    if (localObject != null) {
      appendObject(localStringBuffer, str, "distributionPoint", ((DistributionPointName)localObject).toString());
    }
    localObject = this.reasons;
    if (localObject != null) {
      appendObject(localStringBuffer, str, "reasons", ((ReasonFlags)localObject).toString());
    }
    localObject = this.cRLIssuer;
    if (localObject != null) {
      appendObject(localStringBuffer, str, "cRLIssuer", ((GeneralNames)localObject).toString());
    }
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\DistributionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */