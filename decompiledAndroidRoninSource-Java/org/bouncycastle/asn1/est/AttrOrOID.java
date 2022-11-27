package org.bouncycastle.asn1.est;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.Attribute;

public class AttrOrOID
  extends ASN1Object
  implements ASN1Choice
{
  private final Attribute attribute;
  private final ASN1ObjectIdentifier oid;
  
  public AttrOrOID(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.oid = paramASN1ObjectIdentifier;
    this.attribute = null;
  }
  
  public AttrOrOID(Attribute paramAttribute)
  {
    this.oid = null;
    this.attribute = paramAttribute;
  }
  
  public static AttrOrOID getInstance(Object paramObject)
  {
    if ((paramObject instanceof AttrOrOID)) {
      return (AttrOrOID)paramObject;
    }
    if (paramObject != null)
    {
      if ((paramObject instanceof ASN1Encodable))
      {
        localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
        if ((localObject instanceof ASN1ObjectIdentifier)) {
          return new AttrOrOID(ASN1ObjectIdentifier.getInstance(localObject));
        }
        if ((localObject instanceof ASN1Sequence)) {
          return new AttrOrOID(Attribute.getInstance(localObject));
        }
      }
      if (!(paramObject instanceof byte[])) {}
    }
    try
    {
      paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
      return (AttrOrOID)paramObject;
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
  
  public Attribute getAttribute()
  {
    return this.attribute;
  }
  
  public ASN1ObjectIdentifier getOid()
  {
    return this.oid;
  }
  
  public boolean isOid()
  {
    return this.oid != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = this.oid;
    if (localASN1ObjectIdentifier != null) {
      return localASN1ObjectIdentifier;
    }
    return this.attribute.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\est\AttrOrOID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */