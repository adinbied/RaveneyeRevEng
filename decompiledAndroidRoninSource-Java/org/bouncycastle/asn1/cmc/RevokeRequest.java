package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.util.Arrays;

public class RevokeRequest
  extends ASN1Object
{
  private DERUTF8String comment;
  private ASN1GeneralizedTime invalidityDate;
  private final X500Name name;
  private ASN1OctetString passphrase;
  private final CRLReason reason;
  private final ASN1Integer serialNumber;
  
  private RevokeRequest(ASN1Sequence paramASN1Sequence)
  {
    int i = paramASN1Sequence.size();
    int j = 3;
    if ((i >= 3) && (paramASN1Sequence.size() <= 6))
    {
      this.name = X500Name.getInstance(paramASN1Sequence.getObjectAt(0));
      this.serialNumber = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1));
      this.reason = CRLReason.getInstance(paramASN1Sequence.getObjectAt(2));
      i = j;
      if (paramASN1Sequence.size() > 3)
      {
        i = j;
        if ((paramASN1Sequence.getObjectAt(3).toASN1Primitive() instanceof ASN1GeneralizedTime))
        {
          this.invalidityDate = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(3));
          i = 4;
        }
      }
      j = i;
      if (paramASN1Sequence.size() > i)
      {
        j = i;
        if ((paramASN1Sequence.getObjectAt(i).toASN1Primitive() instanceof ASN1OctetString))
        {
          this.passphrase = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(i));
          j = i + 1;
        }
      }
      if ((paramASN1Sequence.size() > j) && ((paramASN1Sequence.getObjectAt(j).toASN1Primitive() instanceof DERUTF8String))) {
        this.comment = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(j));
      }
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public RevokeRequest(X500Name paramX500Name, ASN1Integer paramASN1Integer, CRLReason paramCRLReason, ASN1GeneralizedTime paramASN1GeneralizedTime, ASN1OctetString paramASN1OctetString, DERUTF8String paramDERUTF8String)
  {
    this.name = paramX500Name;
    this.serialNumber = paramASN1Integer;
    this.reason = paramCRLReason;
    this.invalidityDate = paramASN1GeneralizedTime;
    this.passphrase = paramASN1OctetString;
    this.comment = paramDERUTF8String;
  }
  
  public static RevokeRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof RevokeRequest)) {
      return (RevokeRequest)paramObject;
    }
    if (paramObject != null) {
      return new RevokeRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public DERUTF8String getComment()
  {
    return this.comment;
  }
  
  public ASN1GeneralizedTime getInvalidityDate()
  {
    return this.invalidityDate;
  }
  
  public X500Name getName()
  {
    return this.name;
  }
  
  public byte[] getPassPhrase()
  {
    ASN1OctetString localASN1OctetString = this.passphrase;
    if (localASN1OctetString != null) {
      return Arrays.clone(localASN1OctetString.getOctets());
    }
    return null;
  }
  
  public ASN1OctetString getPassphrase()
  {
    return this.passphrase;
  }
  
  public CRLReason getReason()
  {
    return this.reason;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.serialNumber.getValue();
  }
  
  public void setComment(DERUTF8String paramDERUTF8String)
  {
    this.comment = paramDERUTF8String;
  }
  
  public void setInvalidityDate(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.invalidityDate = paramASN1GeneralizedTime;
  }
  
  public void setPassphrase(ASN1OctetString paramASN1OctetString)
  {
    this.passphrase = paramASN1OctetString;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.name);
    localASN1EncodableVector.add(this.serialNumber);
    localASN1EncodableVector.add(this.reason);
    Object localObject = this.invalidityDate;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.passphrase;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.comment;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\RevokeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */