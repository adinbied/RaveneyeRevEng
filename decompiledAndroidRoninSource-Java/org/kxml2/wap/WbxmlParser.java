package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class WbxmlParser
  implements XmlPullParser
{
  static final String HEX_DIGITS = "0123456789abcdef";
  private static final String ILLEGAL_TYPE = "Wrong event type";
  private static final String UNEXPECTED_EOF = "Unexpected EOF";
  public static final int WAP_EXTENSION = 64;
  private int ATTR_START_TABLE = 1;
  private int ATTR_VALUE_TABLE = 2;
  private int TAG_TABLE = 0;
  private String[] attrStartTable;
  private String[] attrValueTable;
  private int attributeCount;
  private String[] attributes = new String[16];
  private Hashtable cacheStringTable = null;
  private boolean degenerated;
  private int depth;
  private String[] elementStack = new String[16];
  private String encoding;
  private InputStream in;
  private boolean isWhitespace;
  private String name;
  private String namespace;
  private int nextId = -2;
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private String prefix;
  private boolean processNsp;
  private int publicIdentifierId;
  private byte[] stringTable;
  private Vector tables = new Vector();
  private String[] tagTable;
  private String text;
  private int type;
  private int version;
  private int wapCode;
  private Object wapExtensionData;
  
  private final boolean adjustNsp()
    throws XmlPullParserException
  {
    int i = 0;
    int j;
    Object localObject2;
    Object localObject3;
    boolean bool2;
    int k;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      j = this.attributeCount;
      if (i >= j << 2) {
        break;
      }
      localObject2 = this.attributes[(i + 2)];
      j = ((String)localObject2).indexOf(':');
      if (j != -1)
      {
        localObject3 = ((String)localObject2).substring(0, j);
        localObject1 = ((String)localObject2).substring(j + 1);
        localObject2 = localObject3;
      }
      else
      {
        j = i;
        bool2 = bool1;
        if (!((String)localObject2).equals("xmlns")) {
          break label240;
        }
        localObject1 = null;
      }
      if (!((String)localObject2).equals("xmlns"))
      {
        bool2 = true;
        j = i;
      }
      else
      {
        localObject2 = this.nspCounts;
        j = this.depth;
        k = localObject2[j];
        localObject2[j] = (k + 1);
        j = k << 1;
        localObject2 = ensureCapacity(this.nspStack, j + 2);
        this.nspStack = ((String[])localObject2);
        localObject2[j] = localObject1;
        localObject3 = this.attributes;
        k = i + 3;
        localObject2[(j + 1)] = localObject3[k];
        if ((localObject1 != null) && (localObject3[k].equals(""))) {
          exception("illegal empty namespace");
        }
        localObject1 = this.attributes;
        j = this.attributeCount - 1;
        this.attributeCount = j;
        System.arraycopy(localObject1, i + 4, localObject1, i, (j << 2) - i);
        j = i - 4;
        bool2 = bool1;
      }
      label240:
      i = j + 4;
    }
    if (bool1)
    {
      i = (j << 2) - 4;
      while (i >= 0)
      {
        localObject1 = this.attributes;
        j = i + 2;
        localObject2 = localObject1[j];
        k = ((String)localObject2).indexOf(':');
        if (k != 0)
        {
          if (k != -1)
          {
            localObject1 = ((String)localObject2).substring(0, k);
            localObject2 = ((String)localObject2).substring(k + 1);
            localObject3 = getNamespace((String)localObject1);
            if (localObject3 != null)
            {
              String[] arrayOfString = this.attributes;
              arrayOfString[i] = localObject3;
              arrayOfString[(i + 1)] = localObject1;
              arrayOfString[j] = localObject2;
              j = (this.attributeCount << 2) - 4;
              while (j > i)
              {
                if ((((String)localObject2).equals(this.attributes[(j + 2)])) && (((String)localObject3).equals(this.attributes[j])))
                {
                  localObject1 = new StringBuffer();
                  ((StringBuffer)localObject1).append("Duplicate Attribute: {");
                  ((StringBuffer)localObject1).append((String)localObject3);
                  ((StringBuffer)localObject1).append("}");
                  ((StringBuffer)localObject1).append((String)localObject2);
                  exception(((StringBuffer)localObject1).toString());
                }
                j -= 4;
              }
            }
            localObject2 = new StringBuffer();
            ((StringBuffer)localObject2).append("Undefined Prefix: ");
            ((StringBuffer)localObject2).append((String)localObject1);
            ((StringBuffer)localObject2).append(" in ");
            ((StringBuffer)localObject2).append(this);
            throw new RuntimeException(((StringBuffer)localObject2).toString());
          }
          i -= 4;
        }
        else
        {
          localObject1 = new StringBuffer();
          ((StringBuffer)localObject1).append("illegal attribute name: ");
          ((StringBuffer)localObject1).append((String)localObject2);
          ((StringBuffer)localObject1).append(" at ");
          ((StringBuffer)localObject1).append(this);
          throw new RuntimeException(((StringBuffer)localObject1).toString());
        }
      }
    }
    i = this.name.indexOf(':');
    if (i == 0)
    {
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("illegal tag name: ");
      ((StringBuffer)localObject1).append(this.name);
      exception(((StringBuffer)localObject1).toString());
    }
    else if (i != -1)
    {
      this.prefix = this.name.substring(0, i);
      this.name = this.name.substring(i + 1);
    }
    Object localObject1 = getNamespace(this.prefix);
    this.namespace = ((String)localObject1);
    if (localObject1 == null)
    {
      if (this.prefix != null)
      {
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("undefined prefix: ");
        ((StringBuffer)localObject1).append(this.prefix);
        exception(((StringBuffer)localObject1).toString());
      }
      this.namespace = "";
    }
    return bool1;
  }
  
  private final String[] ensureCapacity(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString.length >= paramInt) {
      return paramArrayOfString;
    }
    String[] arrayOfString = new String[paramInt + 16];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    return arrayOfString;
  }
  
  private final void exception(String paramString)
    throws XmlPullParserException
  {
    throw new XmlPullParserException(paramString, this, null);
  }
  
  private final void nextImpl()
    throws IOException, XmlPullParserException
  {
    if (this.type == 3) {
      this.depth -= 1;
    }
    if (this.degenerated)
    {
      this.type = 3;
      this.degenerated = false;
      return;
    }
    this.text = null;
    this.prefix = null;
    this.name = null;
    int i;
    for (;;)
    {
      i = peekId();
      this.nextId = -2;
      if (i != 0) {
        break;
      }
      selectPage(readByte(), true);
    }
    if (i != -1)
    {
      Object localObject;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  parseElement(i);
                  return;
                }
              case 131: 
                this.type = 4;
                localObject = readStrT();
              }
              break;
            case 67: 
              throw new RuntimeException("PI curr. not supp.");
            case 64: 
            case 65: 
            case 66: 
              this.type = 64;
              this.wapCode = i;
              this.wapExtensionData = parseWapExtension(i);
              return;
            }
          }
          else
          {
            this.type = 4;
            localObject = readStrI();
          }
          this.text = ((String)localObject);
          return;
        }
        this.type = 6;
        char c = (char)readInt();
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("");
        ((StringBuffer)localObject).append(c);
        this.text = ((StringBuffer)localObject).toString();
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("#");
        ((StringBuffer)localObject).append(c);
        localObject = ((StringBuffer)localObject).toString();
      }
      else
      {
        i = this.depth - 1 << 2;
        this.type = 3;
        localObject = this.elementStack;
        this.namespace = localObject[i];
        this.prefix = localObject[(i + 1)];
        localObject = localObject[(i + 2)];
      }
      this.name = ((String)localObject);
      return;
    }
    this.type = 1;
  }
  
  private int peekId()
    throws IOException
  {
    if (this.nextId == -2) {
      this.nextId = this.in.read();
    }
    return this.nextId;
  }
  
  private void selectPage(int paramInt, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ((this.tables.size() == 0) && (paramInt == 0)) {
      return;
    }
    int i = paramInt * 3;
    if (i > this.tables.size())
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("Code Page ");
      ((StringBuffer)localObject).append(paramInt);
      ((StringBuffer)localObject).append(" undefined!");
      exception(((StringBuffer)localObject).toString());
    }
    Object localObject = this.tables;
    if (paramBoolean)
    {
      this.tagTable = ((String[])((Vector)localObject).elementAt(i + this.TAG_TABLE));
      return;
    }
    this.attrStartTable = ((String[])((Vector)localObject).elementAt(this.ATTR_START_TABLE + i));
    this.attrValueTable = ((String[])this.tables.elementAt(i + this.ATTR_VALUE_TABLE));
  }
  
  private final void setTable(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (this.stringTable == null)
    {
      int j;
      for (;;)
      {
        int i = this.tables.size();
        j = paramInt1 * 3;
        if (i >= j + 3) {
          break;
        }
        this.tables.addElement(null);
      }
      this.tables.setElementAt(paramArrayOfString, j + paramInt2);
      return;
    }
    throw new RuntimeException("setXxxTable must be called before setInput!");
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2)
    throws XmlPullParserException
  {}
  
  public int getAttributeCount()
  {
    return this.attributeCount;
  }
  
  public String getAttributeName(int paramInt)
  {
    if (paramInt < this.attributeCount) {
      return this.attributes[((paramInt << 2) + 2)];
    }
    throw new IndexOutOfBoundsException();
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    if (paramInt < this.attributeCount) {
      return this.attributes[(paramInt << 2)];
    }
    throw new IndexOutOfBoundsException();
  }
  
  public String getAttributePrefix(int paramInt)
  {
    if (paramInt < this.attributeCount) {
      return this.attributes[((paramInt << 2) + 1)];
    }
    throw new IndexOutOfBoundsException();
  }
  
  public String getAttributeType(int paramInt)
  {
    return "CDATA";
  }
  
  public String getAttributeValue(int paramInt)
  {
    if (paramInt < this.attributeCount) {
      return this.attributes[((paramInt << 2) + 3)];
    }
    throw new IndexOutOfBoundsException();
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i = (this.attributeCount << 2) - 4;
    while (i >= 0)
    {
      if ((this.attributes[(i + 2)].equals(paramString2)) && ((paramString1 == null) || (this.attributes[i].equals(paramString1)))) {
        return this.attributes[(i + 3)];
      }
      i -= 4;
    }
    return null;
  }
  
  public int getColumnNumber()
  {
    return -1;
  }
  
  public int getDepth()
  {
    return this.depth;
  }
  
  public int getEventType()
    throws XmlPullParserException
  {
    return this.type;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString)) {
      return this.processNsp;
    }
    return false;
  }
  
  public String getInputEncoding()
  {
    return this.encoding;
  }
  
  public int getLineNumber()
  {
    return -1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNamespace()
  {
    return this.namespace;
  }
  
  public String getNamespace(String paramString)
  {
    if ("xml".equals(paramString)) {
      return "http://www.w3.org/XML/1998/namespace";
    }
    if ("xmlns".equals(paramString)) {
      return "http://www.w3.org/2000/xmlns/";
    }
    int i = (getNamespaceCount(this.depth) << 1) - 2;
    while (i >= 0)
    {
      String[] arrayOfString = this.nspStack;
      if (paramString == null)
      {
        if (arrayOfString[i] == null) {
          return arrayOfString[(i + 1)];
        }
      }
      else if (paramString.equals(arrayOfString[i])) {
        return this.nspStack[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public int getNamespaceCount(int paramInt)
  {
    if (paramInt <= this.depth) {
      return this.nspCounts[paramInt];
    }
    throw new IndexOutOfBoundsException();
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    return this.nspStack[(paramInt << 1)];
  }
  
  public String getNamespaceUri(int paramInt)
  {
    return this.nspStack[((paramInt << 1) + 1)];
  }
  
  public String getPositionDescription()
  {
    Object localObject;
    if (this.type < XmlPullParser.TYPES.length) {
      localObject = XmlPullParser.TYPES[this.type];
    } else {
      localObject = "unknown";
    }
    StringBuffer localStringBuffer = new StringBuffer((String)localObject);
    localStringBuffer.append(' ');
    int j = this.type;
    int i = 0;
    if ((j != 2) && (j != 3))
    {
      if (j != 7)
      {
        if (j != 4) {
          localObject = getText();
        }
        for (;;)
        {
          localStringBuffer.append((String)localObject);
          break;
          if (this.isWhitespace)
          {
            localObject = "(whitespace)";
          }
          else
          {
            String str = getText();
            localObject = str;
            if (str.length() > 16)
            {
              localObject = new StringBuffer();
              ((StringBuffer)localObject).append(str.substring(0, 16));
              ((StringBuffer)localObject).append("...");
              localObject = ((StringBuffer)localObject).toString();
            }
          }
        }
      }
    }
    else
    {
      if (this.degenerated) {
        localStringBuffer.append("(empty) ");
      }
      localStringBuffer.append('<');
      if (this.type == 3) {
        localStringBuffer.append('/');
      }
      if (this.prefix != null)
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("{");
        ((StringBuffer)localObject).append(this.namespace);
        ((StringBuffer)localObject).append("}");
        ((StringBuffer)localObject).append(this.prefix);
        ((StringBuffer)localObject).append(":");
        localStringBuffer.append(((StringBuffer)localObject).toString());
      }
      localStringBuffer.append(this.name);
      j = this.attributeCount;
      while (i < j << 2)
      {
        localStringBuffer.append(' ');
        localObject = this.attributes;
        int k = i + 1;
        if (localObject[k] != null)
        {
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append("{");
          ((StringBuffer)localObject).append(this.attributes[i]);
          ((StringBuffer)localObject).append("}");
          ((StringBuffer)localObject).append(this.attributes[k]);
          ((StringBuffer)localObject).append(":");
          localStringBuffer.append(((StringBuffer)localObject).toString());
        }
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append(this.attributes[(i + 2)]);
        ((StringBuffer)localObject).append("='");
        ((StringBuffer)localObject).append(this.attributes[(i + 3)]);
        ((StringBuffer)localObject).append("'");
        localStringBuffer.append(((StringBuffer)localObject).toString());
        i += 4;
      }
      localStringBuffer.append('>');
    }
    return localStringBuffer.toString();
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public Object getProperty(String paramString)
  {
    return null;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public char[] getTextCharacters(int[] paramArrayOfInt)
  {
    if (this.type >= 4)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = this.text.length();
      paramArrayOfInt = new char[this.text.length()];
      String str = this.text;
      str.getChars(0, str.length(), paramArrayOfInt, 0);
      return paramArrayOfInt;
    }
    paramArrayOfInt[0] = -1;
    paramArrayOfInt[1] = -1;
    return null;
  }
  
  public int getWapCode()
  {
    return this.wapCode;
  }
  
  public Object getWapExtensionData()
  {
    return this.wapExtensionData;
  }
  
  public boolean isAttributeDefault(int paramInt)
  {
    return false;
  }
  
  public boolean isEmptyElementTag()
    throws XmlPullParserException
  {
    if (this.type != 2) {
      exception("Wrong event type");
    }
    return this.degenerated;
  }
  
  public boolean isWhitespace()
    throws XmlPullParserException
  {
    int i = this.type;
    if ((i != 4) && (i != 7) && (i != 5)) {
      exception("Wrong event type");
    }
    return this.isWhitespace;
  }
  
  public int next()
    throws XmlPullParserException, IOException
  {
    this.isWhitespace = true;
    int i = 9999;
    int k;
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  String str;
                  for (;;)
                  {
                    str = this.text;
                    nextImpl();
                    k = this.type;
                    j = i;
                    if (k < i) {
                      j = k;
                    }
                    if (j <= 5) {
                      break;
                    }
                    i = j;
                  }
                  if (j < 4) {
                    break;
                  }
                  if (str != null)
                  {
                    if (this.text != null)
                    {
                      StringBuffer localStringBuffer = new StringBuffer();
                      localStringBuffer.append(str);
                      localStringBuffer.append(this.text);
                      str = localStringBuffer.toString();
                    }
                    this.text = str;
                  }
                  k = peekId();
                  i = j;
                } while (k == 2);
                i = j;
              } while (k == 3);
              i = j;
            } while (k == 4);
            i = j;
          } while (k == 68);
          i = j;
        } while (k == 196);
        i = j;
      } while (k == 131);
      i = j;
    } while (k == 132);
    this.type = j;
    if (j > 4) {
      this.type = 4;
    }
    return this.type;
  }
  
  public int nextTag()
    throws XmlPullParserException, IOException
  {
    next();
    if ((this.type == 4) && (this.isWhitespace)) {
      next();
    }
    int i = this.type;
    if ((i != 3) && (i != 2)) {
      exception("unexpected type");
    }
    return this.type;
  }
  
  public String nextText()
    throws XmlPullParserException, IOException
  {
    if (this.type != 2) {
      exception("precondition: START_TAG");
    }
    next();
    String str;
    if (this.type == 4)
    {
      str = getText();
      next();
    }
    else
    {
      str = "";
    }
    if (this.type != 3) {
      exception("END_TAG expected");
    }
    return str;
  }
  
  public int nextToken()
    throws XmlPullParserException, IOException
  {
    this.isWhitespace = true;
    nextImpl();
    return this.type;
  }
  
  void parseElement(int paramInt)
    throws IOException, XmlPullParserException
  {
    this.type = 2;
    this.name = resolveId(this.tagTable, paramInt & 0x3F);
    this.attributeCount = 0;
    if ((paramInt & 0x80) != 0) {
      readAttr();
    }
    boolean bool;
    if ((paramInt & 0x40) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.degenerated = bool;
    paramInt = this.depth;
    this.depth = (paramInt + 1);
    int j = paramInt << 2;
    Object localObject = ensureCapacity(this.elementStack, j + 4);
    this.elementStack = ((String[])localObject);
    localObject[(j + 3)] = this.name;
    paramInt = this.depth;
    localObject = this.nspCounts;
    if (paramInt >= localObject.length)
    {
      int[] arrayOfInt = new int[paramInt + 4];
      System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
      this.nspCounts = arrayOfInt;
    }
    localObject = this.nspCounts;
    paramInt = this.depth;
    localObject[paramInt] = localObject[(paramInt - 1)];
    paramInt = this.attributeCount - 1;
    while (paramInt > 0)
    {
      int i = 0;
      while (i < paramInt)
      {
        if (getAttributeName(paramInt).equals(getAttributeName(i)))
        {
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append("Duplicate Attribute: ");
          ((StringBuffer)localObject).append(getAttributeName(paramInt));
          exception(((StringBuffer)localObject).toString());
        }
        i += 1;
      }
      paramInt -= 1;
    }
    if (this.processNsp) {
      adjustNsp();
    } else {
      this.namespace = "";
    }
    localObject = this.elementStack;
    localObject[j] = this.namespace;
    localObject[(j + 1)] = this.prefix;
    localObject[(j + 2)] = this.name;
  }
  
  public Object parseWapExtension(int paramInt)
    throws IOException, XmlPullParserException
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        Object localObject = null;
        switch (paramInt)
        {
        default: 
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append("illegal id: ");
          ((StringBuffer)localObject).append(paramInt);
          exception(((StringBuffer)localObject).toString());
          return null;
        case 195: 
          int i = readInt();
          byte[] arrayOfByte = new byte[i];
          paramInt = i;
          for (;;)
          {
            localObject = arrayOfByte;
            if (paramInt <= 0) {
              break;
            }
            paramInt -= this.in.read(arrayOfByte, i - paramInt, paramInt);
          }
        }
        return localObject;
      }
      return new Integer(readInt());
    }
    return readStrI();
  }
  
  public void readAttr()
    throws IOException, XmlPullParserException
  {
    int i = readByte();
    int j = 0;
    if (i != 1)
    {
      while (i == 0)
      {
        selectPage(readByte(), false);
        i = readByte();
      }
      String str = resolveId(this.attrStartTable, i);
      i = str.indexOf('=');
      StringBuffer localStringBuffer;
      if (i == -1)
      {
        localStringBuffer = new StringBuffer();
      }
      else
      {
        localStringBuffer = new StringBuffer(str.substring(i + 1));
        str = str.substring(0, i);
      }
      for (;;)
      {
        i = readByte();
        Object localObject;
        if ((i <= 128) && (i != 0) && (i != 2) && (i != 3) && (i != 131) && ((i < 64) || (i > 66)) && ((i < 128) || (i > 130)))
        {
          localObject = ensureCapacity(this.attributes, j + 4);
          this.attributes = ((String[])localObject);
          int k = j + 1;
          localObject[j] = "";
          j = k + 1;
          localObject[k] = null;
          k = j + 1;
          localObject[j] = str;
          j = k + 1;
          localObject[k] = localStringBuffer.toString();
          this.attributeCount += 1;
          break;
        }
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 3) {
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  switch (i)
                  {
                  default: 
                    localObject = resolveId(this.attrValueTable, i);
                  }
                  break;
                case 131: 
                  localObject = readStrT();
                }
                break;
              case 64: 
              case 65: 
              case 66: 
                localObject = resolveWapExtension(i, parseWapExtension(i));
                break;
              }
            } else {
              localObject = readStrI();
            }
            localStringBuffer.append((String)localObject);
          }
          else
          {
            localStringBuffer.append((char)readInt());
          }
        }
        else {
          selectPage(readByte(), false);
        }
      }
    }
  }
  
  int readByte()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1) {
      return i;
    }
    throw new IOException("Unexpected EOF");
  }
  
  int readInt()
    throws IOException
  {
    int i = 0;
    int k;
    int j;
    do
    {
      k = readByte();
      j = i << 7 | k & 0x7F;
      i = j;
    } while ((k & 0x80) != 0);
    return j;
  }
  
  String readStrI()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = true;
    for (;;)
    {
      int i = this.in.read();
      if (i == 0)
      {
        this.isWhitespace = bool;
        String str = new String(localByteArrayOutputStream.toByteArray(), this.encoding);
        localByteArrayOutputStream.close();
        return str;
      }
      if (i == -1) {
        break;
      }
      if (i > 32) {
        bool = false;
      }
      localByteArrayOutputStream.write(i);
    }
    throw new IOException("Unexpected EOF");
  }
  
  String readStrT()
    throws IOException
  {
    int j = readInt();
    if (this.cacheStringTable == null) {
      this.cacheStringTable = new Hashtable();
    }
    String str = (String)this.cacheStringTable.get(new Integer(j));
    Object localObject = str;
    if (str == null)
    {
      int i = j;
      for (;;)
      {
        localObject = this.stringTable;
        if ((i >= localObject.length) || (localObject[i] == 0)) {
          break;
        }
        i += 1;
      }
      localObject = new String(this.stringTable, j, i - j, this.encoding);
      this.cacheStringTable.put(new Integer(j), localObject);
    }
    return (String)localObject;
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
    throws XmlPullParserException, IOException
  {
    if ((paramInt != this.type) || ((paramString1 != null) && (!paramString1.equals(getNamespace()))) || ((paramString2 != null) && (!paramString2.equals(getName()))))
    {
      StringBuffer localStringBuffer1 = new StringBuffer();
      localStringBuffer1.append("expected: ");
      if (paramInt == 64)
      {
        paramString1 = "WAP Ext.";
      }
      else
      {
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append(XmlPullParser.TYPES[paramInt]);
        localStringBuffer2.append(" {");
        localStringBuffer2.append(paramString1);
        localStringBuffer2.append("}");
        localStringBuffer2.append(paramString2);
        paramString1 = localStringBuffer2.toString();
      }
      localStringBuffer1.append(paramString1);
      exception(localStringBuffer1.toString());
    }
  }
  
  String resolveId(String[] paramArrayOfString, int paramInt)
    throws IOException
  {
    int i = (paramInt & 0x7F) - 5;
    if (i == -1)
    {
      this.wapCode = -1;
      return readStrT();
    }
    if ((i >= 0) && (paramArrayOfString != null) && (i < paramArrayOfString.length) && (paramArrayOfString[i] != null))
    {
      this.wapCode = (i + 5);
      return paramArrayOfString[i];
    }
    paramArrayOfString = new StringBuffer();
    paramArrayOfString.append("id ");
    paramArrayOfString.append(paramInt);
    paramArrayOfString.append(" undef.");
    throw new IOException(paramArrayOfString.toString());
  }
  
  protected String resolveWapExtension(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof byte[]))
    {
      localStringBuffer = new StringBuffer();
      paramObject = (byte[])paramObject;
      paramInt = 0;
      while (paramInt < paramObject.length)
      {
        localStringBuffer.append("0123456789abcdef".charAt(paramObject[paramInt] >> 4 & 0xF));
        localStringBuffer.append("0123456789abcdef".charAt(paramObject[paramInt] & 0xF));
        paramInt += 1;
      }
      return localStringBuffer.toString();
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("$(");
    localStringBuffer.append(paramObject);
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
  
  public void setAttrStartTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, this.ATTR_START_TABLE, paramArrayOfString);
  }
  
  public void setAttrValueTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, this.ATTR_VALUE_TABLE, paramArrayOfString);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString))
    {
      this.processNsp = paramBoolean;
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("unsupported feature: ");
    localStringBuffer.append(paramString);
    exception(localStringBuffer.toString());
  }
  
  public void setInput(InputStream paramInputStream, String paramString)
    throws XmlPullParserException
  {
    this.in = paramInputStream;
    try
    {
      this.version = readByte();
      i = readInt();
      this.publicIdentifierId = i;
      if (i == 0) {
        readInt();
      }
      i = readInt();
      str = paramString;
      if (paramString == null)
      {
        if (i == 4) {
          break label172;
        }
        if (i != 106) {
          break label69;
        }
        str = "UTF-8";
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        int i;
        int j;
        int k;
        continue;
        String str = "ISO-8859-1";
        continue;
        i += k;
      }
    }
    this.encoding = str;
    break label102;
    label69:
    paramInputStream = new StringBuffer();
    paramInputStream.append("");
    paramInputStream.append(i);
    throw new UnsupportedEncodingException(paramInputStream.toString());
    label102:
    j = readInt();
    this.stringTable = new byte[j];
    i = 0;
    if (i < j)
    {
      k = paramInputStream.read(this.stringTable, i, j - i);
      if (k > 0) {
        break label180;
      }
    }
    selectPage(0, true);
    selectPage(0, false);
    return;
    exception("Illegal input format");
  }
  
  public void setInput(Reader paramReader)
    throws XmlPullParserException
  {
    exception("InputStream required");
  }
  
  public void setProperty(String paramString, Object paramObject)
    throws XmlPullParserException
  {
    paramObject = new StringBuffer();
    ((StringBuffer)paramObject).append("unsupported property: ");
    ((StringBuffer)paramObject).append(paramString);
    throw new XmlPullParserException(((StringBuffer)paramObject).toString());
  }
  
  public void setTagTable(int paramInt, String[] paramArrayOfString)
  {
    setTable(paramInt, this.TAG_TABLE, paramArrayOfString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\kxml2\wap\WbxmlParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */