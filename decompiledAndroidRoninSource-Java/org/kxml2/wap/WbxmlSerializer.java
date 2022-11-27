package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlSerializer;

public class WbxmlSerializer
  implements XmlSerializer
{
  private int attrPage;
  Hashtable attrStartTable = new Hashtable();
  Hashtable attrValueTable = new Hashtable();
  Vector attributes = new Vector();
  ByteArrayOutputStream buf = new ByteArrayOutputStream();
  int depth;
  private String encoding;
  String name;
  String namespace;
  OutputStream out;
  String pending;
  Hashtable stringTable = new Hashtable();
  ByteArrayOutputStream stringTableBuf = new ByteArrayOutputStream();
  private int tagPage;
  Hashtable tagTable = new Hashtable();
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[5];
    int j = 0;
    int i = paramInt;
    for (paramInt = j;; paramInt = j)
    {
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(i & 0x7F));
      i >>= 7;
      if (i == 0)
      {
        while (j > 1)
        {
          j -= 1;
          paramOutputStream.write(arrayOfByte[j] | 0x80);
        }
        paramOutputStream.write(arrayOfByte[0]);
        return;
      }
    }
  }
  
  private void writeStr(String paramString)
    throws IOException
  {
    int n = paramString.length();
    int i = 0;
    int m;
    for (int k = 0; i < n; k = m)
    {
      while ((i < n) && (paramString.charAt(i) < 'A')) {
        i += 1;
      }
      int j = i;
      while ((j < n) && (paramString.charAt(j) >= 'A')) {
        j += 1;
      }
      m = k;
      if (j - i > 10)
      {
        if ((i > k) && (paramString.charAt(i - 1) == ' ') && (this.stringTable.get(paramString.substring(i, j)) == null))
        {
          this.buf.write(131);
          writeStrT(paramString.substring(k, j), false);
        }
        else
        {
          m = i;
          if (i > k)
          {
            m = i;
            if (paramString.charAt(i - 1) == ' ') {
              m = i - 1;
            }
          }
          if (m > k)
          {
            this.buf.write(131);
            writeStrT(paramString.substring(k, m), false);
          }
          this.buf.write(131);
          writeStrT(paramString.substring(m, j), true);
        }
        m = j;
      }
      i = j;
    }
    if (k < n)
    {
      this.buf.write(131);
      writeStrT(paramString.substring(k, n), false);
    }
  }
  
  private final void writeStrT(String paramString, boolean paramBoolean)
    throws IOException
  {
    Object localObject = (Integer)this.stringTable.get(paramString);
    if (localObject != null)
    {
      writeInt(this.buf, ((Integer)localObject).intValue());
      return;
    }
    int j = this.stringTableBuf.size();
    if ((paramString.charAt(0) >= '0') && (paramBoolean))
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(' ');
      ((StringBuffer)localObject).append(paramString);
      paramString = ((StringBuffer)localObject).toString();
      writeInt(this.buf, j + 1);
    }
    else
    {
      writeInt(this.buf, j);
    }
    this.stringTable.put(paramString, new Integer(j));
    if (paramString.charAt(0) == ' ') {
      this.stringTable.put(paramString.substring(1), new Integer(j + 1));
    }
    int i = paramString.lastIndexOf(' ');
    if (i > 1)
    {
      localObject = this.stringTable;
      String str = paramString.substring(i);
      j += i;
      ((Hashtable)localObject).put(str, new Integer(j));
      this.stringTable.put(paramString.substring(i + 1), new Integer(j + 1));
    }
    writeStrI(this.stringTableBuf, paramString);
    this.stringTableBuf.flush();
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    this.attributes.addElement(paramString2);
    this.attributes.addElement(paramString3);
    return this;
  }
  
  public void cdsect(String paramString)
    throws IOException
  {
    text(paramString);
  }
  
  public void checkPending(boolean paramBoolean)
    throws IOException
  {
    if (this.pending == null) {
      return;
    }
    int j = this.attributes.size();
    Object localObject1 = (int[])this.tagTable.get(this.pending);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = this.buf;
      if (j == 0)
      {
        if (paramBoolean) {
          i = 4;
        } else {
          i = 68;
        }
      }
      else if (paramBoolean) {
        i = 132;
      } else {
        i = 196;
      }
      ((ByteArrayOutputStream)localObject1).write(i);
      writeStrT(this.pending, false);
    }
    else
    {
      if (localObject1[0] != this.tagPage)
      {
        this.tagPage = localObject1[0];
        this.buf.write(0);
        this.buf.write(this.tagPage);
      }
      localObject2 = this.buf;
      if (j == 0)
      {
        if (paramBoolean) {
          i = localObject1[1];
        } else {
          i = localObject1[1] | 0x40;
        }
      }
      else if (paramBoolean) {
        i = localObject1[1] | 0x80;
      } else {
        i = localObject1[1] | 0xC0;
      }
      ((ByteArrayOutputStream)localObject2).write(i);
    }
    int i = 0;
    while (i < j)
    {
      localObject1 = (int[])this.attrStartTable.get(this.attributes.elementAt(i));
      if (localObject1 == null)
      {
        this.buf.write(4);
        writeStrT((String)this.attributes.elementAt(i), false);
      }
      else
      {
        if (localObject1[0] != this.attrPage)
        {
          this.attrPage = localObject1[0];
          this.buf.write(0);
          this.buf.write(this.attrPage);
        }
        this.buf.write(localObject1[1]);
      }
      localObject1 = this.attrValueTable;
      localObject2 = this.attributes;
      i += 1;
      localObject1 = (int[])((Hashtable)localObject1).get(((Vector)localObject2).elementAt(i));
      if (localObject1 == null)
      {
        writeStr((String)this.attributes.elementAt(i));
      }
      else
      {
        if (localObject1[0] != this.attrPage)
        {
          this.attrPage = localObject1[0];
          this.buf.write(0);
          this.buf.write(this.attrPage);
        }
        this.buf.write(localObject1[1]);
      }
      i += 1;
    }
    if (j > 0) {
      this.buf.write(1);
    }
    this.pending = null;
    this.attributes.removeAllElements();
  }
  
  public void comment(String paramString) {}
  
  public void docdecl(String paramString)
  {
    throw new RuntimeException("Cannot write docdecl for WBXML");
  }
  
  public void endDocument()
    throws IOException
  {
    writeInt(this.out, this.stringTableBuf.size());
    this.out.write(this.stringTableBuf.toByteArray());
    this.out.write(this.buf.toByteArray());
    this.out.flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
    throws IOException
  {
    if (this.pending != null) {
      checkPending(true);
    } else {
      this.buf.write(1);
    }
    this.depth -= 1;
    return this;
  }
  
  public void entityRef(String paramString)
  {
    throw new RuntimeException("EntityReference not supported for WBXML");
  }
  
  public void flush() {}
  
  public int getDepth()
  {
    return this.depth;
  }
  
  public boolean getFeature(String paramString)
  {
    return false;
  }
  
  public String getName()
  {
    throw new RuntimeException("NYI");
  }
  
  public String getNamespace()
  {
    throw new RuntimeException("NYI");
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    throw new RuntimeException("NYI");
  }
  
  public Object getProperty(String paramString)
  {
    return null;
  }
  
  public void ignorableWhitespace(String paramString) {}
  
  public void processingInstruction(String paramString)
  {
    throw new RuntimeException("PI NYI");
  }
  
  public void setAttrStartTable(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] != null) {
        this.attrStartTable.put(paramArrayOfString[i], new int[] { paramInt, i + 5 });
      }
      i += 1;
    }
  }
  
  public void setAttrValueTable(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] != null) {
        this.attrValueTable.put(paramArrayOfString[i], new int[] { paramInt, i + 133 });
      }
      i += 1;
    }
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("unknown feature ");
    localStringBuffer.append(paramString);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    String str = paramString;
    if (paramString == null) {
      str = "UTF-8";
    }
    this.encoding = str;
    this.out = paramOutputStream;
    this.buf = new ByteArrayOutputStream();
    this.stringTableBuf = new ByteArrayOutputStream();
  }
  
  public void setOutput(Writer paramWriter)
  {
    throw new RuntimeException("Wbxml requires an OutputStream!");
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    throw new RuntimeException("NYI");
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    paramObject = new StringBuffer();
    ((StringBuffer)paramObject).append("unknown property ");
    ((StringBuffer)paramObject).append(paramString);
    throw new IllegalArgumentException(((StringBuffer)paramObject).toString());
  }
  
  public void setTagTable(int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] != null) {
        this.tagTable.put(paramArrayOfString[i], new int[] { paramInt, i + 5 });
      }
      i += 1;
    }
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
    throws IOException
  {
    this.out.write(3);
    this.out.write(1);
    if (paramString != null) {
      this.encoding = paramString;
    }
    if (this.encoding.toUpperCase().equals("UTF-8")) {
      paramString = this.out;
    }
    for (int i = 106;; i = 4)
    {
      paramString.write(i);
      return;
      if (!this.encoding.toUpperCase().equals("ISO-8859-1")) {
        break;
      }
      paramString = this.out;
    }
    throw new UnsupportedEncodingException(paramString);
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
    throws IOException
  {
    if ((paramString1 != null) && (!"".equals(paramString1))) {
      throw new RuntimeException("NSP NYI");
    }
    checkPending(false);
    this.pending = paramString2;
    this.depth += 1;
    return this;
  }
  
  public XmlSerializer text(String paramString)
    throws IOException
  {
    checkPending(false);
    writeStr(paramString);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    checkPending(false);
    writeStr(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
  
  void writeStrI(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramOutputStream.write(paramString.getBytes(this.encoding));
    paramOutputStream.write(0);
  }
  
  public void writeWapExtension(int paramInt, Object paramObject)
    throws IOException
  {
    checkPending(false);
    this.buf.write(paramInt);
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          throw new IllegalArgumentException();
        case 195: 
          paramObject = (byte[])paramObject;
          writeInt(this.buf, paramObject.length);
          this.buf.write((byte[])paramObject);
          return;
        }
        break;
      }
      writeStrT((String)paramObject, false);
      return;
    }
    writeStrI(this.buf, (String)paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\kxml2\wap\WbxmlSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */