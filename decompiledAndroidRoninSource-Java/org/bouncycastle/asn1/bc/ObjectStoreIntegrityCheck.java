package org.bouncycastle.asn1.bc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class ObjectStoreIntegrityCheck
  extends ASN1Object
  implements ASN1Choice
{
  public static final int PBKD_MAC_CHECK = 0;
  private final ASN1Object integrityCheck;
  private final int type;
  
  private ObjectStoreIntegrityCheck(ASN1Encodable paramASN1Encodable)
  {
    if ((!(paramASN1Encodable instanceof ASN1Sequence)) && (!(paramASN1Encodable instanceof PbkdMacIntegrityCheck))) {
      throw new IllegalArgumentException("Unknown check object in integrity check.");
    }
    this.type = 0;
    this.integrityCheck = PbkdMacIntegrityCheck.getInstance(paramASN1Encodable);
  }
  
  public ObjectStoreIntegrityCheck(PbkdMacIntegrityCheck paramPbkdMacIntegrityCheck)
  {
    this(paramPbkdMacIntegrityCheck);
  }
  
  public static ObjectStoreIntegrityCheck getInstance(Object paramObject)
  {
    if ((paramObject instanceof ObjectStoreIntegrityCheck)) {
      return (ObjectStoreIntegrityCheck)paramObject;
    }
    if ((paramObject instanceof byte[])) {}
    try
    {
      paramObject = new ObjectStoreIntegrityCheck(ASN1Primitive.fromByteArray((byte[])paramObject));
      return (ObjectStoreIntegrityCheck)paramObject;
    }
    catch (IOException paramObject)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Unable to parse integrity check details.");
    if (paramObject != null) {
      return new ObjectStoreIntegrityCheck((ASN1Encodable)paramObject);
    }
    return null;
  }
  
  public ASN1Object getIntegrityCheck()
  {
    return this.integrityCheck;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.integrityCheck.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\ObjectStoreIntegrityCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */