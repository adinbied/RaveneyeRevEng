package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class AuthorityInformationAccess
  extends ASN1Object
{
  private AccessDescription[] descriptions;
  
  public AuthorityInformationAccess(ASN1ObjectIdentifier paramASN1ObjectIdentifier, GeneralName paramGeneralName)
  {
    this(new AccessDescription(paramASN1ObjectIdentifier, paramGeneralName));
  }
  
  private AuthorityInformationAccess(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() >= 1)
    {
      this.descriptions = new AccessDescription[paramASN1Sequence.size()];
      int i = 0;
      while (i != paramASN1Sequence.size())
      {
        this.descriptions[i] = AccessDescription.getInstance(paramASN1Sequence.getObjectAt(i));
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("sequence may not be empty");
  }
  
  public AuthorityInformationAccess(AccessDescription paramAccessDescription)
  {
    this(new AccessDescription[] { paramAccessDescription });
  }
  
  public AuthorityInformationAccess(AccessDescription[] paramArrayOfAccessDescription)
  {
    AccessDescription[] arrayOfAccessDescription = new AccessDescription[paramArrayOfAccessDescription.length];
    this.descriptions = arrayOfAccessDescription;
    System.arraycopy(paramArrayOfAccessDescription, 0, arrayOfAccessDescription, 0, paramArrayOfAccessDescription.length);
  }
  
  public static AuthorityInformationAccess fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.authorityInfoAccess));
  }
  
  public static AuthorityInformationAccess getInstance(Object paramObject)
  {
    if ((paramObject instanceof AuthorityInformationAccess)) {
      return (AuthorityInformationAccess)paramObject;
    }
    if (paramObject != null) {
      return new AuthorityInformationAccess(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AccessDescription[] getAccessDescriptions()
  {
    return this.descriptions;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      AccessDescription[] arrayOfAccessDescription = this.descriptions;
      if (i == arrayOfAccessDescription.length) {
        break;
      }
      localASN1EncodableVector.add(arrayOfAccessDescription[i]);
      i += 1;
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AuthorityInformationAccess: Oid(");
    localStringBuilder.append(this.descriptions[0].getAccessMethod().getId());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AuthorityInformationAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */