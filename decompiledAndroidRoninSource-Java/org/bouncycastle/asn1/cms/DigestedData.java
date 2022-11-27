package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class DigestedData
  extends ASN1Object
{
  private ASN1OctetString digest;
  private AlgorithmIdentifier digestAlgorithm;
  private ContentInfo encapContentInfo;
  private ASN1Integer version;
  
  private DigestedData(ASN1Sequence paramASN1Sequence)
  {
    this.version = ((ASN1Integer)paramASN1Sequence.getObjectAt(0));
    this.digestAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
    this.encapContentInfo = ContentInfo.getInstance(paramASN1Sequence.getObjectAt(2));
    this.digest = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(3));
  }
  
  public DigestedData(AlgorithmIdentifier paramAlgorithmIdentifier, ContentInfo paramContentInfo, byte[] paramArrayOfByte)
  {
    this.version = new ASN1Integer(0L);
    this.digestAlgorithm = paramAlgorithmIdentifier;
    this.encapContentInfo = paramContentInfo;
    this.digest = new DEROctetString(paramArrayOfByte);
  }
  
  public static DigestedData getInstance(Object paramObject)
  {
    if ((paramObject instanceof DigestedData)) {
      return (DigestedData)paramObject;
    }
    if (paramObject != null) {
      return new DigestedData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DigestedData getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public byte[] getDigest()
  {
    return this.digest.getOctets();
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    return this.digestAlgorithm;
  }
  
  public ContentInfo getEncapContentInfo()
  {
    return this.encapContentInfo;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.digestAlgorithm);
    localASN1EncodableVector.add(this.encapContentInfo);
    localASN1EncodableVector.add(this.digest);
    return new BERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\DigestedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */