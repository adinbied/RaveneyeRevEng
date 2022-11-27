package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ObjectStore
  extends ASN1Object
{
  private final ObjectStoreIntegrityCheck integrityCheck;
  private final ASN1Encodable storeData;
  
  private ObjectStore(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjectAt(0);
    if ((localObject instanceof EncryptedObjectStoreData)) {}
    for (;;)
    {
      this.storeData = ((ASN1Encodable)localObject);
      break;
      if (!(localObject instanceof ObjectStoreData))
      {
        localObject = ASN1Sequence.getInstance(localObject);
        if (((ASN1Sequence)localObject).size() == 2) {
          localObject = EncryptedObjectStoreData.getInstance(localObject);
        } else {
          localObject = ObjectStoreData.getInstance(localObject);
        }
      }
    }
    this.integrityCheck = ObjectStoreIntegrityCheck.getInstance(paramASN1Sequence.getObjectAt(1));
  }
  
  public ObjectStore(EncryptedObjectStoreData paramEncryptedObjectStoreData, ObjectStoreIntegrityCheck paramObjectStoreIntegrityCheck)
  {
    this.storeData = paramEncryptedObjectStoreData;
    this.integrityCheck = paramObjectStoreIntegrityCheck;
  }
  
  public ObjectStore(ObjectStoreData paramObjectStoreData, ObjectStoreIntegrityCheck paramObjectStoreIntegrityCheck)
  {
    this.storeData = paramObjectStoreData;
    this.integrityCheck = paramObjectStoreIntegrityCheck;
  }
  
  public static ObjectStore getInstance(Object paramObject)
  {
    if ((paramObject instanceof ObjectStore)) {
      return (ObjectStore)paramObject;
    }
    if (paramObject != null) {
      return new ObjectStore(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ObjectStoreIntegrityCheck getIntegrityCheck()
  {
    return this.integrityCheck;
  }
  
  public ASN1Encodable getStoreData()
  {
    return this.storeData;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.storeData);
    localASN1EncodableVector.add(this.integrityCheck);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\ObjectStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */