package org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;

public final class Strings
{
  private static String LINE_SEPARATOR = "\n";
  
  static
  {
    try
    {
      LINE_SEPARATOR = (String)AccessController.doPrivileged(new PrivilegedAction()
      {
        public String run()
        {
          return System.getProperty("line.separator");
        }
      });
      return;
    }
    catch (Exception localException1)
    {
      label30:
      for (;;) {}
    }
    try
    {
      LINE_SEPARATOR = String.format("%n", new Object[0]);
      return;
    }
    catch (Exception localException2)
    {
      break label30;
    }
  }
  
  public static char[] asCharArray(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i != j)
    {
      arrayOfChar[i] = ((char)(paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static String fromByteArray(byte[] paramArrayOfByte)
  {
    return new String(asCharArray(paramArrayOfByte));
  }
  
  public static String fromUTF8ByteArray(byte[] paramArrayOfByte)
  {
    int n = 0;
    int k = 0;
    int m = 0;
    while (k < paramArrayOfByte.length)
    {
      m += 1;
      if ((paramArrayOfByte[k] & 0xF0) == 240)
      {
        m += 1;
        k += 4;
      }
      else if ((paramArrayOfByte[k] & 0xE0) == 224)
      {
        k += 3;
      }
      else if ((paramArrayOfByte[k] & 0xC0) == 192)
      {
        k += 2;
      }
      else
      {
        k += 1;
      }
    }
    char[] arrayOfChar = new char[m];
    m = 0;
    k = n;
    while (k < paramArrayOfByte.length)
    {
      int i;
      if ((paramArrayOfByte[k] & 0xF0) == 240)
      {
        n = ((paramArrayOfByte[k] & 0x3) << 18 | (paramArrayOfByte[(k + 1)] & 0x3F) << 12 | (paramArrayOfByte[(k + 2)] & 0x3F) << 6 | paramArrayOfByte[(k + 3)] & 0x3F) - 65536;
        int j = (char)(0xD800 | n >> 10);
        i = (char)(n & 0x3FF | 0xDC00);
        arrayOfChar[m] = j;
        k += 4;
        m += 1;
      }
      else if ((paramArrayOfByte[k] & 0xE0) == 224)
      {
        i = (char)((paramArrayOfByte[k] & 0xF) << 12 | (paramArrayOfByte[(k + 1)] & 0x3F) << 6 | paramArrayOfByte[(k + 2)] & 0x3F);
        k += 3;
      }
      else
      {
        if ((paramArrayOfByte[k] & 0xD0) == 208) {
          n = (paramArrayOfByte[k] & 0x1F) << 6;
        }
        for (int i1 = paramArrayOfByte[(k + 1)];; i1 = paramArrayOfByte[(k + 1)])
        {
          i = (char)(n | i1 & 0x3F);
          k += 2;
          break label357;
          if ((paramArrayOfByte[k] & 0xC0) != 192) {
            break;
          }
          n = (paramArrayOfByte[k] & 0x1F) << 6;
        }
        i = (char)(paramArrayOfByte[k] & 0xFF);
        k += 1;
      }
      label357:
      arrayOfChar[m] = i;
      m += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String lineSeparator()
  {
    return LINE_SEPARATOR;
  }
  
  public static StringList newList()
  {
    return new StringListImpl(null);
  }
  
  public static String[] split(String paramString, char paramChar)
  {
    Vector localVector = new Vector();
    char c1 = '\001';
    char c2;
    for (;;)
    {
      c2 = '\000';
      if (c1 == 0) {
        break;
      }
      c2 = paramString.indexOf(paramChar);
      if (c2 > 0)
      {
        localVector.addElement(paramString.substring(0, c2));
        paramString = paramString.substring(c2 + '\001');
      }
      else
      {
        localVector.addElement(paramString);
        c1 = '\000';
      }
    }
    c1 = localVector.size();
    paramString = new String[c1];
    paramChar = c2;
    while (paramChar != c1)
    {
      paramString[paramChar] = ((String)localVector.elementAt(paramChar));
      paramChar += '\001';
    }
    return paramString;
  }
  
  public static int toByteArray(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[(paramInt + i)] = ((byte)paramString.charAt(i));
      i += 1;
    }
    return j;
  }
  
  public static byte[] toByteArray(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i != j)
    {
      arrayOfByte[i] = ((byte)paramString.charAt(i));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] toByteArray(char[] paramArrayOfChar)
  {
    int j = paramArrayOfChar.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i != j)
    {
      arrayOfByte[i] = ((byte)paramArrayOfChar[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String toLowerCase(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int k;
    for (int j = 0; i != arrayOfChar.length; j = k)
    {
      int m = arrayOfChar[i];
      k = j;
      if (65 <= m)
      {
        k = j;
        if (90 >= m)
        {
          arrayOfChar[i] = ((char)(m - 65 + 97));
          k = 1;
        }
      }
      i += 1;
    }
    if (j != 0) {
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }
  
  public static void toUTF8ByteArray(char[] paramArrayOfChar, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      int j = paramArrayOfChar[i];
      if (j >= 128) {
        if (j >= 2048) {}
      }
      for (int k = j >> 6 | 0xC0;; k = j >> 6 & 0x3F | 0x80)
      {
        paramOutputStream.write(k);
        if ((j >= 55296) && (j <= 57343))
        {
          i += 1;
          if (i < paramArrayOfChar.length)
          {
            k = paramArrayOfChar[i];
            if (j <= 56319)
            {
              j = ((j & 0x3FF) << 10 | k & 0x3FF) + 65536;
              paramOutputStream.write(j >> 18 | 0xF0);
              paramOutputStream.write(j >> 12 & 0x3F | 0x80);
              paramOutputStream.write(j >> 6 & 0x3F | 0x80);
              j = j & 0x3F | 0x80;
              paramOutputStream.write(j);
              break;
            }
            throw new IllegalStateException("invalid UTF-16 codepoint");
          }
          throw new IllegalStateException("invalid UTF-16 codepoint");
        }
        paramOutputStream.write(j >> 12 | 0xE0);
      }
      i += 1;
    }
  }
  
  public static byte[] toUTF8ByteArray(String paramString)
  {
    return toUTF8ByteArray(paramString.toCharArray());
  }
  
  public static byte[] toUTF8ByteArray(char[] paramArrayOfChar)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      toUTF8ByteArray(paramArrayOfChar, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramArrayOfChar)
    {
      for (;;) {}
    }
    throw new IllegalStateException("cannot encode string to byte array!");
  }
  
  public static String toUpperCase(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int k;
    for (int j = 0; i != arrayOfChar.length; j = k)
    {
      int m = arrayOfChar[i];
      k = j;
      if (97 <= m)
      {
        k = j;
        if (122 >= m)
        {
          arrayOfChar[i] = ((char)(m - 97 + 65));
          k = 1;
        }
      }
      i += 1;
    }
    if (j != 0) {
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }
  
  private static class StringListImpl
    extends ArrayList<String>
    implements StringList
  {
    public void add(int paramInt, String paramString)
    {
      super.add(paramInt, paramString);
    }
    
    public boolean add(String paramString)
    {
      return super.add(paramString);
    }
    
    public String set(int paramInt, String paramString)
    {
      return (String)super.set(paramInt, paramString);
    }
    
    public String[] toStringArray()
    {
      int j = size();
      String[] arrayOfString = new String[j];
      int i = 0;
      while (i != j)
      {
        arrayOfString[i] = ((String)get(i));
        i += 1;
      }
      return arrayOfString;
    }
    
    public String[] toStringArray(int paramInt1, int paramInt2)
    {
      String[] arrayOfString = new String[paramInt2 - paramInt1];
      int i = paramInt1;
      while ((i != size()) && (i != paramInt2))
      {
        arrayOfString[(i - paramInt1)] = ((String)get(i));
        i += 1;
      }
      return arrayOfString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */