package org.bouncycastle.cms;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAlgorithmProtection;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.Time;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class DefaultSignedAttributeTableGenerator
  implements CMSAttributeTableGenerator
{
  private final Hashtable table;
  
  public DefaultSignedAttributeTableGenerator()
  {
    this.table = new Hashtable();
  }
  
  public DefaultSignedAttributeTableGenerator(AttributeTable paramAttributeTable)
  {
    if (paramAttributeTable != null) {
      paramAttributeTable = paramAttributeTable.toHashtable();
    } else {
      paramAttributeTable = new Hashtable();
    }
    this.table = paramAttributeTable;
  }
  
  private static Hashtable copyHashTable(Hashtable paramHashtable)
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
  
  protected Hashtable createStandardAttributeTable(Map paramMap)
  {
    Hashtable localHashtable = copyHashTable(this.table);
    Object localObject;
    if (!localHashtable.containsKey(CMSAttributes.contentType))
    {
      localObject = ASN1ObjectIdentifier.getInstance(paramMap.get("contentType"));
      if (localObject != null)
      {
        localObject = new Attribute(CMSAttributes.contentType, new DERSet((ASN1Encodable)localObject));
        localHashtable.put(((Attribute)localObject).getAttrType(), localObject);
      }
    }
    if (!localHashtable.containsKey(CMSAttributes.signingTime))
    {
      localObject = new Date();
      localObject = new Attribute(CMSAttributes.signingTime, new DERSet(new Time((Date)localObject)));
      localHashtable.put(((Attribute)localObject).getAttrType(), localObject);
    }
    if (!localHashtable.containsKey(CMSAttributes.messageDigest))
    {
      localObject = (byte[])paramMap.get("digest");
      localObject = new Attribute(CMSAttributes.messageDigest, new DERSet(new DEROctetString((byte[])localObject)));
      localHashtable.put(((Attribute)localObject).getAttrType(), localObject);
    }
    if (!localHashtable.contains(CMSAttributes.cmsAlgorithmProtect))
    {
      paramMap = new Attribute(CMSAttributes.cmsAlgorithmProtect, new DERSet(new CMSAlgorithmProtection((AlgorithmIdentifier)paramMap.get("digestAlgID"), 1, (AlgorithmIdentifier)paramMap.get("signatureAlgID"))));
      localHashtable.put(paramMap.getAttrType(), paramMap);
    }
    return localHashtable;
  }
  
  public AttributeTable getAttributes(Map paramMap)
  {
    return new AttributeTable(createStandardAttributeTable(paramMap));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\DefaultSignedAttributeTableGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */