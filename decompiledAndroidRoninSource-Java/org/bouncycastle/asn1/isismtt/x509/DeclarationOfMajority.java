package org.bouncycastle.asn1.isismtt.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Choice;
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

public class DeclarationOfMajority
  extends ASN1Object
  implements ASN1Choice
{
  public static final int dateOfBirth = 2;
  public static final int fullAgeAtCountry = 1;
  public static final int notYoungerThan = 0;
  private ASN1TaggedObject declaration;
  
  public DeclarationOfMajority(int paramInt)
  {
    this.declaration = new DERTaggedObject(false, 0, new ASN1Integer(paramInt));
  }
  
  public DeclarationOfMajority(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.declaration = new DERTaggedObject(false, 2, paramASN1GeneralizedTime);
  }
  
  private DeclarationOfMajority(ASN1TaggedObject paramASN1TaggedObject)
  {
    if (paramASN1TaggedObject.getTagNo() <= 2)
    {
      this.declaration = paramASN1TaggedObject;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad tag number: ");
    localStringBuilder.append(paramASN1TaggedObject.getTagNo());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public DeclarationOfMajority(boolean paramBoolean, String paramString)
  {
    if (paramString.length() <= 2)
    {
      if (paramBoolean)
      {
        this.declaration = new DERTaggedObject(false, 1, new DERSequence(new DERPrintableString(paramString, true)));
        return;
      }
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localASN1EncodableVector.add(ASN1Boolean.FALSE);
      localASN1EncodableVector.add(new DERPrintableString(paramString, true));
      this.declaration = new DERTaggedObject(false, 1, new DERSequence(localASN1EncodableVector));
      return;
    }
    throw new IllegalArgumentException("country can only be 2 characters");
  }
  
  public static DeclarationOfMajority getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DeclarationOfMajority)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new DeclarationOfMajority((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DeclarationOfMajority)paramObject;
  }
  
  public ASN1Sequence fullAgeAtCountry()
  {
    if (this.declaration.getTagNo() != 1) {
      return null;
    }
    return ASN1Sequence.getInstance(this.declaration, false);
  }
  
  public ASN1GeneralizedTime getDateOfBirth()
  {
    if (this.declaration.getTagNo() != 2) {
      return null;
    }
    return ASN1GeneralizedTime.getInstance(this.declaration, false);
  }
  
  public int getType()
  {
    return this.declaration.getTagNo();
  }
  
  public int notYoungerThan()
  {
    if (this.declaration.getTagNo() != 0) {
      return -1;
    }
    return ASN1Integer.getInstance(this.declaration, false).getValue().intValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.declaration;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\DeclarationOfMajority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */