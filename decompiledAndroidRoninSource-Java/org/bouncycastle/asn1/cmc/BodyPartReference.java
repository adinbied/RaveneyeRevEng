package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class BodyPartReference
  extends ASN1Object
  implements ASN1Choice
{
  private final BodyPartID bodyPartID;
  private final BodyPartPath bodyPartPath;
  
  public BodyPartReference(BodyPartID paramBodyPartID)
  {
    this.bodyPartID = paramBodyPartID;
    this.bodyPartPath = null;
  }
  
  public BodyPartReference(BodyPartPath paramBodyPartPath)
  {
    this.bodyPartID = null;
    this.bodyPartPath = paramBodyPartPath;
  }
  
  public static BodyPartReference getInstance(Object paramObject)
  {
    if ((paramObject instanceof BodyPartReference)) {
      return (BodyPartReference)paramObject;
    }
    if (paramObject != null)
    {
      if ((paramObject instanceof ASN1Encodable))
      {
        localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
        if ((localObject instanceof ASN1Integer)) {
          return new BodyPartReference(BodyPartID.getInstance(localObject));
        }
        if ((localObject instanceof ASN1Sequence)) {
          return new BodyPartReference(BodyPartPath.getInstance(localObject));
        }
      }
      if (!(paramObject instanceof byte[])) {}
    }
    try
    {
      paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
      return (BodyPartReference)paramObject;
    }
    catch (IOException paramObject)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("unknown encoding in getInstance()");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object in getInstance(): ");
    ((StringBuilder)localObject).append(paramObject.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    return null;
  }
  
  public BodyPartID getBodyPartID()
  {
    return this.bodyPartID;
  }
  
  public BodyPartPath getBodyPartPath()
  {
    return this.bodyPartPath;
  }
  
  public boolean isBodyPartID()
  {
    return this.bodyPartID != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    BodyPartID localBodyPartID = this.bodyPartID;
    if (localBodyPartID != null) {
      return localBodyPartID.toASN1Primitive();
    }
    return this.bodyPartPath.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\BodyPartReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */