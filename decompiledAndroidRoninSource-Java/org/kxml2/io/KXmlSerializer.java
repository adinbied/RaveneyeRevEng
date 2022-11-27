package org.kxml2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

public class KXmlSerializer
  implements XmlSerializer
{
  private int auto;
  private int depth;
  private String[] elementStack = new String[12];
  private String encoding;
  private boolean[] indent = new boolean[4];
  private int[] nspCounts = new int[4];
  private String[] nspStack = new String[8];
  private boolean pending;
  private boolean unicode;
  private Writer writer;
  
  private final void check(boolean paramBoolean)
    throws IOException
  {
    if (!this.pending) {
      return;
    }
    int i = this.depth + 1;
    this.depth = i;
    this.pending = false;
    Object localObject1 = this.indent;
    if (localObject1.length <= i)
    {
      localObject2 = new boolean[i + 4];
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      this.indent = ((boolean[])localObject2);
    }
    localObject1 = this.indent;
    i = this.depth;
    localObject1[i] = localObject1[(i - 1)];
    i = this.nspCounts[(i - 1)];
    int j;
    for (;;)
    {
      localObject1 = this.nspCounts;
      j = this.depth;
      if (i >= localObject1[j]) {
        break;
      }
      this.writer.write(32);
      this.writer.write("xmlns");
      localObject1 = this.nspStack;
      j = i * 2;
      if (!"".equals(localObject1[j]))
      {
        this.writer.write(58);
        this.writer.write(this.nspStack[j]);
      }
      else if (("".equals(getNamespace())) && (!"".equals(this.nspStack[(j + 1)])))
      {
        throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
      }
      this.writer.write("=\"");
      writeEscaped(this.nspStack[(j + 1)], 34);
      this.writer.write(34);
      i += 1;
    }
    if (localObject1.length <= j + 1)
    {
      localObject2 = new int[j + 8];
      System.arraycopy(localObject1, 0, localObject2, 0, j + 1);
      this.nspCounts = ((int[])localObject2);
    }
    localObject1 = this.nspCounts;
    i = this.depth;
    localObject1[(i + 1)] = localObject1[i];
    Object localObject2 = this.writer;
    if (paramBoolean) {
      localObject1 = " />";
    } else {
      localObject1 = ">";
    }
    ((Writer)localObject2).write((String)localObject1);
  }
  
  private final String getPrefix(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    int i = this.nspCounts[(this.depth + 1)] * 2 - 2;
    Object localObject;
    String str;
    for (;;)
    {
      localObject = null;
      str = "";
      if (i < 0) {
        break;
      }
      if ((this.nspStack[(i + 1)].equals(paramString)) && ((paramBoolean1) || (!this.nspStack[i].equals(""))))
      {
        str = this.nspStack[i];
        int j = i + 2;
        while (j < this.nspCounts[(this.depth + 1)] * 2)
        {
          if (this.nspStack[j].equals(str)) {
            break label128;
          }
          j += 1;
        }
        localObject = str;
        label128:
        if (localObject != null) {
          return (String)localObject;
        }
      }
      i -= 2;
    }
    if (!paramBoolean2) {
      return null;
    }
    if ("".equals(paramString)) {
      localObject = str;
    } else {
      do
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("n");
        i = this.auto;
        this.auto = (i + 1);
        ((StringBuffer)localObject).append(i);
        localObject = ((StringBuffer)localObject).toString();
        i = this.nspCounts[(this.depth + 1)] * 2 - 2;
        while (i >= 0)
        {
          if (((String)localObject).equals(this.nspStack[i]))
          {
            localObject = null;
            break;
          }
          i -= 2;
        }
      } while (localObject == null);
    }
    paramBoolean1 = this.pending;
    this.pending = false;
    setPrefix((String)localObject, paramString);
    this.pending = paramBoolean1;
    return (String)localObject;
  }
  
  private final void writeEscaped(String paramString, int paramInt)
    throws IOException
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      Object localObject1;
      Object localObject2;
      if ((j != 9) && (j != 10) && (j != 13))
      {
        if (j != 34)
        {
          if (j != 60) {
            if (j != 62)
            {
              if (j != 38)
              {
                if (j == 39) {
                  break label122;
                }
                break label162;
              }
              localObject1 = this.writer;
              localObject2 = "&amp;";
            }
          }
          for (;;)
          {
            ((Writer)localObject1).write((String)localObject2);
            break;
            localObject1 = this.writer;
            localObject2 = "&gt;";
            continue;
            localObject1 = this.writer;
            localObject2 = "&lt;";
          }
        }
        label122:
        if (j == paramInt)
        {
          localObject2 = this.writer;
          if (j == 34) {
            localObject1 = "&quot;";
          } else {
            localObject1 = "&apos;";
          }
          ((Writer)localObject2).write((String)localObject1);
          break label304;
        }
        label162:
        if ((j >= 32) && (j != 64) && ((j < 127) || (this.unicode))) {
          break label250;
        }
        localObject1 = this.writer;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("&#");
        ((StringBuffer)localObject2).append(j);
        ((StringBuffer)localObject2).append(";");
      }
      for (;;)
      {
        ((Writer)localObject1).write(((StringBuffer)localObject2).toString());
        break;
        if (paramInt == -1)
        {
          label250:
          this.writer.write(j);
          break;
        }
        localObject1 = this.writer;
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("&#");
        ((StringBuffer)localObject2).append(j);
        ((StringBuffer)localObject2).append(';');
      }
      label304:
      i += 1;
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    if (this.pending)
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      if ("".equals(str)) {
        paramString1 = "";
      } else {
        paramString1 = getPrefix(str, false, true);
      }
      this.writer.write(32);
      if (!"".equals(paramString1))
      {
        this.writer.write(paramString1);
        this.writer.write(58);
      }
      this.writer.write(paramString2);
      this.writer.write(61);
      int i = 34;
      if (paramString3.indexOf('"') != -1) {
        i = 39;
      }
      this.writer.write(i);
      writeEscaped(paramString3, i);
      this.writer.write(i);
      return this;
    }
    throw new IllegalStateException("illegal position for attribute");
  }
  
  public void cdsect(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write("<![CDATA[");
    this.writer.write(paramString);
    this.writer.write("]]>");
  }
  
  public void comment(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write("<!--");
    this.writer.write(paramString);
    this.writer.write("-->");
  }
  
  public void docdecl(String paramString)
    throws IOException
  {
    this.writer.write("<!DOCTYPE");
    this.writer.write(paramString);
    this.writer.write(">");
  }
  
  public void endDocument()
    throws IOException
  {
    for (;;)
    {
      int i = this.depth;
      if (i <= 0) {
        break;
      }
      String[] arrayOfString = this.elementStack;
      endTag(arrayOfString[(i * 3 - 3)], arrayOfString[(i * 3 - 1)]);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
    throws IOException
  {
    if (!this.pending) {
      this.depth -= 1;
    }
    if (((paramString1 != null) || (this.elementStack[(this.depth * 3)] == null)) && ((paramString1 == null) || (paramString1.equals(this.elementStack[(this.depth * 3)]))) && (this.elementStack[(this.depth * 3 + 2)].equals(paramString2)))
    {
      if (this.pending)
      {
        check(true);
        this.depth -= 1;
      }
      else
      {
        if (this.indent[(this.depth + 1)] != 0)
        {
          this.writer.write("\r\n");
          i = 0;
          while (i < this.depth)
          {
            this.writer.write("  ");
            i += 1;
          }
        }
        this.writer.write("</");
        paramString1 = this.elementStack[(this.depth * 3 + 1)];
        if (!"".equals(paramString1))
        {
          this.writer.write(paramString1);
          this.writer.write(58);
        }
        this.writer.write(paramString2);
        this.writer.write(62);
      }
      paramString1 = this.nspCounts;
      int i = this.depth;
      paramString1[(i + 1)] = paramString1[i];
      return this;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("</{");
    localStringBuffer.append(paramString1);
    localStringBuffer.append("}");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("> does not match start");
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public void entityRef(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write(38);
    this.writer.write(paramString);
    this.writer.write(59);
  }
  
  public void flush()
    throws IOException
  {
    check(false);
    this.writer.flush();
  }
  
  public int getDepth()
  {
    if (this.pending) {
      return this.depth + 1;
    }
    return this.depth;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString)) {
      return this.indent[this.depth];
    }
    return false;
  }
  
  public String getName()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.elementStack[(getDepth() * 3 - 1)];
  }
  
  public String getNamespace()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.elementStack[(getDepth() * 3 - 3)];
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getPrefix(paramString, false, paramBoolean);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString.toString());
    }
  }
  
  public Object getProperty(String paramString)
  {
    throw new RuntimeException("Unsupported property");
  }
  
  public void ignorableWhitespace(String paramString)
    throws IOException
  {
    text(paramString);
  }
  
  public void processingInstruction(String paramString)
    throws IOException
  {
    check(false);
    this.writer.write("<?");
    this.writer.write(paramString);
    this.writer.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString))
    {
      this.indent[this.depth] = paramBoolean;
      return;
    }
    throw new RuntimeException("Unsupported Feature");
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      if (paramString == null) {
        paramOutputStream = new OutputStreamWriter(paramOutputStream);
      } else {
        paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString);
      }
      setOutput(paramOutputStream);
      this.encoding = paramString;
      if ((paramString != null) && (paramString.toLowerCase().startsWith("utf"))) {
        this.unicode = true;
      }
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void setOutput(Writer paramWriter)
  {
    this.writer = paramWriter;
    paramWriter = this.nspCounts;
    paramWriter[0] = 2;
    paramWriter[1] = 2;
    paramWriter = this.nspStack;
    paramWriter[0] = "";
    paramWriter[1] = "";
    paramWriter[2] = "xml";
    paramWriter[3] = "http://www.w3.org/XML/1998/namespace";
    this.pending = false;
    this.auto = 0;
    this.depth = 0;
    this.unicode = false;
  }
  
  public void setPrefix(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (str.equals(getPrefix(paramString1, true, false))) {
      return;
    }
    paramString2 = this.nspCounts;
    int i = this.depth + 1;
    int j = paramString2[i];
    paramString2[i] = (j + 1);
    i = j << 1;
    paramString2 = this.nspStack;
    j = paramString2.length;
    int k = i + 1;
    if (j < k)
    {
      String[] arrayOfString = new String[paramString2.length + 16];
      System.arraycopy(paramString2, 0, arrayOfString, 0, i);
      this.nspStack = arrayOfString;
    }
    paramString2 = this.nspStack;
    paramString2[i] = str;
    paramString2[k] = paramString1;
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    paramString = new StringBuffer();
    paramString.append("Unsupported Property:");
    paramString.append(paramObject);
    throw new RuntimeException(paramString.toString());
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
    throws IOException
  {
    this.writer.write("<?xml version='1.0' ");
    if (paramString != null)
    {
      this.encoding = paramString;
      if (paramString.toLowerCase().startsWith("utf")) {
        this.unicode = true;
      }
    }
    if (this.encoding != null)
    {
      this.writer.write("encoding='");
      this.writer.write(this.encoding);
      this.writer.write("' ");
    }
    if (paramBoolean != null)
    {
      this.writer.write("standalone='");
      Writer localWriter = this.writer;
      if (paramBoolean.booleanValue()) {
        paramString = "yes";
      } else {
        paramString = "no";
      }
      localWriter.write(paramString);
      this.writer.write("' ");
    }
    this.writer.write("?>");
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    if (this.indent[this.depth] != 0)
    {
      this.writer.write("\r\n");
      i = 0;
      while (i < this.depth)
      {
        this.writer.write("  ");
        i += 1;
      }
    }
    int j = this.depth * 3;
    Object localObject = this.elementStack;
    if (localObject.length < j + 3)
    {
      arrayOfString = new String[localObject.length + 12];
      System.arraycopy(localObject, 0, arrayOfString, 0, j);
      this.elementStack = arrayOfString;
    }
    if (paramString1 == null) {
      localObject = "";
    } else {
      localObject = getPrefix(paramString1, true, true);
    }
    if ("".equals(paramString1))
    {
      i = this.nspCounts[this.depth];
      while (i < this.nspCounts[(this.depth + 1)])
      {
        arrayOfString = this.nspStack;
        int k = i * 2;
        if (("".equals(arrayOfString[k])) && (!"".equals(this.nspStack[(k + 1)]))) {
          throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
        }
        i += 1;
      }
    }
    String[] arrayOfString = this.elementStack;
    int i = j + 1;
    arrayOfString[j] = paramString1;
    arrayOfString[i] = localObject;
    arrayOfString[(i + 1)] = paramString2;
    this.writer.write(60);
    if (!"".equals(localObject))
    {
      this.writer.write((String)localObject);
      this.writer.write(58);
    }
    this.writer.write(paramString2);
    this.pending = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
    throws IOException
  {
    check(false);
    this.indent[this.depth] = false;
    writeEscaped(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    text(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\kxml2\io\KXmlSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */