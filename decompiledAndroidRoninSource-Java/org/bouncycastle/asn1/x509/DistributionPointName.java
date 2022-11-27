package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

public class DistributionPointName
  extends ASN1Object
  implements ASN1Choice
{
  public static final int FULL_NAME = 0;
  public static final int NAME_RELATIVE_TO_CRL_ISSUER = 1;
  ASN1Encodable name;
  int type;
  
  public DistributionPointName(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    this.type = paramInt;
    this.name = paramASN1Encodable;
  }
  
  public DistributionPointName(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    this.type = i;
    if (i == 0) {
      paramASN1TaggedObject = GeneralNames.getInstance(paramASN1TaggedObject, false);
    } else {
      paramASN1TaggedObject = ASN1Set.getInstance(paramASN1TaggedObject, false);
    }
    this.name = paramASN1TaggedObject;
  }
  
  public DistributionPointName(GeneralNames paramGeneralNames)
  {
    this(0, paramGeneralNames);
  }
  
  private void appendObject(StringBuffer paramStringBuffer, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString2);
    paramStringBuffer.append(":");
    paramStringBuffer.append(paramString1);
    paramStringBuffer.append("    ");
    paramStringBuffer.append("    ");
    paramStringBuffer.append(paramString3);
    paramStringBuffer.append(paramString1);
  }
  
  public static DistributionPointName getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DistributionPointName)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new DistributionPointName((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in factory: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (DistributionPointName)paramObject;
  }
  
  public static DistributionPointName getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1TaggedObject.getInstance(paramASN1TaggedObject, true));
  }
  
  public ASN1Encodable getName()
  {
    return this.name;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERTaggedObject(false, this.type, this.name);
  }
  
  public String toString()
  {
    String str3 = Strings.lineSeparator();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DistributionPointName: [");
    localStringBuffer.append(str3);
    String str1;
    String str2;
    if (this.type == 0)
    {
      str1 = this.name.toString();
      str2 = "fullName";
    }
    else
    {
      str1 = this.name.toString();
      str2 = "nameRelativeToCRLIssuer";
    }
    appendObject(localStringBuffer, str3, str2, str1);
    localStringBuffer.append("]");
    localStringBuffer.append(str3);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\DistributionPointName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */