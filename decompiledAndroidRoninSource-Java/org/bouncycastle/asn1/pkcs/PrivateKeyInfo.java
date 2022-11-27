package org.bouncycastle.asn1.pkcs;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class PrivateKeyInfo
  extends ASN1Object
{
  private AlgorithmIdentifier algId;
  private ASN1Set attributes;
  private ASN1OctetString privKey;
  
  public PrivateKeyInfo(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    if (((ASN1Integer)paramASN1Sequence.nextElement()).getValue().intValue() == 0)
    {
      this.algId = AlgorithmIdentifier.getInstance(paramASN1Sequence.nextElement());
      this.privKey = ASN1OctetString.getInstance(paramASN1Sequence.nextElement());
      if (paramASN1Sequence.hasMoreElements()) {
        this.attributes = ASN1Set.getInstance((ASN1TaggedObject)paramASN1Sequence.nextElement(), false);
      }
      return;
    }
    throw new IllegalArgumentException("wrong version for private key info");
  }
  
  public PrivateKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    this(paramAlgorithmIdentifier, paramASN1Encodable, null);
  }
  
  public PrivateKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1Encodable paramASN1Encodable, ASN1Set paramASN1Set)
    throws IOException
  {
    this.privKey = new DEROctetString(paramASN1Encodable.toASN1Primitive().getEncoded("DER"));
    this.algId = paramAlgorithmIdentifier;
    this.attributes = paramASN1Set;
  }
  
  public static PrivateKeyInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof PrivateKeyInfo)) {
      return (PrivateKeyInfo)paramObject;
    }
    if (paramObject != null) {
      return new PrivateKeyInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static PrivateKeyInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getAlgorithmId()
  {
    return this.algId;
  }
  
  public ASN1Set getAttributes()
  {
    return this.attributes;
  }
  
  public ASN1Primitive getPrivateKey()
  {
    try
    {
      ASN1Primitive localASN1Primitive = parsePrivateKey().toASN1Primitive();
      return localASN1Primitive;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("unable to parse private key");
  }
  
  public AlgorithmIdentifier getPrivateKeyAlgorithm()
  {
    return this.algId;
  }
  
  public ASN1Encodable parsePrivateKey()
    throws IOException
  {
    return ASN1Primitive.fromByteArray(this.privKey.getOctets());
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(0L));
    localASN1EncodableVector.add(this.algId);
    localASN1EncodableVector.add(this.privKey);
    ASN1Set localASN1Set = this.attributes;
    if (localASN1Set != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localASN1Set));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\PrivateKeyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */