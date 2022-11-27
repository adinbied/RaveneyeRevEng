package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSet;

public class AttributeTable
{
  private Hashtable attributes = new Hashtable();
  
  public AttributeTable(Hashtable paramHashtable)
  {
    this.attributes = copyTable(paramHashtable);
  }
  
  public AttributeTable(ASN1EncodableVector paramASN1EncodableVector)
  {
    int i = 0;
    while (i != paramASN1EncodableVector.size())
    {
      Attribute localAttribute = Attribute.getInstance(paramASN1EncodableVector.get(i));
      addAttribute(localAttribute.getAttrType(), localAttribute);
      i += 1;
    }
  }
  
  public AttributeTable(ASN1Set paramASN1Set)
  {
    int i = 0;
    while (i != paramASN1Set.size())
    {
      Attribute localAttribute = Attribute.getInstance(paramASN1Set.getObjectAt(i));
      addAttribute(localAttribute.getAttrType(), localAttribute);
      i += 1;
    }
  }
  
  public AttributeTable(Attribute paramAttribute)
  {
    addAttribute(paramAttribute.getAttrType(), paramAttribute);
  }
  
  public AttributeTable(Attributes paramAttributes)
  {
    this(ASN1Set.getInstance(paramAttributes.toASN1Primitive()));
  }
  
  private void addAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, Attribute paramAttribute)
  {
    Object localObject = this.attributes.get(paramASN1ObjectIdentifier);
    if (localObject == null)
    {
      this.attributes.put(paramASN1ObjectIdentifier, paramAttribute);
      return;
    }
    Vector localVector;
    if ((localObject instanceof Attribute))
    {
      localVector = new Vector();
      localVector.addElement(localObject);
    }
    else
    {
      localVector = (Vector)localObject;
    }
    localVector.addElement(paramAttribute);
    this.attributes.put(paramASN1ObjectIdentifier, localVector);
  }
  
  private Hashtable copyTable(Hashtable paramHashtable)
  {
    Hashtable localHashtable = new Hashtable();
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      localHashtable.put(localObject, paramHashtable.get(localObject));
    }
    return localHashtable;
  }
  
  public AttributeTable add(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    AttributeTable localAttributeTable = new AttributeTable(this.attributes);
    localAttributeTable.addAttribute(paramASN1ObjectIdentifier, new Attribute(paramASN1ObjectIdentifier, new DERSet(paramASN1Encodable)));
    return localAttributeTable;
  }
  
  public Attribute get(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    paramASN1ObjectIdentifier = this.attributes.get(paramASN1ObjectIdentifier);
    if ((paramASN1ObjectIdentifier instanceof Vector)) {
      return (Attribute)((Vector)paramASN1ObjectIdentifier).elementAt(0);
    }
    return (Attribute)paramASN1ObjectIdentifier;
  }
  
  public ASN1EncodableVector getAll(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    paramASN1ObjectIdentifier = this.attributes.get(paramASN1ObjectIdentifier);
    if ((paramASN1ObjectIdentifier instanceof Vector))
    {
      paramASN1ObjectIdentifier = ((Vector)paramASN1ObjectIdentifier).elements();
      while (paramASN1ObjectIdentifier.hasMoreElements()) {
        localASN1EncodableVector.add((Attribute)paramASN1ObjectIdentifier.nextElement());
      }
    }
    if (paramASN1ObjectIdentifier != null) {
      localASN1EncodableVector.add((Attribute)paramASN1ObjectIdentifier);
    }
    return localASN1EncodableVector;
  }
  
  public AttributeTable remove(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    AttributeTable localAttributeTable = new AttributeTable(this.attributes);
    localAttributeTable.attributes.remove(paramASN1ObjectIdentifier);
    return localAttributeTable;
  }
  
  public int size()
  {
    Enumeration localEnumeration = this.attributes.elements();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      if ((localObject instanceof Vector)) {
        i += ((Vector)localObject).size();
      } else {
        i += 1;
      }
    }
    return i;
  }
  
  public ASN1EncodableVector toASN1EncodableVector()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Enumeration localEnumeration = this.attributes.elements();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      if ((localObject instanceof Vector))
      {
        localObject = ((Vector)localObject).elements();
        while (((Enumeration)localObject).hasMoreElements()) {
          localASN1EncodableVector.add(Attribute.getInstance(((Enumeration)localObject).nextElement()));
        }
      }
      else
      {
        localASN1EncodableVector.add(Attribute.getInstance(localObject));
      }
    }
    return localASN1EncodableVector;
  }
  
  public Attributes toASN1Structure()
  {
    return new Attributes(toASN1EncodableVector());
  }
  
  public Hashtable toHashtable()
  {
    return copyTable(this.attributes);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\AttributeTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */