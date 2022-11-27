package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

public class IssuingDistributionPoint
  extends ASN1Object
{
  private DistributionPointName distributionPoint;
  private boolean indirectCRL;
  private boolean onlyContainsAttributeCerts;
  private boolean onlyContainsCACerts;
  private boolean onlyContainsUserCerts;
  private ReasonFlags onlySomeReasons;
  private ASN1Sequence seq;
  
  private IssuingDistributionPoint(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      ASN1TaggedObject localASN1TaggedObject = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(i));
      int j = localASN1TaggedObject.getTagNo();
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  this.onlyContainsAttributeCerts = ASN1Boolean.getInstance(localASN1TaggedObject, false).isTrue();
                } else {
                  throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
              }
              else {
                this.indirectCRL = ASN1Boolean.getInstance(localASN1TaggedObject, false).isTrue();
              }
            }
            else {
              this.onlySomeReasons = new ReasonFlags(ReasonFlags.getInstance(localASN1TaggedObject, false));
            }
          }
          else {
            this.onlyContainsCACerts = ASN1Boolean.getInstance(localASN1TaggedObject, false).isTrue();
          }
        }
        else {
          this.onlyContainsUserCerts = ASN1Boolean.getInstance(localASN1TaggedObject, false).isTrue();
        }
      }
      else {
        this.distributionPoint = DistributionPointName.getInstance(localASN1TaggedObject, true);
      }
      i += 1;
    }
  }
  
  public IssuingDistributionPoint(DistributionPointName paramDistributionPointName, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramDistributionPointName, false, false, null, paramBoolean1, paramBoolean2);
  }
  
  public IssuingDistributionPoint(DistributionPointName paramDistributionPointName, boolean paramBoolean1, boolean paramBoolean2, ReasonFlags paramReasonFlags, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.distributionPoint = paramDistributionPointName;
    this.indirectCRL = paramBoolean3;
    this.onlyContainsAttributeCerts = paramBoolean4;
    this.onlyContainsCACerts = paramBoolean2;
    this.onlyContainsUserCerts = paramBoolean1;
    this.onlySomeReasons = paramReasonFlags;
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (paramDistributionPointName != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, paramDistributionPointName));
    }
    if (paramBoolean1) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, ASN1Boolean.getInstance(true)));
    }
    if (paramBoolean2) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, ASN1Boolean.getInstance(true)));
    }
    if (paramReasonFlags != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 3, paramReasonFlags));
    }
    if (paramBoolean3) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 4, ASN1Boolean.getInstance(true)));
    }
    if (paramBoolean4) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 5, ASN1Boolean.getInstance(true)));
    }
    this.seq = new DERSequence(localASN1EncodableVector);
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
  
  private String booleanToString(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "true";
    }
    return "false";
  }
  
  public static IssuingDistributionPoint getInstance(Object paramObject)
  {
    if ((paramObject instanceof IssuingDistributionPoint)) {
      return (IssuingDistributionPoint)paramObject;
    }
    if (paramObject != null) {
      return new IssuingDistributionPoint(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static IssuingDistributionPoint getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public DistributionPointName getDistributionPoint()
  {
    return this.distributionPoint;
  }
  
  public ReasonFlags getOnlySomeReasons()
  {
    return this.onlySomeReasons;
  }
  
  public boolean isIndirectCRL()
  {
    return this.indirectCRL;
  }
  
  public boolean onlyContainsAttributeCerts()
  {
    return this.onlyContainsAttributeCerts;
  }
  
  public boolean onlyContainsCACerts()
  {
    return this.onlyContainsCACerts;
  }
  
  public boolean onlyContainsUserCerts()
  {
    return this.onlyContainsUserCerts;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
  
  public String toString()
  {
    String str = Strings.lineSeparator();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("IssuingDistributionPoint: [");
    localStringBuffer.append(str);
    Object localObject = this.distributionPoint;
    if (localObject != null) {
      appendObject(localStringBuffer, str, "distributionPoint", ((DistributionPointName)localObject).toString());
    }
    boolean bool = this.onlyContainsUserCerts;
    if (bool) {
      appendObject(localStringBuffer, str, "onlyContainsUserCerts", booleanToString(bool));
    }
    bool = this.onlyContainsCACerts;
    if (bool) {
      appendObject(localStringBuffer, str, "onlyContainsCACerts", booleanToString(bool));
    }
    localObject = this.onlySomeReasons;
    if (localObject != null) {
      appendObject(localStringBuffer, str, "onlySomeReasons", ((ReasonFlags)localObject).toString());
    }
    bool = this.onlyContainsAttributeCerts;
    if (bool) {
      appendObject(localStringBuffer, str, "onlyContainsAttributeCerts", booleanToString(bool));
    }
    bool = this.indirectCRL;
    if (bool) {
      appendObject(localStringBuffer, str, "indirectCRL", booleanToString(bool));
    }
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\IssuingDistributionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */