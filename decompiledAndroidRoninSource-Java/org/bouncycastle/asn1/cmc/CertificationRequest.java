package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest
  extends ASN1Object
{
  private static final ASN1Integer ZERO = new ASN1Integer(0L);
  private final CertificationRequestInfo certificationRequestInfo;
  private final DERBitString signature;
  private final AlgorithmIdentifier signatureAlgorithm;
  
  private CertificationRequest(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.certificationRequestInfo = new CertificationRequestInfo(ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(0)), null);
      this.signatureAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.signature = DERBitString.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public CertificationRequest(X500Name paramX500Name, AlgorithmIdentifier paramAlgorithmIdentifier1, DERBitString paramDERBitString1, ASN1Set paramASN1Set, AlgorithmIdentifier paramAlgorithmIdentifier2, DERBitString paramDERBitString2)
  {
    this.certificationRequestInfo = new CertificationRequestInfo(paramX500Name, paramAlgorithmIdentifier1, paramDERBitString1, paramASN1Set, null);
    this.signatureAlgorithm = paramAlgorithmIdentifier2;
    this.signature = paramDERBitString2;
  }
  
  public static CertificationRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertificationRequest)) {
      return (CertificationRequest)paramObject;
    }
    if (paramObject != null) {
      return new CertificationRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Set getAttributes()
  {
    return this.certificationRequestInfo.getAttributes();
  }
  
  public DERBitString getSignature()
  {
    return this.signature;
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.signatureAlgorithm;
  }
  
  public X500Name getSubject()
  {
    return this.certificationRequestInfo.getSubject();
  }
  
  public DERBitString getSubjectPublicKey()
  {
    return DERBitString.getInstance(this.certificationRequestInfo.getSubjectPublicKeyInfo().getObjectAt(1));
  }
  
  public AlgorithmIdentifier getSubjectPublicKeyAlgorithm()
  {
    return AlgorithmIdentifier.getInstance(this.certificationRequestInfo.getSubjectPublicKeyInfo().getObjectAt(0));
  }
  
  public BigInteger getVersion()
  {
    return this.certificationRequestInfo.getVersion().getValue();
  }
  
  public ASN1Primitive parsePublicKey()
    throws IOException
  {
    return ASN1Primitive.fromByteArray(getSubjectPublicKey().getOctets());
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certificationRequestInfo);
    localASN1EncodableVector.add(this.signatureAlgorithm);
    localASN1EncodableVector.add(this.signature);
    return new DERSequence(localASN1EncodableVector);
  }
  
  private class CertificationRequestInfo
    extends ASN1Object
  {
    private final ASN1Set attributes;
    private final X500Name subject;
    private final ASN1Sequence subjectPublicKeyInfo;
    private final ASN1Integer version;
    
    private CertificationRequestInfo(ASN1Sequence paramASN1Sequence)
    {
      if (paramASN1Sequence.size() == 4)
      {
        this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
        this.subject = X500Name.getInstance(paramASN1Sequence.getObjectAt(1));
        this$1 = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(2));
        this.subjectPublicKeyInfo = CertificationRequest.this;
        if (CertificationRequest.this.size() == 2)
        {
          this$1 = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(3);
          if (CertificationRequest.this.getTagNo() == 0)
          {
            this.attributes = ASN1Set.getInstance(CertificationRequest.this, false);
            return;
          }
          throw new IllegalArgumentException("incorrect tag number on attributes for CertificationRequestInfo");
        }
        throw new IllegalArgumentException("incorrect subjectPublicKeyInfo size for CertificationRequestInfo");
      }
      throw new IllegalArgumentException("incorrect sequence size for CertificationRequestInfo");
    }
    
    private CertificationRequestInfo(X500Name paramX500Name, AlgorithmIdentifier paramAlgorithmIdentifier, DERBitString paramDERBitString, ASN1Set paramASN1Set)
    {
      this.version = CertificationRequest.ZERO;
      this.subject = paramX500Name;
      this.subjectPublicKeyInfo = new DERSequence(new ASN1Encodable[] { paramAlgorithmIdentifier, paramDERBitString });
      this.attributes = paramASN1Set;
    }
    
    private ASN1Set getAttributes()
    {
      return this.attributes;
    }
    
    private X500Name getSubject()
    {
      return this.subject;
    }
    
    private ASN1Sequence getSubjectPublicKeyInfo()
    {
      return this.subjectPublicKeyInfo;
    }
    
    private ASN1Integer getVersion()
    {
      return this.version;
    }
    
    public ASN1Primitive toASN1Primitive()
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localASN1EncodableVector.add(this.version);
      localASN1EncodableVector.add(this.subject);
      localASN1EncodableVector.add(this.subjectPublicKeyInfo);
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, this.attributes));
      return new DERSequence(localASN1EncodableVector);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CertificationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */