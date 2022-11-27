package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;

public class ServiceLocator
  extends ASN1Object
{
  private final X500Name issuer;
  private final AuthorityInformationAccess locator;
  
  private ServiceLocator(ASN1Sequence paramASN1Sequence)
  {
    this.issuer = X500Name.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() == 2) {
      paramASN1Sequence = AuthorityInformationAccess.getInstance(paramASN1Sequence.getObjectAt(1));
    } else {
      paramASN1Sequence = null;
    }
    this.locator = paramASN1Sequence;
  }
  
  public static ServiceLocator getInstance(Object paramObject)
  {
    if ((paramObject instanceof ServiceLocator)) {
      return (ServiceLocator)paramObject;
    }
    if (paramObject != null) {
      return new ServiceLocator(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public X500Name getIssuer()
  {
    return this.issuer;
  }
  
  public AuthorityInformationAccess getLocator()
  {
    return this.locator;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.issuer);
    AuthorityInformationAccess localAuthorityInformationAccess = this.locator;
    if (localAuthorityInformationAccess != null) {
      localASN1EncodableVector.add(localAuthorityInformationAccess);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\ServiceLocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */