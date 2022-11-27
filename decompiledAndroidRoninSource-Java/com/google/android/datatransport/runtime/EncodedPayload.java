package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

public final class EncodedPayload
{
  private final byte[] bytes;
  private final Encoding encoding;
  
  public EncodedPayload(Encoding paramEncoding, byte[] paramArrayOfByte)
  {
    if (paramEncoding != null)
    {
      if (paramArrayOfByte != null)
      {
        this.encoding = paramEncoding;
        this.bytes = paramArrayOfByte;
        return;
      }
      throw new NullPointerException("bytes is null");
    }
    throw new NullPointerException("encoding is null");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof EncodedPayload)) {
      return false;
    }
    paramObject = (EncodedPayload)paramObject;
    if (!this.encoding.equals(((EncodedPayload)paramObject).encoding)) {
      return false;
    }
    return Arrays.equals(this.bytes, ((EncodedPayload)paramObject).bytes);
  }
  
  public byte[] getBytes()
  {
    return this.bytes;
  }
  
  public Encoding getEncoding()
  {
    return this.encoding;
  }
  
  public int hashCode()
  {
    return (this.encoding.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.bytes);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EncodedPayload{encoding=");
    localStringBuilder.append(this.encoding);
    localStringBuilder.append(", bytes=[...]}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\EncodedPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */