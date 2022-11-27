package org.bouncycastle.openssl;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;

public class CertificateTrustBlock
{
  private String alias;
  private ASN1Sequence prohibitions;
  private ASN1Sequence uses;
  
  public CertificateTrustBlock(String paramString, Set<ASN1ObjectIdentifier> paramSet)
  {
    this(paramString, paramSet, null);
  }
  
  public CertificateTrustBlock(String paramString, Set<ASN1ObjectIdentifier> paramSet1, Set<ASN1ObjectIdentifier> paramSet2)
  {
    this.alias = paramString;
    this.uses = toSequence(paramSet1);
    this.prohibitions = toSequence(paramSet2);
  }
  
  public CertificateTrustBlock(Set<ASN1ObjectIdentifier> paramSet)
  {
    this(null, paramSet, null);
  }
  
  CertificateTrustBlock(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ASN1Sequence.getInstance(paramArrayOfByte).getObjects();
    while (paramArrayOfByte.hasMoreElements())
    {
      ASN1Encodable localASN1Encodable = (ASN1Encodable)paramArrayOfByte.nextElement();
      if ((localASN1Encodable instanceof ASN1Sequence)) {
        this.uses = ASN1Sequence.getInstance(localASN1Encodable);
      } else if ((localASN1Encodable instanceof ASN1TaggedObject)) {
        this.prohibitions = ASN1Sequence.getInstance((ASN1TaggedObject)localASN1Encodable, false);
      } else if ((localASN1Encodable instanceof DERUTF8String)) {
        this.alias = DERUTF8String.getInstance(localASN1Encodable).getString();
      }
    }
  }
  
  private ASN1Sequence toSequence(Set<ASN1ObjectIdentifier> paramSet)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        localASN1EncodableVector.add((ASN1Encodable)paramSet.next());
      }
      return new DERSequence(localASN1EncodableVector);
    }
    return null;
  }
  
  private Set<ASN1ObjectIdentifier> toSet(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence != null)
    {
      HashSet localHashSet = new HashSet(paramASN1Sequence.size());
      paramASN1Sequence = paramASN1Sequence.getObjects();
      while (paramASN1Sequence.hasMoreElements()) {
        localHashSet.add(ASN1ObjectIdentifier.getInstance(paramASN1Sequence.nextElement()));
      }
      return localHashSet;
    }
    return Collections.EMPTY_SET;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public Set<ASN1ObjectIdentifier> getProhibitions()
  {
    return toSet(this.prohibitions);
  }
  
  public Set<ASN1ObjectIdentifier> getUses()
  {
    return toSet(this.uses);
  }
  
  ASN1Sequence toASN1Sequence()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.uses;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.prohibitions;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    localObject = this.alias;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERUTF8String((String)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\CertificateTrustBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */