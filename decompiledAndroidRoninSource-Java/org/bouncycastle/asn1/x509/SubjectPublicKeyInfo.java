package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

public class SubjectPublicKeyInfo
  extends ASN1Object
{
  private AlgorithmIdentifier algId;
  private DERBitString keyData;
  
  public SubjectPublicKeyInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      this.algId = AlgorithmIdentifier.getInstance(paramASN1Sequence.nextElement());
      this.keyData = DERBitString.getInstance(paramASN1Sequence.nextElement());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public SubjectPublicKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    this.keyData = new DERBitString(paramASN1Encodable);
    this.algId = paramAlgorithmIdentifier;
  }
  
  public SubjectPublicKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.keyData = new DERBitString(paramArrayOfByte);
    this.algId = paramAlgorithmIdentifier;
  }
  
  public static SubjectPublicKeyInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof SubjectPublicKeyInfo)) {
      return (SubjectPublicKeyInfo)paramObject;
    }
    if (paramObject != null) {
      return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static SubjectPublicKeyInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getAlgorithm()
  {
    return this.algId;
  }
  
  public AlgorithmIdentifier getAlgorithmId()
  {
    return this.algId;
  }
  
  public ASN1Primitive getPublicKey()
    throws IOException
  {
    return new ASN1InputStream(this.keyData.getOctets()).readObject();
  }
  
  public DERBitString getPublicKeyData()
  {
    return this.keyData;
  }
  
  public ASN1Primitive parsePublicKey()
    throws IOException
  {
    return new ASN1InputStream(this.keyData.getOctets()).readObject();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.algId);
    localASN1EncodableVector.add(this.keyData);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\SubjectPublicKeyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */