package org.bouncycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

public class ASN1EncodableVector
{
  private final Vector v = new Vector();
  
  public void add(ASN1Encodable paramASN1Encodable)
  {
    this.v.addElement(paramASN1Encodable);
  }
  
  public void addAll(ASN1EncodableVector paramASN1EncodableVector)
  {
    paramASN1EncodableVector = paramASN1EncodableVector.v.elements();
    while (paramASN1EncodableVector.hasMoreElements()) {
      this.v.addElement(paramASN1EncodableVector.nextElement());
    }
  }
  
  public ASN1Encodable get(int paramInt)
  {
    return (ASN1Encodable)this.v.elementAt(paramInt);
  }
  
  public int size()
  {
    return this.v.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1EncodableVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */