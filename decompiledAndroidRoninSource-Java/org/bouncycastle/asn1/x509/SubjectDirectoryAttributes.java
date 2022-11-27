package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SubjectDirectoryAttributes
  extends ASN1Object
{
  private Vector attributes = new Vector();
  
  public SubjectDirectoryAttributes(Vector paramVector)
  {
    paramVector = paramVector.elements();
    while (paramVector.hasMoreElements()) {
      this.attributes.addElement(paramVector.nextElement());
    }
  }
  
  private SubjectDirectoryAttributes(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements())
    {
      ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence.nextElement());
      this.attributes.addElement(Attribute.getInstance(localASN1Sequence));
    }
  }
  
  public static SubjectDirectoryAttributes getInstance(Object paramObject)
  {
    if ((paramObject instanceof SubjectDirectoryAttributes)) {
      return (SubjectDirectoryAttributes)paramObject;
    }
    if (paramObject != null) {
      return new SubjectDirectoryAttributes(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Vector getAttributes()
  {
    return this.attributes;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Enumeration localEnumeration = this.attributes.elements();
    while (localEnumeration.hasMoreElements()) {
      localASN1EncodableVector.add((Attribute)localEnumeration.nextElement());
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\SubjectDirectoryAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */