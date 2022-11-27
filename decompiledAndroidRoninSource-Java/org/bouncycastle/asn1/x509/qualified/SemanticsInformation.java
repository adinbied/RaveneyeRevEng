package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class SemanticsInformation
  extends ASN1Object
{
  private GeneralName[] nameRegistrationAuthorities;
  private ASN1ObjectIdentifier semanticsIdentifier;
  
  public SemanticsInformation(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.semanticsIdentifier = paramASN1ObjectIdentifier;
    this.nameRegistrationAuthorities = null;
  }
  
  public SemanticsInformation(ASN1ObjectIdentifier paramASN1ObjectIdentifier, GeneralName[] paramArrayOfGeneralName)
  {
    this.semanticsIdentifier = paramASN1ObjectIdentifier;
    this.nameRegistrationAuthorities = cloneNames(paramArrayOfGeneralName);
  }
  
  private SemanticsInformation(ASN1Sequence paramASN1Sequence)
  {
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    if (paramASN1Sequence.size() >= 1)
    {
      Object localObject = localEnumeration.nextElement();
      paramASN1Sequence = (ASN1Sequence)localObject;
      if ((localObject instanceof ASN1ObjectIdentifier))
      {
        this.semanticsIdentifier = ASN1ObjectIdentifier.getInstance(localObject);
        if (localEnumeration.hasMoreElements()) {
          paramASN1Sequence = localEnumeration.nextElement();
        } else {
          paramASN1Sequence = null;
        }
      }
      if (paramASN1Sequence != null)
      {
        paramASN1Sequence = ASN1Sequence.getInstance(paramASN1Sequence);
        this.nameRegistrationAuthorities = new GeneralName[paramASN1Sequence.size()];
        int i = 0;
        while (i < paramASN1Sequence.size())
        {
          this.nameRegistrationAuthorities[i] = GeneralName.getInstance(paramASN1Sequence.getObjectAt(i));
          i += 1;
        }
      }
      return;
    }
    throw new IllegalArgumentException("no objects in SemanticsInformation");
  }
  
  public SemanticsInformation(GeneralName[] paramArrayOfGeneralName)
  {
    this.semanticsIdentifier = null;
    this.nameRegistrationAuthorities = cloneNames(paramArrayOfGeneralName);
  }
  
  private static GeneralName[] cloneNames(GeneralName[] paramArrayOfGeneralName)
  {
    if (paramArrayOfGeneralName != null)
    {
      GeneralName[] arrayOfGeneralName = new GeneralName[paramArrayOfGeneralName.length];
      System.arraycopy(paramArrayOfGeneralName, 0, arrayOfGeneralName, 0, paramArrayOfGeneralName.length);
      return arrayOfGeneralName;
    }
    return null;
  }
  
  public static SemanticsInformation getInstance(Object paramObject)
  {
    if ((paramObject instanceof SemanticsInformation)) {
      return (SemanticsInformation)paramObject;
    }
    if (paramObject != null) {
      return new SemanticsInformation(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GeneralName[] getNameRegistrationAuthorities()
  {
    return cloneNames(this.nameRegistrationAuthorities);
  }
  
  public ASN1ObjectIdentifier getSemanticsIdentifier()
  {
    return this.semanticsIdentifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.semanticsIdentifier;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    if (this.nameRegistrationAuthorities != null)
    {
      localObject = new ASN1EncodableVector();
      int i = 0;
      for (;;)
      {
        GeneralName[] arrayOfGeneralName = this.nameRegistrationAuthorities;
        if (i >= arrayOfGeneralName.length) {
          break;
        }
        ((ASN1EncodableVector)localObject).add(arrayOfGeneralName[i]);
        i += 1;
      }
      localASN1EncodableVector.add(new DERSequence((ASN1EncodableVector)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\qualified\SemanticsInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */