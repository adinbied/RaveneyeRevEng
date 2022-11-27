package com.facebook.binaryresource;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayBinaryResource
  implements BinaryResource
{
  private final byte[] mBytes;
  
  public ByteArrayBinaryResource(byte[] paramArrayOfByte)
  {
    this.mBytes = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
  }
  
  public InputStream openStream()
    throws IOException
  {
    return new ByteArrayInputStream(this.mBytes);
  }
  
  public byte[] read()
  {
    return this.mBytes;
  }
  
  public long size()
  {
    return this.mBytes.length;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\binaryresource\ByteArrayBinaryResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */