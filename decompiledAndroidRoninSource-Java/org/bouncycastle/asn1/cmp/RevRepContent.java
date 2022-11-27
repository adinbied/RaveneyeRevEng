package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.CertificateList;

public class RevRepContent
  extends ASN1Object
{
  private ASN1Sequence crls;
  private ASN1Sequence revCerts;
  private ASN1Sequence status;
  
  private RevRepContent(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.status = ASN1Sequence.getInstance(paramASN1Sequence.nextElement());
    while (paramASN1Sequence.hasMoreElements())
    {
      Object localObject = ASN1TaggedObject.getInstance(paramASN1Sequence.nextElement());
      int i = ((ASN1TaggedObject)localObject).getTagNo();
      localObject = ASN1Sequence.getInstance((ASN1TaggedObject)localObject, true);
      if (i == 0) {
        this.revCerts = ((ASN1Sequence)localObject);
      } else {
        this.crls = ((ASN1Sequence)localObject);
      }
    }
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(true, paramInt, paramASN1Encodable));
    }
  }
  
  public static RevRepContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof RevRepContent)) {
      return (RevRepContent)paramObject;
    }
    if (paramObject != null) {
      return new RevRepContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertificateList[] getCrls()
  {
    Object localObject = this.crls;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CertificateList[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = CertificateList.getInstance(this.crls.getObjectAt(i));
      i += 1;
    }
    return (CertificateList[])localObject;
  }
  
  public CertId[] getRevCerts()
  {
    Object localObject = this.revCerts;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CertId[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = CertId.getInstance(this.revCerts.getObjectAt(i));
      i += 1;
    }
    return (CertId[])localObject;
  }
  
  public PKIStatusInfo[] getStatus()
  {
    int j = this.status.size();
    PKIStatusInfo[] arrayOfPKIStatusInfo = new PKIStatusInfo[j];
    int i = 0;
    while (i != j)
    {
      arrayOfPKIStatusInfo[i] = PKIStatusInfo.getInstance(this.status.getObjectAt(i));
      i += 1;
    }
    return arrayOfPKIStatusInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.status);
    addOptional(localASN1EncodableVector, 0, this.revCerts);
    addOptional(localASN1EncodableVector, 1, this.crls);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\RevRepContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */