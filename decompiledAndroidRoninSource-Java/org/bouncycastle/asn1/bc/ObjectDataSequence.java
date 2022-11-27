package org.bouncycastle.asn1.bc;

import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays.Iterator;
import org.bouncycastle.util.Iterable;

public class ObjectDataSequence
  extends ASN1Object
  implements Iterable<ASN1Encodable>
{
  private final ASN1Encodable[] dataSequence;
  
  private ObjectDataSequence(ASN1Sequence paramASN1Sequence)
  {
    this.dataSequence = new ASN1Encodable[paramASN1Sequence.size()];
    int i = 0;
    for (;;)
    {
      ASN1Encodable[] arrayOfASN1Encodable = this.dataSequence;
      if (i == arrayOfASN1Encodable.length) {
        break;
      }
      arrayOfASN1Encodable[i] = ObjectData.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
  }
  
  public ObjectDataSequence(ObjectData[] paramArrayOfObjectData)
  {
    ASN1Encodable[] arrayOfASN1Encodable = new ASN1Encodable[paramArrayOfObjectData.length];
    this.dataSequence = arrayOfASN1Encodable;
    System.arraycopy(paramArrayOfObjectData, 0, arrayOfASN1Encodable, 0, paramArrayOfObjectData.length);
  }
  
  public static ObjectDataSequence getInstance(Object paramObject)
  {
    if ((paramObject instanceof ObjectDataSequence)) {
      return (ObjectDataSequence)paramObject;
    }
    if (paramObject != null) {
      return new ObjectDataSequence(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Iterator<ASN1Encodable> iterator()
  {
    return new Arrays.Iterator(this.dataSequence);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.dataSequence);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\bc\ObjectDataSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */