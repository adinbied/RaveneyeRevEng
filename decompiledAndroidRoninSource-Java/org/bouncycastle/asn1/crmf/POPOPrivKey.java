package org.bouncycastle.asn1.crmf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

public class POPOPrivKey
  extends ASN1Object
  implements ASN1Choice
{
  public static final int agreeMAC = 3;
  public static final int dhMAC = 2;
  public static final int encryptedKey = 4;
  public static final int subsequentMessage = 1;
  public static final int thisMessage = 0;
  private ASN1Encodable obj;
  private int tagNo;
  
  private POPOPrivKey(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    this.tagNo = i;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              paramASN1TaggedObject = EnvelopedData.getInstance(paramASN1TaggedObject, false);
              break label90;
            }
            throw new IllegalArgumentException("unknown tag in POPOPrivKey");
          }
          paramASN1TaggedObject = PKMACValue.getInstance(paramASN1TaggedObject, false);
          break label90;
        }
      }
      else
      {
        paramASN1TaggedObject = SubsequentMessage.valueOf(ASN1Integer.getInstance(paramASN1TaggedObject, false).getValue().intValue());
        break label90;
      }
    }
    paramASN1TaggedObject = DERBitString.getInstance(paramASN1TaggedObject, false);
    label90:
    this.obj = paramASN1TaggedObject;
  }
  
  public POPOPrivKey(SubsequentMessage paramSubsequentMessage)
  {
    this.tagNo = 1;
    this.obj = paramSubsequentMessage;
  }
  
  public static POPOPrivKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof POPOPrivKey)) {
      return (POPOPrivKey)paramObject;
    }
    if (paramObject != null) {
      return new POPOPrivKey(ASN1TaggedObject.getInstance(paramObject));
    }
    return null;
  }
  
  public static POPOPrivKey getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1TaggedObject.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public int getType()
  {
    return this.tagNo;
  }
  
  public ASN1Encodable getValue()
  {
    return this.obj;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERTaggedObject(false, this.tagNo, this.obj);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\POPOPrivKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */