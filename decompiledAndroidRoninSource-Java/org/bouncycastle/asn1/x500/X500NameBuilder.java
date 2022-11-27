package org.bouncycastle.asn1.x500;

import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.style.BCStyle;

public class X500NameBuilder
{
  private Vector rdns = new Vector();
  private X500NameStyle template;
  
  public X500NameBuilder()
  {
    this(BCStyle.INSTANCE);
  }
  
  public X500NameBuilder(X500NameStyle paramX500NameStyle)
  {
    this.template = paramX500NameStyle;
  }
  
  public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] paramArrayOfASN1ObjectIdentifier, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    ASN1Encodable[] arrayOfASN1Encodable = new ASN1Encodable[j];
    int i = 0;
    while (i != j)
    {
      arrayOfASN1Encodable[i] = this.template.stringToValue(paramArrayOfASN1ObjectIdentifier[i], paramArrayOfString[i]);
      i += 1;
    }
    return addMultiValuedRDN(paramArrayOfASN1ObjectIdentifier, arrayOfASN1Encodable);
  }
  
  public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] paramArrayOfASN1ObjectIdentifier, ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    AttributeTypeAndValue[] arrayOfAttributeTypeAndValue = new AttributeTypeAndValue[paramArrayOfASN1ObjectIdentifier.length];
    int i = 0;
    while (i != paramArrayOfASN1ObjectIdentifier.length)
    {
      arrayOfAttributeTypeAndValue[i] = new AttributeTypeAndValue(paramArrayOfASN1ObjectIdentifier[i], paramArrayOfASN1Encodable[i]);
      i += 1;
    }
    return addMultiValuedRDN(arrayOfAttributeTypeAndValue);
  }
  
  public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] paramArrayOfAttributeTypeAndValue)
  {
    this.rdns.addElement(new RDN(paramArrayOfAttributeTypeAndValue));
    return this;
  }
  
  public X500NameBuilder addRDN(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    addRDN(paramASN1ObjectIdentifier, this.template.stringToValue(paramASN1ObjectIdentifier, paramString));
    return this;
  }
  
  public X500NameBuilder addRDN(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.rdns.addElement(new RDN(paramASN1ObjectIdentifier, paramASN1Encodable));
    return this;
  }
  
  public X500NameBuilder addRDN(AttributeTypeAndValue paramAttributeTypeAndValue)
  {
    this.rdns.addElement(new RDN(paramAttributeTypeAndValue));
    return this;
  }
  
  public X500Name build()
  {
    int j = this.rdns.size();
    RDN[] arrayOfRDN = new RDN[j];
    int i = 0;
    while (i != j)
    {
      arrayOfRDN[i] = ((RDN)this.rdns.elementAt(i));
      i += 1;
    }
    return new X500Name(this.template, arrayOfRDN);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\X500NameBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */