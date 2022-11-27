package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.DirectoryString;

public class SignerLocation
  extends ASN1Object
{
  private DERUTF8String countryName;
  private DERUTF8String localityName;
  private ASN1Sequence postalAddress;
  
  private SignerLocation(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    while (localEnumeration.hasMoreElements())
    {
      paramASN1Sequence = (ASN1TaggedObject)localEnumeration.nextElement();
      int i = paramASN1Sequence.getTagNo();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            if (paramASN1Sequence.isExplicit()) {
              paramASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence, true);
            } else {
              paramASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence, false);
            }
            this.postalAddress = paramASN1Sequence;
            paramASN1Sequence = this.postalAddress;
            if ((paramASN1Sequence != null) && (paramASN1Sequence.size() > 6)) {
              throw new IllegalArgumentException("postal address must contain less than 6 strings");
            }
          }
          else
          {
            throw new IllegalArgumentException("illegal tag");
          }
        }
        else {
          this.localityName = new DERUTF8String(DirectoryString.getInstance(paramASN1Sequence, true).getString());
        }
      }
      else {
        this.countryName = new DERUTF8String(DirectoryString.getInstance(paramASN1Sequence, true).getString());
      }
    }
  }
  
  public SignerLocation(DERUTF8String paramDERUTF8String1, DERUTF8String paramDERUTF8String2, ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence != null) && (paramASN1Sequence.size() > 6)) {
      throw new IllegalArgumentException("postal address must contain less than 6 strings");
    }
    if (paramDERUTF8String1 != null) {
      this.countryName = DERUTF8String.getInstance(paramDERUTF8String1.toASN1Primitive());
    }
    if (paramDERUTF8String2 != null) {
      this.localityName = DERUTF8String.getInstance(paramDERUTF8String2.toASN1Primitive());
    }
    if (paramASN1Sequence != null) {
      this.postalAddress = ASN1Sequence.getInstance(paramASN1Sequence.toASN1Primitive());
    }
  }
  
  public static SignerLocation getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof SignerLocation))) {
      return new SignerLocation(ASN1Sequence.getInstance(paramObject));
    }
    return (SignerLocation)paramObject;
  }
  
  public DERUTF8String getCountryName()
  {
    return this.countryName;
  }
  
  public DERUTF8String getLocalityName()
  {
    return this.localityName;
  }
  
  public ASN1Sequence getPostalAddress()
  {
    return this.postalAddress;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.countryName;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localObject = this.localityName;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable)localObject));
    }
    localObject = this.postalAddress;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\SignerLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */