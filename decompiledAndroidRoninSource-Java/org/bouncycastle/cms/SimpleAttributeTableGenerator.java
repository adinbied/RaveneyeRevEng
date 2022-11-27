package org.bouncycastle.cms;

import java.util.Map;
import org.bouncycastle.asn1.cms.AttributeTable;

public class SimpleAttributeTableGenerator
  implements CMSAttributeTableGenerator
{
  private final AttributeTable attributes;
  
  public SimpleAttributeTableGenerator(AttributeTable paramAttributeTable)
  {
    this.attributes = paramAttributeTable;
  }
  
  public AttributeTable getAttributes(Map paramMap)
  {
    return this.attributes;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SimpleAttributeTableGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */