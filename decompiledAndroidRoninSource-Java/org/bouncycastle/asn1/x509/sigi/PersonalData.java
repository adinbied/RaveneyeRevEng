package org.bouncycastle.asn1.x509.sigi;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;

public class PersonalData
  extends ASN1Object
{
  private ASN1GeneralizedTime dateOfBirth;
  private String gender;
  private BigInteger nameDistinguisher;
  private NameOrPseudonym nameOrPseudonym;
  private DirectoryString placeOfBirth;
  private DirectoryString postalAddress;
  
  private PersonalData(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() >= 1)
    {
      localObject = paramASN1Sequence.getObjects();
      this.nameOrPseudonym = NameOrPseudonym.getInstance(((Enumeration)localObject).nextElement());
      while (((Enumeration)localObject).hasMoreElements())
      {
        paramASN1Sequence = ASN1TaggedObject.getInstance(((Enumeration)localObject).nextElement());
        int i = paramASN1Sequence.getTagNo();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4)
                {
                  this.postalAddress = DirectoryString.getInstance(paramASN1Sequence, true);
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
                this.gender = DERPrintableString.getInstance(paramASN1Sequence, false).getString();
              }
            }
            else {
              this.placeOfBirth = DirectoryString.getInstance(paramASN1Sequence, true);
            }
          }
          else {
            this.dateOfBirth = ASN1GeneralizedTime.getInstance(paramASN1Sequence, false);
          }
        }
        else {
          this.nameDistinguisher = ASN1Integer.getInstance(paramASN1Sequence, false).getValue();
        }
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public PersonalData(NameOrPseudonym paramNameOrPseudonym, BigInteger paramBigInteger, ASN1GeneralizedTime paramASN1GeneralizedTime, DirectoryString paramDirectoryString1, String paramString, DirectoryString paramDirectoryString2)
  {
    this.nameOrPseudonym = paramNameOrPseudonym;
    this.dateOfBirth = paramASN1GeneralizedTime;
    this.gender = paramString;
    this.nameDistinguisher = paramBigInteger;
    this.postalAddress = paramDirectoryString2;
    this.placeOfBirth = paramDirectoryString1;
  }
  
  public static PersonalData getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof PersonalData)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new PersonalData((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (PersonalData)paramObject;
  }
  
  public ASN1GeneralizedTime getDateOfBirth()
  {
    return this.dateOfBirth;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public BigInteger getNameDistinguisher()
  {
    return this.nameDistinguisher;
  }
  
  public NameOrPseudonym getNameOrPseudonym()
  {
    return this.nameOrPseudonym;
  }
  
  public DirectoryString getPlaceOfBirth()
  {
    return this.placeOfBirth;
  }
  
  public DirectoryString getPostalAddress()
  {
    return this.postalAddress;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.nameOrPseudonym);
    if (this.nameDistinguisher != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, new ASN1Integer(this.nameDistinguisher)));
    }
    if (this.dateOfBirth != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, this.dateOfBirth));
    }
    if (this.placeOfBirth != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, this.placeOfBirth));
    }
    if (this.gender != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 3, new DERPrintableString(this.gender, true)));
    }
    if (this.postalAddress != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 4, this.postalAddress));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\sigi\PersonalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */