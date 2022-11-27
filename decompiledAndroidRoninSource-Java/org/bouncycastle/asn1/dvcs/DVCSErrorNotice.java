package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.GeneralName;

public class DVCSErrorNotice
  extends ASN1Object
{
  private GeneralName transactionIdentifier;
  private PKIStatusInfo transactionStatus;
  
  private DVCSErrorNotice(ASN1Sequence paramASN1Sequence)
  {
    this.transactionStatus = PKIStatusInfo.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.transactionIdentifier = GeneralName.getInstance(paramASN1Sequence.getObjectAt(1));
    }
  }
  
  public DVCSErrorNotice(PKIStatusInfo paramPKIStatusInfo)
  {
    this(paramPKIStatusInfo, null);
  }
  
  public DVCSErrorNotice(PKIStatusInfo paramPKIStatusInfo, GeneralName paramGeneralName)
  {
    this.transactionStatus = paramPKIStatusInfo;
    this.transactionIdentifier = paramGeneralName;
  }
  
  public static DVCSErrorNotice getInstance(Object paramObject)
  {
    if ((paramObject instanceof DVCSErrorNotice)) {
      return (DVCSErrorNotice)paramObject;
    }
    if (paramObject != null) {
      return new DVCSErrorNotice(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DVCSErrorNotice getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public GeneralName getTransactionIdentifier()
  {
    return this.transactionIdentifier;
  }
  
  public PKIStatusInfo getTransactionStatus()
  {
    return this.transactionStatus;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.transactionStatus);
    GeneralName localGeneralName = this.transactionIdentifier;
    if (localGeneralName != null) {
      localASN1EncodableVector.add(localGeneralName);
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DVCSErrorNotice {\ntransactionStatus: ");
    localStringBuilder.append(this.transactionStatus);
    localStringBuilder.append("\n");
    Object localObject;
    if (this.transactionIdentifier != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("transactionIdentifier: ");
      ((StringBuilder)localObject).append(this.transactionIdentifier);
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSErrorNotice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */