package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

public class TBSCertList
  extends ASN1Object
{
  Extensions crlExtensions;
  X500Name issuer;
  Time nextUpdate;
  ASN1Sequence revokedCertificates;
  AlgorithmIdentifier signature;
  Time thisUpdate;
  ASN1Integer version;
  
  public TBSCertList(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 3) && (paramASN1Sequence.size() <= 7))
    {
      int i = 0;
      if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1Integer))
      {
        this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
        i = 1;
      }
      else
      {
        this.version = null;
      }
      int j = i + 1;
      this.signature = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(i));
      i = j + 1;
      this.issuer = X500Name.getInstance(paramASN1Sequence.getObjectAt(j));
      j = i + 1;
      this.thisUpdate = Time.getInstance(paramASN1Sequence.getObjectAt(i));
      i = j;
      if (j < paramASN1Sequence.size()) {
        if ((!(paramASN1Sequence.getObjectAt(j) instanceof ASN1UTCTime)) && (!(paramASN1Sequence.getObjectAt(j) instanceof ASN1GeneralizedTime)))
        {
          i = j;
          if (!(paramASN1Sequence.getObjectAt(j) instanceof Time)) {}
        }
        else
        {
          this.nextUpdate = Time.getInstance(paramASN1Sequence.getObjectAt(j));
          i = j + 1;
        }
      }
      j = i;
      if (i < paramASN1Sequence.size())
      {
        j = i;
        if (!(paramASN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject))
        {
          this.revokedCertificates = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(i));
          j = i + 1;
        }
      }
      if ((j < paramASN1Sequence.size()) && ((paramASN1Sequence.getObjectAt(j) instanceof ASN1TaggedObject))) {
        this.crlExtensions = Extensions.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(j), true));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static TBSCertList getInstance(Object paramObject)
  {
    if ((paramObject instanceof TBSCertList)) {
      return (TBSCertList)paramObject;
    }
    if (paramObject != null) {
      return new TBSCertList(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static TBSCertList getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public Extensions getExtensions()
  {
    return this.crlExtensions;
  }
  
  public X500Name getIssuer()
  {
    return this.issuer;
  }
  
  public Time getNextUpdate()
  {
    return this.nextUpdate;
  }
  
  public Enumeration getRevokedCertificateEnumeration()
  {
    ASN1Sequence localASN1Sequence = this.revokedCertificates;
    if (localASN1Sequence == null) {
      return new EmptyEnumeration(null);
    }
    return new RevokedCertificatesEnumeration(localASN1Sequence.getObjects());
  }
  
  public CRLEntry[] getRevokedCertificates()
  {
    Object localObject = this.revokedCertificates;
    int i = 0;
    if (localObject == null) {
      return new CRLEntry[0];
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CRLEntry[j];
    while (i < j)
    {
      localObject[i] = CRLEntry.getInstance(this.revokedCertificates.getObjectAt(i));
      i += 1;
    }
    return (CRLEntry[])localObject;
  }
  
  public AlgorithmIdentifier getSignature()
  {
    return this.signature;
  }
  
  public Time getThisUpdate()
  {
    return this.thisUpdate;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public int getVersionNumber()
  {
    ASN1Integer localASN1Integer = this.version;
    if (localASN1Integer == null) {
      return 1;
    }
    return localASN1Integer.getValue().intValue() + 1;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.version;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localASN1EncodableVector.add(this.signature);
    localASN1EncodableVector.add(this.issuer);
    localASN1EncodableVector.add(this.thisUpdate);
    localObject = this.nextUpdate;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.revokedCertificates;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.crlExtensions;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(0, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public static class CRLEntry
    extends ASN1Object
  {
    Extensions crlEntryExtensions;
    ASN1Sequence seq;
    
    private CRLEntry(ASN1Sequence paramASN1Sequence)
    {
      if ((paramASN1Sequence.size() >= 2) && (paramASN1Sequence.size() <= 3))
      {
        this.seq = paramASN1Sequence;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad sequence size: ");
      localStringBuilder.append(paramASN1Sequence.size());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public static CRLEntry getInstance(Object paramObject)
    {
      if ((paramObject instanceof CRLEntry)) {
        return (CRLEntry)paramObject;
      }
      if (paramObject != null) {
        return new CRLEntry(ASN1Sequence.getInstance(paramObject));
      }
      return null;
    }
    
    public Extensions getExtensions()
    {
      if ((this.crlEntryExtensions == null) && (this.seq.size() == 3)) {
        this.crlEntryExtensions = Extensions.getInstance(this.seq.getObjectAt(2));
      }
      return this.crlEntryExtensions;
    }
    
    public Time getRevocationDate()
    {
      return Time.getInstance(this.seq.getObjectAt(1));
    }
    
    public ASN1Integer getUserCertificate()
    {
      return ASN1Integer.getInstance(this.seq.getObjectAt(0));
    }
    
    public boolean hasExtensions()
    {
      return this.seq.size() == 3;
    }
    
    public ASN1Primitive toASN1Primitive()
    {
      return this.seq;
    }
  }
  
  private class EmptyEnumeration
    implements Enumeration
  {
    private EmptyEnumeration() {}
    
    public boolean hasMoreElements()
    {
      return false;
    }
    
    public Object nextElement()
    {
      throw new NoSuchElementException("Empty Enumeration");
    }
  }
  
  private class RevokedCertificatesEnumeration
    implements Enumeration
  {
    private final Enumeration en;
    
    RevokedCertificatesEnumeration(Enumeration paramEnumeration)
    {
      this.en = paramEnumeration;
    }
    
    public boolean hasMoreElements()
    {
      return this.en.hasMoreElements();
    }
    
    public Object nextElement()
    {
      return TBSCertList.CRLEntry.getInstance(this.en.nextElement());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\TBSCertList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */