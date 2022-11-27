package org.bouncycastle.asn1.isismtt.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.DirectoryString;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.IssuerSerial;

public class ProcurationSyntax
  extends ASN1Object
{
  private IssuerSerial certRef;
  private String country;
  private GeneralName thirdPerson;
  private DirectoryString typeOfSubstitution;
  
  public ProcurationSyntax(String paramString, DirectoryString paramDirectoryString, GeneralName paramGeneralName)
  {
    this.country = paramString;
    this.typeOfSubstitution = paramDirectoryString;
    this.thirdPerson = paramGeneralName;
    this.certRef = null;
  }
  
  public ProcurationSyntax(String paramString, DirectoryString paramDirectoryString, IssuerSerial paramIssuerSerial)
  {
    this.country = paramString;
    this.typeOfSubstitution = paramDirectoryString;
    this.thirdPerson = null;
    this.certRef = paramIssuerSerial;
  }
  
  private ProcurationSyntax(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 3))
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      while (paramASN1Sequence.hasMoreElements())
      {
        localObject = ASN1TaggedObject.getInstance(paramASN1Sequence.nextElement());
        int i = ((ASN1TaggedObject)localObject).getTagNo();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              localObject = ((ASN1TaggedObject)localObject).getObject();
              if ((localObject instanceof ASN1TaggedObject)) {
                this.thirdPerson = GeneralName.getInstance(localObject);
              } else {
                this.certRef = IssuerSerial.getInstance(localObject);
              }
            }
            else
            {
              paramASN1Sequence = new StringBuilder();
              paramASN1Sequence.append("Bad tag number: ");
              paramASN1Sequence.append(((ASN1TaggedObject)localObject).getTagNo());
              throw new IllegalArgumentException(paramASN1Sequence.toString());
            }
          }
          else {
            this.typeOfSubstitution = DirectoryString.getInstance((ASN1TaggedObject)localObject, true);
          }
        }
        else {
          this.country = DERPrintableString.getInstance((ASN1TaggedObject)localObject, true).getString();
        }
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static ProcurationSyntax getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ProcurationSyntax)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new ProcurationSyntax((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ProcurationSyntax)paramObject;
  }
  
  public IssuerSerial getCertRef()
  {
    return this.certRef;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public GeneralName getThirdPerson()
  {
    return this.thirdPerson;
  }
  
  public DirectoryString getTypeOfSubstitution()
  {
    return this.typeOfSubstitution;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.country;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, new DERPrintableString((String)localObject, true)));
    }
    localObject = this.typeOfSubstitution;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 2, (ASN1Encodable)localObject));
    }
    localObject = this.thirdPerson;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 3, (ASN1Encodable)localObject));
    } else {
      localASN1EncodableVector.add(new DERTaggedObject(true, 3, this.certRef));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\ProcurationSyntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */