package org.bouncycastle.cms;

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
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class DefaultAuthenticatedAttributeTableGenerator
  implements CMSAttributeTableGenerator
{
  private final Hashtable table;
  
  public DefaultAuthenticatedAttributeTableGenerator()
  {
    this.table = new Hashtable();
  }
  
  public DefaultAuthenticatedAttributeTableGenerator(AttributeTable paramAttributeTable)
  {
    if (paramAttributeTable != null) {
      paramAttributeTable = paramAttributeTable.toHashtable();
    } else {
      paramAttributeTable = new Hashtable();
    }
    this.table = paramAttributeTable;
  }
  
  protected Hashtable createStandardAttributeTable(Map paramMap)
  {
    Hashtable localHashtable = new Hashtable();
    Object localObject1 = this.table.keys();
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject2 = ((Enumeration)localObject1).nextElement();
      localHashtable.put(localObject2, this.table.get(localObject2));
    }
    if (!localHashtable.containsKey(CMSAttributes.contentType))
    {
      localObject1 = ASN1ObjectIdentifier.getInstance(paramMap.get("contentType"));
      localObject1 = new Attribute(CMSAttributes.contentType, new DERSet((ASN1Encodable)localObject1));
      localHashtable.put(((Attribute)localObject1).getAttrType(), localObject1);
    }
    if (!localHashtable.containsKey(CMSAttributes.messageDigest))
    {
      localObject1 = (byte[])paramMap.get("digest");
      localObject1 = new Attribute(CMSAttributes.messageDigest, new DERSet(new DEROctetString((byte[])localObject1)));
      localHashtable.put(((Attribute)localObject1).getAttrType(), localObject1);
    }
    if (!localHashtable.contains(CMSAttributes.cmsAlgorithmProtect))
    {
      paramMap = new Attribute(CMSAttributes.cmsAlgorithmProtect, new DERSet(new CMSAlgorithmProtection((AlgorithmIdentifier)paramMap.get("digestAlgID"), 2, (AlgorithmIdentifier)paramMap.get("macAlgID"))));
      localHashtable.put(paramMap.getAttrType(), paramMap);
    }
    return localHashtable;
  }
  
  public AttributeTable getAttributes(Map paramMap)
  {
    return new AttributeTable(createStandardAttributeTable(paramMap));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\DefaultAuthenticatedAttributeTableGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */