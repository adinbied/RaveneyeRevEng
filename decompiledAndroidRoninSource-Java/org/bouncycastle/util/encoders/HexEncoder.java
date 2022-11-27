package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder
  implements Encoder
{
  protected final byte[] decodingTable = new byte[''];
  protected final byte[] encodingTable = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public HexEncoder()
  {
    initialiseDecodingTable();
  }
  
  private static boolean ignore(char paramChar)
  {
    return (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == ' ');
  }
  
  public int decode(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int j = paramString.length();
    while ((j > 0) && (ignore(paramString.charAt(j - 1)))) {
      j -= 1;
    }
    int i = 0;
    int k = 0;
    while (i < j)
    {
      while ((i < j) && (ignore(paramString.charAt(i)))) {
        i += 1;
      }
      byte[] arrayOfByte = this.decodingTable;
      int m = i + 1;
      int n = arrayOfByte[paramString.charAt(i)];
      i = m;
      while ((i < j) && (ignore(paramString.charAt(i)))) {
        i += 1;
      }
      m = this.decodingTable[paramString.charAt(i)];
      if ((n | m) >= 0)
      {
        paramOutputStream.write(n << 4 | m);
        k += 1;
        i += 1;
      }
      else
      {
        throw new IOException("invalid characters encountered in Hex string");
      }
    }
    return k;
  }
  
  public int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    paramInt2 += paramInt1;
    while ((paramInt2 > paramInt1) && (ignore((char)paramArrayOfByte[(paramInt2 - 1)]))) {
      paramInt2 -= 1;
    }
    int i = 0;
    while (paramInt1 < paramInt2)
    {
      while ((paramInt1 < paramInt2) && (ignore((char)paramArrayOfByte[paramInt1]))) {
        paramInt1 += 1;
      }
      byte[] arrayOfByte = this.decodingTable;
      int j = paramInt1 + 1;
      int k = arrayOfByte[paramArrayOfByte[paramInt1]];
      paramInt1 = j;
      while ((paramInt1 < paramInt2) && (ignore((char)paramArrayOfByte[paramInt1]))) {
        paramInt1 += 1;
      }
      j = this.decodingTable[paramArrayOfByte[paramInt1]];
      if ((k | j) >= 0)
      {
        paramOutputStream.write(k << 4 | j);
        i += 1;
        paramInt1 += 1;
      }
      else
      {
        throw new IOException("invalid characters encountered in Hex data");
      }
    }
    return i;
  }
  
  public int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      paramOutputStream.write(this.encodingTable[(j >>> 4)]);
      paramOutputStream.write(this.encodingTable[(j & 0xF)]);
      i += 1;
    }
    return paramInt2 * 2;
  }
  
  protected void initialiseDecodingTable()
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      arrayOfByte = this.decodingTable;
      j = k;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = -1;
      i += 1;
    }
    for (;;)
    {
      arrayOfByte = this.encodingTable;
      if (j >= arrayOfByte.length) {
        break;
      }
      this.decodingTable[arrayOfByte[j]] = ((byte)j);
      j += 1;
    }
    byte[] arrayOfByte = this.decodingTable;
    arrayOfByte[65] = arrayOfByte[97];
    arrayOfByte[66] = arrayOfByte[98];
    arrayOfByte[67] = arrayOfByte[99];
    arrayOfByte[68] = arrayOfByte[100];
    arrayOfByte[69] = arrayOfByte[101];
    arrayOfByte[70] = arrayOfByte[102];
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\HexEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */