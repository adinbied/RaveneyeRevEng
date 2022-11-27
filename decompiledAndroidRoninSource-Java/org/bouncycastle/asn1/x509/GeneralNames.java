package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Strings;

public class GeneralNames
  extends ASN1Object
{
  private final GeneralName[] names;
  
  private GeneralNames(ASN1Sequence paramASN1Sequence)
  {
    this.names = new GeneralName[paramASN1Sequence.size()];
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      this.names[i] = GeneralName.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
  }
  
  public GeneralNames(GeneralName paramGeneralName)
  {
    this.names = new GeneralName[] { paramGeneralName };
  }
  
  public GeneralNames(GeneralName[] paramArrayOfGeneralName)
  {
    this.names = paramArrayOfGeneralName;
  }
  
  public static GeneralNames fromExtensions(Extensions paramExtensions, ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(paramASN1ObjectIdentifier));
  }
  
  public static GeneralNames getInstance(Object paramObject)
  {
    if ((paramObject instanceof GeneralNames)) {
      return (GeneralNames)paramObject;
    }
    if (paramObject != null) {
      return new GeneralNames(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static GeneralNames getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public GeneralName[] getNames()
  {
    GeneralName[] arrayOfGeneralName1 = this.names;
    GeneralName[] arrayOfGeneralName2 = new GeneralName[arrayOfGeneralName1.length];
    System.arraycopy(arrayOfGeneralName1, 0, arrayOfGeneralName2, 0, arrayOfGeneralName1.length);
    return arrayOfGeneralName2;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.names);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("GeneralNames:");
    localStringBuffer.append(str);
    int i = 0;
    while (i != this.names.length)
    {
      localStringBuffer.append("    ");
      localStringBuffer.append(this.names[i]);
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\GeneralNames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */