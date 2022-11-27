package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

public class V2TBSCertListGenerator
{
  private static final ASN1Sequence[] reasons;
  private ASN1EncodableVector crlentries = new ASN1EncodableVector();
  private Extensions extensions = null;
  private X500Name issuer;
  private Time nextUpdate = null;
  private AlgorithmIdentifier signature;
  private Time thisUpdate;
  private ASN1Integer version = new ASN1Integer(1L);
  
  static
  {
    ASN1Sequence[] arrayOfASN1Sequence = new ASN1Sequence[11];
    reasons = arrayOfASN1Sequence;
    arrayOfASN1Sequence[0] = createReasonExtension(0);
    reasons[1] = createReasonExtension(1);
    reasons[2] = createReasonExtension(2);
    reasons[3] = createReasonExtension(3);
    reasons[4] = createReasonExtension(4);
    reasons[5] = createReasonExtension(5);
    reasons[6] = createReasonExtension(6);
    reasons[7] = createReasonExtension(7);
    reasons[8] = createReasonExtension(8);
    reasons[9] = createReasonExtension(9);
    reasons[10] = createReasonExtension(10);
  }
  
  private static ASN1Sequence createInvalidityDateExtension(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    Object localObject = new ASN1EncodableVector();
    try
    {
      ((ASN1EncodableVector)localObject).add(Extension.invalidityDate);
      ((ASN1EncodableVector)localObject).add(new DEROctetString(paramASN1GeneralizedTime.getEncoded()));
      return new DERSequence((ASN1EncodableVector)localObject);
    }
    catch (IOException paramASN1GeneralizedTime)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error encoding reason: ");
      ((StringBuilder)localObject).append(paramASN1GeneralizedTime);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  private static ASN1Sequence createReasonExtension(int paramInt)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = CRLReason.lookup(paramInt);
    try
    {
      localASN1EncodableVector.add(Extension.reasonCode);
      localASN1EncodableVector.add(new DEROctetString(((CRLReason)localObject).getEncoded()));
      return new DERSequence(localASN1EncodableVector);
    }
    catch (IOException localIOException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error encoding reason: ");
      ((StringBuilder)localObject).append(localIOException);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
  
  private void internalAddCRLEntry(ASN1Integer paramASN1Integer, Time paramTime, ASN1Sequence paramASN1Sequence)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramASN1Integer);
    localASN1EncodableVector.add(paramTime);
    if (paramASN1Sequence != null) {
      localASN1EncodableVector.add(paramASN1Sequence);
    }
    addCRLEntry(new DERSequence(localASN1EncodableVector));
  }
  
  public void addCRLEntry(ASN1Integer paramASN1Integer, ASN1UTCTime paramASN1UTCTime, int paramInt)
  {
    addCRLEntry(paramASN1Integer, new Time(paramASN1UTCTime), paramInt);
  }
  
  public void addCRLEntry(ASN1Integer paramASN1Integer, Time paramTime, int paramInt)
  {
    addCRLEntry(paramASN1Integer, paramTime, paramInt, null);
  }
  
  public void addCRLEntry(ASN1Integer paramASN1Integer, Time paramTime, int paramInt, ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    Object localObject;
    if (paramInt != 0)
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localObject = reasons;
      if (paramInt < localObject.length)
      {
        if (paramInt >= 0)
        {
          localObject = localObject[paramInt];
        }
        else
        {
          paramASN1Integer = new StringBuilder();
          paramASN1Integer.append("invalid reason value: ");
          paramASN1Integer.append(paramInt);
          throw new IllegalArgumentException(paramASN1Integer.toString());
        }
      }
      else {
        localObject = createReasonExtension(paramInt);
      }
      localASN1EncodableVector.add((ASN1Encodable)localObject);
      if (paramASN1GeneralizedTime != null) {
        localASN1EncodableVector.add(createInvalidityDateExtension(paramASN1GeneralizedTime));
      }
      internalAddCRLEntry(paramASN1Integer, paramTime, new DERSequence(localASN1EncodableVector));
      return;
    }
    if (paramASN1GeneralizedTime != null)
    {
      localObject = new ASN1EncodableVector();
      ((ASN1EncodableVector)localObject).add(createInvalidityDateExtension(paramASN1GeneralizedTime));
      internalAddCRLEntry(paramASN1Integer, paramTime, new DERSequence((ASN1EncodableVector)localObject));
      return;
    }
    addCRLEntry(paramASN1Integer, paramTime, null);
  }
  
  public void addCRLEntry(ASN1Integer paramASN1Integer, Time paramTime, Extensions paramExtensions)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramASN1Integer);
    localASN1EncodableVector.add(paramTime);
    if (paramExtensions != null) {
      localASN1EncodableVector.add(paramExtensions);
    }
    addCRLEntry(new DERSequence(localASN1EncodableVector));
  }
  
  public void addCRLEntry(ASN1Sequence paramASN1Sequence)
  {
    this.crlentries.add(paramASN1Sequence);
  }
  
  public TBSCertList generateTBSCertList()
  {
    if ((this.signature != null) && (this.issuer != null) && (this.thisUpdate != null))
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localASN1EncodableVector.add(this.version);
      localASN1EncodableVector.add(this.signature);
      localASN1EncodableVector.add(this.issuer);
      localASN1EncodableVector.add(this.thisUpdate);
      Object localObject = this.nextUpdate;
      if (localObject != null) {
        localASN1EncodableVector.add((ASN1Encodable)localObject);
      }
      if (this.crlentries.size() != 0) {
        localASN1EncodableVector.add(new DERSequence(this.crlentries));
      }
      localObject = this.extensions;
      if (localObject != null) {
        localASN1EncodableVector.add(new DERTaggedObject(0, (ASN1Encodable)localObject));
      }
      return new TBSCertList(new DERSequence(localASN1EncodableVector));
    }
    throw new IllegalStateException("Not all mandatory fields set in V2 TBSCertList generator.");
  }
  
  public void setExtensions(Extensions paramExtensions)
  {
    this.extensions = paramExtensions;
  }
  
  public void setExtensions(X509Extensions paramX509Extensions)
  {
    setExtensions(Extensions.getInstance(paramX509Extensions));
  }
  
  public void setIssuer(X500Name paramX500Name)
  {
    this.issuer = paramX500Name;
  }
  
  public void setIssuer(X509Name paramX509Name)
  {
    this.issuer = X500Name.getInstance(paramX509Name.toASN1Primitive());
  }
  
  public void setNextUpdate(ASN1UTCTime paramASN1UTCTime)
  {
    this.nextUpdate = new Time(paramASN1UTCTime);
  }
  
  public void setNextUpdate(Time paramTime)
  {
    this.nextUpdate = paramTime;
  }
  
  public void setSignature(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.signature = paramAlgorithmIdentifier;
  }
  
  public void setThisUpdate(ASN1UTCTime paramASN1UTCTime)
  {
    this.thisUpdate = new Time(paramASN1UTCTime);
  }
  
  public void setThisUpdate(Time paramTime)
  {
    this.thisUpdate = paramTime;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\V2TBSCertListGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */