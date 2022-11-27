package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class RecipientInfo
  extends ASN1Object
  implements ASN1Choice
{
  ASN1Encodable info;
  
  public RecipientInfo(ASN1Primitive paramASN1Primitive)
  {
    this.info = paramASN1Primitive;
  }
  
  public RecipientInfo(KEKRecipientInfo paramKEKRecipientInfo)
  {
    this.info = new DERTaggedObject(false, 2, paramKEKRecipientInfo);
  }
  
  public RecipientInfo(KeyAgreeRecipientInfo paramKeyAgreeRecipientInfo)
  {
    this.info = new DERTaggedObject(false, 1, paramKeyAgreeRecipientInfo);
  }
  
  public RecipientInfo(KeyTransRecipientInfo paramKeyTransRecipientInfo)
  {
    this.info = paramKeyTransRecipientInfo;
  }
  
  public RecipientInfo(OtherRecipientInfo paramOtherRecipientInfo)
  {
    this.info = new DERTaggedObject(false, 4, paramOtherRecipientInfo);
  }
  
  public RecipientInfo(PasswordRecipientInfo paramPasswordRecipientInfo)
  {
    this.info = new DERTaggedObject(false, 3, paramPasswordRecipientInfo);
  }
  
  public static RecipientInfo getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof RecipientInfo)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new RecipientInfo((ASN1Sequence)paramObject);
      }
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new RecipientInfo((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (RecipientInfo)paramObject;
  }
  
  private KEKRecipientInfo getKEKInfo(ASN1TaggedObject paramASN1TaggedObject)
  {
    if (paramASN1TaggedObject.isExplicit()) {}
    for (boolean bool = true;; bool = false) {
      return KEKRecipientInfo.getInstance(paramASN1TaggedObject, bool);
    }
  }
  
  public ASN1Encodable getInfo()
  {
    Object localObject = this.info;
    if ((localObject instanceof ASN1TaggedObject))
    {
      localObject = (ASN1TaggedObject)localObject;
      int i = ((ASN1TaggedObject)localObject).getTagNo();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              return OtherRecipientInfo.getInstance((ASN1TaggedObject)localObject, false);
            }
            throw new IllegalStateException("unknown tag");
          }
          return PasswordRecipientInfo.getInstance((ASN1TaggedObject)localObject, false);
        }
        return getKEKInfo((ASN1TaggedObject)localObject);
      }
      return KeyAgreeRecipientInfo.getInstance((ASN1TaggedObject)localObject, false);
    }
    return KeyTransRecipientInfo.getInstance(localObject);
  }
  
  public ASN1Integer getVersion()
  {
    Object localObject = this.info;
    if ((localObject instanceof ASN1TaggedObject))
    {
      localObject = (ASN1TaggedObject)localObject;
      int i = ((ASN1TaggedObject)localObject).getTagNo();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              return new ASN1Integer(0L);
            }
            throw new IllegalStateException("unknown tag");
          }
          return PasswordRecipientInfo.getInstance((ASN1TaggedObject)localObject, false).getVersion();
        }
        return getKEKInfo((ASN1TaggedObject)localObject).getVersion();
      }
      return KeyAgreeRecipientInfo.getInstance((ASN1TaggedObject)localObject, false).getVersion();
    }
    return KeyTransRecipientInfo.getInstance(localObject).getVersion();
  }
  
  public boolean isTagged()
  {
    return this.info instanceof ASN1TaggedObject;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.info.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\RecipientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */