package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class Target
  extends ASN1Object
  implements ASN1Choice
{
  public static final int targetGroup = 1;
  public static final int targetName = 0;
  private GeneralName targGroup;
  private GeneralName targName;
  
  public Target(int paramInt, GeneralName paramGeneralName)
  {
    this(new DERTaggedObject(paramInt, paramGeneralName));
  }
  
  private Target(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    if (i != 0)
    {
      if (i == 1)
      {
        this.targGroup = GeneralName.getInstance(paramASN1TaggedObject, true);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown tag: ");
      localStringBuilder.append(paramASN1TaggedObject.getTagNo());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.targName = GeneralName.getInstance(paramASN1TaggedObject, true);
  }
  
  public static Target getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof Target)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new Target((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (Target)paramObject;
  }
  
  public GeneralName getTargetGroup()
  {
    return this.targGroup;
  }
  
  public GeneralName getTargetName()
  {
    return this.targName;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    GeneralName localGeneralName = this.targName;
    if (localGeneralName != null) {
      return new DERTaggedObject(true, 0, localGeneralName);
    }
    return new DERTaggedObject(true, 1, this.targGroup);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\Target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */