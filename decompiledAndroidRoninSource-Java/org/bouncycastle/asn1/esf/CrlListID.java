package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CrlListID
  extends ASN1Object
{
  private ASN1Sequence crls;
  
  private CrlListID(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = (ASN1Sequence)paramASN1Sequence.getObjectAt(0);
    this.crls = paramASN1Sequence;
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements()) {
      CrlValidatedID.getInstance(paramASN1Sequence.nextElement());
    }
  }
  
  public CrlListID(CrlValidatedID[] paramArrayOfCrlValidatedID)
  {
    this.crls = new DERSequence(paramArrayOfCrlValidatedID);
  }
  
  public static CrlListID getInstance(Object paramObject)
  {
    if ((paramObject instanceof CrlListID)) {
      return (CrlListID)paramObject;
    }
    if (paramObject != null) {
      return new CrlListID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CrlValidatedID[] getCrls()
  {
    int j = this.crls.size();
    CrlValidatedID[] arrayOfCrlValidatedID = new CrlValidatedID[j];
    int i = 0;
    while (i < j)
    {
      arrayOfCrlValidatedID[i] = CrlValidatedID.getInstance(this.crls.getObjectAt(i));
      i += 1;
    }
    return arrayOfCrlValidatedID;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.crls);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CrlListID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */