package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

public class PKIStatusInfo
  extends ASN1Object
{
  DERBitString failInfo;
  ASN1Integer status;
  PKIFreeText statusString;
  
  private PKIStatusInfo(ASN1Sequence paramASN1Sequence)
  {
    this.status = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    this.statusString = null;
    this.failInfo = null;
    if (paramASN1Sequence.size() > 2)
    {
      this.statusString = PKIFreeText.getInstance(paramASN1Sequence.getObjectAt(1));
      paramASN1Sequence = paramASN1Sequence.getObjectAt(2);
    }
    do
    {
      this.failInfo = DERBitString.getInstance(paramASN1Sequence);
      return;
      if (paramASN1Sequence.size() <= 1) {
        break;
      }
      paramASN1Sequence = paramASN1Sequence.getObjectAt(1);
    } while ((paramASN1Sequence instanceof DERBitString));
    this.statusString = PKIFreeText.getInstance(paramASN1Sequence);
  }
  
  public PKIStatusInfo(PKIStatus paramPKIStatus)
  {
    this.status = ASN1Integer.getInstance(paramPKIStatus.toASN1Primitive());
  }
  
  public PKIStatusInfo(PKIStatus paramPKIStatus, PKIFreeText paramPKIFreeText)
  {
    this.status = ASN1Integer.getInstance(paramPKIStatus.toASN1Primitive());
    this.statusString = paramPKIFreeText;
  }
  
  public PKIStatusInfo(PKIStatus paramPKIStatus, PKIFreeText paramPKIFreeText, PKIFailureInfo paramPKIFailureInfo)
  {
    this.status = ASN1Integer.getInstance(paramPKIStatus.toASN1Primitive());
    this.statusString = paramPKIFreeText;
    this.failInfo = paramPKIFailureInfo;
  }
  
  public static PKIStatusInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIStatusInfo)) {
      return (PKIStatusInfo)paramObject;
    }
    if (paramObject != null) {
      return new PKIStatusInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static PKIStatusInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public DERBitString getFailInfo()
  {
    return this.failInfo;
  }
  
  public BigInteger getStatus()
  {
    return this.status.getValue();
  }
  
  public PKIFreeText getStatusString()
  {
    return this.statusString;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.status);
    Object localObject = this.statusString;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.failInfo;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */