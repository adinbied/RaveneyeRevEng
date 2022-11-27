package org.kxml2.kdom;

import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class Element
  extends Node
{
  protected Vector attributes;
  protected String name;
  protected String namespace;
  protected Node parent;
  protected Vector prefixes;
  
  public void clear()
  {
    this.attributes = null;
    this.children = null;
  }
  
  public Element createElement(String paramString1, String paramString2)
  {
    Node localNode = this.parent;
    if (localNode == null) {
      return super.createElement(paramString1, paramString2);
    }
    return localNode.createElement(paramString1, paramString2);
  }
  
  public int getAttributeCount()
  {
    Vector localVector = this.attributes;
    if (localVector == null) {
      return 0;
    }
    return localVector.size();
  }
  
  public String getAttributeName(int paramInt)
  {
    return ((String[])(String[])this.attributes.elementAt(paramInt))[1];
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    return ((String[])(String[])this.attributes.elementAt(paramInt))[0];
  }
  
  public String getAttributeValue(int paramInt)
  {
    return ((String[])(String[])this.attributes.elementAt(paramInt))[2];
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i = 0;
    while (i < getAttributeCount())
    {
      if ((paramString2.equals(getAttributeName(i))) && ((paramString1 == null) || (paramString1.equals(getAttributeNamespace(i))))) {
        return getAttributeValue(i);
      }
      i += 1;
    }
    return null;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNamespace()
  {
    return this.namespace;
  }
  
  public int getNamespaceCount()
  {
    Vector localVector = this.prefixes;
    if (localVector == null) {
      return 0;
    }
    return localVector.size();
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    return ((String[])(String[])this.prefixes.elementAt(paramInt))[0];
  }
  
  public String getNamespaceUri(int paramInt)
  {
    return ((String[])(String[])this.prefixes.elementAt(paramInt))[1];
  }
  
  public String getNamespaceUri(String paramString)
  {
    int j = getNamespaceCount();
    int i = 0;
    while (i < j) {
      if ((paramString != getNamespacePrefix(i)) && ((paramString == null) || (!paramString.equals(getNamespacePrefix(i))))) {
        i += 1;
      } else {
        return getNamespaceUri(i);
      }
    }
    Node localNode = this.parent;
    if ((localNode instanceof Element)) {
      return ((Element)localNode).getNamespaceUri(paramString);
    }
    return null;
  }
  
  public Node getParent()
  {
    return this.parent;
  }
  
  public Node getRoot()
  {
    Node localNode;
    for (Element localElement = this;; localElement = (Element)localNode)
    {
      localNode = localElement.parent;
      if (localNode == null) {
        break;
      }
      if (!(localNode instanceof Element)) {
        return localNode;
      }
    }
    return localElement;
  }
  
  public void init() {}
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    int i = paramXmlPullParser.getNamespaceCount(paramXmlPullParser.getDepth() - 1);
    while (i < paramXmlPullParser.getNamespaceCount(paramXmlPullParser.getDepth()))
    {
      setPrefix(paramXmlPullParser.getNamespacePrefix(i), paramXmlPullParser.getNamespaceUri(i));
      i += 1;
    }
    i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      setAttribute(paramXmlPullParser.getAttributeNamespace(i), paramXmlPullParser.getAttributeName(i), paramXmlPullParser.getAttributeValue(i));
      i += 1;
    }
    init();
    boolean bool = paramXmlPullParser.isEmptyElementTag();
    paramXmlPullParser.nextToken();
    if (!bool)
    {
      super.parse(paramXmlPullParser);
      if (getChildCount() == 0) {
        addChild(7, "");
      }
    }
    paramXmlPullParser.require(3, getNamespace(), getName());
    paramXmlPullParser.nextToken();
  }
  
  public void setAttribute(String paramString1, String paramString2, String paramString3)
  {
    if (this.attributes == null) {
      this.attributes = new Vector();
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    int i = this.attributes.size() - 1;
    while (i >= 0)
    {
      paramString1 = (String[])this.attributes.elementAt(i);
      if ((paramString1[0].equals(str)) && (paramString1[1].equals(paramString2)))
      {
        if (paramString3 == null)
        {
          this.attributes.removeElementAt(i);
          return;
        }
        paramString1[2] = paramString3;
        return;
      }
      i -= 1;
    }
    this.attributes.addElement(new String[] { str, paramString2, paramString3 });
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNamespace(String paramString)
  {
    if (paramString != null)
    {
      this.namespace = paramString;
      return;
    }
    throw new NullPointerException("Use \"\" for empty namespace");
  }
  
  protected void setParent(Node paramNode)
  {
    this.parent = paramNode;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    if (this.prefixes == null) {
      this.prefixes = new Vector();
    }
    this.prefixes.addElement(new String[] { paramString1, paramString2 });
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    Vector localVector = this.prefixes;
    int j = 0;
    if (localVector != null)
    {
      i = 0;
      while (i < this.prefixes.size())
      {
        paramXmlSerializer.setPrefix(getNamespacePrefix(i), getNamespaceUri(i));
        i += 1;
      }
    }
    paramXmlSerializer.startTag(getNamespace(), getName());
    int k = getAttributeCount();
    int i = j;
    while (i < k)
    {
      paramXmlSerializer.attribute(getAttributeNamespace(i), getAttributeName(i), getAttributeValue(i));
      i += 1;
    }
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.endTag(getNamespace(), getName());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\kxml2\kdom\Element.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */