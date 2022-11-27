package org.bouncycastle.crypto.generators;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class OpenBSDBCrypt
{
  private static final byte[] decodingTable;
  private static final byte[] encodingTable = { 46, 47, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  private static final String version = "2a";
  
  static
  {
    decodingTable = new byte[''];
    int k = 0;
    int i = 0;
    byte[] arrayOfByte;
    int j;
    for (;;)
    {
      arrayOfByte = decodingTable;
      j = k;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = -1;
      i += 1;
    }
    for (;;)
    {
      arrayOfByte = encodingTable;
      if (j >= arrayOfByte.length) {
        break;
      }
      decodingTable[arrayOfByte[j]] = ((byte)j);
      j += 1;
    }
  }
  
  public static boolean checkPassword(String paramString, char[] paramArrayOfChar)
  {
    if ((paramString.length() != 60) || ((paramString.charAt(0) != '$') || (paramString.charAt(3) != '$') || (paramString.charAt(6) != '$') || (paramString.substring(1, 3).equals("2a")))) {}
    try
    {
      int i = Integer.parseInt(paramString.substring(4, 6));
      if ((i >= 4) && (i <= 31))
      {
        if (paramArrayOfChar != null) {
          return paramString.equals(generate(paramArrayOfChar, decodeSaltString(paramString.substring(paramString.lastIndexOf('$') + 1, paramString.length() - 31)), i));
        }
        throw new IllegalArgumentException("Missing password.");
      }
      paramString = new StringBuilder();
      paramString.append("Invalid cost factor: ");
      paramString.append(i);
      paramString.append(", 4 < cost < 31 expected.");
      throw new IllegalArgumentException(paramString.toString());
    }
    catch (NumberFormatException paramArrayOfChar)
    {
      for (;;) {}
    }
    paramArrayOfChar = new StringBuilder();
    paramArrayOfChar.append("Invalid cost factor: ");
    paramArrayOfChar.append(paramString.substring(4, 6));
    throw new IllegalArgumentException(paramArrayOfChar.toString());
    throw new IllegalArgumentException("Wrong Bcrypt version, 2a expected.");
    throw new IllegalArgumentException("Invalid Bcrypt String format.");
    paramArrayOfChar = new StringBuilder();
    paramArrayOfChar.append("Bcrypt String length: ");
    paramArrayOfChar.append(paramString.length());
    paramArrayOfChar.append(", 60 required.");
    throw new DataLengthException(paramArrayOfChar.toString());
  }
  
  private static String createBcryptString(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(60);
    localStringBuffer.append('$');
    localStringBuffer.append("2a");
    localStringBuffer.append('$');
    Object localObject;
    if (paramInt < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = Integer.toString(paramInt);
    }
    localStringBuffer.append((String)localObject);
    localStringBuffer.append('$');
    localStringBuffer.append(encodeData(paramArrayOfByte2));
    localStringBuffer.append(encodeData(BCrypt.generate(paramArrayOfByte1, paramArrayOfByte2, paramInt)));
    return localStringBuffer.toString();
  }
  
  private static byte[] decodeSaltString(String paramString)
  {
    paramString = paramString.toCharArray();
    Object localObject = new ByteArrayOutputStream(16);
    if (paramString.length == 22)
    {
      int i = 0;
      int j;
      while (i < paramString.length)
      {
        j = paramString[i];
        if ((j <= 122) && (j >= 46) && ((j <= 57) || (j >= 65)))
        {
          i += 1;
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("Salt string contains invalid character: ");
          paramString.append(j);
          throw new IllegalArgumentException(paramString.toString());
        }
      }
      char[] arrayOfChar = new char[24];
      System.arraycopy(paramString, 0, arrayOfChar, 0, paramString.length);
      i = 0;
      while (i < 24)
      {
        paramString = decodingTable;
        j = paramString[arrayOfChar[i]];
        int k = paramString[arrayOfChar[(i + 1)]];
        int m = paramString[arrayOfChar[(i + 2)]];
        int n = paramString[arrayOfChar[(i + 3)]];
        ((ByteArrayOutputStream)localObject).write(j << 2 | k >> 4);
        ((ByteArrayOutputStream)localObject).write(k << 4 | m >> 2);
        ((ByteArrayOutputStream)localObject).write(n | m << 6);
        i += 4;
      }
      paramString = ((ByteArrayOutputStream)localObject).toByteArray();
      localObject = new byte[16];
      System.arraycopy(paramString, 0, localObject, 0, 16);
      return (byte[])localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid base64 salt length: ");
    ((StringBuilder)localObject).append(paramString.length);
    ((StringBuilder)localObject).append(" , 22 required.");
    throw new DataLengthException(((StringBuilder)localObject).toString());
  }
  
  private static String encodeData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length != 24) && (paramArrayOfByte.length != 16))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid length: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length);
      ((StringBuilder)localObject).append(", 24 for key or 16 for salt expected");
      throw new DataLengthException(((StringBuilder)localObject).toString());
    }
    if (paramArrayOfByte.length == 16)
    {
      localObject = new byte[18];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
      paramArrayOfByte = (byte[])localObject;
      i = 1;
    }
    else
    {
      paramArrayOfByte[(paramArrayOfByte.length - 1)] = 0;
      i = 0;
    }
    Object localObject = new ByteArrayOutputStream();
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k)
    {
      int m = paramArrayOfByte[j] & 0xFF;
      int n = paramArrayOfByte[(j + 1)] & 0xFF;
      int i1 = paramArrayOfByte[(j + 2)] & 0xFF;
      ((ByteArrayOutputStream)localObject).write(encodingTable[(m >>> 2 & 0x3F)]);
      ((ByteArrayOutputStream)localObject).write(encodingTable[((m << 4 | n >>> 4) & 0x3F)]);
      ((ByteArrayOutputStream)localObject).write(encodingTable[((n << 2 | i1 >>> 6) & 0x3F)]);
      ((ByteArrayOutputStream)localObject).write(encodingTable[(i1 & 0x3F)]);
      j += 3;
    }
    paramArrayOfByte = Strings.fromByteArray(((ByteArrayOutputStream)localObject).toByteArray());
    if (i == 1) {}
    for (int i = 22;; i = paramArrayOfByte.length() - 1) {
      return paramArrayOfByte.substring(0, i);
    }
  }
  
  public static String generate(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfChar != null)
    {
      if (paramArrayOfByte != null)
      {
        if (paramArrayOfByte.length == 16)
        {
          if ((paramInt >= 4) && (paramInt <= 31))
          {
            byte[] arrayOfByte = Strings.toUTF8ByteArray(paramArrayOfChar);
            int j = arrayOfByte.length;
            int i = 72;
            if (j < 72) {
              i = arrayOfByte.length + 1;
            }
            paramArrayOfChar = new byte[i];
            j = i;
            if (i > arrayOfByte.length) {
              j = arrayOfByte.length;
            }
            System.arraycopy(arrayOfByte, 0, paramArrayOfChar, 0, j);
            Arrays.fill(arrayOfByte, (byte)0);
            paramArrayOfByte = createBcryptString(paramArrayOfChar, paramArrayOfByte, paramInt);
            Arrays.fill(paramArrayOfChar, (byte)0);
            return paramArrayOfByte;
          }
          throw new IllegalArgumentException("Invalid cost factor.");
        }
        paramArrayOfChar = new StringBuilder();
        paramArrayOfChar.append("16 byte salt required: ");
        paramArrayOfChar.append(paramArrayOfByte.length);
        throw new DataLengthException(paramArrayOfChar.toString());
      }
      throw new IllegalArgumentException("Salt required.");
    }
    throw new IllegalArgumentException("Password required.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\OpenBSDBCrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */