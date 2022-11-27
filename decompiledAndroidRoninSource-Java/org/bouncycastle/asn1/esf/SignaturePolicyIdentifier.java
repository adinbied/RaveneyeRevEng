package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;

public class SignaturePolicyIdentifier
  extends ASN1Object
{
  private boolean isSignaturePolicyImplied;
  private SignaturePolicyId signaturePolicyId;
  
  public SignaturePolicyIdentifier()
  {
    this.isSignaturePolicyImplied = true;
  }
  
  public SignaturePolicyIdentifier(SignaturePolicyId paramSignaturePolicyId)
  {
    this.signaturePolicyId = paramSignaturePolicyId;
    this.isSignaturePolicyImplied = false;
  }
  
  public static SignaturePolicyIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof SignaturePolicyIdentifier)) {
      return (SignaturePolicyIdentifier)paramObject;
    }
    if ((!(paramObject instanceof ASN1Null)) && (!hasEncodedTagValue(paramObject, 5)))
    {
      if (paramObject != null) {
        return new SignaturePolicyIdentifier(SignaturePolicyId.getInstance(paramObject));
      }
      return null;
    }
    return new SignaturePolicyIdentifier();
  }
  
  public SignaturePolicyId getSignaturePolicyId()
  {
    return this.signaturePolicyId;
  }
  
  public boolean isSignaturePolicyImplied()
  {
    return this.isSignaturePolicyImplied;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    if (this.isSignaturePolicyImplied) {
      return DERNull.INSTANCE;
    }
    return this.signaturePolicyId.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\SignaturePolicyIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */