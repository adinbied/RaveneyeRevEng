package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class NameConstraints
  extends ASN1Object
{
  private GeneralSubtree[] excluded;
  private GeneralSubtree[] permitted;
  
  private NameConstraints(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = ASN1TaggedObject.getInstance(((Enumeration)localObject).nextElement());
      int i = paramASN1Sequence.getTagNo();
      if (i != 0)
      {
        if (i == 1)
        {
          this.excluded = createArray(ASN1Sequence.getInstance(paramASN1Sequence, false));
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown tag encountered: ");
          ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        this.permitted = createArray(ASN1Sequence.getInstance(paramASN1Sequence, false));
      }
    }
  }
  
  public NameConstraints(GeneralSubtree[] paramArrayOfGeneralSubtree1, GeneralSubtree[] paramArrayOfGeneralSubtree2)
  {
    this.permitted = cloneSubtree(paramArrayOfGeneralSubtree1);
    this.excluded = cloneSubtree(paramArrayOfGeneralSubtree2);
  }
  
  private static GeneralSubtree[] cloneSubtree(GeneralSubtree[] paramArrayOfGeneralSubtree)
  {
    if (paramArrayOfGeneralSubtree != null)
    {
      int i = paramArrayOfGeneralSubtree.length;
      GeneralSubtree[] arrayOfGeneralSubtree = new GeneralSubtree[i];
      System.arraycopy(paramArrayOfGeneralSubtree, 0, arrayOfGeneralSubtree, 0, i);
      return arrayOfGeneralSubtree;
    }
    return null;
  }
  
  private GeneralSubtree[] createArray(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    GeneralSubtree[] arrayOfGeneralSubtree = new GeneralSubtree[j];
    int i = 0;
    while (i != j)
    {
      arrayOfGeneralSubtree[i] = GeneralSubtree.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfGeneralSubtree;
  }
  
  public static NameConstraints getInstance(Object paramObject)
  {
    if ((paramObject instanceof NameConstraints)) {
      return (NameConstraints)paramObject;
    }
    if (paramObject != null) {
      return new NameConstraints(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GeneralSubtree[] getExcludedSubtrees()
  {
    return cloneSubtree(this.excluded);
  }
  
  public GeneralSubtree[] getPermittedSubtrees()
  {
    return cloneSubtree(this.permitted);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    GeneralSubtree[] arrayOfGeneralSubtree = this.permitted;
    if (arrayOfGeneralSubtree != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, new DERSequence(arrayOfGeneralSubtree)));
    }
    arrayOfGeneralSubtree = this.excluded;
    if (arrayOfGeneralSubtree != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, new DERSequence(arrayOfGeneralSubtree)));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\NameConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */