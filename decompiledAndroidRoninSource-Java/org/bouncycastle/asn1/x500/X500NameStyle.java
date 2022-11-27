package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public abstract interface X500NameStyle
{
  public abstract boolean areEqual(X500Name paramX500Name1, X500Name paramX500Name2);
  
  public abstract ASN1ObjectIdentifier attrNameToOID(String paramString);
  
  public abstract int calculateHashCode(X500Name paramX500Name);
  
  public abstract RDN[] fromString(String paramString);
  
  public abstract String[] oidToAttrNames(ASN1ObjectIdentifier paramASN1ObjectIdentifier);
  
  public abstract String oidToDisplayName(ASN1ObjectIdentifier paramASN1ObjectIdentifier);
  
  public abstract ASN1Encodable stringToValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString);
  
  public abstract String toString(X500Name paramX500Name);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\X500NameStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */