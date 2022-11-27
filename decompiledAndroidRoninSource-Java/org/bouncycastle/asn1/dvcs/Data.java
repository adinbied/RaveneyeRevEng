package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.DigestInfo;

public class Data
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Sequence certs;
  private ASN1OctetString message;
  private DigestInfo messageImprint;
  
  public Data(ASN1OctetString paramASN1OctetString)
  {
    this.message = paramASN1OctetString;
  }
  
  private Data(ASN1Sequence paramASN1Sequence)
  {
    this.certs = paramASN1Sequence;
  }
  
  public Data(TargetEtcChain paramTargetEtcChain)
  {
    this.certs = new DERSequence(paramTargetEtcChain);
  }
  
  public Data(DigestInfo paramDigestInfo)
  {
    this.messageImprint = paramDigestInfo;
  }
  
  public Data(byte[] paramArrayOfByte)
  {
    this.message = new DEROctetString(paramArrayOfByte);
  }
  
  public Data(TargetEtcChain[] paramArrayOfTargetEtcChain)
  {
    this.certs = new DERSequence(paramArrayOfTargetEtcChain);
  }
  
  public static Data getInstance(Object paramObject)
  {
    if ((paramObject instanceof Data)) {
      return (Data)paramObject;
    }
    if ((paramObject instanceof ASN1OctetString)) {
      return new Data((ASN1OctetString)paramObject);
    }
    if ((paramObject instanceof ASN1Sequence)) {
      return new Data(DigestInfo.getInstance(paramObject));
    }
    if ((paramObject instanceof ASN1TaggedObject)) {
      return new Data(ASN1Sequence.getInstance((ASN1TaggedObject)paramObject, false));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown object submitted to getInstance: ");
    localStringBuilder.append(paramObject.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static Data getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public TargetEtcChain[] getCerts()
  {
    Object localObject = this.certs;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new TargetEtcChain[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = TargetEtcChain.getInstance(this.certs.getObjectAt(i));
      i += 1;
    }
    return (TargetEtcChain[])localObject;
  }
  
  public ASN1OctetString getMessage()
  {
    return this.message;
  }
  
  public DigestInfo getMessageImprint()
  {
    return this.messageImprint;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    Object localObject = this.message;
    if (localObject != null) {
      return ((ASN1OctetString)localObject).toASN1Primitive();
    }
    localObject = this.messageImprint;
    if (localObject != null) {
      return ((DigestInfo)localObject).toASN1Primitive();
    }
    return new DERTaggedObject(false, 0, this.certs);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    Object localObject;
    if (this.message != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Data {\n");
      localObject = this.message;
    }
    for (;;)
    {
      localStringBuilder.append(localObject);
      localStringBuilder.append("}\n");
      return localStringBuilder.toString();
      if (this.messageImprint != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Data {\n");
        localObject = this.messageImprint;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Data {\n");
        localObject = this.certs;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\Data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */