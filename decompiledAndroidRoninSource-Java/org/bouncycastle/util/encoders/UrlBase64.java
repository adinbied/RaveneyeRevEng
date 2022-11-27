package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UrlBase64
{
  private static final Encoder encoder = new UrlBase64Encoder();
  
  public static int decode(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    return encoder.decode(paramString, paramOutputStream);
  }
  
  public static int decode(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    return encoder.decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramOutputStream);
  }
  
  public static byte[] decode(String paramString)
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      encoder.decode(paramString, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception decoding URL safe base64 string: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      throw new DecoderException(((StringBuilder)localObject).toString(), paramString);
    }
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      encoder.decode(paramArrayOfByte, 0, paramArrayOfByte.length, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception decoding URL safe base64 string: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new DecoderException(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
  
  public static int encode(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    return encoder.encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramOutputStream);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      encoder.encode(paramArrayOfByte, 0, paramArrayOfByte.length, (OutputStream)localObject);
      return ((ByteArrayOutputStream)localObject).toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception encoding URL safe base64 data: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new EncoderException(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\encoders\UrlBase64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */