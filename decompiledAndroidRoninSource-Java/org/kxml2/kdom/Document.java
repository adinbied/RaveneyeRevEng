package org.kxml2.kdom;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class Document
  extends Node
{
  String encoding;
  protected int rootIndex = -1;
  Boolean standalone;
  
  public void addChild(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt2 == 2)
    {
      this.rootIndex = paramInt1;
    }
    else
    {
      int i = this.rootIndex;
      if (i >= paramInt1) {
        this.rootIndex = (i + 1);
      }
    }
    super.addChild(paramInt1, paramInt2, paramObject);
  }
  
  public String getEncoding()
  {
    return this.encoding;
  }
  
  public String getName()
  {
    return "#document";
  }
  
  public Element getRootElement()
  {
    int i = this.rootIndex;
    if (i != -1) {
      return (Element)getChild(i);
    }
    throw new RuntimeException("Document has no root element!");
  }
  
  public Boolean getStandalone()
  {
    return this.standalone;
  }
  
  public void parse(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.require(0, null, null);
    paramXmlPullParser.nextToken();
    this.encoding = paramXmlPullParser.getInputEncoding();
    this.standalone = ((Boolean)paramXmlPullParser.getProperty("http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone"));
    super.parse(paramXmlPullParser);
    if (paramXmlPullParser.getEventType() == 1) {
      return;
    }
    throw new RuntimeException("Document end expected!");
  }
  
  public void removeChild(int paramInt)
  {
    int i = this.rootIndex;
    if (paramInt == i) {
      i = -1;
    }
    for (;;)
    {
      this.rootIndex = i;
      break;
      if (paramInt >= i) {
        break;
      }
      i -= 1;
    }
    super.removeChild(paramInt);
  }
  
  public void setEncoding(String paramString)
  {
    this.encoding = paramString;
  }
  
  public void setStandalone(Boolean paramBoolean)
  {
    this.standalone = paramBoolean;
  }
  
  public void write(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startDocument(this.encoding, this.standalone);
    writeChildren(paramXmlSerializer);
    paramXmlSerializer.endDocument();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\kxml2\kdom\Document.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */