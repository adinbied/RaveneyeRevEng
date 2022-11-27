package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertTemplate;

public class ModCertTemplate
  extends ASN1Object
{
  private final BodyPartList certReferences;
  private final CertTemplate certTemplate;
  private final BodyPartPath pkiDataReference;
  private final boolean replace;
  
  private ModCertTemplate(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() != 4) && (paramASN1Sequence.size() != 3)) {
      throw new IllegalArgumentException("incorrect sequence size");
    }
    this.pkiDataReference = BodyPartPath.getInstance(paramASN1Sequence.getObjectAt(0));
    this.certReferences = BodyPartList.getInstance(paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() == 4)
    {
      this.replace = ASN1Boolean.getInstance(paramASN1Sequence.getObjectAt(2)).isTrue();
      paramASN1Sequence = paramASN1Sequence.getObjectAt(3);
    }
    else
    {
      this.replace = true;
      paramASN1Sequence = paramASN1Sequence.getObjectAt(2);
    }
    this.certTemplate = CertTemplate.getInstance(paramASN1Sequence);
  }
  
  public ModCertTemplate(BodyPartPath paramBodyPartPath, BodyPartList paramBodyPartList, boolean paramBoolean, CertTemplate paramCertTemplate)
  {
    this.pkiDataReference = paramBodyPartPath;
    this.certReferences = paramBodyPartList;
    this.replace = paramBoolean;
    this.certTemplate = paramCertTemplate;
  }
  
  public static ModCertTemplate getInstance(Object paramObject)
  {
    if ((paramObject instanceof ModCertTemplate)) {
      return (ModCertTemplate)paramObject;
    }
    if (paramObject != null) {
      return new ModCertTemplate(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BodyPartList getCertReferences()
  {
    return this.certReferences;
  }
  
  public CertTemplate getCertTemplate()
  {
    return this.certTemplate;
  }
  
  public BodyPartPath getPkiDataReference()
  {
    return this.pkiDataReference;
  }
  
  public boolean isReplacingFields()
  {
    return this.replace;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.pkiDataReference);
    localASN1EncodableVector.add(this.certReferences);
    boolean bool = this.replace;
    if (!bool) {
      localASN1EncodableVector.add(ASN1Boolean.getInstance(bool));
    }
    localASN1EncodableVector.add(this.certTemplate);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\ModCertTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */