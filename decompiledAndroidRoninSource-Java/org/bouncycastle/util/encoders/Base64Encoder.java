package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class Base64Encoder
  implements Encoder
{
  protected final byte[] decodingTable = new byte[''];
  protected final byte[] encodingTable = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  protected byte padding = 61;
  
  public Base64Encoder()
  {
    initialiseDecodingTable();
  }
  
  private int decodeLastBlock(OutputStream paramOutputStream, char paramChar1, char paramChar2, char paramChar3, char paramChar4)
    throws IOException
  {
    char c = this.padding;
    if (paramChar3 == c)
    {
      if (paramChar4 == c)
      {
        arrayOfByte = this.decodingTable;
        paramChar1 = arrayOfByte[paramChar1];
        paramChar2 = arrayOfByte[paramChar2];
        if ((paramChar1 | paramChar2) >= 0)
        {
          paramOutputStream.write(paramChar1 << '\002' | paramChar2 >> '\004');
          return 1;
        }
        throw new IOException("invalid characters encountered at end of base64 data");
      }
      throw new IOException("invalid characters encountered at end of base64 data");
    }
    if (paramChar4 == c)
    {
      arrayOfByte = this.decodingTable;
      paramChar1 = arrayOfByte[paramChar1];
      paramChar2 = arrayOfByte[paramChar2];
      paramChar3 = arrayOfByte[paramChar3];
      if ((paramChar1 | paramChar2 | paramChar3) >= 0)
      {
        paramOutputStream.write(paramChar1 << '\002' | paramChar2 >> '\004');
        paramOutputStream.write(paramChar2 << '\004' | paramChar3 >> '\002');
        return 2;
      }
      throw new IOException("invalid characters encountered at end of base64 data");
    }
    byte[] arrayOfByte = this.decodingTable;
    paramChar1 = arrayOfByte[paramChar1];
    paramChar2 = arrayOfByte[paramChar2];
    paramChar3 = arrayOfByte[paramChar3];
    paramChar4 = arrayOfByte[paramChar4];
    if ((paramChar1 | paramChar2 | paramChar3 | paramChar4) >= 0)
    {
      paramOutputStream.write(paramChar1 << '\002' | paramChar2 >> '\004');
      paramOutputStream.write(paramChar2 << '\004' | paramChar3 >> '\002');
      paramOutputStream.write(paramChar3 << '\006' | paramChar4);
      return 3;
    }
    throw new IOException("invalid characters encountered at end of base64 data");
  }
  
  private boolean ignore(char paramChar)
  {
    return (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == ' ');
  }
  
  private int nextI(String paramString, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (ignore(paramString.charAt(paramInt1)))) {
      paramInt1 += 1;
    }
    return paramInt1;
  }
  
  private int nextI(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (ignore((char)paramArrayOfByte[paramInt1]))) {
      paramInt1 += 1;
    }
    return paramInt1;
  }
  
  public int decode(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramString.length();
    while ((i > 0) && (ignore(paramString.charAt(i - 1)))) {
      i -= 1;
    }
    int m = i - 4;
    int j = 0;
    int k = nextI(paramString, 0, m);
    while (k < m)
    {
      int n = this.decodingTable[paramString.charAt(k)];
      int i1 = nextI(paramString, k + 1, m);
      k = this.decodingTable[paramString.charAt(i1)];
      int i2 = nextI(paramString, i1 + 1, m);
      i1 = this.decodingTable[paramString.charAt(i2)];
      i2 = nextI(paramString, i2 + 1, m);
      int i3 = this.decodingTable[paramString.charAt(i2)];
      if ((n | k | i1 | i3) >= 0)
      {
        paramOutputStream.write(n << 2 | k >> 4);
        paramOutputStream.write(k << 4 | i1 >> 2);
        paramOutputStream.write(i1 << 6 | i3);
        j += 3;
        k = nextI(paramString, i2 + 1, m);
      }
      else
      {
        throw new IOException("invalid characters encountered in base64 data");
      }
    }
    return j + decodeLastBlock(paramOutputStream, paramString.charAt(m), paramString.charAt(i - 3), paramString.charAt(i - 2), paramString.charAt(i - 1));
  }
  
  public int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    paramInt2 += paramInt1;
    while ((paramInt2 > paramInt1) && (ignore((char)paramArrayOfByte[(paramInt2 - 1)]))) {
      paramInt2 -= 1;
    }
    int j = paramInt2 - 4;
    int i = nextI(paramArrayOfByte, paramInt1, j);
    paramInt1 = 0;
    while (i < j)
    {
      int k = this.decodingTable[paramArrayOfByte[i]];
      int m = nextI(paramArrayOfByte, i + 1, j);
      i = this.decodingTable[paramArrayOfByte[m]];
      int n = nextI(paramArrayOfByte, m + 1, j);
      m = this.decodingTable[paramArrayOfByte[n]];
      n = nextI(paramArrayOfByte, n + 1, j);
      int i1 = this.decodingTable[paramArrayOfByte[n]];
      if ((k | i | m | i1) >= 0)
      {
        paramOutputStream.write(k << 2 | i >> 4);
        paramOutputStream.write(i << 4 | m >> 2);
        paramOutputStream.write(m << 6 | i1);
        paramInt1 += 3;
        i = nextI(paramArrayOfByte, n + 1, j);
      }
      else
      {
        throw new IOException("invalid characters encountered in base64 data");
      }
    }
    return paramInt1 + decodeLastBlock(paramOutputStream, (char)paramArrayOfByte[j], (char)paramArrayOfByte[(paramInt2 - 3)], (char)paramArrayOfByte[(paramInt2 - 2)], (char)paramArrayOfByte[(paramInt2 - 1)]);
  }
  
  public int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    int j = paramInt2 % 3;
    int k = paramInt2 - j;
    paramInt2 = paramInt1;
    int m;
    int i;
    for (;;)
    {
      m = paramInt1 + k;
      i = 4;
      if (paramInt2 >= m) {
        break;
      }
      i = paramArrayOfByte[paramInt2] & 0xFF;
      m = paramArrayOfByte[(paramInt2 + 1)] & 0xFF;
      int n = paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
      paramOutputStream.write(this.encodingTable[(i >>> 2 & 0x3F)]);
      paramOutputStream.write(this.encodingTable[((i << 4 | m >>> 4) & 0x3F)]);
      paramOutputStream.write(this.encodingTable[((m << 2 | n >>> 6) & 0x3F)]);
      paramOutputStream.write(this.encodingTable[(n & 0x3F)]);
      paramInt2 += 3;
    }
    if (j != 1)
    {
      if (j != 2) {
        break label290;
      }
      paramInt1 = paramArrayOfByte[m] & 0xFF;
      paramInt2 = paramArrayOfByte[(m + 1)] & 0xFF;
      paramOutputStream.write(this.encodingTable[(paramInt1 >>> 2 & 0x3F)]);
      paramOutputStream.write(this.encodingTable[((paramInt1 << 4 | paramInt2 >>> 4) & 0x3F)]);
      paramInt1 = this.encodingTable[(paramInt2 << 2 & 0x3F)];
    }
    else
    {
      paramInt1 = paramArrayOfByte[m] & 0xFF;
      paramOutputStream.write(this.encodingTable[(paramInt1 >>> 2 & 0x3F)]);
      paramOutputStream.write(this.encodingTable[(paramInt1 << 4 & 0x3F)]);
      paramInt1 = this.padding;
    }
    paramOutputStream.write(paramInt1);
    paramOutputStream.write(this.padding);
    label290:
    paramInt2 = k / 3;
    paramInt1 = i;
    if (j == 0) {
      paramInt1 = 0;
    }
    return paramInt2 * 4 + paramInt1;
  }
  
  protected void initialiseDecodingTable()
  {
    int k = 0;
    int i = 0;
    byte[] arrayOfByte;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\Base64Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */