package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Extensions;

public class TBSRequest
  extends ASN1Object
{
  private static final ASN1Integer V1 = new ASN1Integer(0L);
  Extensions requestExtensions;
  ASN1Sequence requestList;
  GeneralName requestorName;
  ASN1Integer version;
  boolean versionSet;
  
  private TBSRequest(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    if (((paramASN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0)).getTagNo() == 0))
    {
      this.versionSet = true;
      this.version = ASN1Integer.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0), true);
      i = 1;
    }
    else
    {
      this.version = V1;
    }
    int j = i;
    if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject))
    {
      this.requestorName = GeneralName.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(i), true);
      j = i + 1;
    }
    i = j + 1;
    this.requestList = ((ASN1Sequence)paramASN1Sequence.getObjectAt(j));
    if (paramASN1Sequence.size() == i + 1) {
      this.requestExtensions = Extensions.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(i), true);
    }
  }
  
  public TBSRequest(GeneralName paramGeneralName, ASN1Sequence paramASN1Sequence, Extensions paramExtensions)
  {
    this.version = V1;
    this.requestorName = paramGeneralName;
    this.requestList = paramASN1Sequence;
    this.requestExtensions = paramExtensions;
  }
  
  public TBSRequest(GeneralName paramGeneralName, ASN1Sequence paramASN1Sequence, X509Extensions paramX509Extensions)
  {
    this.version = V1;
    this.requestorName = paramGeneralName;
    this.requestList = paramASN1Sequence;
    this.requestExtensions = Extensions.getInstance(paramX509Extensions);
  }
  
  public static TBSRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof TBSRequest)) {
      return (TBSRequest)paramObject;
    }
    if (paramObject != null) {
      return new TBSRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static TBSRequest getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public Extensions getRequestExtensions()
  {
    return this.requestExtensions;
  }
  
  public ASN1Sequence getRequestList()
  {
    return this.requestList;
  }
  
  public GeneralName getRequestorName()
  {
    return this.requestorName;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if ((!this.version.equals(V1)) || (this.versionSet)) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, this.version));
    }
    if (this.requestorName != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, this.requestorName));
    }
    localASN1EncodableVector.add(this.requestList);
    if (this.requestExtensions != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, this.requestExtensions));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\TBSRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */