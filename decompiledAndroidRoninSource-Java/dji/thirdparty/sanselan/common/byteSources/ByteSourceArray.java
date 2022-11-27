package dji.thirdparty.sanselan.common.byteSources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteSourceArray
  extends ByteSource
{
  private final byte[] bytes;
  
  public ByteSourceArray(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString);
    this.bytes = paramArrayOfByte;
  }
  
  public ByteSourceArray(byte[] paramArrayOfByte)
  {
    super(null);
    this.bytes = paramArrayOfByte;
  }
  
  public byte[] getAll()
    throws IOException
  {
    return this.bytes;
  }
  
  public byte[] getBlock(int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  public String getDescription()
  {
    return null;
  }
  
  public InputStream getInputStream()
  {
    return new ByteArrayInputStream(this.bytes);
  }
  
  public long getLength()
  {
    return this.bytes.length;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\byteSources\ByteSourceArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */