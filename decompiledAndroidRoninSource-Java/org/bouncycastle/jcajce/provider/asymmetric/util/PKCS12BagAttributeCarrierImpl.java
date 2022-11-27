package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class PKCS12BagAttributeCarrierImpl
  implements PKCS12BagAttributeCarrier
{
  private Hashtable pkcs12Attributes;
  private Vector pkcs12Ordering;
  
  public PKCS12BagAttributeCarrierImpl()
  {
    this(new Hashtable(), new Vector());
  }
  
  PKCS12BagAttributeCarrierImpl(Hashtable paramHashtable, Vector paramVector)
  {
    this.pkcs12Attributes = paramHashtable;
    this.pkcs12Ordering = paramVector;
  }
  
  Hashtable getAttributes()
  {
    return this.pkcs12Attributes;
  }
  
  public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (ASN1Encodable)this.pkcs12Attributes.get(paramASN1ObjectIdentifier);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.pkcs12Ordering.elements();
  }
  
  Vector getOrdering()
  {
    return this.pkcs12Ordering;
  }
  
  public void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    Object localObject = paramObjectInputStream.readObject();
    if ((localObject instanceof Hashtable))
    {
      this.pkcs12Attributes = ((Hashtable)localObject);
      this.pkcs12Ordering = ((Vector)paramObjectInputStream.readObject());
      return;
    }
    paramObjectInputStream = new ASN1InputStream((byte[])localObject);
    for (;;)
    {
      localObject = (ASN1ObjectIdentifier)paramObjectInputStream.readObject();
      if (localObject == null) {
        break;
      }
      setBagAttribute((ASN1ObjectIdentifier)localObject, paramObjectInputStream.readObject());
    }
  }
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    if (this.pkcs12Attributes.containsKey(paramASN1ObjectIdentifier))
    {
      this.pkcs12Attributes.put(paramASN1ObjectIdentifier, paramASN1Encodable);
      return;
    }
    this.pkcs12Attributes.put(paramASN1ObjectIdentifier, paramASN1Encodable);
    this.pkcs12Ordering.addElement(paramASN1ObjectIdentifier);
  }
  
  int size()
  {
    return this.pkcs12Ordering.size();
  }
  
  public void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    if (this.pkcs12Ordering.size() == 0)
    {
      paramObjectOutputStream.writeObject(new Hashtable());
      paramObjectOutputStream.writeObject(new Vector());
      return;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ASN1OutputStream localASN1OutputStream = new ASN1OutputStream(localByteArrayOutputStream);
    Enumeration localEnumeration = getBagAttributeKeys();
    while (localEnumeration.hasMoreElements())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
      localASN1OutputStream.writeObject(localASN1ObjectIdentifier);
      localASN1OutputStream.writeObject((ASN1Encodable)this.pkcs12Attributes.get(localASN1ObjectIdentifier));
    }
    paramObjectOutputStream.writeObject(localByteArrayOutputStream.toByteArray());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\PKCS12BagAttributeCarrierImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */