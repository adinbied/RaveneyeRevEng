package org.kxml2.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Hashtable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KXmlParser
  implements XmlPullParser
{
  private static final String ILLEGAL_TYPE = "Wrong event type";
  private static final int LEGACY = 999;
  private static final String UNEXPECTED_EOF = "Unexpected EOF";
  private static final int XML_DECL = 998;
  private int attributeCount;
  private String[] attributes;
  private int column;
  private boolean degenerated;
  private int depth;
  private String[] elementStack = new String[16];
  private String encoding;
  private Hashtable entityMap;
  private String error;
  private boolean isWhitespace;
  private int line;
  private Object location;
  private String name;
  private String namespace;
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private int[] peek;
  private int peekCount;
  private String prefix;
  private boolean processNsp;
  private Reader reader;
  private boolean relaxed;
  private char[] srcBuf;
  private int srcCount;
  private int srcPos;
  private int stackMismatch;
  private Boolean standalone;
  private boolean token;
  private char[] txtBuf;
  private int txtPos;
  private int type;
  private boolean unresolved;
  private String version;
  private boolean wasCR;
  
  public KXmlParser()
  {
    int i = 128;
    this.txtBuf = new char[''];
    this.attributes = new String[16];
    this.stackMismatch = 0;
    this.peek = new int[2];
    if (Runtime.getRuntime().freeMemory() >= 1048576L) {
      i = 8192;
    }
    this.srcBuf = new char[i];
  }
  
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
          error("illegal empty namespace");
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
        if ((k == 0) && (!this.relaxed))
        {
          localObject1 = new StringBuffer();
          ((StringBuffer)localObject1).append("illegal attribute name: ");
          ((StringBuffer)localObject1).append((String)localObject2);
          ((StringBuffer)localObject1).append(" at ");
          ((StringBuffer)localObject1).append(this);
          throw new RuntimeException(((StringBuffer)localObject1).toString());
        }
        if (k != -1)
        {
          localObject1 = ((String)localObject2).substring(0, k);
          localObject2 = ((String)localObject2).substring(k + 1);
          localObject3 = getNamespace((String)localObject1);
          if ((localObject3 == null) && (!this.relaxed))
          {
            localObject2 = new StringBuffer();
            ((StringBuffer)localObject2).append("Undefined Prefix: ");
            ((StringBuffer)localObject2).append((String)localObject1);
            ((StringBuffer)localObject2).append(" in ");
            ((StringBuffer)localObject2).append(this);
            throw new RuntimeException(((StringBuffer)localObject2).toString());
          }
          String[] arrayOfString = this.attributes;
          arrayOfString[i] = localObject3;
          arrayOfString[(i + 1)] = localObject1;
          arrayOfString[j] = localObject2;
        }
        i -= 4;
      }
    }
    i = this.name.indexOf(':');
    if (i == 0)
    {
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("illegal tag name: ");
      ((StringBuffer)localObject1).append(this.name);
      error(((StringBuffer)localObject1).toString());
    }
    if (i != -1)
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
        error(((StringBuffer)localObject1).toString());
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
  
  private final void error(String paramString)
    throws XmlPullParserException
  {
    if (this.relaxed)
    {
      if (this.error == null)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("ERR: ");
        localStringBuffer.append(paramString);
        this.error = localStringBuffer.toString();
      }
    }
    else {
      exception(paramString);
    }
  }
  
  private final void exception(String paramString)
    throws XmlPullParserException
  {
    if (paramString.length() >= 100)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString.substring(0, 100));
      localStringBuffer.append("\n");
      paramString = localStringBuffer.toString();
    }
    throw new XmlPullParserException(paramString, this, null);
  }
  
  private final String get(int paramInt)
  {
    return new String(this.txtBuf, paramInt, this.txtPos - paramInt);
  }
  
  private final boolean isProp(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (!paramString1.startsWith("http://xmlpull.org/v1/doc/")) {
      return false;
    }
    if (paramBoolean) {}
    for (int i = 42;; i = 40) {
      return paramString1.substring(i).equals(paramString2);
    }
  }
  
  private final void nextImpl()
    throws IOException, XmlPullParserException
  {
    if (this.reader == null) {
      exception("No Input specified");
    }
    if (this.type == 3) {
      this.depth -= 1;
    }
    int i;
    do
    {
      this.attributeCount = -1;
      boolean bool = this.degenerated;
      i = 0;
      if (bool)
      {
        this.degenerated = false;
        this.type = 3;
        return;
      }
      if (this.error != null)
      {
        while (i < this.error.length())
        {
          push(this.error.charAt(i));
          i += 1;
        }
        this.error = null;
        this.type = 9;
        return;
      }
      if ((this.relaxed) && ((this.stackMismatch > 0) || ((peek(0) == -1) && (this.depth > 0))))
      {
        i = this.depth - 1 << 2;
        this.type = 3;
        Object localObject = this.elementStack;
        this.namespace = localObject[i];
        this.prefix = localObject[(i + 1)];
        this.name = localObject[(i + 2)];
        if (this.stackMismatch != 1)
        {
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append("missing end tag /");
          ((StringBuffer)localObject).append(this.name);
          ((StringBuffer)localObject).append(" inserted");
          this.error = ((StringBuffer)localObject).toString();
        }
        i = this.stackMismatch;
        if (i > 0) {
          this.stackMismatch = (i - 1);
        }
        return;
      }
      this.prefix = null;
      this.name = null;
      this.namespace = null;
      i = peekType();
      this.type = i;
      if (i == 1) {
        return;
      }
      if (i == 2) {
        break label361;
      }
      if (i == 3) {
        break label356;
      }
      if (i == 4) {
        break label323;
      }
      if (i == 6) {
        break;
      }
      i = parseLegacy(this.token);
      this.type = i;
    } while (i == 998);
    return;
    pushEntity();
    return;
    label323:
    pushText(60, this.token ^ true);
    if ((this.depth == 0) && (this.isWhitespace)) {
      this.type = 7;
    }
    return;
    label356:
    parseEndTag();
    return;
    label361:
    parseStartTag(false);
  }
  
  private final void parseDoctype(boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    int k = 1;
    int j = 0;
    for (;;)
    {
      int n = read();
      if (n == -1) {
        break;
      }
      int i;
      int m;
      if (n != 39)
      {
        if (n != 60)
        {
          if (n != 62)
          {
            i = k;
            m = j;
          }
          else
          {
            i = k;
            m = j;
            if (j == 0)
            {
              k -= 1;
              i = k;
              m = j;
              if (k != 0) {}
            }
          }
        }
        else
        {
          i = k;
          m = j;
          if (j == 0)
          {
            i = k + 1;
            m = j;
          }
        }
      }
      else
      {
        m = j ^ 0x1;
        i = k;
      }
      k = i;
      j = m;
      if (paramBoolean)
      {
        push(n);
        k = i;
        j = m;
      }
    }
    error("Unexpected EOF");
  }
  
  private final void parseEndTag()
    throws IOException, XmlPullParserException
  {
    read();
    read();
    this.name = readName();
    skip();
    read('>');
    int i = this.depth;
    int j = i - 1 << 2;
    if (i == 0)
    {
      error("element stack empty");
      this.type = 9;
      return;
    }
    Object localObject = this.name;
    String[] arrayOfString = this.elementStack;
    i = j + 3;
    if (!((String)localObject).equals(arrayOfString[i]))
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("expected: /");
      ((StringBuffer)localObject).append(this.elementStack[i]);
      ((StringBuffer)localObject).append(" read: ");
      ((StringBuffer)localObject).append(this.name);
      error(((StringBuffer)localObject).toString());
      i = j;
      while ((i >= 0) && (!this.name.toLowerCase().equals(this.elementStack[(i + 3)].toLowerCase())))
      {
        this.stackMismatch += 1;
        i -= 4;
      }
      if (i < 0)
      {
        this.stackMismatch = 0;
        this.type = 9;
        return;
      }
    }
    localObject = this.elementStack;
    this.namespace = localObject[j];
    this.prefix = localObject[(j + 1)];
    this.name = localObject[(j + 2)];
  }
  
  private final int parseLegacy(boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    read();
    int i = read();
    int j;
    if (i == 63)
    {
      if (((peek(0) == 120) || (peek(0) == 88)) && ((peek(1) == 109) || (peek(1) == 77)))
      {
        if (paramBoolean)
        {
          push(peek(0));
          push(peek(1));
        }
        read();
        read();
        if (((peek(0) == 108) || (peek(0) == 76)) && (peek(1) <= 32))
        {
          if ((this.line != 1) || (this.column > 4)) {
            error("PI must not start with xml");
          }
          parseStartTag(true);
          j = this.attributeCount;
          i = 2;
          if ((j < 1) || (!"version".equals(this.attributes[2]))) {
            error("version expected");
          }
          localObject = this.attributes;
          this.version = localObject[3];
          if ((1 < this.attributeCount) && ("encoding".equals(localObject[6]))) {
            this.encoding = this.attributes[7];
          } else {
            i = 1;
          }
          j = i;
          if (i < this.attributeCount)
          {
            localObject = this.attributes;
            k = i * 4;
            j = i;
            if ("standalone".equals(localObject[(k + 2)]))
            {
              localObject = this.attributes[(k + 3)];
              if ("yes".equals(localObject)) {}
              for (localObject = new Boolean(true);; localObject = new Boolean(false))
              {
                this.standalone = ((Boolean)localObject);
                break label371;
                if (!"no".equals(localObject)) {
                  break;
                }
              }
              StringBuffer localStringBuffer = new StringBuffer();
              localStringBuffer.append("illegal standalone value: ");
              localStringBuffer.append((String)localObject);
              error(localStringBuffer.toString());
              label371:
              j = i + 1;
            }
          }
          if (j != this.attributeCount) {
            error("illegal xmldecl");
          }
          this.isWhitespace = true;
          this.txtPos = 0;
          return 998;
        }
      }
      localObject = "";
      i = 63;
      j = 8;
    }
    else
    {
      if (i != 33) {
        break label656;
      }
      if (peek(0) == 45)
      {
        localObject = "--";
        i = 45;
        j = 9;
      }
      else if (peek(0) == 91)
      {
        localObject = "[CDATA[";
        paramBoolean = true;
        i = 93;
        j = 5;
      }
      else
      {
        localObject = "DOCTYPE";
        i = -1;
        j = 10;
      }
    }
    int k = 0;
    while (k < ((String)localObject).length())
    {
      read(((String)localObject).charAt(k));
      k += 1;
    }
    if (j == 10)
    {
      parseDoctype(paramBoolean);
      return j;
    }
    k = 0;
    int m = read();
    if (m == -1) {}
    for (Object localObject = "Unexpected EOF";; localObject = ((StringBuffer)localObject).toString())
    {
      error((String)localObject);
      return 9;
      if (paramBoolean) {
        push(m);
      }
      if (((i == 63) || (m == i)) && (peek(0) == i) && (peek(1) == 62))
      {
        if ((i == 45) && (k == 45)) {
          error("illegal comment delimiter: --->");
        }
        read();
        read();
        if ((paramBoolean) && (i != 63)) {
          this.txtPos -= 1;
        }
        return j;
      }
      k = m;
      break;
      label656:
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("illegal: <");
      ((StringBuffer)localObject).append(i);
    }
  }
  
  private final void parseStartTag(boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    if (!paramBoolean) {
      read();
    }
    this.name = readName();
    this.attributeCount = 0;
    for (;;)
    {
      skip();
      int i = peek(0);
      if (paramBoolean)
      {
        if (i == 63)
        {
          read();
          read('>');
        }
      }
      else
      {
        if (i == 47)
        {
          this.degenerated = true;
          read();
          skip();
          read('>');
          break label134;
        }
        if ((i == 62) && (!paramBoolean))
        {
          read();
          break label134;
        }
      }
      if (i == -1)
      {
        error("Unexpected EOF");
        return;
      }
      Object localObject1 = readName();
      if (((String)localObject1).length() == 0)
      {
        error("attr name expected");
        label134:
        i = this.depth;
        this.depth = (i + 1);
        i <<= 2;
        localObject1 = ensureCapacity(this.elementStack, i + 4);
        this.elementStack = ((String[])localObject1);
        localObject1[(i + 3)] = this.name;
        j = this.depth;
        localObject1 = this.nspCounts;
        if (j >= localObject1.length)
        {
          localObject2 = new int[j + 4];
          System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
          this.nspCounts = ((int[])localObject2);
        }
        localObject1 = this.nspCounts;
        j = this.depth;
        localObject1[j] = localObject1[(j - 1)];
        if (this.processNsp) {
          adjustNsp();
        } else {
          this.namespace = "";
        }
        localObject1 = this.elementStack;
        localObject1[i] = this.namespace;
        localObject1[(i + 1)] = this.prefix;
        localObject1[(i + 2)] = this.name;
        return;
      }
      i = this.attributeCount;
      this.attributeCount = (i + 1);
      int j = i << 2;
      Object localObject2 = ensureCapacity(this.attributes, j + 4);
      this.attributes = ((String[])localObject2);
      i = j + 1;
      localObject2[j] = "";
      int k = i + 1;
      localObject2[i] = null;
      j = k + 1;
      localObject2[k] = localObject1;
      skip();
      if (peek(0) != 61)
      {
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("Attr.value missing f. ");
        ((StringBuffer)localObject2).append((String)localObject1);
        error(((StringBuffer)localObject2).toString());
        this.attributes[j] = "1";
      }
      else
      {
        read('=');
        skip();
        i = peek(0);
        if ((i != 39) && (i != 34))
        {
          error("attr value delimiter missing!");
          i = 32;
        }
        else
        {
          read();
        }
        k = this.txtPos;
        pushText(i, true);
        this.attributes[j] = get(k);
        this.txtPos = k;
        if (i != 32) {
          read();
        }
      }
    }
  }
  
  private final int peek(int paramInt)
    throws IOException
  {
    while (paramInt >= this.peekCount)
    {
      Object localObject = this.srcBuf;
      int i;
      if (localObject.length <= 1)
      {
        i = this.reader.read();
      }
      else
      {
        i = this.srcPos;
        if (i < this.srcCount)
        {
          this.srcPos = (i + 1);
          i = localObject[i];
        }
        else
        {
          i = this.reader.read((char[])localObject, 0, localObject.length);
          this.srcCount = i;
          if (i <= 0) {
            i = -1;
          } else {
            i = this.srcBuf[0];
          }
          this.srcPos = 1;
        }
      }
      if (i == 13)
      {
        this.wasCR = true;
        localObject = this.peek;
        i = this.peekCount;
        this.peekCount = (i + 1);
        localObject[i] = 10;
      }
      else
      {
        if (i == 10)
        {
          if (!this.wasCR)
          {
            localObject = this.peek;
            i = this.peekCount;
            this.peekCount = (i + 1);
            localObject[i] = 10;
          }
        }
        else
        {
          localObject = this.peek;
          int j = this.peekCount;
          this.peekCount = (j + 1);
          localObject[j] = i;
        }
        this.wasCR = false;
      }
    }
    return this.peek[paramInt];
  }
  
  private final int peekType()
    throws IOException
  {
    int i = peek(0);
    if (i != -1)
    {
      if (i != 38)
      {
        if (i != 60) {
          return 4;
        }
        i = peek(1);
        if (i != 33) {
          if (i != 47)
          {
            if (i != 63) {
              return 2;
            }
          }
          else {
            return 3;
          }
        }
        return 999;
      }
      return 6;
    }
    return 1;
  }
  
  private final void push(int paramInt)
  {
    boolean bool2 = this.isWhitespace;
    boolean bool1;
    if (paramInt <= 32) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isWhitespace = (bool2 & bool1);
    int i = this.txtPos;
    char[] arrayOfChar1 = this.txtBuf;
    if (i == arrayOfChar1.length)
    {
      char[] arrayOfChar2 = new char[i * 4 / 3 + 4];
      System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, i);
      this.txtBuf = arrayOfChar2;
    }
    arrayOfChar1 = this.txtBuf;
    i = this.txtPos;
    this.txtPos = (i + 1);
    arrayOfChar1[i] = ((char)paramInt);
  }
  
  private final void pushEntity()
    throws IOException, XmlPullParserException
  {
    push(read());
    int i = this.txtPos;
    for (;;)
    {
      int j = read();
      if (j == 59)
      {
        String str = get(i);
        boolean bool = true;
        this.txtPos = (i - 1);
        if ((this.token) && (this.type == 6)) {
          this.name = str;
        }
        i = 0;
        if (str.charAt(0) == '#')
        {
          if (str.charAt(1) == 'x') {
            i = Integer.parseInt(str.substring(2), 16);
          } else {
            i = Integer.parseInt(str.substring(1));
          }
          push(i);
          return;
        }
        Object localObject = (String)this.entityMap.get(str);
        if (localObject != null) {
          bool = false;
        }
        this.unresolved = bool;
        if (bool)
        {
          if (!this.token)
          {
            localObject = new StringBuffer();
            ((StringBuffer)localObject).append("unresolved: &");
            ((StringBuffer)localObject).append(str);
            ((StringBuffer)localObject).append(";");
            error(((StringBuffer)localObject).toString());
          }
        }
        else {
          while (i < ((String)localObject).length())
          {
            push(((String)localObject).charAt(i));
            i += 1;
          }
        }
        return;
      }
      if ((j < 128) && ((j < 48) || (j > 57)) && ((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && (j != 95) && (j != 45) && (j != 35))
      {
        if (!this.relaxed) {
          error("unterminated entity ref");
        }
        if (j != -1) {
          push(j);
        }
        return;
      }
      push(j);
    }
  }
  
  private final void pushText(int paramInt, boolean paramBoolean)
    throws IOException, XmlPullParserException
  {
    int j = peek(0);
    int i = 0;
    while ((j != -1) && (j != paramInt))
    {
      int k = 32;
      if (paramInt == 32)
      {
        if (j <= 32) {
          break;
        }
        if (j == 62) {
          return;
        }
      }
      if (j == 38)
      {
        if (!paramBoolean) {
          return;
        }
        pushEntity();
      }
      else
      {
        if ((j == 10) && (this.type == 2)) {
          read();
        } else {
          k = read();
        }
        push(k);
      }
      if ((j == 62) && (i >= 2) && (paramInt != 93)) {
        error("Illegal: ]]>");
      }
      if (j == 93) {
        i += 1;
      } else {
        i = 0;
      }
      j = peek(0);
    }
  }
  
  private final int read()
    throws IOException
  {
    int i;
    if (this.peekCount == 0)
    {
      i = peek(0);
    }
    else
    {
      int[] arrayOfInt = this.peek;
      i = arrayOfInt[0];
      arrayOfInt[0] = arrayOfInt[1];
    }
    this.peekCount -= 1;
    this.column += 1;
    if (i == 10)
    {
      this.line += 1;
      this.column = 1;
    }
    return i;
  }
  
  private final void read(char paramChar)
    throws IOException, XmlPullParserException
  {
    char c = read();
    if (c != paramChar)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("expected: '");
      localStringBuffer.append(paramChar);
      localStringBuffer.append("' actual: '");
      localStringBuffer.append((char)c);
      localStringBuffer.append("'");
      error(localStringBuffer.toString());
    }
  }
  
  private final String readName()
    throws IOException, XmlPullParserException
  {
    int i = this.txtPos;
    int j = peek(0);
    if (((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && (j != 95) && (j != 58) && (j < 192) && (!this.relaxed)) {
      error("name expected");
    }
    do
    {
      push(read());
      j = peek(0);
    } while (((j >= 97) && (j <= 122)) || ((j >= 65) && (j <= 90)) || ((j >= 48) && (j <= 57)) || (j == 95) || (j == 45) || (j == 58) || (j == 46) || (j >= 183));
    String str = get(i);
    this.txtPos = i;
    return str;
  }
  
  private final void skip()
    throws IOException
  {
    for (;;)
    {
      int i = peek(0);
      if (i > 32) {
        break;
      }
      if (i == -1) {
        return;
      }
      read();
    }
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2)
    throws XmlPullParserException
  {
    Hashtable localHashtable = this.entityMap;
    if (localHashtable != null)
    {
      localHashtable.put(paramString1, paramString2);
      return;
    }
    throw new RuntimeException("entity replacement text must be defined after setInput!");
  }
  
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
    return this.column;
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
    if (isProp(paramString, false, "relaxed")) {
      return this.relaxed;
    }
    return false;
  }
  
  public String getInputEncoding()
  {
    return this.encoding;
  }
  
  public int getLineNumber()
  {
    return this.line;
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
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("@");
    ((StringBuffer)localObject).append(this.line);
    ((StringBuffer)localObject).append(":");
    ((StringBuffer)localObject).append(this.column);
    localStringBuffer.append(((StringBuffer)localObject).toString());
    if (this.location != null)
    {
      localStringBuffer.append(" in ");
      localStringBuffer.append(this.location);
    }
    else if (this.reader != null)
    {
      localStringBuffer.append(" in ");
      localStringBuffer.append(this.reader.toString());
    }
    return localStringBuffer.toString();
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public Object getProperty(String paramString)
  {
    if (isProp(paramString, true, "xmldecl-version")) {
      return this.version;
    }
    if (isProp(paramString, true, "xmldecl-standalone")) {
      return this.standalone;
    }
    if (isProp(paramString, true, "location"))
    {
      paramString = this.location;
      if (paramString != null) {
        return paramString;
      }
      return this.reader.toString();
    }
    return null;
  }
  
  public String getText()
  {
    int i = this.type;
    if ((i >= 4) && ((i != 6) || (!this.unresolved))) {
      return get(0);
    }
    return null;
  }
  
  public char[] getTextCharacters(int[] paramArrayOfInt)
  {
    int i = this.type;
    if (i >= 4)
    {
      if (i == 6)
      {
        paramArrayOfInt[0] = 0;
        paramArrayOfInt[1] = this.name.length();
        return this.name.toCharArray();
      }
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = this.txtPos;
      return this.txtBuf;
    }
    paramArrayOfInt[0] = -1;
    paramArrayOfInt[1] = -1;
    return null;
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
    this.txtPos = 0;
    this.isWhitespace = true;
    this.token = false;
    int i = 9999;
    int j;
    do
    {
      do
      {
        nextImpl();
        int k = this.type;
        j = i;
        if (k < i) {
          j = k;
        }
        i = j;
      } while (j > 6);
      if (j < 4) {
        break;
      }
      i = j;
    } while (peekType() >= 4);
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
    this.txtPos = 0;
    this.token = true;
    nextImpl();
    return this.type;
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
    throws XmlPullParserException, IOException
  {
    if ((paramInt != this.type) || ((paramString1 != null) && (!paramString1.equals(getNamespace()))) || ((paramString2 != null) && (!paramString2.equals(getName()))))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("expected: ");
      localStringBuffer.append(XmlPullParser.TYPES[paramInt]);
      localStringBuffer.append(" {");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("}");
      localStringBuffer.append(paramString2);
      exception(localStringBuffer.toString());
    }
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    if ("http://xmlpull.org/v1/doc/features.html#process-namespaces".equals(paramString))
    {
      this.processNsp = paramBoolean;
      return;
    }
    if (isProp(paramString, false, "relaxed"))
    {
      this.relaxed = paramBoolean;
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
    this.srcPos = 0;
    this.srcCount = 0;
    String str2;
    Object localObject;
    String str1;
    int i;
    if (paramInputStream != null)
    {
      str2 = "UTF-16LE";
      localObject = "UTF-32BE";
      str1 = "UTF-8";
      if (paramString != null) {
        break label652;
      }
      i = 0;
    }
    for (;;)
    {
      try
      {
        int j;
        int k;
        if (this.srcCount < 4)
        {
          j = paramInputStream.read();
          if (j != -1)
          {
            i = i << 8 | j;
            char[] arrayOfChar = this.srcBuf;
            k = this.srcCount;
            this.srcCount = (k + 1);
            arrayOfChar[k] = ((char)j);
            continue;
          }
        }
        if (this.srcCount != 4) {
          break label652;
        }
        switch (i)
        {
        case 1010792557: 
          j = paramInputStream.read();
          if (j == -1) {
            break label643;
          }
          localObject = this.srcBuf;
          k = this.srcCount;
          this.srcCount = (k + 1);
          localObject[k] = ((char)j);
          if (j != 62) {
            continue;
          }
          localObject = new String(this.srcBuf, 0, this.srcCount);
          j = ((String)localObject).indexOf("encoding");
          if (j == -1) {
            break label643;
          }
          if ((((String)localObject).charAt(j) != '"') && (((String)localObject).charAt(j) != '\''))
          {
            j += 1;
            continue;
          }
          k = j + 1;
          localObject = ((String)localObject).substring(k, ((String)localObject).indexOf(((String)localObject).charAt(j), k));
          break;
        case 1006649088: 
          this.srcBuf[0] = '<';
          this.srcBuf[1] = '?';
          this.srcCount = 2;
          localObject = str2;
          break;
        case 1006632960: 
          this.srcBuf[0] = '<';
          this.srcCount = 1;
          break;
        case 3932223: 
          this.srcBuf[0] = '<';
          this.srcBuf[1] = '?';
          this.srcCount = 2;
          break;
        case 65279: 
          this.srcCount = 0;
          break;
        case 60: 
          this.srcBuf[0] = '<';
          this.srcCount = 1;
          break;
        case -131072: 
          this.srcCount = 0;
          break label635;
          j = 0xFFFF0000 & i;
          if (j == -16842752)
          {
            this.srcBuf[0] = ((char)(this.srcBuf[2] << '\b' | this.srcBuf[3]));
            this.srcCount = 1;
            break label627;
          }
          if (j == -131072)
          {
            this.srcBuf[0] = ((char)(this.srcBuf[3] << '\b' | this.srcBuf[2]));
            this.srcCount = 1;
            localObject = str2;
          }
          else if ((i & 0xFF00) == -272908544)
          {
            this.srcBuf[0] = this.srcBuf[3];
            this.srcCount = 1;
            localObject = "UTF-8";
          }
          break;
        }
      }
      catch (Exception paramInputStream)
      {
        paramString = new StringBuffer();
        paramString.append("Invalid stream or encoding: ");
        paramString.append(paramInputStream.toString());
        throw new XmlPullParserException(paramString.toString(), this, paramInputStream);
      }
      i = this.srcCount;
      setInput(new InputStreamReader(paramInputStream, (String)localObject));
      this.encoding = paramString;
      this.srcCount = i;
      return;
      throw new IllegalArgumentException();
      break label643;
      label627:
      localObject = "UTF-16BE";
      break label655;
      label635:
      localObject = "UTF-32LE";
      break label655;
      label643:
      localObject = paramString;
      continue;
      break label655;
      label652:
      localObject = paramString;
      label655:
      if (localObject == null) {
        localObject = str1;
      }
    }
  }
  
  public void setInput(Reader paramReader)
    throws XmlPullParserException
  {
    this.reader = paramReader;
    this.line = 1;
    this.column = 0;
    this.type = 0;
    this.name = null;
    this.namespace = null;
    this.degenerated = false;
    this.attributeCount = -1;
    this.encoding = null;
    this.version = null;
    this.standalone = null;
    if (paramReader == null) {
      return;
    }
    this.srcPos = 0;
    this.srcCount = 0;
    this.peekCount = 0;
    this.depth = 0;
    paramReader = new Hashtable();
    this.entityMap = paramReader;
    paramReader.put("amp", "&");
    this.entityMap.put("apos", "'");
    this.entityMap.put("gt", ">");
    this.entityMap.put("lt", "<");
    this.entityMap.put("quot", "\"");
  }
  
  public void setProperty(String paramString, Object paramObject)
    throws XmlPullParserException
  {
    if (isProp(paramString, true, "location"))
    {
      this.location = paramObject;
      return;
    }
    paramObject = new StringBuffer();
    ((StringBuffer)paramObject).append("unsupported property: ");
    ((StringBuffer)paramObject).append(paramString);
    throw new XmlPullParserException(((StringBuffer)paramObject).toString());
  }
  
  public void skipSubTree()
    throws XmlPullParserException, IOException
  {
    require(2, null, null);
    int i = 1;
    while (i > 0)
    {
      int j = next();
      if (j == 3) {
        i -= 1;
      } else if (j == 2) {
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\kxml2\io\KXmlParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */