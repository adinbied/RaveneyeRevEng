package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class ExtendedKeyUsage
  extends ASN1Object
{
  ASN1Sequence seq;
  Hashtable usageTable = new Hashtable();
  
  public ExtendedKeyUsage(Vector paramVector)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    paramVector = paramVector.elements();
    while (paramVector.hasMoreElements())
    {
      KeyPurposeId localKeyPurposeId = KeyPurposeId.getInstance(paramVector.nextElement());
      localASN1EncodableVector.add(localKeyPurposeId);
      this.usageTable.put(localKeyPurposeId, localKeyPurposeId);
    }
    this.seq = new DERSequence(localASN1EncodableVector);
  }
  
  private ExtendedKeyUsage(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements())
    {
      ASN1Encodable localASN1Encodable = (ASN1Encodable)paramASN1Sequence.nextElement();
      if ((localASN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier)) {
        this.usageTable.put(localASN1Encodable, localASN1Encodable);
      } else {
        throw new IllegalArgumentException("Only ASN1ObjectIdentifiers allowed in ExtendedKeyUsage.");
      }
    }
  }
  
  public ExtendedKeyUsage(KeyPurposeId paramKeyPurposeId)
  {
    this.seq = new DERSequence(paramKeyPurposeId);
    this.usageTable.put(paramKeyPurposeId, paramKeyPurposeId);
  }
  
  public ExtendedKeyUsage(KeyPurposeId[] paramArrayOfKeyPurposeId)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i != paramArrayOfKeyPurposeId.length)
    {
      localASN1EncodableVector.add(paramArrayOfKeyPurposeId[i]);
      this.usageTable.put(paramArrayOfKeyPurposeId[i], paramArrayOfKeyPurposeId[i]);
      i += 1;
    }
    this.seq = new DERSequence(localASN1EncodableVector);
  }
  
  public static ExtendedKeyUsage fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.extendedKeyUsage));
  }
  
  public static ExtendedKeyUsage getInstance(Object paramObject)
  {
    if ((paramObject instanceof ExtendedKeyUsage)) {
      return (ExtendedKeyUsage)paramObject;
    }
    if (paramObject != null) {
      return new ExtendedKeyUsage(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static ExtendedKeyUsage getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public KeyPurposeId[] getUsages()
  {
    KeyPurposeId[] arrayOfKeyPurposeId = new KeyPurposeId[this.seq.size()];
    Enumeration localEnumeration = this.seq.getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      arrayOfKeyPurposeId[i] = KeyPurposeId.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return arrayOfKeyPurposeId;
  }
  
  public boolean hasKeyPurposeId(KeyPurposeId paramKeyPurposeId)
  {
    return this.usageTable.get(paramKeyPurposeId) != null;
  }
  
  public int size()
  {
    return this.usageTable.size();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\ExtendedKeyUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */