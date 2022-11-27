package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DLSequence;

public class AuthenticatedSafe
  extends ASN1Object
{
  private ContentInfo[] info;
  private boolean isBer = true;
  
  private AuthenticatedSafe(ASN1Sequence paramASN1Sequence)
  {
    this.info = new ContentInfo[paramASN1Sequence.size()];
    int i = 0;
    for (;;)
    {
      ContentInfo[] arrayOfContentInfo = this.info;
      if (i == arrayOfContentInfo.length) {
        break;
      }
      arrayOfContentInfo[i] = ContentInfo.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
    this.isBer = (paramASN1Sequence instanceof BERSequence);
  }
  
  public AuthenticatedSafe(ContentInfo[] paramArrayOfContentInfo)
  {
    this.info = paramArrayOfContentInfo;
  }
  
  public static AuthenticatedSafe getInstance(Object paramObject)
  {
    if ((paramObject instanceof AuthenticatedSafe)) {
      return (AuthenticatedSafe)paramObject;
    }
    if (paramObject != null) {
      return new AuthenticatedSafe(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ContentInfo[] getContentInfo()
  {
    return this.info;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      ContentInfo[] arrayOfContentInfo = this.info;
      if (i == arrayOfContentInfo.length) {
        break;
      }
      localASN1EncodableVector.add(arrayOfContentInfo[i]);
      i += 1;
    }
    if (this.isBer) {
      return new BERSequence(localASN1EncodableVector);
    }
    return new DLSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\AuthenticatedSafe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */