package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

public class IssuerSerial
  extends ASN1Object
{
  GeneralNames issuer;
  DERBitString issuerUID;
  ASN1Integer serial;
  
  private IssuerSerial(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() != 2) && (paramASN1Sequence.size() != 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad sequence size: ");
      localStringBuilder.append(paramASN1Sequence.size());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.issuer = GeneralNames.getInstance(paramASN1Sequence.getObjectAt(0));
    this.serial = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() == 3) {
      this.issuerUID = DERBitString.getInstance(paramASN1Sequence.getObjectAt(2));
    }
  }
  
  public IssuerSerial(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this(new GeneralNames(new GeneralName(paramX500Name)), new ASN1Integer(paramBigInteger));
  }
  
  public IssuerSerial(GeneralNames paramGeneralNames, BigInteger paramBigInteger)
  {
    this(paramGeneralNames, new ASN1Integer(paramBigInteger));
  }
  
  public IssuerSerial(GeneralNames paramGeneralNames, ASN1Integer paramASN1Integer)
  {
    this.issuer = paramGeneralNames;
    this.serial = paramASN1Integer;
  }
  
  public static IssuerSerial getInstance(Object paramObject)
  {
    if ((paramObject instanceof IssuerSerial)) {
      return (IssuerSerial)paramObject;
    }
    if (paramObject != null) {
      return new IssuerSerial(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static IssuerSerial getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public GeneralNames getIssuer()
  {
    return this.issuer;
  }
  
  public DERBitString getIssuerUID()
  {
    return this.issuerUID;
  }
  
  public ASN1Integer getSerial()
  {
    return this.serial;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.issuer);
    localASN1EncodableVector.add(this.serial);
    DERBitString localDERBitString = this.issuerUID;
    if (localDERBitString != null) {
      localASN1EncodableVector.add(localDERBitString);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\IssuerSerial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */