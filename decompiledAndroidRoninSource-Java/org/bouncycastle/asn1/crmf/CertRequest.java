package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CertRequest
  extends ASN1Object
{
  private ASN1Integer certReqId;
  private CertTemplate certTemplate;
  private Controls controls;
  
  public CertRequest(int paramInt, CertTemplate paramCertTemplate, Controls paramControls)
  {
    this(new ASN1Integer(paramInt), paramCertTemplate, paramControls);
  }
  
  public CertRequest(ASN1Integer paramASN1Integer, CertTemplate paramCertTemplate, Controls paramControls)
  {
    this.certReqId = paramASN1Integer;
    this.certTemplate = paramCertTemplate;
    this.controls = paramControls;
  }
  
  private CertRequest(ASN1Sequence paramASN1Sequence)
  {
    this.certReqId = new ASN1Integer(ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0)).getValue());
    this.certTemplate = CertTemplate.getInstance(paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() > 2) {
      this.controls = Controls.getInstance(paramASN1Sequence.getObjectAt(2));
    }
  }
  
  public static CertRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertRequest)) {
      return (CertRequest)paramObject;
    }
    if (paramObject != null) {
      return new CertRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getCertReqId()
  {
    return this.certReqId;
  }
  
  public CertTemplate getCertTemplate()
  {
    return this.certTemplate;
  }
  
  public Controls getControls()
  {
    return this.controls;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certReqId);
    localASN1EncodableVector.add(this.certTemplate);
    Controls localControls = this.controls;
    if (localControls != null) {
      localASN1EncodableVector.add(localControls);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\CertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */