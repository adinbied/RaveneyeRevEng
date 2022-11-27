package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class DVCSRequest
  extends ASN1Object
{
  private Data data;
  private DVCSRequestInformation requestInformation;
  private GeneralName transactionIdentifier;
  
  private DVCSRequest(ASN1Sequence paramASN1Sequence)
  {
    this.requestInformation = DVCSRequestInformation.getInstance(paramASN1Sequence.getObjectAt(0));
    this.data = Data.getInstance(paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() > 2) {
      this.transactionIdentifier = GeneralName.getInstance(paramASN1Sequence.getObjectAt(2));
    }
  }
  
  public DVCSRequest(DVCSRequestInformation paramDVCSRequestInformation, Data paramData)
  {
    this(paramDVCSRequestInformation, paramData, null);
  }
  
  public DVCSRequest(DVCSRequestInformation paramDVCSRequestInformation, Data paramData, GeneralName paramGeneralName)
  {
    this.requestInformation = paramDVCSRequestInformation;
    this.data = paramData;
    this.transactionIdentifier = paramGeneralName;
  }
  
  public static DVCSRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof DVCSRequest)) {
      return (DVCSRequest)paramObject;
    }
    if (paramObject != null) {
      return new DVCSRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DVCSRequest getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public Data getData()
  {
    return this.data;
  }
  
  public DVCSRequestInformation getRequestInformation()
  {
    return this.requestInformation;
  }
  
  public GeneralName getTransactionIdentifier()
  {
    return this.transactionIdentifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.requestInformation);
    localASN1EncodableVector.add(this.data);
    GeneralName localGeneralName = this.transactionIdentifier;
    if (localGeneralName != null) {
      localASN1EncodableVector.add(localGeneralName);
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DVCSRequest {\nrequestInformation: ");
    localStringBuilder.append(this.requestInformation);
    localStringBuilder.append("\n");
    localStringBuilder.append("data: ");
    localStringBuilder.append(this.data);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */