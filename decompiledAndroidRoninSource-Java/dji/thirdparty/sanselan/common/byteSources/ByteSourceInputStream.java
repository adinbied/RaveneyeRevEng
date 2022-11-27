package dji.thirdparty.sanselan.common.byteSources;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteSourceInputStream
  extends ByteSource
{
  private static final int BLOCK_SIZE = 1024;
  private CacheBlock cacheHead = null;
  private final InputStream is;
  private Long length = null;
  private byte[] readBuffer = null;
  
  public ByteSourceInputStream(InputStream paramInputStream, String paramString)
  {
    super(paramString);
    this.is = new BufferedInputStream(paramInputStream);
  }
  
  private CacheBlock getFirstBlock()
    throws IOException
  {
    return null;
  }
  
  private CacheBlock readBlock()
    throws IOException
  {
    return null;
  }
  
  public byte[] getAll()
    throws IOException
  {
    return null;
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
    throws IOException
  {
    return new CacheReadingInputStream(null);
  }
  
  public long getLength()
    throws IOException
  {
    return 278009136L;
  }
  
  private class CacheBlock
  {
    public final byte[] bytes;
    private CacheBlock next = null;
    private boolean triedNext = false;
    
    public CacheBlock(byte[] paramArrayOfByte)
    {
      this.bytes = paramArrayOfByte;
    }
    
    public CacheBlock getNext()
      throws IOException
    {
      return null;
    }
  }
  
  private class CacheReadingInputStream
    extends InputStream
  {
    private ByteSourceInputStream.CacheBlock block = null;
    private int blockIndex = 0;
    private boolean readFirst = false;
    
    private CacheReadingInputStream() {}
    
    public int read()
      throws IOException
    {
      return 0;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\byteSources\ByteSourceInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */