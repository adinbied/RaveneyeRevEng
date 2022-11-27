package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.Extension;

class Utils
{
  static BodyPartID[] clone(BodyPartID[] paramArrayOfBodyPartID)
  {
    BodyPartID[] arrayOfBodyPartID = new BodyPartID[paramArrayOfBodyPartID.length];
    System.arraycopy(paramArrayOfBodyPartID, 0, arrayOfBodyPartID, 0, paramArrayOfBodyPartID.length);
    return arrayOfBodyPartID;
  }
  
  static Extension[] clone(Extension[] paramArrayOfExtension)
  {
    Extension[] arrayOfExtension = new Extension[paramArrayOfExtension.length];
    System.arraycopy(paramArrayOfExtension, 0, arrayOfExtension, 0, paramArrayOfExtension.length);
    return arrayOfExtension;
  }
  
  static BodyPartID[] toBodyPartIDArray(ASN1Sequence paramASN1Sequence)
  {
    BodyPartID[] arrayOfBodyPartID = new BodyPartID[paramASN1Sequence.size()];
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      arrayOfBodyPartID[i] = BodyPartID.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfBodyPartID;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */