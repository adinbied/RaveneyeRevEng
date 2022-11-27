package org.bouncycastle.jce.interfaces;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface PKCS12BagAttributeCarrier
{
  public abstract ASN1Encodable getBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier);
  
  public abstract Enumeration getBagAttributeKeys();
  
  public abstract void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\interfaces\PKCS12BagAttributeCarrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */