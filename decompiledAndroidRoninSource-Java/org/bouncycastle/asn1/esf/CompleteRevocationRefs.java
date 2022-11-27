package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CompleteRevocationRefs
  extends ASN1Object
{
  private ASN1Sequence crlOcspRefs;
  
  private CompleteRevocationRefs(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    while (localEnumeration.hasMoreElements()) {
      CrlOcspRef.getInstance(localEnumeration.nextElement());
    }
    this.crlOcspRefs = paramASN1Sequence;
  }
  
  public CompleteRevocationRefs(CrlOcspRef[] paramArrayOfCrlOcspRef)
  {
    this.crlOcspRefs = new DERSequence(paramArrayOfCrlOcspRef);
  }
  
  public static CompleteRevocationRefs getInstance(Object paramObject)
  {
    if ((paramObject instanceof CompleteRevocationRefs)) {
      return (CompleteRevocationRefs)paramObject;
    }
    if (paramObject != null) {
      return new CompleteRevocationRefs(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CrlOcspRef[] getCrlOcspRefs()
  {
    int j = this.crlOcspRefs.size();
    CrlOcspRef[] arrayOfCrlOcspRef = new CrlOcspRef[j];
    int i = 0;
    while (i < j)
    {
      arrayOfCrlOcspRef[i] = CrlOcspRef.getInstance(this.crlOcspRefs.getObjectAt(i));
      i += 1;
    }
    return arrayOfCrlOcspRef;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.crlOcspRefs;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CompleteRevocationRefs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */