package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class AdmissionSyntax
  extends ASN1Object
{
  private GeneralName admissionAuthority;
  private ASN1Sequence contentsOfAdmissions;
  
  private AdmissionSyntax(ASN1Sequence paramASN1Sequence)
  {
    int i = paramASN1Sequence.size();
    if (i != 1)
    {
      if (i == 2)
      {
        this.admissionAuthority = GeneralName.getInstance(paramASN1Sequence.getObjectAt(0));
        paramASN1Sequence = paramASN1Sequence.getObjectAt(1);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Bad sequence size: ");
        localStringBuilder.append(paramASN1Sequence.size());
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    else {
      paramASN1Sequence = paramASN1Sequence.getObjectAt(0);
    }
    this.contentsOfAdmissions = DERSequence.getInstance(paramASN1Sequence);
  }
  
  public AdmissionSyntax(GeneralName paramGeneralName, ASN1Sequence paramASN1Sequence)
  {
    this.admissionAuthority = paramGeneralName;
    this.contentsOfAdmissions = paramASN1Sequence;
  }
  
  public static AdmissionSyntax getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof AdmissionSyntax)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new AdmissionSyntax((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (AdmissionSyntax)paramObject;
  }
  
  public GeneralName getAdmissionAuthority()
  {
    return this.admissionAuthority;
  }
  
  public Admissions[] getContentsOfAdmissions()
  {
    Admissions[] arrayOfAdmissions = new Admissions[this.contentsOfAdmissions.size()];
    Enumeration localEnumeration = this.contentsOfAdmissions.getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      arrayOfAdmissions[i] = Admissions.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return arrayOfAdmissions;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    GeneralName localGeneralName = this.admissionAuthority;
    if (localGeneralName != null) {
      localASN1EncodableVector.add(localGeneralName);
    }
    localASN1EncodableVector.add(this.contentsOfAdmissions);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\AdmissionSyntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */