package dji.thirdparty.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final ByteString EMPTY = of(new byte[0]);
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long serialVersionUID = 1L;
  final byte[] data;
  transient int hashCode;
  transient String utf8;
  
  ByteString(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public static ByteString decodeBase64(String paramString)
  {
    if (paramString != null)
    {
      paramString = Base64.decode(paramString);
      if (paramString != null) {
        return new ByteString(paramString);
      }
      return null;
    }
    throw new IllegalArgumentException("base64 == null");
  }
  
  public static ByteString decodeHex(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() % 2 == 0)
      {
        int j = paramString.length() / 2;
        localObject = new byte[j];
        int i = 0;
        while (i < j)
        {
          int k = i * 2;
          localObject[i] = ((byte)((decodeHexDigit(paramString.charAt(k)) << 4) + decodeHexDigit(paramString.charAt(k + 1))));
          i += 1;
        }
        return of((byte[])localObject);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected hex string: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("hex == null");
  }
  
  private static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      return paramChar - c + 10;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected hex digit: ");
    localStringBuilder.append(paramChar);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private ByteString digest(String paramString)
  {
    return null;
  }
  
  public static ByteString encodeUtf8(String paramString)
  {
    if (paramString != null)
    {
      ByteString localByteString = new ByteString(paramString.getBytes(Util.UTF_8));
      localByteString.utf8 = paramString;
      return localByteString;
    }
    throw new IllegalArgumentException("s == null");
  }
  
  public static ByteString of(byte... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return new ByteString((byte[])paramVarArgs.clone());
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return new ByteString(arrayOfByte);
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static ByteString read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream != null)
    {
      if (paramInt >= 0)
      {
        byte[] arrayOfByte = new byte[paramInt];
        int i = 0;
        while (i < paramInt)
        {
          int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
          if (j != -1) {
            i += j;
          } else {
            throw new EOFException();
          }
        }
        return new ByteString(arrayOfByte);
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("byteCount < 0: ");
      paramInputStream.append(paramInt);
      throw new IllegalArgumentException(paramInputStream.toString());
    }
    throw new IllegalArgumentException("in == null");
  }
  
  /* Error */
  private void readObject(java.io.ObjectInputStream arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void writeObject(java.io.ObjectOutputStream arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ByteBuffer asByteBuffer()
  {
    return null;
  }
  
  public String base64()
  {
    return Base64.encode(this.data);
  }
  
  public String base64Url()
  {
    return Base64.encodeUrl(this.data);
  }
  
  public int compareTo(ByteString paramByteString)
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public byte getByte(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String hex()
  {
    return null;
  }
  
  byte[] internalArray()
  {
    return this.data;
  }
  
  public ByteString md5()
  {
    return digest("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return paramByteString.rangeEquals(paramInt2, this.data, paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  public ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public int size()
  {
    return this.data.length;
  }
  
  public ByteString substring(int paramInt)
  {
    return substring(paramInt, this.data.length);
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public ByteString toAsciiLowercase()
  {
    return null;
  }
  
  public ByteString toAsciiUppercase()
  {
    return null;
  }
  
  public byte[] toByteArray()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
  
  public String utf8()
  {
    return null;
  }
  
  void write(Buffer paramBuffer)
  {
    byte[] arrayOfByte = this.data;
    paramBuffer.write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  /* Error */
  public void write(java.io.OutputStream arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */