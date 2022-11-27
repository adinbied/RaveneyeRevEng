package org.bouncycastle.asn1.est;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class CsrAttrs
  extends ASN1Object
{
  private final AttrOrOID[] attrOrOIDs;
  
  private CsrAttrs(ASN1Sequence paramASN1Sequence)
  {
    this.attrOrOIDs = new AttrOrOID[paramASN1Sequence.size()];
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      this.attrOrOIDs[i] = AttrOrOID.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
  }
  
  public CsrAttrs(AttrOrOID paramAttrOrOID)
  {
    this.attrOrOIDs = new AttrOrOID[] { paramAttrOrOID };
  }
  
  public CsrAttrs(AttrOrOID[] paramArrayOfAttrOrOID)
  {
    this.attrOrOIDs = Utils.clone(paramArrayOfAttrOrOID);
  }
  
  public static CsrAttrs getInstance(Object paramObject)
  {
    if ((paramObject instanceof CsrAttrs)) {
      return (CsrAttrs)paramObject;
    }
    if (paramObject != null) {
      return new CsrAttrs(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static CsrAttrs getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AttrOrOID[] getAttrOrOIDs()
  {
    return Utils.clone(this.attrOrOIDs);
  }
  
  public int size()
  {
    return this.attrOrOIDs.length;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.attrOrOIDs);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\est\CsrAttrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */