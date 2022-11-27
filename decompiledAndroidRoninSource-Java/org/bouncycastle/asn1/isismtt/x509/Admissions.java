package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralName;

public class Admissions
  extends ASN1Object
{
  private GeneralName admissionAuthority;
  private NamingAuthority namingAuthority;
  private ASN1Sequence professionInfos;
  
  private Admissions(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() <= 3)
    {
      Enumeration localEnumeration = paramASN1Sequence.getObjects();
      localObject = (ASN1Encodable)localEnumeration.nextElement();
      paramASN1Sequence = (ASN1Sequence)localObject;
      if ((localObject instanceof ASN1TaggedObject))
      {
        paramASN1Sequence = (ASN1TaggedObject)localObject;
        int i = paramASN1Sequence.getTagNo();
        if (i != 0)
        {
          if (i == 1)
          {
            this.namingAuthority = NamingAuthority.getInstance(paramASN1Sequence, true);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Bad tag number: ");
            ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else {
          this.admissionAuthority = GeneralName.getInstance(paramASN1Sequence, true);
        }
        paramASN1Sequence = (ASN1Encodable)localEnumeration.nextElement();
      }
      localObject = paramASN1Sequence;
      if ((paramASN1Sequence instanceof ASN1TaggedObject))
      {
        paramASN1Sequence = (ASN1TaggedObject)paramASN1Sequence;
        if (paramASN1Sequence.getTagNo() == 1)
        {
          this.namingAuthority = NamingAuthority.getInstance(paramASN1Sequence, true);
          localObject = (ASN1Encodable)localEnumeration.nextElement();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Bad tag number: ");
          ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      this.professionInfos = ASN1Sequence.getInstance(localObject);
      if (!localEnumeration.hasMoreElements()) {
        return;
      }
      paramASN1Sequence = new StringBuilder();
      paramASN1Sequence.append("Bad object encountered: ");
      paramASN1Sequence.append(localEnumeration.nextElement().getClass());
      throw new IllegalArgumentException(paramASN1Sequence.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public Admissions(GeneralName paramGeneralName, NamingAuthority paramNamingAuthority, ProfessionInfo[] paramArrayOfProfessionInfo)
  {
    this.admissionAuthority = paramGeneralName;
    this.namingAuthority = paramNamingAuthority;
    this.professionInfos = new DERSequence(paramArrayOfProfessionInfo);
  }
  
  public static Admissions getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof Admissions)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new Admissions((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (Admissions)paramObject;
  }
  
  public GeneralName getAdmissionAuthority()
  {
    return this.admissionAuthority;
  }
  
  public NamingAuthority getNamingAuthority()
  {
    return this.namingAuthority;
  }
  
  public ProfessionInfo[] getProfessionInfos()
  {
    ProfessionInfo[] arrayOfProfessionInfo = new ProfessionInfo[this.professionInfos.size()];
    Enumeration localEnumeration = this.professionInfos.getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      arrayOfProfessionInfo[i] = ProfessionInfo.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return arrayOfProfessionInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.admissionAuthority;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localObject = this.namingAuthority;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable)localObject));
    }
    localASN1EncodableVector.add(this.professionInfos);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\Admissions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */