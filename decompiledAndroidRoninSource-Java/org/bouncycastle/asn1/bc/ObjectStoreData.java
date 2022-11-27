package org.bouncycastle.asn1.bc;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class ObjectStoreData
  extends ASN1Object
{
  private final String comment;
  private final ASN1GeneralizedTime creationDate;
  private final AlgorithmIdentifier integrityAlgorithm;
  private final ASN1GeneralizedTime lastModifiedDate;
  private final ObjectDataSequence objectDataSequence;
  private final BigInteger version;
  
  private ObjectStoreData(ASN1Sequence paramASN1Sequence)
  {
    this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0)).getValue();
    this.integrityAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
    this.creationDate = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(2));
    this.lastModifiedDate = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(3));
    this.objectDataSequence = ObjectDataSequence.getInstance(paramASN1Sequence.getObjectAt(4));
    if (paramASN1Sequence.size() == 6) {
      paramASN1Sequence = DERUTF8String.getInstance(paramASN1Sequence.getObjectAt(5)).getString();
    } else {
      paramASN1Sequence = null;
    }
    this.comment = paramASN1Sequence;
  }
  
  public ObjectStoreData(AlgorithmIdentifier paramAlgorithmIdentifier, Date paramDate1, Date paramDate2, ObjectDataSequence paramObjectDataSequence, String paramString)
  {
    this.version = BigInteger.valueOf(1L);
    this.integrityAlgorithm = paramAlgorithmIdentifier;
    this.creationDate = new DERGeneralizedTime(paramDate1);
    this.lastModifiedDate = new DERGeneralizedTime(paramDate2);
    this.objectDataSequence = paramObjectDataSequence;
    this.comment = paramString;
  }
  
  public static ObjectStoreData getInstance(Object paramObject)
  {
    if ((paramObject instanceof ObjectStoreData)) {
      return (ObjectStoreData)paramObject;
    }
    if (paramObject != null) {
      return new ObjectStoreData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public ASN1GeneralizedTime getCreationDate()
  {
    return this.creationDate;
  }
  
  public AlgorithmIdentifier getIntegrityAlgorithm()
  {
    return this.integrityAlgorithm;
  }
  
  public ASN1GeneralizedTime getLastModifiedDate()
  {
    return this.lastModifiedDate;
  }
  
  public ObjectDataSequence getObjectDataSequence()
  {
    return this.objectDataSequence;
  }
  
  public BigInteger getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(this.version));
    localASN1EncodableVector.add(this.integrityAlgorithm);
    localASN1EncodableVector.add(this.creationDate);
    localASN1EncodableVector.add(this.lastModifiedDate);
    localASN1EncodableVector.add(this.objectDataSequence);
    String str = this.comment;
    if (str != null) {
      localASN1EncodableVector.add(new DERUTF8String(str));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\ObjectStoreData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */