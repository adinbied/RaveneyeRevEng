package org.kxml2.kdom;

import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class Node
{
  public static final int CDSECT = 5;
  public static final int COMMENT = 9;
  public static final int DOCDECL = 10;
  public static final int DOCUMENT = 0;
  public static final int ELEMENT = 2;
  public static final int ENTITY_REF = 6;
  public static final int IGNORABLE_WHITESPACE = 7;
  public static final int PROCESSING_INSTRUCTION = 8;
  public static final int TEXT = 4;
  protected Vector children;
  protected StringBuffer types;
  
  public void addChild(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject != null)
    {
      if (this.children == null)
      {
        this.children = new Vector();
        this.types = new StringBuffer();
      }
      if (paramInt2 == 2)
      {
        if ((paramObject instanceof Element)) {
          ((Element)paramObject).setParent(this);
        } else {
          throw new RuntimeException("Element obj expected)");
        }
      }
      else {
        if (!(paramObject instanceof String)) {
          break label94;
        }
      }
      this.children.insertElementAt(paramObject, paramInt1);
      this.types.insert(paramInt1, (char)paramInt2);
      return;
      label94:
      throw new RuntimeException("String expected");
    }
    throw null;
  }
  
  public void addChild(int paramInt, Object paramObject)
  {
    addChild(getChildCount(), paramInt, paramObject);
  }
  
  public Element createElement(String paramString1, String paramString2)
  {
    Element localElement = new Element();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localElement.namespace = str;
    localElement.name = paramString2;
    return localElement;
  }
  
  public Object getChild(int paramInt)
  {
    return this.children.elementAt(paramInt);
  }
  
  public int getChildCount()
  {
    Vector localVector = this.children;
    if (localVector == null) {
      return 0;
    }
    return localVector.size();
  }
  
  public Element getElement(int paramInt)
  {
    Object localObject = getChild(paramInt);
    if ((localObject instanceof Element)) {
      return (Element)localObject;
    }
    return null;
  }
  
  public Element getElement(String paramString1, String paramString2)
  {
    int i = indexOf(paramString1, paramString2, 0);
    int j = indexOf(paramString1, paramString2, i + 1);
    if ((i != -1) && (j == -1)) {
      return getElement(i);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Element {");
    localStringBuffer.append(paramString1);
    localStringBuffer.append("}");
    localStringBuffer.append(paramString2);
    if (i == -1) {
      paramString1 = " not found in ";
    } else {
      paramString1 = " more than once in ";
    }
    localStringBuffer.append(paramString1);
    localStringBuffer.append(this);
    throw new RuntimeException(localStringBuffer.toString());
  }
  
  public String getText(int paramInt)
  {
    if (isText(paramInt)) {
      return (String)getChild(paramInt);
    }
    return null;
  }
  
  public int getType(int paramInt)
  {
    return this.types.charAt(paramInt);
  }
  
  public int indexOf(String paramString1, String paramString2, int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      Element localElement = getElement(paramInt);
      if ((localElement != null) && (paramString2.equals(localElement.getName())) && ((paramString1 == null) || (paramString1.equals(localElement.getNamespace())))) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public boolean isText(int paramInt)
  {
    paramInt = getType(paramInt);
    return (paramInt == 4) || (paramInt == 7) || (paramInt == 5);
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    int i = 0;
    int j;
    label141:
    do
    {
      int k = paramXmlPullParser.getEventType();
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (paramXmlPullParser.getText() != null)
            {
              j = k;
              if (k == 6) {
                j = 4;
              }
              addChild(j, paramXmlPullParser.getText());
            }
            else if ((k == 6) && (paramXmlPullParser.getName() != null))
            {
              addChild(6, paramXmlPullParser.getName());
            }
            paramXmlPullParser.nextToken();
            j = i;
            break label141;
          }
        }
        else
        {
          Element localElement = createElement(paramXmlPullParser.getNamespace(), paramXmlPullParser.getName());
          addChild(2, localElement);
          localElement.parse(paramXmlPullParser);
          j = i;
          break label141;
        }
      }
      j = 1;
      i = j;
    } while (j == 0);
  }
  
  public void removeChild(int paramInt)
  {
    this.children.removeElementAt(paramInt);
    int j = this.types.length() - 1;
    while (paramInt < j)
    {
      StringBuffer localStringBuffer = this.types;
      int i = paramInt + 1;
      localStringBuffer.setCharAt(paramInt, localStringBuffer.charAt(i));
      paramInt = i;
    }
    this.types.setLength(j);
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.flush();
  }
  
  public void writeChildren(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    Object localObject = this.children;
    if (localObject == null) {
      return;
    }
    int j = ((Vector)localObject).size();
    int i = 0;
    while (i < j)
    {
      int k = getType(i);
      localObject = this.children.elementAt(i);
      switch (k)
      {
      case 3: 
      default: 
        paramXmlSerializer = new StringBuffer();
        paramXmlSerializer.append("Illegal type: ");
        paramXmlSerializer.append(k);
        throw new RuntimeException(paramXmlSerializer.toString());
      case 10: 
        paramXmlSerializer.docdecl((String)localObject);
        break;
      case 9: 
        paramXmlSerializer.comment((String)localObject);
        break;
      case 8: 
        paramXmlSerializer.processingInstruction((String)localObject);
        break;
      case 7: 
        paramXmlSerializer.ignorableWhitespace((String)localObject);
        break;
      case 6: 
        paramXmlSerializer.entityRef((String)localObject);
        break;
      case 5: 
        paramXmlSerializer.cdsect((String)localObject);
        break;
      case 4: 
        paramXmlSerializer.text((String)localObject);
        break;
      case 2: 
        ((Element)localObject).write(paramXmlSerializer);
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\kxml2\kdom\Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */