package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

public class Base64
{
  private static final Encoder encoder = new Base64Encoder();
  
  public static int decode(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    return encoder.decode(paramString, paramOutputStream);
  }
  
  public static int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
  {
    try
    {
      paramInt1 = encoder.decode(paramArrayOfByte, paramInt1, paramInt2, paramOutputStream);
      return paramInt1;
    }
    catch (Exception paramArrayOfByte)
    {
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("unable to decode base64 data: ");
      paramOutputStream.append(paramArrayOfByte.getMessage());
      throw new DecoderException(paramOutputStream.toString(), paramArrayOfByte);
    }
  }
  
  public static byte[] decode(String paramString)
  {
    Object localObject = new ByteArrayOutputStream(paramString.length() / 4 * 3);
    try
    {
      encoder.decode(paramString, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to decode base64 string: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      throw new DecoderException(((StringBuilder)localObject).toString(), paramString);
    }
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    Object localObject = new ByteArrayOutputStream(paramArrayOfByte.length / 4 * 3);
    try
    {
      encoder.decode(paramArrayOfByte, 0, paramArrayOfByte.length, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to decode base64 data: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new DecoderException(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
  
  public static int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    return encoder.encode(paramArrayOfByte, paramInt1, paramInt2, paramOutputStream);
  }
  
  public static int encode(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    return encoder.encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramOutputStream);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new ByteArrayOutputStream((paramInt2 + 2) / 3 * 4);
    try
    {
      encoder.encode(paramArrayOfByte, paramInt1, paramInt2, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception encoding base64 string: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new EncoderException(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
  
  public static String toBase64String(byte[] paramArrayOfByte)
  {
    return toBase64String(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String toBase64String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Strings.fromByteArray(encode(paramArrayOfByte, paramInt1, paramInt2));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */