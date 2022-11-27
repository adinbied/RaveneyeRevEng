package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;

public class IetfAttrSyntax
  extends ASN1Object
{
  public static final int VALUE_OCTETS = 1;
  public static final int VALUE_OID = 2;
  public static final int VALUE_UTF8 = 3;
  GeneralNames policyAuthority = null;
  int valueChoice = -1;
  Vector values = new Vector();
  
  private IetfAttrSyntax(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject)) {}
    for (Object localObject = GeneralNames.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0), false);; localObject = GeneralNames.getInstance(paramASN1Sequence.getObjectAt(0)))
    {
      this.policyAuthority = ((GeneralNames)localObject);
      i = 1;
      break;
      if (paramASN1Sequence.size() != 2) {
        break;
      }
    }
    if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1Sequence))
    {
      paramASN1Sequence = ((ASN1Sequence)paramASN1Sequence.getObjectAt(i)).getObjects();
      while (paramASN1Sequence.hasMoreElements())
      {
        localObject = (ASN1Primitive)paramASN1Sequence.nextElement();
        if ((localObject instanceof ASN1ObjectIdentifier))
        {
          i = 2;
        }
        else if ((localObject instanceof DERUTF8String))
        {
          i = 3;
        }
        else
        {
          if (!(localObject instanceof DEROctetString)) {
            break label197;
          }
          i = 1;
        }
        if (this.valueChoice < 0) {
          this.valueChoice = i;
        }
        if (i == this.valueChoice)
        {
          this.values.addElement(localObject);
        }
        else
        {
          throw new IllegalArgumentException("Mix of value types in IetfAttrSyntax");
          label197:
          throw new IllegalArgumentException("Bad value type encoding IetfAttrSyntax");
        }
      }
      return;
    }
    throw new IllegalArgumentException("Non-IetfAttrSyntax encoding");
  }
  
  public static IetfAttrSyntax getInstance(Object paramObject)
  {
    if ((paramObject instanceof IetfAttrSyntax)) {
      return (IetfAttrSyntax)paramObject;
    }
    if (paramObject != null) {
      return new IetfAttrSyntax(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public GeneralNames getPolicyAuthority()
  {
    return this.policyAuthority;
  }
  
  public int getValueType()
  {
    return this.valueChoice;
  }
  
  public Object[] getValues()
  {
    int m = getValueType();
    int j = 0;
    int k = 0;
    int i = 0;
    if (m == 1)
    {
      j = this.values.size();
      localObject = new ASN1OctetString[j];
      while (i != j)
      {
        localObject[i] = ((ASN1OctetString)this.values.elementAt(i));
        i += 1;
      }
      return (Object[])localObject;
    }
    if (getValueType() == 2)
    {
      k = this.values.size();
      localObject = new ASN1ObjectIdentifier[k];
      i = j;
      while (i != k)
      {
        localObject[i] = ((ASN1ObjectIdentifier)this.values.elementAt(i));
        i += 1;
      }
      return (Object[])localObject;
    }
    j = this.values.size();
    Object localObject = new DERUTF8String[j];
    i = k;
    while (i != j)
    {
      localObject[i] = ((DERUTF8String)this.values.elementAt(i));
      i += 1;
    }
    return (Object[])localObject;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.policyAuthority;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(0, (ASN1Encodable)localObject));
    }
    localObject = new ASN1EncodableVector();
    Enumeration localEnumeration = this.values.elements();
    while (localEnumeration.hasMoreElements()) {
      ((ASN1EncodableVector)localObject).add((ASN1Encodable)localEnumeration.nextElement());
    }
    localASN1EncodableVector.add(new DERSequence((ASN1EncodableVector)localObject));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\IetfAttrSyntax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */