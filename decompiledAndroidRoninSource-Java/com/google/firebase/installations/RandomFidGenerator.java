package com.google.firebase.installations;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

public class RandomFidGenerator
{
  private static final byte FID_4BIT_PREFIX = Byte.parseByte("01110000", 2);
  private static final int FID_LENGTH = 22;
  private static final byte REMOVE_PREFIX_MASK = Byte.parseByte("00001111", 2);
  
  private static String encodeFidBase64UrlSafe(byte[] paramArrayOfByte)
  {
    return new String(Base64.encode(paramArrayOfByte, 11), Charset.defaultCharset()).substring(0, 22);
  }
  
  private static byte[] getBytesFromUUID(UUID paramUUID, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.putLong(paramUUID.getMostSignificantBits());
    paramArrayOfByte.putLong(paramUUID.getLeastSignificantBits());
    return paramArrayOfByte.array();
  }
  
  public String createRandomFid()
  {
    byte[] arrayOfByte = getBytesFromUUID(UUID.randomUUID(), new byte[17]);
    arrayOfByte[16] = arrayOfByte[0];
    arrayOfByte[0] = ((byte)(REMOVE_PREFIX_MASK & arrayOfByte[0] | FID_4BIT_PREFIX));
    return encodeFidBase64UrlSafe(arrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\RandomFidGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */