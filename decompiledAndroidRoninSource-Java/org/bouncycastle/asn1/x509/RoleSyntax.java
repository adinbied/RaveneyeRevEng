package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class RoleSyntax
  extends ASN1Object
{
  private GeneralNames roleAuthority;
  private GeneralName roleName;
  
  public RoleSyntax(String paramString)
  {
    this(new GeneralName(6, str));
  }
  
  private RoleSyntax(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      int i = 0;
      while (i != paramASN1Sequence.size())
      {
        localObject = ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(i));
        int j = ((ASN1TaggedObject)localObject).getTagNo();
        if (j != 0)
        {
          if (j == 1) {
            this.roleName = GeneralName.getInstance((ASN1TaggedObject)localObject, true);
          } else {
            throw new IllegalArgumentException("Unknown tag in RoleSyntax");
          }
        }
        else {
          this.roleAuthority = GeneralNames.getInstance((ASN1TaggedObject)localObject, false);
        }
        i += 1;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Bad sequence size: ");
    ((StringBuilder)localObject).append(paramASN1Sequence.size());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public RoleSyntax(GeneralName paramGeneralName)
  {
    this(null, paramGeneralName);
  }
  
  public RoleSyntax(GeneralNames paramGeneralNames, GeneralName paramGeneralName)
  {
    if ((paramGeneralName != null) && (paramGeneralName.getTagNo() == 6) && (!((ASN1String)paramGeneralName.getName()).getString().equals("")))
    {
      this.roleAuthority = paramGeneralNames;
      this.roleName = paramGeneralName;
      return;
    }
    throw new IllegalArgumentException("the role name MUST be non empty and MUST use the URI option of GeneralName");
  }
  
  public static RoleSyntax getInstance(Object paramObject)
  {
    if ((paramObject instanceof RoleSyntax)) {
      return (RoleSyntax)paramObject;
    }
    if (paramObject != null) {
      return new RoleSyntax(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GeneralNames getRoleAuthority()
  {
    return this.roleAuthority;
  }
  
  public String[] getRoleAuthorityAsString()
  {
    Object localObject = this.roleAuthority;
    int i = 0;
    if (localObject == null) {
      return new String[0];
    }
    localObject = ((GeneralNames)localObject).getNames();
    String[] arrayOfString = new String[localObject.length];
    while (i < localObject.length)
    {
      ASN1Encodable localASN1Encodable = localObject[i].getName();
      if ((localASN1Encodable instanceof ASN1String)) {
        arrayOfString[i] = ((ASN1String)localASN1Encodable).getString();
      } else {
        arrayOfString[i] = localASN1Encodable.toString();
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  public GeneralName getRoleName()
  {
    return this.roleName;
  }
  
  public String getRoleNameAsString()
  {
    return ((ASN1String)this.roleName.getName()).getString();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    GeneralNames localGeneralNames = this.roleAuthority;
    if (localGeneralNames != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localGeneralNames));
    }
    localASN1EncodableVector.add(new DERTaggedObject(true, 1, this.roleName));
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Name: ");
    ((StringBuilder)localObject1).append(getRoleNameAsString());
    ((StringBuilder)localObject1).append(" - Auth: ");
    localObject1 = new StringBuffer(((StringBuilder)localObject1).toString());
    Object localObject2 = this.roleAuthority;
    if ((localObject2 != null) && (((GeneralNames)localObject2).getNames().length != 0))
    {
      localObject2 = getRoleAuthorityAsString();
      ((StringBuffer)localObject1).append('[');
      ((StringBuffer)localObject1).append(localObject2[0]);
      int i = 1;
      while (i < localObject2.length)
      {
        ((StringBuffer)localObject1).append(", ");
        ((StringBuffer)localObject1).append(localObject2[i]);
        i += 1;
      }
      ((StringBuffer)localObject1).append(']');
    }
    else
    {
      ((StringBuffer)localObject1).append("N/A");
    }
    return ((StringBuffer)localObject1).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\RoleSyntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */