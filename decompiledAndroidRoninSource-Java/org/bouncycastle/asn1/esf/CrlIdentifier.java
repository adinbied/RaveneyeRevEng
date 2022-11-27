package org.bouncycastle.asn1.esf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

public class CrlIdentifier
  extends ASN1Object
{
  private ASN1UTCTime crlIssuedTime;
  private X500Name crlIssuer;
  private ASN1Integer crlNumber;
  
  private CrlIdentifier(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 2) && (paramASN1Sequence.size() <= 3))
    {
      this.crlIssuer = X500Name.getInstance(paramASN1Sequence.getObjectAt(0));
      this.crlIssuedTime = ASN1UTCTime.getInstance(paramASN1Sequence.getObjectAt(1));
      if (paramASN1Sequence.size() > 2) {
        this.crlNumber = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(2));
      }
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public CrlIdentifier(X500Name paramX500Name, ASN1UTCTime paramASN1UTCTime)
  {
    this(paramX500Name, paramASN1UTCTime, null);
  }
  
  public CrlIdentifier(X500Name paramX500Name, ASN1UTCTime paramASN1UTCTime, BigInteger paramBigInteger)
  {
    this.crlIssuer = paramX500Name;
    this.crlIssuedTime = paramASN1UTCTime;
    if (paramBigInteger != null) {
      this.crlNumber = new ASN1Integer(paramBigInteger);
    }
  }
  
  public static CrlIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof CrlIdentifier)) {
      return (CrlIdentifier)paramObject;
    }
    if (paramObject != null) {
      return new CrlIdentifier(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1UTCTime getCrlIssuedTime()
  {
    return this.crlIssuedTime;
  }
  
  public X500Name getCrlIssuer()
  {
    return this.crlIssuer;
  }
  
  public BigInteger getCrlNumber()
  {
    ASN1Integer localASN1Integer = this.crlNumber;
    if (localASN1Integer == null) {
      return null;
    }
    return localASN1Integer.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.crlIssuer.toASN1Primitive());
    localASN1EncodableVector.add(this.crlIssuedTime);
    ASN1Integer localASN1Integer = this.crlNumber;
    if (localASN1Integer != null) {
      localASN1EncodableVector.add(localASN1Integer);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CrlIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */